/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IntoMar;

import Buzo.Buseador;
import Enemigos.Piraña;
import Enemigos.Tiburon;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.FadeTransition;
import javafx.animation.ParallelTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

/**
 *
 * @author best buy
 */
public final class Mar implements Runnable {

    private Pane p;
    private Image imagen;
    private ImageView verImagen;
    private Circle[] c, f;
    private ArrayList<Tiburon> tiburones;
    private Buseador buso;
    private HashMap<Tiburon, Thread> thread;
    private int numTiburon;
    private Random random = new Random();
    private int ancho;
    private int alto;

    public Mar(int ancho, int alto, numTiburones) {
        //Creamos el contenedor del mar
        p = new Pane();
        p.maxWidth(ancho);
        p.maxHeight(alto);
        tiburones = new ArrayList<Tiburon>();
        this.imagen = new Image(Mar.class.getResource("FondoMarino.jpg").toExternalForm());
        this.verImagen = new ImageView();
        this.verImagen.setImage(imagen);
        p.getChildren().add(verImagen);
        this.numTiburon = numTiburones;
        this.addTiburones(this.numTiburon);
        this.Burbujas();
        this.addBuzo();
        this.alto = alto;
        this.ancho = ancho;
        this.addDatosBuzo();
        p.setFocusTraversable(true);
        p.setOnKeyPressed(new Teclea());
    }

    public void Burbujas() {
        c = new Circle[200];
        f = new Circle[200];
        for (int i = 0; i < c.length; i++) {
            int x = (int) (Math.random() * 1500);
            int y = (int) (Math.random() * 800);
            c[i] = new Circle(x, y, 5, Color.BLUE);
            f[i] = new Circle(x, y, 5, Color.ANTIQUEWHITE);
        }
        for (int j = 0; j < c.length; j++) {
            c[j].setTranslateX(j + 3);
            c[j].setTranslateY(j + 5);
            final Timeline timeline = new Timeline();
            FadeTransition fadeTransition
                    = new FadeTransition(Duration.millis(300), c[j]);
            fadeTransition.setFromValue(1.0f);
            fadeTransition.setToValue(0.3f);
            fadeTransition.setCycleCount(2);
            fadeTransition.setAutoReverse(true);
            TranslateTransition translateTransition
                    = new TranslateTransition(Duration.millis(2000), c[j]);
            translateTransition.setFromX(0);
            translateTransition.setFromY(700);
            translateTransition.setToX(0);
            translateTransition.setToY(-50);
            translateTransition.setCycleCount(1);
            // translateTransition.setAutoReverse(true);
            ScaleTransition scaleTransition
                    = new ScaleTransition(Duration.millis(2000), c[j]);
            scaleTransition.setToX(1f);
            scaleTransition.setToY(1f);
            scaleTransition.setCycleCount(1);
            scaleTransition.setAutoReverse(true);

            ParallelTransition parallelTransition = new ParallelTransition();
            parallelTransition.getChildren().addAll(
                    fadeTransition,
                    translateTransition,
                    scaleTransition
            );
            parallelTransition.setCycleCount(Timeline.INDEFINITE);
            parallelTransition.play();
            p.getChildren().addAll(c[j], f[j]);
        }
    }

    public void addTiburones(int numTiburones) {

        for (int j = 0; j < numTiburones; j++) {
            int posy = random.nextInt(6) * (-100) + 400;
            int tiempo = (int) (Math.random() * 1000);
            tiburones.add(new Tiburon(950, posy, tiempo));
            p.getChildren().add(tiburones.get(j).getGroup());
        }
    }
    
    public void verificarHilo() {
        for (int i = 0; i < this.thread.size(); i++) {
            if (this.thread.get(this.getTiburones().get(i)).isAlive() != true) {
                this.thread.remove(this.getTiburones().get(i));
                if (this.getTiburones().contains(this.getTiburones().get(i)) == true) {
                    if (this.thread.get(this.getTiburones().get(i)) == null) {
                        if (this.getTiburones().get(i).verificar() == true) {
                            int punto = this.buso.getPuntaje();
                            punto = punto + 100;
                            this.buso.setPuntaje(punto);
                            this.getTiburones().remove(this.getTiburones().get(i));
                            System.out.println("Entro");
                        } else if (this.getTiburones().get(i).verificar() == false) {
                            this.getTiburones().remove(this.getTiburones().get(i));
                            int vida = this.buso.getVida();
                            vida = vida - 1;
                            this.buso.setVida(vida);
                            System.out.println("Vida : " + this.buso.getVida());
                        }
                    }
                }
            }
        }
    }

    public void verificarPalabra(String e) {
        Label letra = new Label(e);
        for (int i = 0; i < this.getTiburones().size(); i++) {
            for (int j = 0; j < this.getTiburones().get(i).getLabel().getChildren().size(); j++) {
                if (j == 0) {
                    if (((Label) this.getTiburones().get(i).getLabel().getChildren().get(0)).getText().equals(letra.getText())) {
                        for (int n = 0; n < this.getTiburones().size(); n++) {
                            if (n == 0) {
                                if (((Label) this.getTiburones().get(n).getLabel().getChildren().get(0)).getText().equals(letra.getText())) {
                                    if (n != this.getTiburones().size() - 1) {
                                        if (((Label) this.getTiburones().get(n + 1).getLabel().getChildren().get(0)).getTextFill() != Color.YELLOW) {
                                            ((Label) this.getTiburones().get(n).getLabel().getChildren().get(0)).setTextFill(Color.YELLOW);
                                        }
                                    } else {
                                        ((Label) this.getTiburones().get(n).getLabel().getChildren().get(0)).setTextFill(Color.YELLOW);
                                    }
                                }
                            } else if (n > 0 && n < this.getTiburones().size() - 1) {
                                if (((Label) this.getTiburones().get(n).getLabel().getChildren().get(0)).getText().equals(letra.getText())) {
                                    if (((Label) this.getTiburones().get(n - 1).getLabel().getChildren().get(0)).getTextFill() != Color.YELLOW && ((Label) this.getTiburones().get(n + 1).getLabel().getChildren().get(0)).getTextFill() != Color.YELLOW) {
                                        ((Label) this.getTiburones().get(n).getLabel().getChildren().get(0)).setTextFill(Color.YELLOW);
                                    }
                                }
                            } else if (n == this.getTiburones().size() - 1) {
                                if (((Label) this.getTiburones().get(n).getLabel().getChildren().get(0)).getText().equals(letra.getText())) {
                                    if (((Label) this.getTiburones().get(n - 1).getLabel().getChildren().get(0)).getTextFill() != Color.YELLOW) {
                                        ((Label) this.getTiburones().get(n).getLabel().getChildren().get(0)).setTextFill(Color.YELLOW);
                                    }
                                }
                            }
                        }
                    }
                } else if (j != 0) {
                    if (((Label) this.getTiburones().get(i).getLabel().getChildren().get(j - 1)).getTextFill() == Color.YELLOW) {
                        if (((Label) this.getTiburones().get(i).getLabel().getChildren().get(j)).getText().equals(letra.getText())) {
                            ((Label) this.getTiburones().get(i).getLabel().getChildren().get(j)).setTextFill(Color.YELLOW);
                        }
                    }

                }

            }

        }
    }

    public void addBuzo() {
        buso = new Buseador();
        p.getChildren().add(buso.getIv_buseador());
    }
    
    public void addPiraña(){
        Piraña piraña= new Piraña(1000,0);
       p.getChildren().add(piraña.getIv_piraña());
    }

    public Pane getP() {
        return p;
    }

    public Tiburon[] getTiburones() {
        return tiburones;
    }

    @Override
    public void run() {
             Thread t = new Thread(this.buso);
        t.start();
        thread = new HashMap<Tiburon, Thread>();

        while (this.buso.getVida() != 0) {
            
            for (int i = 0; i < this.getTiburones().size(); i++) {
                this.thread.put(this.getTiburones().get(i), new Thread(this.getTiburones().get(i)));
                this.thread.get(this.getTiburones().get(i)).start();
            }

            while (this.getTiburones().isEmpty() != true) {
                this.verificarHilo();

            }
            System.out.println("los tiburones fueron eliminados");

        }
        System.out.println("VIDA: " + this.buso.getVida());
        System.out.println("PUNTOS: " + this.buso.getPuntaje());
        System.out.println("BUZO ASESADO D:");
    }
    }
    
    private class Teclea implements EventHandler<KeyEvent> {

        @Override
        public void handle(KeyEvent e) {
            if (e.getCode() != KeyCode.CAPS) {
                String letra = e.getText();
                verificarPalabra(letra);
                
            }

        }

    }

}
