package edu.fiuba.algo3.modelo.edificios;

public class Espiral extends EdificioZerg {
    public Espiral() {
        super(1300, 10, 150, 100);
    }

    @Override
    public void avanzarTurno(){
        this.tiempoConstruccion -= 1;
        this.contadorTurnos += 1;
        regenerar();
    }
}
