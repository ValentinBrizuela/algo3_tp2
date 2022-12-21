package edu.fiuba.algo3.view;

import edu.fiuba.algo3.controller.ControladorInicio;
import edu.fiuba.algo3.modelo.juego.AlgoStar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.*;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class VistaInicio extends VBox {


    public VistaInicio() throws FileNotFoundException {


        ImageView etiquetaTitulo = new ImageView(new Image(getClass().getResourceAsStream("/AlgoStarLogo.png")));
        etiquetaTitulo.relocate(350, 150);

        Button botonJugar = new Button();
        botonJugar.setText("Jugar");
        botonJugar.relocate(530, 400);
        botonJugar.setPrefSize(70,50);
        botonJugar.setOnAction(new ControladorInicio());

        Image menu = new Image(new FileInputStream("assets/menu.png"));
        ImageView fondo = new ImageView(menu);
        fondo.fitHeightProperty().bind(this.heightProperty());
        fondo.fitWidthProperty().bind(this.widthProperty());

        Button btn = new Button();
        btn.setText("X");
        btn.setPrefSize(30, 20);
        btn.setOnAction((ActionEvent event) -> {
            Platform.exit();
        });
        btn.relocate(1145,5);

        Pane pane = new Pane(fondo, etiquetaTitulo, botonJugar, btn);
        pane.setStyle("-fx-background-image: url(menu.gif);-fx-background-repeat: stretch;-fx-background-size: 500 500;-fx-background-position: center center; -fx-effect: dropshadow(three-pass-box, black, 30, 0.5, 0, 0);");

        this.getChildren().addAll(pane);
    }

}