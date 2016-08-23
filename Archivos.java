/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Enemigos;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author best buy
 */
public class Archivos {
     private File archivo;

    public Archivos() {
    }
     
   
    
      public void llamarArray(String s) {
        try {
            this.obtenerDeArchivo(s);
        } catch (FileNotFoundException e) {
            System.out.println("No se encuetra el archivo");
        }
    }

      
      public ArrayList<String> obtenerDeArchivo(String nombreDeArchivo) throws FileNotFoundException {
        ArrayList<String> PalabraParaTiburon= new ArrayList();
        this.archivo = new File("C:\\Users\\best buy\\Documents\\NetBeansProjects\\POOProject\\"+nombreDeArchivo+".txt");
        String[] getlinea;
        Scanner leer = new Scanner(archivo);

        while (leer.hasNext()) {
            String linea = leer.nextLine();
            getlinea = linea.split(",");
            for (String p : getlinea) {
                if (PalabraParaTiburon.contains(p) == false) {
                  PalabraParaTiburon.add(p);
                }
            }
        }
        return PalabraParaTiburon;
    }     
    
}
