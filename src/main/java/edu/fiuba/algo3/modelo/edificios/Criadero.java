package edu.fiuba.algo3.modelo.edificios;

import edu.fiuba.algo3.modelo.errores.EdificioEnConstruccionError;
import edu.fiuba.algo3.modelo.razas.Zerg;

public class Criadero extends EdificioZerg {
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

    @Override
    public void avanzarTurno() {
        if (cantidadLarvas() < 3) {
        cantidadLarvas += 1;
        }
        this.tiempoConstruccion -= 1;
        this.regenerar();
    }
    public int cantidadLarvas(){
        return this.cantidadLarvas;
    }

}
