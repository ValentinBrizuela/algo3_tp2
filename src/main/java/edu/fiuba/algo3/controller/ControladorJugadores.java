package edu.fiuba.algo3.controller;
import edu.fiuba.algo3.modelo.errores.NombreDeJugadorInvalidoError;
import edu.fiuba.algo3.modelo.juego.AlgoStar;
import edu.fiuba.algo3.modelo.juego.Jugador;
import edu.fiuba.algo3.modelo.razas.Protoss;
import edu.fiuba.algo3.modelo.razas.Zerg;
import edu.fiuba.algo3.view.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class ControladorJugadores implements EventHandler<ActionEvent> {
    AlgoStar algoStar;
    TextField nombreUsuario1;
    TextField nombreUsuario2;
    ColorPicker color1;
    ColorPicker color2;

    Stage stage;

    public ControladorJugadores(AlgoStar algoStar, TextField jugador1, TextField jugador2, ColorPicker color1, ColorPicker color2, Stage stage) {
        this.algoStar = algoStar;
        this.nombreUsuario1 = jugador1;
        this.nombreUsuario2 = jugador2;
        this.color1 = color1;
        this.color2 = color2;
        this.stage = stage;

    }
    @Override
    public void handle(ActionEvent actionEvent) {
        try {
            System.out.print(color1);
            System.out.print(color2);
            Jugador jugador1 = new Jugador(nombreUsuario1.getText(), color1.getValue(), new Zerg());
            Jugador jugador2 = new Jugador(nombreUsuario2.getText(), color2.getValue(), new Protoss());

            algoStar.registrarJugadores(jugador1, jugador2);
            ((Button)actionEvent.getSource()).getScene().setRoot(new VistaMapa(algoStar, stage));
        } catch (Exception e) {
            System.out.print(e);
        }
    }
}
