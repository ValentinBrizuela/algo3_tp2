package edu.fiuba.algo3.modelo.terrenos;

import edu.fiuba.algo3.modelo.edificios.Edificio;
import edu.fiuba.algo3.modelo.errores.ConstruccionNoPermitidaError;
import edu.fiuba.algo3.modelo.edificios.EdificioProtoss;
import edu.fiuba.algo3.modelo.edificios.EdificioZerg;
import edu.fiuba.algo3.modelo.juego.Almacen;
import edu.fiuba.algo3.modelo.errores.MovimientoInvalidoError;
import edu.fiuba.algo3.modelo.unidades.Unidad;

public class TierraEnergizada implements Terreno {

    public void construir(Edificio edificio, Almacen almacen) {
        edificio.construir(this, almacen);
    }

    @Override
    public void puedoMover(Unidad unidad) {
        unidad.obtenerTipoMovimiento().puedoMoverA(this);
    }
}
