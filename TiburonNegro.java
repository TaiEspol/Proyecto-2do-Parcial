/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Enemigos;

import Enemigos.Palabras;
import Enemigos.Pez;
import Enemigos.Tiburon;
import javafx.application.Platform;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;

/**
 *
 * @author best buy
 */
public final class TiburonNegro extends Pez{
    private final Palabras palabras;
    
    public TiburonNegro(double x, double y, long time) {
        super(x, y, time);
        this.palabras= new Palabras("palabras");
        this.cargarImagen();
        group.setFocusTraversable(true);
        this.addLetter();
    }

    @Override
    public void run() {
        try {
            while (group.getLayoutX() > -900 && group.getLayoutX() < 11 && this.verificar() == false) {
                  
                Platform.runLater(() -> {
                    group.setLayoutX(group.getLayoutX() - 20);
                    System.out.println("" + group.getLayoutX());
                });

                Thread.sleep(time);
                    }
                              
                Platform.runLater(() -> {
                    
                group.getChildren().removeAll(this.label,this.group.getChildren().get(0));
                
                System.out.println("Tiburon muerto");
            });
        } catch (InterruptedException e) {
                System.out.println("SE HA INTERRMPIDO EL HILO");
            
            }
        }

    @Override
    public Group cargarImagen() {
        Image i_tiburon=new Image(Tiburon.class.getResource("tiburon.gif").toExternalForm());
        ImageView iv_tiburon= new ImageView();
        iv_tiburon.setImage(i_tiburon);  
        this.group.getChildren().add(iv_tiburon);
        iv_tiburon.relocate(x, y);
        return this.group;
    }
    

    @Override
    public void addLetter() {
        label = palabras.getPalabraEnLabel(70 + x, y + 195);
        label.setFocusTraversable(true);
        group.getChildren().add(label);
    }
    
    @Override
    public Group getLabel() {
        return label;
    }
    
    
        @Override
    public boolean verificar() {
        int j = 0;
        for (int i = 0; i < palabras.getLabelWord().size(); i++) {
            if (palabras.getLabelWord().get(i).getTextFill() == Color.YELLOW) {
                j++;
            }
        }
        if (j == palabras.getLabelWord().size()) {
            return true;
        }

        return false;

    }
    public void verificarAgain(){
        if (this.verificar()==true);
        
        
    }
    
    public Palabras getPalabras() {
        return palabras;
    }

}

