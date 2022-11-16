package edu.fiuba.algo3.modelo.terrenos;

import edu.fiuba.algo3.modelo.edificios.*;
import edu.fiuba.algo3.modelo.errores.ConstruccionNoPermitidaError;
import edu.fiuba.algo3.modelo.errores.MovimientoInvalidoError;
import edu.fiuba.algo3.modelo.unidades.Unidad;

public class Tierra extends Terreno {
    @Override
    public void construir(EdificioZerg edificio) {
        if(!(edificio instanceof Criadero)){
            throw new ConstruccionNoPermitidaError();
        }
    }
    @Override
    public void construir(EdificioProtoss edificio) {
        if(!(edificio instanceof Pilon) && !(edificio instanceof NexoMineral)){
            throw new ConstruccionNoPermitidaError();
        }
    }


}
