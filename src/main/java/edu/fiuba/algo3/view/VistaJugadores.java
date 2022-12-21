package edu.fiuba.algo3.view;

import edu.fiuba.algo3.controller.ControladorJugadores;
import edu.fiuba.algo3.modelo.juego.AlgoStar;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableListBase;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Callback;

import java.util.ArrayList;
import java.util.List;

public class VistaJugadores extends VBox {
    private static String fontType = "Tahoma";
    public VistaJugadores(AlgoStar algostar) {
        ObservableList<String> data = FXCollections.observableArrayList(
                "red", "blue", "yellow", "green", "pink", "orange");
        Callback<ListView<String>, ListCell<String>> factory = new Callback<ListView<String>, ListCell<String>>() {
            @Override
            public ListCell<String> call(ListView<String> list) {
                return new ColorRectCell();
            }
        };


        Label etiquetaZerg = new Label();
        etiquetaZerg.setFont(Font.font(fontType, FontWeight.BOLD, 18));
        etiquetaZerg.setText("Jugador Zerg:");
        etiquetaZerg.relocate(450, 80);

        TextField nombreUsuario1 = new TextField();
        nombreUsuario1.setPromptText("Nombre Jugador Zerg");
        nombreUsuario1.relocate(485, 120);
        nombreUsuario1.setPrefSize(300, 8);

        ComboBox color1 = new ComboBox<String>();
        color1.getStyleClass().add("button");
        color1.setItems(data);
        color1.relocate(785, 120);
        color1.setPrefSize(30, 25);
        color1.setCellFactory(factory);
        color1.setButtonCell(factory.call(null));

        Label etiquetaProtoss = new Label();
        etiquetaProtoss.setFont(Font.font(fontType, FontWeight.BOLD, 18));
        etiquetaProtoss.setText("Jugador Protoss:");
        etiquetaProtoss.relocate(450, 240);

        TextField nombreUsuario2 = new TextField();
        nombreUsuario2.setPromptText("Nombre Jugador Protoss");
        nombreUsuario2.relocate(485, 280);
        nombreUsuario2.setPrefSize(300, 8);

        ComboBox<String> color2 = new ComboBox<String>();
        color2.setPrefSize(30, 25);
        color2.setItems(data);



        color2.setCellFactory(factory);
        color2.setButtonCell(factory.call(null));

        //ColorPicker color2 = new ColorPicker();
        //color2.getStyleClass().add("button");
        color2.relocate(785, 280);
        color2.setPrefSize(30, 25);

        Button botonJugar = new Button();
        botonJugar.setText("Comenzar");
        botonJugar.setPrefSize(100, 40);
        botonJugar.relocate(550, 400);
        botonJugar.setOnAction(new ControladorJugadores(algostar, nombreUsuario1, nombreUsuario2, color1, color2));

        Button btn = new Button();
        btn.setText("X");
        btn.setPrefSize(30, 20);
        btn.setOnAction((ActionEvent event) -> {
            Platform.exit();
        });
        btn.relocate(1145,5);

        Pane pane = new Pane(new Label(), new Label(), nombreUsuario1, nombreUsuario2, etiquetaZerg, etiquetaProtoss, new Label(), new Label(), color1, color2, botonJugar, btn);

        this.setStyle("-fx-background-color: rgb(213, 237, 223)");
        this.getChildren().addAll(pane);
    }
    static class ColorRectCell extends ListCell<String>{
        @Override
        public void updateItem(String item, boolean empty){

            super.updateItem(item, empty);
            Rectangle rect = new Rectangle(20,10);
            if(item != null){
                rect.setFill(Color.web(item));
                setGraphic(rect);
            }
        }
    }
}
