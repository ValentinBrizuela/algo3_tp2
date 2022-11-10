package edu.fiuba.algo3.modelo.edificios;

public class PuertoEstelar extends EdificioProtoss {

    public PuertoEstelar() {
        super(600, 600, 10, 150, 150);
    }

    @Override
    public void avanzarTurno(){
        regenerar();
    }
}
