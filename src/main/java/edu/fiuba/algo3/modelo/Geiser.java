package edu.fiuba.algo3.modelo;

public class Geiser extends Terreno {

    public Geiser() {
    }

    public void construir(Edificio edificio, Casilla casilla) {
        if (!(edificio instanceof RefineriaGas)) {
            throw new ConstruccionNoPermitidaError();
        }

    }
}
