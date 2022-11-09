package edu.fiuba.algo3.modelo;

public abstract class Terreno {

    private Boolean energizado = false;
    public abstract void construir(Edificio edificio, Casilla casilla);

    public void energizarse(){
        energizado = true;
    }
}
