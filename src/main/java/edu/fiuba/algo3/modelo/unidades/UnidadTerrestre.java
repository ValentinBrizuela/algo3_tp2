package edu.fiuba.algo3.modelo.unidades;

import edu.fiuba.algo3.modelo.errores.MovimientoInvalidoError;
import edu.fiuba.algo3.modelo.terrenos.*;

public class UnidadTerrestre extends TipoDeUnidad {


    public UnidadTerrestre() {
    }

    public UnidadTerrestre(int danio) {
        this.danio = danio;
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
