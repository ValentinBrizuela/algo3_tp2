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
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.text.*;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class VistaInicio extends VBox {


    public VistaInicio() throws FileNotFoundException {

        Media media = new Media(new File("assets/musicaFondo.mp3").toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        mediaPlayer.setAutoPlay(true);
        mediaPlayer.setVolume(0.1);
        mediaPlayer.play();

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