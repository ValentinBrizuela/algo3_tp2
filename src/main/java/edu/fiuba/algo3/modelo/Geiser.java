package edu.fiuba.algo3.modelo;

public class Geiser extends Terreno {

    public Geiser() {
    }

    public void construir(Edificio edificio, Casilla casilla) {
        if (edificio instanceof RefineriaGas) {
            Estado ocupada = new Ocupada();
            casilla.cambiarEstado(ocupada);
        } else {
            throw new ConstruccionNoPermitidaError();
        }
    }
}
