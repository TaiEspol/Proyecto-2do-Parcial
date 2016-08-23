/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Enemigos;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;

/**
 *
 * @author best buy
 */
public class Piraña  extends Pez{
    private ArrayList<String> letterPira;
    Letra letra;
    public Piraña(double x, double y, long time) {
        super(x, y, time);
        letterPira= new ArrayList();
        this.cargarImagen();
        this.addLetter();
        this.group.setFocusTraversable(true);
    }

    @Override
    public Group cargarImagen() {
        Image i_piraña=new Image(Piraña.class.getResource("pirania.gif").toExternalForm());
        ImageView iv_piraña= new ImageView();
        iv_piraña.setImage(i_piraña);
        iv_piraña.relocate(x+5, y+10);
        this.group.getChildren().add(iv_piraña);
        return this.group;
     }

    @Override
    public void run() {
        try {
            while (group.getLayoutX() > -800 && group.getLayoutX() < 11 && this.verificar() == false) {
                Platform.runLater(() -> {
                    group.setLayoutX(group.getLayoutX() - 20);
                    System.out.println("" + group.getLayoutX());
                });

                Thread.sleep(time);
            }
            Platform.runLater(() -> {
                group.getChildren().removeAll(this.label,this.group.getChildren().get(0));
                
                System.out.println("piraña ha muerto");
            });
        } catch (InterruptedException e) {
                System.out.println("SE HA INTERRMPIDO EL HILO");
            
            }
       
    }

    @Override
    public void addLetter() {
        Archivos archivo= new Archivos();
        try {
           this.letterPira=archivo.obtenerDeArchivo("palabrasPirañas");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Piraña.class.getName()).log(Level.SEVERE, null, ex);
        }
        int aleatorio= (int)(Math.random()*letterPira.size());
        letra= new Letra(this.letterPira.get(aleatorio),this.x,this.y);
        label= new Group();
        label.getChildren().add(letra.getLetra());
        group.getChildren().add(label);
    }
    
    @Override
        public boolean verificar() {
        if(letra.getLetra().getTextFill()==Color.YELLOW)
            return true;
        else
        return false;
    }
    
}
