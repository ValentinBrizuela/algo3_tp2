package edu.fiuba.algo3.controller;
import edu.fiuba.algo3.modelo.juego.AlgoStar;
import edu.fiuba.algo3.modelo.juego.Jugador;
import edu.fiuba.algo3.modelo.razas.Protoss;
import edu.fiuba.algo3.modelo.razas.Zerg;
import edu.fiuba.algo3.view.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class ControladorJugadores implements EventHandler<ActionEvent> {
    AlgoStar algoStar;
    TextField nombreUsuario1;
    TextField nombreUsuario2;
    ComboBox color1;
    ComboBox color2;

    Stage stage;

    public ControladorJugadores(AlgoStar algoStar, TextField jugador1, TextField jugador2, ComboBox color1, ComboBox color2, Stage stage) {
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
            Jugador jugador1 = new Jugador(nombreUsuario1.getText(), Color.web(color1.getValue().toString()), new Zerg());
            Jugador jugador2 = new Jugador(nombreUsuario2.getText(), Color.web(color2.getValue().toString()), new Protoss());

            algoStar.registrarJugadores(jugador1, jugador2);
            ((Button)actionEvent.getSource()).getScene().setRoot(new VistaJuego(new VistaMapa(algoStar, stage), algoStar, stage));
        } catch (Exception e) {
            System.out.print(e);
        }
    }
}
