package edu.fiuba.algo3.view;

import edu.fiuba.algo3.modelo.juego.AlgoStar;
import edu.fiuba.algo3.modelo.razas.Protoss;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class nombreEntidades extends VBox {
    private AlgoStar algoStar;
    private Label nombres;

    public nombreEntidades(AlgoStar algoStar) {
        this.algoStar = algoStar;
        this.nombres = new Label();
        actualizar();
        this.getChildren().addAll(nombres);
    }

    public void actualizar() {
        if (algoStar.obtenerJugadorActual().obtenerRaza().getClass() == Protoss.class) {
            nombres.setText("Edificios:\nPilon\nAsimilador\nNexoMineral\nAcceso\nPuertoEstelar\n\nUnidades:\nZealot\nDragon\nScout");
        } else {
            nombres.setText("Edificios:\nCriadero\nReservaDeReproduccion\nExtractor\nGuarida\nEspiral\n\nUnidades:\nAmoSupremo\nZangano\nZerling\nHidralisco\nMutalisco\nGuaridan\nDevorador");
        }
    }
}
