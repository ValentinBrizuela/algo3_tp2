package edu.fiuba.algo3.modelo;

public class Criadero extends Edificio {
    private int cantidadLarvas;

    public Criadero(){

        super(500, 4, 50, 0);
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
        this.tiempoConstruccion -= 1;
    }
    public int cantidadLarvas(){
        return this.cantidadLarvas;
    }

}
