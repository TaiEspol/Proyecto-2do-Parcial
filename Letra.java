/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Enemigos;

import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

/**
 *
 * @author Marbelisa
 */
public final class Letra  {
    private Label letra;
    public Letra(String text,double x,double y) {
       this.letra=new Label(text);
      letra.relocate(x, y);
    }
    public Label getLetra() {
        return letra;
    }
    public void setText(Group p) {
        letra.setFont(Font.font("Time New Roman", 35));
        letra.setTextFill(Color.CHARTREUSE);
        p.getChildren().add(letra);
    }
    
}
