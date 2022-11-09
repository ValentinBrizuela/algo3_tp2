package edu.fiuba.algo3.modelo.terrenos;

import edu.fiuba.algo3.modelo.edificios.EdificioProtoss;
import edu.fiuba.algo3.modelo.edificios.EdificioZerg;

public abstract class Terreno {

    private Boolean energizado = false;
    public abstract void construir(EdificioZerg edificio);

    public abstract void construir(EdificioProtoss edificio);

    public void energizarse(){
        energizado = true;
    }
}
