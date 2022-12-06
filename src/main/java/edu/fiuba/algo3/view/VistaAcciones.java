package edu.fiuba.algo3.view;

import edu.fiuba.algo3.modelo.juego.AlgoStar;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

/*public class VistaAcciones extends VBox {

    private AlgoStar algoStar;

    private Label nombre;

    public VistaAcciones (AlgoStar algoStar) {
        this.algoStar = algoStar;

        Label turno = new Label("Turno de:");

        this.nombre = new Label(algoStar.obtenerJugadorActual().obtenerNombre());
        nombre.setPadding(new Insets(10));

        Button botonAvanzarTurno = new Button("Avanzar Turno");
        botonAvanzarTurno.setPadding(new Insets(10));
        botonAvanzarTurno.setOnAction((e)->{
            algoStar.avanzarTurno();
            actualizar();
        });

        Button botonAtacar = new Button("Atacar");
        botonAvanzarTurno.setPadding(new Insets(10));
        botonAvanzarTurno.setOnAction((e)->{
            algoStar.atacaraPosicion(algoStar.casillaActiva.obtenerPosX(), algoStar.casillaActiva.obtenerPosY(), );
        });

        this.getChildren().addAll(turno, nombre, botonAvanzarTurno);
    }

    public void actualizar() {
        nombre.setText(algoStar.obtenerJugadorActual().obtenerNombre());
    }

}*/
