/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Buzo;

import javafx.application.Platform;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

/**
 *
 * @author best buy
 */
public class Buseador implements Runnable {

    Image i_buseador;
    ImageView iv_buseador;
    Text t;
    int puntaje;
    int vida;
    Label puntos;
    Label life;
    NotificacionClass tablanotificadora;
    private boolean acabaHilo=false;

    public Buseador() {
        i_buseador = new Image(Buseador.class.getResource("buceo.gif").toExternalForm());
        iv_buseador = new ImageView();
        iv_buseador.setImage(i_buseador);
        iv_buseador.relocate(0, 10);
        this.puntaje = 0;
        this.vida = 3;
    }
    
    public Label getPuntos(){
        puntos= new Label(" Puntos: " + puntaje);
        puntos.setFocusTraversable(true);
        return puntos;
    }
    
    public Label getLife(){
        life= new Label(" Vida: " + vida);
        life.setFocusTraversable(true);
        return life;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }
    
    

    public int getPuntaje() {
        return puntaje;
    }

    public int getVida() {
        return vida;
    }
    public void armaS(){
        if(this.puntaje>=500){
            
            this.puntaje=this.puntaje-500;
        }
    }
    

    @Override
    public void run() {
        try {
            while (this.vida != 0 && this.acabaHilo==false ) {
                while (iv_buseador.getY() < 500&& this.acabaHilo==false ) {
                    Platform.runLater(() -> {
                        iv_buseador.setY(iv_buseador.getY() + 2);
                    });
                    Thread.sleep(100);
                }
                if (iv_buseador.getY() == 500) {
                    iv_buseador.setY(10);
                }
            }
            this.iv_buseador.setOpacity(0);
        } catch (InterruptedException e) {
            e.getMessage();
        }
    }

    public void Eliminar(Pane p) {
        if (p.getChildren().contains(this.iv_buseador)) {
            p.getChildren().remove(this.iv_buseador);
        }
    }

    public ImageView getIv_buseador() {
        return iv_buseador;
    }

    public boolean verificarPez() {
        return false;
    }

    public void setPuntaje(int p) {
        this.puntaje = p;
    }

    public boolean isAcabaHilo() {
        return acabaHilo;
    }

    public void setAcabaHilo(boolean acabaHilo) {
        this.acabaHilo = acabaHilo;
    }
    
    

}
