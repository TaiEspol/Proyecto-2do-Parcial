/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Enemigos;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;

/**
 *
 * @author Marbelisa
 */
public final class Palabras{

    private File archivo;
    private final ArrayList<String> palabras;
    private final Group group;
    private String[] linea;
    private Letra [] letra;
    private ArrayList<Label> labelWord;
    
    public Palabras() {
        group= new Group();
        palabras = new ArrayList<>();
        labelWord= new ArrayList<>();
        this.llamarArray();
        group.setFocusTraversable(true);

    }

    public ArrayList<String> getPalabras() {
        return palabras;
    }

    public Letra[] getLetra() {
        return letra;
    }
    
    

    public ArrayList<String> getWord(int valor) {
        ArrayList<String> word = new ArrayList();
        String palabra = palabras.get(valor);
        for (int i = 0; i < palabra.length(); i++) {
            String s = (String.valueOf(palabra.charAt(i)));
            word.add(s);
        }

        return word;
    }
    
    public Group getPalabraEnLabel( double posx,double posy){
        int valor= (int) (Math.random()*(this.getPalabras().size()));
        letra= new Letra[this.getWord(valor).size()];
        
        int x=10;
        for(int i=0; i<letra.length; i++){
            letra[i]=new Letra(this.getWord(valor).get(i),(x),10);
            this.labelWord.add(letra[i].getLetra());
            group.getChildren().add(letra[i].getLetra());
            group.relocate(posx, posy);
            x=30+x;
        }
        return group; 
    }

    public ArrayList<Label> getLabelWord() {
        return labelWord;
    }
    
    

    public void llamarArray() {
        try {
            this.obtenerDeArchivo();
        } catch (FileNotFoundException e) {
            System.out.println("No se encuetra el archivo");
        }
    }
    
    
    public void obtenerDeArchivo() throws FileNotFoundException {
        //this.archivo = new File(Palabras.class.getResource("palabras.txt").toExternalForm());
        this.archivo = new File("C:\\Users\\Marbelisa\\Desktop\\Proyecto\\POOProject\\src\\Enemigos\\palabras.txt");
        Scanner leer = new Scanner(archivo);

        while (leer.hasNext()) {
            String linea = leer.nextLine();
            this.linea = linea.split(",");
            for (String p : this.linea) {
                if (palabras.contains(p) == false) {
                    palabras.add(p);
                }
            }
        }
    }

}
