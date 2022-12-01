package edu.fiuba.algo3.view;

import edu.fiuba.algo3.controller.ControladorJugadores;
import edu.fiuba.algo3.modelo.juego.AlgoStar;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class VistaJugadores extends VBox {
    private static String fontType = "Tahoma";
    public VistaJugadores(AlgoStar algostar) {
        Label etiquetaZerg = new Label();
        etiquetaZerg.setFont(Font.font(fontType, FontWeight.BOLD, 18));
        etiquetaZerg.setText("Jugador Zerg:");
        etiquetaZerg.relocate(50, 80);

        Label etiquetaUsuario1 = new Label();
        etiquetaUsuario1.setFont(Font.font(fontType, FontWeight.BOLD, 10));
        etiquetaUsuario1.setText("Ingrese nombre:");
        etiquetaUsuario1.relocate(50, 120);

        TextField nombreUsuario1 = new TextField();
        nombreUsuario1.relocate(150, 120);
        nombreUsuario1.setPrefSize(300, 8);

        Label etiquetaColor1 = new Label();
        etiquetaColor1.setFont(Font.font(fontType, FontWeight.BOLD, 10));
        etiquetaColor1.setText("Ingrese color:");
        etiquetaColor1.relocate(50, 160);

        TextField color1 = new TextField();
        color1.relocate(150, 160);
        color1.setPrefSize(300, 8);

        Label etiquetaProtoss = new Label();
        etiquetaProtoss.setFont(Font.font(fontType, FontWeight.BOLD, 18));
        etiquetaProtoss.setText("Jugador Protoss:");
        etiquetaProtoss.relocate(50, 240);

        Label etiquetaUsuario2 = new Label();
        etiquetaUsuario2.setFont(Font.font(fontType, FontWeight.BOLD, 10));
        etiquetaUsuario2.setText("Ingrese nombre:");
        etiquetaUsuario2.relocate(50, 280);

        TextField nombreUsuario2 = new TextField();
        nombreUsuario2.relocate(150, 280);
        nombreUsuario2.setPrefSize(300, 8);

        Label etiquetaColor2 = new Label();
        etiquetaColor2.setFont(Font.font(fontType, FontWeight.BOLD, 10));
        etiquetaColor2.setText("Ingrese color:");
        etiquetaColor2.relocate(50, 320);

        TextField color2 = new TextField();
        color2.relocate(150, 320);
        color2.setPrefSize(300, 8);

        Button botonJugar = new Button();
        botonJugar.setText("comenzar");
        botonJugar.relocate(225, 400);
        botonJugar.setOnAction(new ControladorJugadores(algostar, nombreUsuario1, nombreUsuario2, color1, color2));

        Pane pane = new Pane(etiquetaUsuario1, etiquetaUsuario2, nombreUsuario1, nombreUsuario2, etiquetaZerg, etiquetaProtoss, etiquetaColor1, etiquetaColor2, color1, color2, botonJugar);
        pane.setStyle("-fx-background-color: rgb(213, 237, 223)");
        pane.setPrefSize(500, 500);


        this.getChildren().addAll(pane);
    }
}
