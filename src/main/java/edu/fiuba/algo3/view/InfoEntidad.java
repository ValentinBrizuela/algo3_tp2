package edu.fiuba.algo3.view;

import edu.fiuba.algo3.modelo.juego.Casilla;
import edu.fiuba.algo3.modelo.juego.Entidad;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.lang.invoke.CallSite;

public class InfoEntidad  extends VBox {

    private Casilla casilla;

    private Label tipo;
    private Label nombre;
    private Label raza;
    private Label vida;
    private Label turno;

    public InfoEntidad() {
        this.casilla = null;
        this.tipo = new Label();
        this.raza = new Label();
        this.nombre = new Label();
        this.vida = new Label();
        this.turno = new Label();
    }

    public void cambiarCasilla(Casilla casilla) {
        this.casilla = casilla;
        actualizar();
    }

    public void actualizar() {
        try {
            Entidad entidad = casilla.obtenerEntidad();
            if ( entidad != null) {
                if (this.getChildren().isEmpty()) {
                    this.getChildren().addAll(this.tipo, this.nombre, this.raza, this.vida, this.turno);
                }
                this.nombre.setText("Nombre: " + entidad.getClass().getSimpleName());

                this.raza.setText("Raza: " + entidad.obtenerRaza().getClass().getSimpleName());

                this.vida.setText("Vida: " + entidad.vida() + " Escudo: " + entidad.escudo());

                int tiempo = entidad.tiempoDeConstruccion();
                if (tiempo < 1) {
                    this.turno.setText("Esta construido: Verdadero");
                } else {
                    this.turno.setText("Esta construido: Faltan " + tiempo + " turnos");
                }

            }
            else {
                this.getChildren().clear();
            }
        } catch (Exception e) {

        }
    }

    public void tipo(String tipo) {
        this.tipo.setText(tipo);
    }
}
