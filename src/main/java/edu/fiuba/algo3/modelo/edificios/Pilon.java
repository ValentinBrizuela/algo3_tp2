package edu.fiuba.algo3.modelo.edificios;

import edu.fiuba.algo3.modelo.razas.Protoss;

public class Pilon extends EdificioProtoss {
    private int escudo;
    public Pilon() {
        super(300, 300, 5, 100, 0);
        escudo = 300;
        this.raza = new Protoss();
    }
    @Override
    public void avanzarTurno() {
        this.tiempoConstruccion -= 1;
        this.contadorTurnos += 1;
        regenerar();
    }
}
