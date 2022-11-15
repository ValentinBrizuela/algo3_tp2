package edu.fiuba.algo3.modelo.edificios;

import edu.fiuba.algo3.modelo.juego.Casilla;

public class EdificioVacio extends Edificio{

    public EdificioVacio(Casilla casilla) {
        super(100, 0, 0, 0, casilla);
    }

    @Override
    public void recibirDanio(int dano) {

    }

    @Override
    public void regenerar() {

    }

    @Override
    public void avanzarTurno() {

    }
}
