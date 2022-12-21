package edu.fiuba.algo3.controller;

import edu.fiuba.algo3.modelo.edificios.Extractor;
import edu.fiuba.algo3.modelo.juego.AlgoStar;
import edu.fiuba.algo3.modelo.juego.Casilla;
import edu.fiuba.algo3.modelo.unidades.Mutalisco;
import edu.fiuba.algo3.modelo.unidades.Zangano;
import edu.fiuba.algo3.view.VistaFinal;
import edu.fiuba.algo3.view.VistaJuego;
import edu.fiuba.algo3.view.VistaMapa;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;

import java.security.Signature;

public class ControladorJuego {
    private AlgoStar algoStar;

    private VistaMapa vistaMapa;
    private VistaJuego vistaJuego;
    private Casilla casillaActiva;
    private Casilla casillaObjetivo;
    public ControladorJuego(AlgoStar algoStar, VistaMapa vistaMapa, VistaJuego vistaJuego) {
        this.algoStar = algoStar;
        this.vistaMapa = vistaMapa;
        this.vistaJuego = vistaJuego;
    }

    public void clickEnMapa(MouseEvent mouseEvent) {
        if ((int) (mouseEvent.getX()/8) < this.algoStar.mapa.tamanioMapa() && (int) (mouseEvent.getY()/8) < algoStar.mapa.tamanioMapa()) {
            if (mouseEvent.getButton() == MouseButton.PRIMARY) {
                this.casillaActiva = algoStar.mapa.obtenerCasilla((int) (mouseEvent.getX()/8), (int) (mouseEvent.getY()/8));
                this.vistaMapa.dibujarBordeCasillaPrimaria((int) (mouseEvent.getX()/8), (int) (mouseEvent.getY()/8));
                this.vistaJuego.infoEntidad1.cambiarCasilla(this.casillaActiva);
                this.vistaJuego.accionesEntidad.cambiarCasilla(this.casillaActiva);
            }
            if (mouseEvent.getButton() == MouseButton.SECONDARY) {
                this.casillaObjetivo = algoStar.mapa.obtenerCasilla((int) (mouseEvent.getX()/8), (int) (mouseEvent.getY()/8));
                this.vistaMapa.dibujarBordeCasillaSecundaria((int) (mouseEvent.getX()/8), (int) (mouseEvent.getY()/8));
                this.vistaJuego.infoEntidad2.cambiarCasilla(this.casillaObjetivo);
            }
        }
    }

    public void avanzarTurno(Button boton) {
       // boton.getScene().setRoot(new VistaFinal(algoStar.obtenerJugadorActual()));
        if (algoStar.hayGanador()) {
            boton.getScene().setRoot(new VistaFinal(algoStar.obtenerJugadorActual()));
        }
        else {
            algoStar.avanzarTurno();
        }
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
        String s = algoStar.atacaraPosicion(casillaActiva.obtenerPosX(), casillaActiva.obtenerPosY(), casillaObjetivo.obtenerPosX(), casillaObjetivo.obtenerPosY());
        if ( s != null) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText(s);

            alert.showAndWait();
        }
    }

    public void mover() {
        String s = algoStar.mover(casillaActiva.obtenerPosX(), casillaActiva.obtenerPosY(), casillaObjetivo.obtenerPosX(), casillaObjetivo.obtenerPosY());
        if ( s != null) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText(s);

            alert.showAndWait();
        }
    }

    public void construir(String construccion) {
        algoStar.construirEntidad(construccion, casillaActiva.obtenerPosX(), casillaActiva.obtenerPosY());
    }

    public void evolucionarGuardian() {
        try {
            ((Mutalisco)casillaActiva.obtenerEntidad()).evolucionarAGuardian(algoStar.obtenerJugadorActual().obtenerAlmacen());
        } catch (Exception e) {

        }
    }
    public void evolucionarDevorador() {
        try {
            ((Mutalisco)casillaActiva.obtenerEntidad()).evolucionarADevorador(algoStar.obtenerJugadorActual().obtenerAlmacen());
        } catch (Exception e) {

        }
    }

    public void meterZangano() {
        try {
            ((Extractor)casillaActiva.obtenerEntidad()).meterZangano((Zangano)casillaObjetivo.obtenerEntidad());
        } catch (Exception e) {

        }
    }
}
