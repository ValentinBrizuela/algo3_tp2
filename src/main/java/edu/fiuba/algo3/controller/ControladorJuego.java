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
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.security.Signature;

public class ControladorJuego {

    final int escalado = 8;
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
        if ((int) (mouseEvent.getX()/escalado) < this.algoStar.mapa.tamanioMapa() && (int) (mouseEvent.getY()/escalado) < algoStar.mapa.tamanioMapa()) {
            if (mouseEvent.getButton() == MouseButton.PRIMARY) {
                this.casillaActiva = algoStar.mapa.obtenerCasilla((int)(mouseEvent.getX()/escalado), (int)(mouseEvent.getY()/escalado));
                this.vistaMapa.dibujarBordeCasillaPrimaria((int)(mouseEvent.getX()/escalado), (int)(mouseEvent.getY()/escalado));
                this.vistaJuego.infoEntidad1.cambiarCasilla(this.casillaActiva);
                this.vistaJuego.accionesEntidad.cambiarCasilla(this.casillaActiva);
            }
            if (mouseEvent.getButton() == MouseButton.SECONDARY) {
                this.casillaObjetivo = algoStar.mapa.obtenerCasilla((int)(mouseEvent.getX()/escalado), (int)(mouseEvent.getY()/escalado));
                this.vistaMapa.dibujarBordeCasillaSecundaria((int)(mouseEvent.getX()/escalado), (int)(mouseEvent.getY()/escalado));
                this.vistaJuego.infoEntidad2.cambiarCasilla(this.casillaObjetivo);
            }
        }
    }

    public void avanzarTurno(Button boton) {
        //boton.getScene().setRoot(new VistaFinal(algoStar.obtenerJugadorActual()));
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
        return Integer.toString(algoStar.obtenerJugadorActual().obtenerMineral());
    }

    public String obtenerGas() {
        return Integer.toString(algoStar.obtenerJugadorActual().obtenerGas());
    }

    public void atacar() throws FileNotFoundException {

        Media media = new Media(new File("assets/espada.mp3").toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        mediaPlayer.play();

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
