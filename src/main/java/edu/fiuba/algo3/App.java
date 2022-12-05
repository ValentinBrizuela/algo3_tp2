package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.juego.AlgoStar;
import edu.fiuba.algo3.modelo.juego.Mapa;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import edu.fiuba.algo3.view.VistaInicio;
import javafx.stage.StageStyle;

/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {

        Mapa mapa = new Mapa(2);
        AlgoStar algoStar = new AlgoStar(mapa);
        stage.setResizable(false);
        stage.initStyle(StageStyle.UNDECORATED);
        var scene = new Scene(new VistaInicio(algoStar, stage));
        stage.getIcons().add(new Image("icon.png"));
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}