package edu.fiuba.algo3.modelo;

public abstract class Terreno {

    private Boolean energizado = false;
    public abstract void construir(EdificioZerg edificio);

    public abstract void construir(EdificioProtoss edificio);

    public void energizarse(){
        energizado = true;
    }
}
