package edu.fiuba.algo3.controller;

import edu.fiuba.algo3.modelo.juego.AlgoStar;
import edu.fiuba.algo3.modelo.juego.Mapa;
import edu.fiuba.algo3.view.VistaInicio;
import edu.fiuba.algo3.view.VistaJugadores;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class ControladorInicio implements EventHandler<ActionEvent> {
    @Override
    public void handle(ActionEvent actionEvent) {
        Mapa mapa = new Mapa(2);
        AlgoStar algoStar = new AlgoStar(mapa);
        ((Button)actionEvent.getSource()).getScene().setRoot(new VistaJugadores(algoStar));
    }
}
