package edu.fiuba.algo3.controller;

import edu.fiuba.algo3.modelo.juego.AlgoStar;
import edu.fiuba.algo3.modelo.juego.Casilla;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;

public class ControladorJuego {
    private AlgoStar algoStar;
    private Casilla casillaActiva;
    private Casilla casillaObjetivo;
    public ControladorJuego(AlgoStar algoStar) {
        this.algoStar = algoStar;
    }

    public void clickEnMapa(MouseEvent mouseEvent) {

        if ((int) (mouseEvent.getX()/8) < this.algoStar.mapa.tamanioMapa() && (int) (mouseEvent.getY()/8) < algoStar.mapa.tamanioMapa()) {
            if (mouseEvent.getButton() == MouseButton.PRIMARY) {
                this.casillaActiva = algoStar.mapa.obtenerCasilla((int) (mouseEvent.getX()/8), (int) (mouseEvent.getY()/8));
            }
            if (mouseEvent.getButton() == MouseButton.SECONDARY) {
                this.casillaObjetivo = algoStar.mapa.obtenerCasilla((int) (mouseEvent.getX()/8), (int) (mouseEvent.getY()/8));
            }
        }
    }

    public void avanzarTurno() {
        algoStar.avanzarTurno();
    }

    public String obtenerJugador() {
        return algoStar.obtenerJugadorActual().obtenerNombre();
    }

    public String obtenerMineral() {
        return Integer.toString(algoStar.obtenerJugadorActual().obtenerAlmacen().cantMineral());
    }

    public String obtenerGas() {
        return Integer.toString(algoStar.obtenerJugadorActual().obtenerAlmacen().cantGas());
    }

    public void atacar() {
        algoStar.atacaraPosicion(casillaActiva.obtenerPosX(), casillaActiva.obtenerPosY(), casillaObjetivo.obtenerPosX(), casillaObjetivo.obtenerPosY());
    }

    public void mover() {
        algoStar.atacaraPosicion(casillaActiva.obtenerPosX(), casillaActiva.obtenerPosY(), casillaObjetivo.obtenerPosX(), casillaObjetivo.obtenerPosY());
    }

    public void construir(String construccion) {
        algoStar.construirEdificio(construccion, casillaActiva.obtenerPosX(), casillaActiva.obtenerPosY());
    }
}
