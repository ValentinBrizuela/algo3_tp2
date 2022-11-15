package edu.fiuba.algo3.modelo.terrenos;

import edu.fiuba.algo3.modelo.edificios.*;
import edu.fiuba.algo3.modelo.errores.ConstruccionNoPermitidaError;
import edu.fiuba.algo3.modelo.juego.Almacen;

public class Tierra extends Terreno {

    public void construir(Edificio edificio, Almacen almacen) {
        edificio.construir(this, almacen);
    }
}
