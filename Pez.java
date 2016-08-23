/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Enemigos;

import Constantes.Constantes;
import javafx.scene.Group;

/**
 *
 * @author best buy
 */
public abstract  class Pez implements Runnable {

    protected Group group;
    protected Group label;
    protected double x, y;
    protected Constantes constantes;
    protected long time;

    public  Pez(double x, double y, long time) {
        constantes = new Constantes();
        group = new Group();
        group.setLayoutX(0);
        this.x = x;
        this.time = time;
        this.y = y;  
    }
    
   public abstract Group cargarImagen();
   
   @Override
    public abstract void run();
    
    
    public abstract void addLetter();

    public Group getGroup() {
        return group;
    }

    public Group getLabel() {
        return label;
    }
    
     public abstract boolean verificar() ;

}
