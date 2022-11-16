package edu.fiuba.algo3.modelo.terrenos;

import edu.fiuba.algo3.modelo.errores.ConstruccionNoPermitidaError;
import edu.fiuba.algo3.modelo.edificios.EdificioProtoss;
import edu.fiuba.algo3.modelo.edificios.EdificioZerg;
import edu.fiuba.algo3.modelo.errores.MovimientoInvalidoError;
import edu.fiuba.algo3.modelo.unidades.Unidad;

public class Moho extends Terreno {

    @Override
    public void construir(EdificioZerg edificio) {
    }
    @Override
    public void construir(EdificioProtoss edificio) {
        throw new ConstruccionNoPermitidaError();
    }

}
