package edu.fiuba.algo3.modelo.edificios;

import edu.fiuba.algo3.modelo.juego.Casilla;

public class EdificioVacio extends Edificio{

    public EdificioVacio() {
        super(100, 0, 0, 0);
    }

    @Override
    public void atacar(int dano) {

    }

    @Override
    public void regenerar() {

    }

    @Override
    public void avanzarTurno() {

    }
}
