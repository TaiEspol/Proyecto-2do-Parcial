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

/**
 *
 * @author Marbelisa
 */
public class Palabras {

    private File archivo;
    private ArrayList<String> palabras;
    //private ArrayList<String> numPez;
    private String[] linea;
    private Random random = new Random();

    public Palabras() {
        palabras = new ArrayList<String>();
        this.llamarArray();

    }

    public ArrayList<String> getPalabras() {
        return palabras;
    }

    /*public ArrayList<String> getNumPez(int num) {
        numPez = new ArrayList<String>();
        while(numPez.size()!=num){
            int valor=random.nextInt(palabras.size());
            if(numPez.contains(palabras.get(valor))==false){
                numPez.add(palabras.get(valor));
            }
        }
        return numPez;
    }*/
    public ArrayList<String> getWord(int valor) {
        ArrayList<String> word = new ArrayList();
        String palabra = palabras.get(valor);
        for (int i = 0; i < palabra.length(); i++) {
            String s = (String.valueOf(palabra.charAt(i)));
            word.add(s);
        }

        return word;
    }

    public void llamarArray() {
        try {
            this.obtenerDeArchivo();
        } catch (FileNotFoundException e) {
            System.out.println("No se encuetra el archivo");
        }
    }

    public void obtenerDeArchivo() throws FileNotFoundException {
        this.archivo = new File("C:\\Users\\best buy\\Documents\\NetBeansProjects\\New Folder\\POOProject\\palabras.txt");
        
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
