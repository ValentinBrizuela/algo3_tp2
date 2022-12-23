package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.juego.AlgoStar;
import edu.fiuba.algo3.modelo.juego.Mapa;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import edu.fiuba.algo3.view.VistaInicio;
import javafx.stage.StageStyle;

import javax.security.auth.login.FailedLoginException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) throws FileNotFoundException {

        stage.setResizable(true);
        stage.setHeight(842);
        stage.setWidth(1200);
        //stage.initStyle(StageStyle.UNDECORATED);
        var scene = new Scene(new VistaInicio());
        stage.getIcons().add(new Image("icon.png"));
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}