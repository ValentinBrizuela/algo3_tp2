package edu.fiuba.algo3.modelo;

public class EdificioProtoss extends Edificio {
    protected int escudo;
    protected int escudoMax;

    public EdificioProtoss(int vida, int escudo, int tiempoConstruccion, int costoMinerales, int costoGas) {
        super(vida, tiempoConstruccion, costoMinerales, costoGas);
        this.escudo = escudo;
        this.escudoMax = escudo;
    }

}
