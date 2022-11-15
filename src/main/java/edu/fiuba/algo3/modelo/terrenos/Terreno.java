package edu.fiuba.algo3.modelo.terrenos;

import edu.fiuba.algo3.modelo.edificios.Edificio;
import edu.fiuba.algo3.modelo.edificios.EdificioProtoss;
import edu.fiuba.algo3.modelo.edificios.EdificioZerg;
import edu.fiuba.algo3.modelo.juego.Almacen;

public abstract class Terreno {

    private Boolean energizado = false;
    public abstract void construir(Edificio edificio, Almacen almacen);


    public void energizarse(){
        energizado = true;
    }
}
