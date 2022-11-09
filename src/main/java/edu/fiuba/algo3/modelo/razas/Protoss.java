package edu.fiuba.algo3.modelo.razas;

import edu.fiuba.algo3.modelo.edificios.Edificio;
import edu.fiuba.algo3.modelo.edificios.Pilon;
import edu.fiuba.algo3.modelo.errores.ConstruccionNoPermitidaError;
import edu.fiuba.algo3.modelo.juego.Casilla;
import edu.fiuba.algo3.modelo.razas.Raza;

public class Protoss extends Raza {
    public Protoss(){

    }

    public void construir(Edificio edificio, Casilla casilla) {
        if(edificio instanceof Pilon) {
            //se puede
        } else {
            throw new ConstruccionNoPermitidaError();
        }
    }
}
