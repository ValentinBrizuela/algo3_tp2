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
import javafx.scene.control.TextField;

public class ControladorJugadores implements EventHandler<ActionEvent> {
    AlgoStar algoStar;
    TextField nombreUsuario1;
    TextField nombreUsuario2;
    TextField color1;
    TextField color2;

    public ControladorJugadores(AlgoStar algoStar, TextField jugador1, TextField jugador2, TextField color1, TextField color2) {
        this.algoStar = algoStar;
        this.nombreUsuario1 = jugador1;
        this.nombreUsuario2 = jugador2;
        this.color1 = color1;
        this.color2 = color2;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        try {
            Jugador jugador1 = new Jugador(nombreUsuario1.getText(), color1.getText(), new Zerg());
            Jugador jugador2 = new Jugador(nombreUsuario2.getText(), color2.getText(), new Protoss());
            algoStar.registrarJugadores(jugador1, jugador2);
            ((Button)actionEvent.getSource()).getScene().setRoot(new VistaMapa(algoStar));
        } catch (Exception e) {
            System.out.print("a");
        }
    }
}
