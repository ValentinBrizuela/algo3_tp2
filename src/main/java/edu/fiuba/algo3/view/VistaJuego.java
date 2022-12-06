package edu.fiuba.algo3.view;

import edu.fiuba.algo3.modelo.juego.AlgoStar;
import edu.fiuba.algo3.modelo.juego.Casilla;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class VistaJuego extends HBox {

    private AlgoStar algoStar;

    private Label nombre;

    private Label cantMineral;

    private Label cantGas;

    private Casilla casillaActiva;
    private Casilla casillaObjetivo;

    public VistaJuego (Pane vistaMapa, AlgoStar algoStar, Stage stage) {

        this.algoStar = algoStar;

        this.setOnMouseClicked((mouseEvent -> {
            if ((int) (mouseEvent.getX()/8) < algoStar.mapa.tamanioMapa() && (int) (mouseEvent.getY()/8) < algoStar.mapa.tamanioMapa()) {
                if (mouseEvent.getButton() == MouseButton.PRIMARY) {
                    this.casillaActiva = algoStar.mapa.obtenerCasilla((int) (mouseEvent.getX()/8), (int) (mouseEvent.getY()/8));
                }
                if (mouseEvent.getButton() == MouseButton.SECONDARY) {
                    this.casillaObjetivo = algoStar.mapa.obtenerCasilla((int) (mouseEvent.getX()/8), (int) (mouseEvent.getY()/8));
                }
            }
        }));

        Label turno = new Label("Turno de:");

        this.nombre = new Label(algoStar.obtenerJugadorActual().obtenerNombre());
        nombre.setPadding(new Insets(10));

        Label cantMineral = new Label("Mineral");
        this.cantMineral = new Label(Integer.toString(algoStar.obtenerJugadorActual().obtenerAlmacen().cantMineral()));
        VBox cajaMineral = new VBox(cantMineral, this.cantMineral);

        Label cantGas = new Label("Gas");
        this.cantGas = new Label(Integer.toString(algoStar.obtenerJugadorActual().obtenerAlmacen().cantGas()));
        VBox cajaGas = new VBox(cantGas, this.cantGas);


        Button botonAvanzarTurno = new Button("Avanzar Turno");
        botonAvanzarTurno.setPadding(new Insets(10));
        botonAvanzarTurno.setOnAction((e)->{
            algoStar.avanzarTurno();
            actualizar();
        });
        botonAvanzarTurno.setPadding(new Insets(10));

        Button botonAtacar = new Button("Atacar");
        botonAtacar.setPadding(new Insets(10));
        botonAtacar.setOnAction((e)->{
            try {
                algoStar.atacaraPosicion(casillaActiva.obtenerPosX(), casillaActiva.obtenerPosY(), casillaObjetivo.obtenerPosX(), casillaObjetivo.obtenerPosY());
            } catch (Exception ignored) {

            }
        });
        botonAtacar.setPadding(new Insets(10));

        Button botonMover = new Button("Mover");
        botonMover.setPadding(new Insets(10));
        botonMover.setOnAction((e)->{
            try {
                algoStar.atacaraPosicion(casillaActiva.obtenerPosX(), casillaActiva.obtenerPosY(), casillaObjetivo.obtenerPosX(), casillaObjetivo.obtenerPosY());
            } catch (Exception ignored) {

            }
        });
        botonMover.setPadding(new Insets(10));

        Button botonConstruir = new Button("Construir");
        botonConstruir.setPadding(new Insets(10));
        botonConstruir.setOnAction((e)->{
            try {
                algoStar.construirEdificio("Criadero", casillaActiva.obtenerPosX(), casillaActiva.obtenerPosY());
                this.cantMineral.setText(Integer.toString(algoStar.obtenerJugadorActual().obtenerAlmacen().cantMineral()));
                this.cantGas.setText(Integer.toString(algoStar.obtenerJugadorActual().obtenerAlmacen().cantGas()));
            } catch (Exception ignored) {

            }
        });
        botonConstruir.setPadding(new Insets(10));

        VBox acciones = new VBox(turno, nombre, cajaMineral, cajaGas, botonAtacar, botonMover, botonConstruir, botonAvanzarTurno);

        this.getChildren().addAll(vistaMapa, acciones);
        stage.setFullScreen(true);
    }

    public void actualizar() {
        nombre.setText(algoStar.obtenerJugadorActual().obtenerNombre());
    }

}
