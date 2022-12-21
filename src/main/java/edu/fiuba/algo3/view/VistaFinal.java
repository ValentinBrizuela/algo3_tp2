package edu.fiuba.algo3.view;

import edu.fiuba.algo3.modelo.juego.Jugador;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

public class VistaFinal extends Pane {
    public VistaFinal(Jugador jugador) {
        Label felicidades = new Label("Game Over");
        felicidades.relocate(200, 100);
        Label ganador = new Label("El ganador es " + jugador.obtenerNombre());
        ganador.relocate(100, 300);
        this.setPrefSize(500, 500);
        this.getChildren().addAll(felicidades, ganador);
    }
}
