package edu.fiuba.algo3.modelo.unidades;

import edu.fiuba.algo3.modelo.terrenos.Espacio;
import edu.fiuba.algo3.modelo.terrenos.Moho;
import edu.fiuba.algo3.modelo.terrenos.Tierra;
import edu.fiuba.algo3.modelo.terrenos.TierraEnergizada;
import edu.fiuba.algo3.modelo.errores.MovimientoInvalidoError;

public class UnidadTerrestre implements TipoDeUnidad {


    public UnidadTerrestre() {
    }

    public void puedoMoverA(Espacio espacio) {
        throw new MovimientoInvalidoError();
    }

    public void puedoMoverA(Moho moho) {
    }

    public void puedoMoverA(Tierra tierra) {

    }

    public void puedoMoverA(TierraEnergizada tierraEnergizada) {

    }

}
