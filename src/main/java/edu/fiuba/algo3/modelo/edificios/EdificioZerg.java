package edu.fiuba.algo3.modelo.edificios;

import edu.fiuba.algo3.modelo.juego.Casilla;

public abstract class EdificioZerg extends Edificio {

    public EdificioZerg(int vida, int tiempoConstruccion, int costoMinerales, int costoGas, Casilla casilla) {
        super(vida, tiempoConstruccion, costoMinerales, costoGas, casilla);
    }

    public void recibirDanio(int dano) {
        vida -= dano;
    }
    @Override
    public void regenerar() {
        if (vidaMax-vida > 0) {
            vida += vidaMax*0.1;
            if (vida > vidaMax) {
                vida = vidaMax;
            }
        }
    }

    public void avanzarTurno() {
        regenerar();
        tiempoConstruccion -= 1;
    }
}
