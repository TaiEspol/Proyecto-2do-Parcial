/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pooproject;

import Constantes.Constantes;
import IntoMar.Mar;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 *
 * @author Marbelisa
 */
public class Ventana{

    private int ancho;
    private int alto;
    private Button btn1;
    private Button btn2;
    private Button btn3;
    private HBox contenedor;
    private Pane panel;
    private Image imagen;
    private ImageView verImage;
    private Mar mar;
    private Button btnInicio;
    private Button btnSalir;
    private Button btnArma;
    private Thread t;

    public Ventana(int ancho, int alto) {
        this.ancho = ancho;
        this.alto = alto;
        this.btn1 = new Button("Jugar");
        this.btn2 = new Button("Acerca de");
        this.btn3 = new Button("Top 10");
        contenedor = new HBox(20);
        this.panel = new Pane();
        this.imagen = new Image(Ventana.class.getResource("fondo-marino-con-sirenas-y-peces-de-colores-.jpg").toExternalForm());
        verImage = new ImageView();
        this.verImage.setImage(imagen);
        this.mar = new Mar(ancho, alto, 4);
        this.contenedor.relocate(ancho / 2, alto / 2);
        this.agregarBoton(ancho, alto);
        
        panel.getChildren().addAll(verImage, contenedor);
        

    }

    public Pane getPanel() {
        return panel;
    }

    public Button getBtnSalir() {
        return btnSalir;
    }

    public void agregarBoton(int ancho, int alto) {
        this.contenedor.getChildren().addAll(btn1, btn2, btn3);
        contenedor.setAlignment(Pos.CENTER);
        btnInicio = new Button("Iniciar");
        btnInicio.setOnAction(new Iniciar());
        btnInicio.relocate(550, 650);
        btnArma = new Button("ENTER(Arma Especial)");
        btnArma.setOnKeyPressed(new Teclea());
        btnArma.setFocusTraversable(true);
        btnArma.relocate(650, 650);
        btnSalir = new Button("Salir");
        btnSalir.relocate(850, 650);
        mar.getP().getChildren().addAll(btnInicio,btnArma, btnSalir);
        mar.getP().setFocusTraversable(true);
        btn1.setOnAction(new Click(new Scene(mar.getP())));
       
    }
    
    

    private class Click implements EventHandler<ActionEvent> {
        private Stage ventana;
        private Scene scene;
        public Click(Scene scene) {
            this.scene = scene;
        }

        @Override
        public void handle(ActionEvent e) {

            ventana = (Stage) ((Node) e.getSource()).getScene().getWindow();
            ventana.setScene(scene);
            e.consume();
        }

    }

    private class Iniciar implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent e) {
            t = new Thread(mar);
            t.start();
            
            e.consume();
        }

    }
    
    private class Teclea implements EventHandler<KeyEvent>{

        @Override
        public void handle(KeyEvent e) {
            if(e.getCode()==KeyCode.ENTER){
                if(mar.getBuso().getPuntaje()>=100){
                    System.out.println("pulso enter");
                    for(int i=0;i<mar.getThread().size();i++){
                        mar.getThread().get(mar.getTiburones().get(i)).interrupt();
                    }
                }
            }
        }
        
    }
    

    
    

}
