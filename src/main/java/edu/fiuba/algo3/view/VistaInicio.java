package edu.fiuba.algo3.view;

import edu.fiuba.algo3.modelo.juego.AlgoStar;
import javafx.scene.layout.Pane;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.scene.text.*;

public class VistaInicio extends VBox {


    public VistaInicio(AlgoStar algoStar) {
        Label etiquetaVehiculo = new Label();
        etiquetaVehiculo.setFont(Font.font("Tahoma", FontWeight.BOLD, 20));
        etiquetaVehiculo.setText("Algo Star:");
        etiquetaVehiculo.relocate(200, 100);

        Button botonJugar = new Button();
        botonJugar.setText("Jugar");
        botonJugar.relocate(225, 250);
        botonJugar.setOnAction((event) -> {
            ((Button)event.getSource()).getScene().setRoot(new VistaJugadores(algoStar));
        });

        Pane pane = new Pane(etiquetaVehiculo, botonJugar);
        pane.setStyle("-fx-background-color: rgb(213, 237, 223)");
        pane.setPrefSize(500, 500);

        this.getChildren().addAll(pane);
    }

}