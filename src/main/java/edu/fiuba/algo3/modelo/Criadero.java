package edu.fiuba.algo3.modelo;

public class Criadero {
    private int cantidadLarvas;

    public Criadero(){
        this.cantidadLarvas = 3;
    }
    public void engendrarZangano(){
        cantidadLarvas -= 1;
    }

    public void avanzarTurno(){
        cantidadLarvas += 1;
    }

    public int cantidadLarvas(){
        return this.cantidadLarvas;
    }
}
