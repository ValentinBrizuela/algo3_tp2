package edu.fiuba.algo3.view;

import edu.fiuba.algo3.controller.ControladorJuego;
import edu.fiuba.algo3.modelo.juego.AlgoStar;
import edu.fiuba.algo3.modelo.juego.Casilla;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Control;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.FileNotFoundException;

public class VistaJuego extends HBox {

    private AlgoStar algoStar;

    private Label nombre;

    private Label cantMineral;

    private Label cantGas;

    private VistaMapa vistaMapa;

    public VistaJuego (VistaMapa vistaMapa, AlgoStar algoStar, Stage stage) {

        this.vistaMapa = vistaMapa;
        this.algoStar = algoStar;

        ControladorJuego controlador = new ControladorJuego(algoStar);
        this.setOnMouseClicked((mouseEvent -> {
            controlador.clickEnMapa(mouseEvent);
        }));

        Label turno = new Label("Turno de:");

        this.nombre = new Label(controlador.obtenerJugador());
        nombre.setPadding(new Insets(10));

        Label cantMineral = new Label("Mineral");
        this.cantMineral = new Label(controlador.obtenerMineral());
        VBox cajaMineral = new VBox(cantMineral, this.cantMineral);

        Label cantGas = new Label("Gas");
        this.cantGas = new Label(controlador.obtenerGas());
        VBox cajaGas = new VBox(cantGas, this.cantGas);


        Button botonAvanzarTurno = new Button("Avanzar Turno");
        botonAvanzarTurno.setPadding(new Insets(10));
        botonAvanzarTurno.setOnAction((e) -> {
            controlador.avanzarTurno();
            try {
                actualizar();
            } catch (FileNotFoundException ex) {
                throw new RuntimeException(ex);
            }
        });
        botonAvanzarTurno.setPadding(new Insets(10));

        Button botonAtacar = new Button("Atacar");
        botonAtacar.setPadding(new Insets(10));
        botonAtacar.setOnAction((e) -> {
            try {
                controlador.atacar();

            } catch (Exception ignored) {

            }
        });
        botonAtacar.setPadding(new Insets(10));

        Button botonMover = new Button("Mover");
        botonMover.setPadding(new Insets(10));
        botonMover.setOnAction((e) -> {
            try {
                controlador.mover();
            } catch (Exception ignored) {

            }
        });
        botonMover.setPadding(new Insets(10));

        TextField construccion = new TextField();
        construccion.setPromptText("Nombre de la construccion");

        Button botonConstruir = new Button("Construir");
        botonConstruir.setPadding(new Insets(10));
        botonConstruir.setOnAction((e) -> {
            try {
                controlador.construir(construccion.getText());
                actualizar();
            } catch (Exception ignored) {

            }
        });
        botonConstruir.setPadding(new Insets(10));

        VBox acciones = new VBox(turno, nombre, cajaMineral, cajaGas, botonAtacar, botonMover, construccion, botonConstruir, botonAvanzarTurno);

        this.getChildren().addAll(vistaMapa, acciones);
        stage.setFullScreen(true);
    }

    public void actualizar() throws FileNotFoundException {
        nombre.setText(algoStar.obtenerJugadorActual().obtenerNombre());
        this.cantMineral.setText(Integer.toString(algoStar.obtenerJugadorActual().obtenerAlmacen().cantMineral()));
        this.cantGas.setText(Integer.toString(algoStar.obtenerJugadorActual().obtenerAlmacen().cantGas()));
        this.vistaMapa.actualizar();
    }

}
