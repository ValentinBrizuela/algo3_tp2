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

    private Label raza;

    private Label poblacion;

    private Label cantMineral;

    private Label cantGas;

    private VistaMapa vistaMapa;

    public InfoEntidad infoEntidad1;
    public InfoEntidad infoEntidad2;

    public AccionesEntidades accionesEntidad;

    public VistaJuego (VistaMapa vistaMapa, AlgoStar algoStar) {

        this.vistaMapa = vistaMapa;
        this.algoStar = algoStar;
        this.infoEntidad1 = new InfoEntidad();
        this.infoEntidad1.tipo("Seleccionada:");
        this.infoEntidad2 = new InfoEntidad();
        this.infoEntidad2.tipo("Objetivo:");

        ControladorJuego controlador = new ControladorJuego(algoStar, vistaMapa, this);
        this.accionesEntidad = new AccionesEntidades(controlador, this);

        this.setOnMouseClicked((mouseEvent -> {
            controlador.clickEnMapa(mouseEvent);
        }));

        Label turno = new Label("Turno de: ");
        this.nombre = new Label(controlador.obtenerJugador());
        HBox cajaNombre = new HBox(turno, this.nombre);

        this.raza = new Label("Raza: " + algoStar.obtenerJugadorActual().obtenerRaza().getClass().getSimpleName());

        this.poblacion = new Label("Poblacion disponible: " + algoStar.obtenerJugadorActual().obtenerPoblacionUsable());

        Label cantMineral = new Label("Mineral: ");
        this.cantMineral = new Label(controlador.obtenerMineral());
        HBox cajaMineral = new HBox(cantMineral, this.cantMineral);

        Label cantGas = new Label("Gas: ");
        this.cantGas = new Label(controlador.obtenerGas());
        HBox cajaGas = new HBox(cantGas, this.cantGas);

        Button botonAvanzarTurno = new Button("Avanzar Turno");
       /* botonAvanzarTurno.setOnAction((e) -> {
            controlador.avanzarTurno();
            try {
                actualizar();
            } catch (FileNotFoundException ex) {
                throw new RuntimeException(ex);
            }
        });*/
        botonAvanzarTurno.setOnAction((e) -> {
            controlador.avanzarTurno(botonAvanzarTurno);
            try {
                actualizar();
            } catch (FileNotFoundException ex) {
                throw new RuntimeException(ex);
            }
        });

       /* Button botonAtacar = new Button("Atacar");
        botonAtacar.setOnAction((e) -> {
            try {
                controlador.atacar();
                actualizar();

            } catch (Exception ignored) {

            }
        });

        Button botonMover = new Button("Mover");
        botonMover.setOnAction((e) -> {
            try {
                controlador.mover();
                actualizar();
            } catch (Exception ignored) {

            }
        });*/

        TextField construccion = new TextField();
        construccion.setPromptText("Nombre de la construccion");

        Button botonConstruir = new Button("Construir");
        botonConstruir.setOnAction((e) -> {
            try {
                controlador.construir(construccion.getText());
                actualizar();
            } catch (Exception ignored) {

            }
        });

        VBox acciones = new VBox(cajaNombre, raza, poblacion, cajaMineral, cajaGas, construccion, botonConstruir, botonAvanzarTurno, this.infoEntidad1, this.infoEntidad2, this.accionesEntidad);
        acciones.setPadding(new Insets(10));
        acciones.setSpacing(10);


        this.getChildren().addAll(vistaMapa, acciones);
    }

    public void actualizar() throws FileNotFoundException {
        this.nombre.setText(algoStar.obtenerJugadorActual().obtenerNombre());
        this.raza.setText("Raza: " + algoStar.obtenerJugadorActual().obtenerRaza().getClass().getSimpleName());
        this.poblacion.setText("Poblacion disponible: " + algoStar.obtenerJugadorActual().obtenerPoblacionUsable());
        this.cantMineral.setText(Integer.toString(algoStar.obtenerJugadorActual().obtenerAlmacen().cantMineral()));
        this.cantGas.setText(Integer.toString(algoStar.obtenerJugadorActual().obtenerAlmacen().cantGas()));
        this.vistaMapa.actualizar();
        this.infoEntidad1.actualizar();
        this.infoEntidad2.actualizar();
        accionesEntidad.actualizar();
    }

}
