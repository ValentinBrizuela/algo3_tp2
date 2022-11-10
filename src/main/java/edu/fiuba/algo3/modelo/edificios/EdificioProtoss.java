package edu.fiuba.algo3.modelo.edificios;

import edu.fiuba.algo3.modelo.juego.Casilla;
import edu.fiuba.algo3.modelo.terrenos.TierraEnergizada;

public abstract class EdificioProtoss extends Edificio {
    protected int escudo;
    protected int escudoMax;

    public EdificioProtoss(int vida, int escudo, int tiempoConstruccion, int costoMinerales, int costoGas, Casilla casilla) {
        super(vida, tiempoConstruccion, costoMinerales, costoGas, casilla);
        this.escudo = escudo;
        this.escudoMax = escudo;
    }
    @Override
    public void atacar(int cant) {
        if (cant > escudo) {
            vida -= (cant - escudo);
            escudo = 0;
        }
        else {
            escudo -= cant;
        }
    }

    @Override
    public void regenerar() {
        if (escudoMax-escudo > 0) {
            escudo += escudoMax*0.1;
            if (escudo > escudoMax) {
                escudo = escudoMax;
            }
        }
    }

    public int escudo() {
        return escudo;
    }

    public void avanzarTurno() {
        regenerar();
        tiempoConstruccion -= 1;
    }

    public boolean estaEnergizado(){
        if (casilla.obtenerTerreno().getClass() == TierraEnergizada.class){
            return true;
        }
        return false;
    }
}
