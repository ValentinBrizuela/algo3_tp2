package edu.fiuba.algo3.modelo.edificios;

import edu.fiuba.algo3.modelo.juego.Casilla;

public class ReservaDeReproduccion extends EdificioZerg {

    public ReservaDeReproduccion(Casilla casilla) {
        super(1000, 12, 150, 0, casilla);
    }

    @Override
    public void avanzarTurno() {
        regenerar();
    }
}
