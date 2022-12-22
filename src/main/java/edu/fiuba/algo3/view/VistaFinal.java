package edu.fiuba.algo3.view;

import edu.fiuba.algo3.controller.ControladorFinal;
import edu.fiuba.algo3.modelo.juego.Jugador;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Font;

import java.io.File;

public class VistaFinal extends Pane {
    public VistaFinal(Jugador jugador) {
        Media media = new Media(new File("assets/victoria.mp3").toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        mediaPlayer.play();

        Label felicidades = new Label("Game Over");
        felicidades.setFont(new Font(40));
        felicidades.relocate(500, 150);
        Label ganador = new Label("El ganador es " + jugador.obtenerNombre());
        ganador.setFont(new Font(18));
        ganador.relocate(500, 300);

        Button menu = new Button("Menu");
        menu.setOnAction(new ControladorFinal());
        menu.relocate(550, 600);
        menu.setPrefSize(100, 30);

        this.setStyle("-fx-background-color: rgb(213, 237, 223)");
        this.getChildren().addAll(felicidades, ganador, menu);
    }
}
