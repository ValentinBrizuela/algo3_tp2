package edu.fiuba.algo3.view;

import edu.fiuba.algo3.controller.ControladorJuego;
import edu.fiuba.algo3.modelo.juego.Casilla;
import edu.fiuba.algo3.modelo.unidades.Zangano;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

import java.io.FileNotFoundException;

public class AccionesEntidades extends VBox {

    private Casilla casilla;

    private ControladorJuego controlador;

    private VistaJuego vista;

    public AccionesEntidades(ControladorJuego controladorJuego, VistaJuego vistaJuego) {
        casilla = null;
        controlador = controladorJuego;
        vista = vistaJuego;
    }

    public void cambiarCasilla(Casilla casilla) {
        this.casilla = casilla;
        actualizar();
    }

    public void actualizar() {
        this.getChildren().clear();

        Button botonAtacar = new Button("Atacar");
        botonAtacar.setOnAction((e) -> {
            try {
                controlador.atacar();
                vista.actualizar();
            } catch (Exception ignored) {
                System.out.print("Error en ataque");
            }
        });

        Button botonMover = new Button("Mover");
        botonMover.setOnAction((e) -> {
            try {
                controlador.mover();
                vista.actualizar();
            } catch (Exception ignored) {

            }
        });

        Button botonEvolucionarGuardian = new Button("Evolucionar a Guardian");
        botonEvolucionarGuardian.setOnAction((e) -> {
            try {
                controlador.evolucionarGuardian();
                vista.actualizar();
            } catch (Exception ignored) {

            }
        });

        Button botonEvolucionarDevorador = new Button("Evolucionar a Devorador");
        botonEvolucionarDevorador.setOnAction((e) -> {
            try {
                controlador.evolucionarDevorador();
                vista.actualizar();
            } catch (Exception ignored) {

            }
        });

        Button botonMeterZangano = new Button("Meter Zangano");
        botonMeterZangano.setOnAction((e) -> {
            try {
                controlador.meterZangano();
                vista.actualizar();
            } catch (Exception ex) {

            }
        });

        try {
            switch (casilla.obtenerEntidad().getClass().getSimpleName()) {
                case "Zangano":
                    this.getChildren().addAll(botonMover);
                case "Zerling":
                    this.getChildren().addAll(botonAtacar, botonMover);
                case "Hidralisco":
                    this.getChildren().addAll(botonAtacar, botonMover);
                case "Mutalisco":
                    this.getChildren().addAll(botonAtacar, botonMover, botonEvolucionarGuardian, botonEvolucionarDevorador);
                case "Guardian":
                    this.getChildren().addAll(botonAtacar, botonMover);
                case "Devorador":
                    this.getChildren().addAll(botonAtacar, botonMover);
                case "Dragon":
                    this.getChildren().addAll(botonAtacar, botonMover);
                case "Scout":
                    this.getChildren().addAll(botonAtacar, botonMover);
                case "Zealot":
                    this.getChildren().addAll(botonAtacar, botonMover);
                case "AmoSupremo":
                    this.getChildren().addAll(botonAtacar, botonMover);
                case "Extractor":
                    this.getChildren().add(botonMeterZangano);
            }
        } catch (Exception e) {

        }
    }
}
