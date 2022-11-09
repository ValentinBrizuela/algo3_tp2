package edu.fiuba.algo3.modelo.terrenos;

import edu.fiuba.algo3.modelo.errores.ConstruccionNoPermitidaError;
import edu.fiuba.algo3.modelo.edificios.EdificioProtoss;
import edu.fiuba.algo3.modelo.edificios.EdificioZerg;

public class TierraEnergizada extends Terreno {
    @Override
    public void construir(EdificioZerg edificio) {
        throw new ConstruccionNoPermitidaError();
    }

    @Override
    public void construir(EdificioProtoss edificio) {
    }
}
