package edu.fiuba.algo3.modelo.edificios;

import edu.fiuba.algo3.modelo.razas.Protoss;

public class Pilon extends EdificioProtoss {
    private int escudo;
    public Pilon() {
        super(100, 300, 4, 100, 0);
        escudo = 300;
        this.raza = new Protoss();
    }
}
