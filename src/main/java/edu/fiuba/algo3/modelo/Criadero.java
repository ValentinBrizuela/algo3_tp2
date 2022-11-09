package edu.fiuba.algo3.modelo;

public class Criadero extends Edificio {
    private int cantidadLarvas;

    public Criadero(){
        super(500, 50, 4);
        this.cantidadLarvas = 3;
        this.raza = new Zerg();
    }
    public void engendrarZangano(){
        if (!esUsable()) {
            throw new EdificioEnConstruccionError();
        }
        cantidadLarvas -= 1;
    }

    public void avanzarTurno() {
        if (cantidadLarvas() < 3) {
        cantidadLarvas += 1;
        }
        this.tiempoContruccion -= 1;
    }
    public int cantidadLarvas(){
        return this.cantidadLarvas;
    }
}
