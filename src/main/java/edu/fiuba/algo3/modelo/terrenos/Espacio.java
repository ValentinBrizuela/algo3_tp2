package edu.fiuba.algo3.modelo.terrenos;

import edu.fiuba.algo3.modelo.edificios.Construible;
import edu.fiuba.algo3.modelo.errores.ConstruccionNoPermitidaError;
import edu.fiuba.algo3.modelo.errores.ConstruccionNoPermitidaTerrenoError;
import edu.fiuba.algo3.modelo.errores.GeneracionInvalidaError;
import edu.fiuba.algo3.modelo.juego.Almacen;
import edu.fiuba.algo3.modelo.unidades.Unidad;

public class Espacio implements Terreno{

    public void construir(Construible entidad, Almacen almacen) {
        throw new ConstruccionNoPermitidaTerrenoError();
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
