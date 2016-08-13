/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Enemigos;

import Constantes.Constantes;
import javafx.application.Platform;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 *
 * @author best buy
 */
public final class Tiburon implements Runnable {

    Group group;
    Image i_tiburon, explosion;
    private final ImageView iv_tiburon;
    double x, y;
    Constantes constantes;
    long time;
    Palabras palabras;
    int t;
    public Tiburon(int t,double x, double y, long time) {
        constantes = new Constantes();
        group = new Group();
        palabras = new Palabras();
        palabras.llamarArray();
        i_tiburon = new Image(Tiburon.class.getResource("tiburon.gif").toExternalForm());
        explosion = new Image(Tiburon.class.getResource("explosion.GIF").toExternalForm());
        iv_tiburon = new ImageView();
        iv_tiburon.setImage(i_tiburon);
        iv_tiburon.relocate(x, y);
        this.x = x;
        this.t=t;
        this.time = time;
        this.y = y;
        x = iv_tiburon.getX();
        y = iv_tiburon.getY();
        group.getChildren().addAll(iv_tiburon);
        group.setLayoutX(0);
        System.out.println("" + group.getLayoutX());
        this.addLetter();
    }

    @Override
    public void run() {
        try {
            while (group.getLayoutX() > -1230 && group.getLayoutX() < 11) {
                Platform.runLater(() -> {
                    group.setLayoutX(group.getLayoutX() - 20);
                    System.out.println("" + group.getLayoutX());
                });
                Thread.sleep(time);
            }
            Platform.runLater(new Runnable() {

                @Override
                public void run() {
                    if (group.getLayoutX() == -1240.0) {
                        group.getChildren().remove(iv_tiburon);
                    }
                }
            });

        } catch (InterruptedException e) {
            e.getMessage();
        }

    }

    public void addLetter() {

        for (int i = 0; i < palabras.getWord(t).size(); i++) {
            group.getChildren().add(new Letra((palabras.getWord(t).get(i)), x, y).getLetra());
            x = x + 40;
        }

    }

    public ImageView getIv_tiburon() {
        return iv_tiburon;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public Group getGroup() {
        return group;
    }

}
