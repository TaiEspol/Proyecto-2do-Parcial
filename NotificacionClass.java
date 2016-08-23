/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Buzo;

import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;

/**
 *
 * @author best buy
 */
public class NotificacionClass {
    Pane p;
    Label puntaje;
    Group vidas;
    Rectangle vida1;
    Rectangle vida2;
    Rectangle vida3;
    

    public NotificacionClass() {
        this.p = new Pane();
        this.puntaje =new Label("500");
        this.puntaje.setFont(new Font("Arial",50));
        this.puntaje.setTextFill(Color.BLUE);
        this.p.getChildren().addAll(this.AddVida(),puntaje);
        this.vidas.relocate(5, 5);
        this.puntaje.relocate(5, 40);
        
    }
    
    public Group AddVida(){
        this.vidas= new Group();
        this.vida1= new Rectangle(30,30);
        this.vida1.relocate(0, 5);
        this.vida1.setFill(Color.RED);
        this.vida2= new Rectangle(30,30);
        this.vida2.relocate(35, 5);
        this.vida2.setFill(Color.RED);
        this.vida3= new Rectangle(30,30);
        this.vida3.relocate(70, 5);
        this.vida3.setFill(Color.RED);
        this.vidas.getChildren().addAll(vida1,vida2,vida3);
        vidas.maxHeight(200);
        vidas.maxWidth(200);
        return vidas;
    }

    public Pane getP() {
        return p;
    }
    
    public Label getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(String puntaje) {
        this.puntaje.setText(puntaje);
    }

    public Group getVidas() {
        return vidas;
    }

    public void setVidas(Group vidas) {
        this.vidas = vidas;
    }

    public Rectangle getVida1() {
        return vida1;
    }

    public void setVida1(Rectangle vida1) {
        this.vida1 = vida1;
    }

    public Rectangle getVida2() {
        return vida2;
    }

    public void setVida2(Rectangle vida2) {
        this.vida2 = vida2;
    }

    public Rectangle getVida3() {
        return vida3;
    }

    public void setVida3(Rectangle vida3) {
        this.vida3 = vida3;
    }
    
    
}
