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
    private String s;
    

    public Letra(String text, double x, double y) {
        this.s = text;
        this.letra = new Label(text);
        letra.relocate(x, y);
        this.setText();

    }
    

    public Label getLetra() {
        return letra;
    }

    public void setText() {
        letra.setFont(Font.font("Time New Roman", 50));
        letra.setTextFill(Color.RED);
    }
    public String getS() {
        return s;
    }
    
}
