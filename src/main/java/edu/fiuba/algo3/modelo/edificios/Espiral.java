package edu.fiuba.algo3.modelo.edificios;

import edu.fiuba.algo3.modelo.juego.Casilla;

public class Espiral extends EdificioZerg {
    public Espiral(Casilla casilla) {
        super(1300, 10, 150, 100, casilla);
    }

    @Override
    public void avanzarTurno(){
        regenerar();
    }
}
