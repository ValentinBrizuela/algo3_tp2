package edu.fiuba.algo3.modelo.edificios;

import edu.fiuba.algo3.modelo.errores.EdificioEnConstruccionError;
import edu.fiuba.algo3.modelo.razas.Zangano;
import edu.fiuba.algo3.modelo.razas.Zerg;

public class Criadero extends EdificioZerg {
    private int cantidadLarvas;

    private int rangoMoho;

    public Criadero(){

        super(500, 4, 50, 0);
        this.cantidadLarvas = 3;
        this.rangoMoho = 5;
    }
    public Zangano engendrarZangano(){
        if (!esUsable()) {
            throw new EdificioEnConstruccionError();
        }
        cantidadLarvas -= 1;
        return new Zangano();
    }

    @Override
    public void avanzarTurno() {
        if (!esUsable()){
            this.tiempoConstruccion -= 1;
            this.regenerar();
            this.contadorTurnos += 1;
            return;
        }

        this.contadorTurnos += 1;

        if (cantidadLarvas() < 3) {
        cantidadLarvas += 1;
        }

        if (deboExpandirMoho()){
            casilla.expandirTerreno(rangoMoho);
        }

        this.regenerar();
    }
    public int cantidadLarvas(){
        return this.cantidadLarvas;
    }

    private boolean deboExpandirMoho(){
        if (contadorTurnos > 0 && (contadorTurnos % 2) == 0){
            rangoMoho += 1;
            return true;
        }
        return false;
    }

}
