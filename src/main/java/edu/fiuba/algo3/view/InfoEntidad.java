package edu.fiuba.algo3.view;

import edu.fiuba.algo3.modelo.juego.Casilla;
import edu.fiuba.algo3.modelo.juego.Entidad;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class InfoEntidad  extends VBox {

    private Label tipo;
    private Label nombre;
    private Label vida;
    private Label turno;

    public InfoEntidad() {
        this.tipo = new Label();
        this.nombre = new Label();
        this.vida = new Label();
        this.turno = new Label();
    }

    public void actualizar(Casilla casilla) {
        Entidad entidad = casilla.obtenerEstado().obtenerEntidad();
        if ( entidad != null) {
            if (this.getChildren().isEmpty()) {
                this.getChildren().addAll(this.tipo, this.nombre, this.vida, this.turno);
            }
            this.nombre.setText("Nombre: " + entidad.getClass().getSimpleName());

            this.vida.setText("Vida: " + entidad.vida() + " Escudo: " + entidad.escudo());

            this.turno.setText("Esta construido: " + entidad.tiempoDeConstruccion());
        }
        else {
            this.getChildren().clear();
        }
    }

    public void tipo(String tipo) {
        this.tipo.setText(tipo);
    }
}
