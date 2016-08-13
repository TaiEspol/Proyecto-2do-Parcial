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

    Pane p;
    Circle[] c, f;
    Circle piedra;
    Tiburon[] tiburones;
    Buseador buso;

    public Mar(int ancho, int alto) {
        //Creamos el contenedor del mar
        p = new Pane();
        p.maxWidth(ancho);
        p.maxHeight(alto);
        p.setStyle("-fx-background-Color: #00bfff;");

        this.Burbujas();
        this.addTiburones();
        this.addBuzo();
     //   this.addPiraña();

        piedra = new Circle(1325, 690, 50, Color.BLACK);
        p.getChildren().add(piedra);
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

    public void addTiburones() {
        tiburones = new Tiburon[5];
        for (int j = 0; j < tiburones.length; j++) {
            int posy = (int) (Math.random() * 500);
             int tiempo = (int) (Math.random() * 1000);
            tiburones[j] = new Tiburon(j,950, posy,tiempo);
            p.getChildren().add(tiburones[j].getGroup());
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
            while(true){
                Thread t1= new Thread(this.tiburones[0]);
                Thread t2= new Thread(this.tiburones[1]);
                Thread t3= new Thread(this.tiburones[2]);
                Thread t4= new Thread(this.tiburones[3]);
                Thread t5= new Thread(this.tiburones[4]);
                t1.start();
                t2.start();
                t3.start();
                t4.start();
                t5.start();
                break;
            }
    }

}
