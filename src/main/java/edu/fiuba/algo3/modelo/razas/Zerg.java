package edu.fiuba.algo3.modelo.razas;

import edu.fiuba.algo3.modelo.edificios.Criadero;
import edu.fiuba.algo3.modelo.edificios.Edificio;
import edu.fiuba.algo3.modelo.errores.ConstruccionNoPermitidaError;
import edu.fiuba.algo3.modelo.juego.Casilla;
import edu.fiuba.algo3.modelo.razas.Raza;

public class Zerg extends Raza {

    public Zerg(){

    }

    public void construir(Edificio edificio, Casilla casilla) {
        if(edificio instanceof Criadero){
            //se puede
        }else{
            throw new ConstruccionNoPermitidaError();
        }
    }
}
