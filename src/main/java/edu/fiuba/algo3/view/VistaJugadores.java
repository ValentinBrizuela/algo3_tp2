package edu.fiuba.algo3.view;

import edu.fiuba.algo3.controller.ControladorJugadores;
import edu.fiuba.algo3.modelo.juego.AlgoStar;
import javafx.collections.ObservableList;
import javafx.collections.ObservableListBase;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.util.ArrayList;
import java.util.List;

public class VistaJugadores extends VBox {
    private static String fontType = "Tahoma";
    public VistaJugadores(AlgoStar algostar, Stage stage) {
        Label etiquetaZerg = new Label();
        etiquetaZerg.setFont(Font.font(fontType, FontWeight.BOLD, 18));
        etiquetaZerg.setText("Jugador Zerg:");
        etiquetaZerg.relocate(50, 80);

        TextField nombreUsuario1 = new TextField();
        nombreUsuario1.setPromptText("Nombre Jugador Zerg");
        nombreUsuario1.relocate(85, 120);
        nombreUsuario1.setPrefSize(300, 8);

        ColorPicker color1 = new ColorPicker();
        color1.getStyleClass().add("button");
        color1.relocate(385, 120);
        color1.setPrefSize(30, 25);

        Label etiquetaProtoss = new Label();
        etiquetaProtoss.setFont(Font.font(fontType, FontWeight.BOLD, 18));
        etiquetaProtoss.setText("Jugador Protoss:");
        etiquetaProtoss.relocate(50, 240);

        TextField nombreUsuario2 = new TextField();
        nombreUsuario2.setPromptText("Nombre Jugador Protoss");
        nombreUsuario2.relocate(85, 280);
        nombreUsuario2.setPrefSize(300, 8);

        ColorPicker color2 = new ColorPicker();
        color2.getStyleClass().add("button");
        color2.relocate(385, 280);
        color2.setPrefSize(30, 25);

        Button botonJugar = new Button();
        botonJugar.setText("Comenzar");
        botonJugar.setPrefSize(100, 40);
        botonJugar.relocate(200, 400);
        botonJugar.setOnAction(new ControladorJugadores(algostar, nombreUsuario1, nombreUsuario2, color1, color2, stage));

        Pane pane = new Pane(new Label(), new Label(), nombreUsuario1, nombreUsuario2, etiquetaZerg, etiquetaProtoss, new Label(), new Label(), color1, color2, botonJugar);
        pane.setStyle("-fx-background-color: rgb(213, 237, 223)");
        pane.setPrefSize(500, 500);


        this.getChildren().addAll(pane);
    }
}
