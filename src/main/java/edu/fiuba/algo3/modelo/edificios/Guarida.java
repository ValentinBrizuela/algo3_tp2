package edu.fiuba.algo3.modelo.edificios;

public class Guarida extends EdificioZerg {
    public Guarida() {
        super(1250, 12, 200, 100);
    }

    @Override
    public void avanzarTurno(){
        this.tiempoConstruccion -= 1;
        this.contadorTurnos += 1;
        regenerar();
    }
}
