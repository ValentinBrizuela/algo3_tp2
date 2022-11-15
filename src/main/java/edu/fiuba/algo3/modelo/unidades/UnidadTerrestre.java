package edu.fiuba.algo3.modelo.unidades;

import edu.fiuba.algo3.modelo.edificios.Edificio;
import edu.fiuba.algo3.modelo.juego.Casilla;
import edu.fiuba.algo3.modelo.juego.Entidad;
import edu.fiuba.algo3.modelo.razas.Raza;

public abstract class UnidadTerrestre extends Entidad {

    public UnidadTerrestre(int vida, int costoMineral, int costoGas, int tiempoConstruccion, Raza raza, Casilla casilla){
        super(vida, costoMineral, costoGas, tiempoConstruccion, raza, casilla);
    }

    public abstract void recibirAtaque(int danio);


    public void avanzarCasilla(){

    }
}
