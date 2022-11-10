package edu.fiuba.algo3.modelo.edificios;

public class ReservaDeReproduccion extends EdificioZerg {

    public ReservaDeReproduccion() {
        super(1000, 12, 150, 0);
    }

    @Override
    public void avanzarTurno() {
        regenerar();
    }
}
