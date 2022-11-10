package edu.fiuba.algo3.modelo.edificios;

import edu.fiuba.algo3.modelo.juego.Casilla;
import edu.fiuba.algo3.modelo.razas.Protoss;

public class Acceso extends EdificioProtoss {

    private int escudo;
    public Acceso(Casilla casilla) {
        super(500, 500,8, 150, 0, casilla);
        this.escudo = 500;
    }

    @Override
    public void avanzarTurno(){
        regenerar();
    }
}
