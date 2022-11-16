package edu.fiuba.algo3.modelo.unidades;

import edu.fiuba.algo3.modelo.errores.MovimientoInvalidoError;
import edu.fiuba.algo3.modelo.terrenos.*;

public class UnidadAerea extends TipoDeUnidad {

    public UnidadAerea(int danio) {
        super(danio);
    }

    public UnidadAerea() {
    }

    public void puedoMoverA(Espacio espacio) {
    }

    @Override
    public void puedoMoverA(Moho moho) {

    }

    @Override
    public void puedoMoverA(Tierra tierra) {

    }

    @Override
    public void puedoMoverA(TierraEnergizada tierraEnergizada) {

    }

    public void puedoMoverA(Terreno terreno){
    }
}
