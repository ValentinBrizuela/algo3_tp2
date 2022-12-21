package edu.fiuba.algo3.modelo.terrenos;

import edu.fiuba.algo3.modelo.edificios.Construible;
import edu.fiuba.algo3.modelo.errores.GeneracionInvalidaError;
import edu.fiuba.algo3.modelo.juego.Almacen;
import edu.fiuba.algo3.modelo.unidades.Unidad;

public class Moho implements Terreno {

    public void construir(Construible entidad, Almacen almacen) {
        entidad.construir(this, almacen);
    }


    @Override
    public void puedoMover(Unidad unidad) {
        unidad.obtenerTipoMovimiento().puedoMoverA(this);
    }

    @Override
    public void puedoCambiar() {
        throw new GeneracionInvalidaError();
    }

    @Override
    public boolean esTierraEnergizada() {
        return false;
    }

}
