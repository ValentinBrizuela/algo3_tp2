package edu.fiuba.algo3.modelo.terrenos;

import edu.fiuba.algo3.modelo.edificios.Criadero;
import edu.fiuba.algo3.modelo.edificios.Pilon;
import edu.fiuba.algo3.modelo.errores.ConstruccionNoPermitidaError;
import edu.fiuba.algo3.modelo.edificios.EdificioProtoss;
import edu.fiuba.algo3.modelo.edificios.EdificioZerg;

public class Tierra extends Terreno {
    @Override
    public void construir(EdificioZerg edificio) {
        if (!(edificio instanceof Criadero)) {
            throw new ConstruccionNoPermitidaError();

        }
    }
    @Override
    public void construir(EdificioProtoss edificio) {
        if (!(edificio instanceof Pilon)) {
            throw new ConstruccionNoPermitidaError();

        }
    }
}
