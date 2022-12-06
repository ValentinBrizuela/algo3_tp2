package edu.fiuba.algo3.modelo.terrenos;

import edu.fiuba.algo3.modelo.edificios.*;
import edu.fiuba.algo3.modelo.unidades.Unidad;
import edu.fiuba.algo3.modelo.juego.Almacen;

public class Tierra implements Terreno {

    public void construir(Construible edificio, Almacen almacen) {
        edificio.construir(this, almacen);
    }


    @Override
    public void puedoMover(Unidad unidad) {
        unidad.obtenerTipoMovimiento().puedoMoverA(this);
    }

    @Override
    public void puedoCambiar() {

    }


}
