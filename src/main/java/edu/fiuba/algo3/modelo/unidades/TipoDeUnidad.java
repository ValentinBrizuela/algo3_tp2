package edu.fiuba.algo3.modelo.unidades;

import edu.fiuba.algo3.modelo.terrenos.*;

public interface TipoDeUnidad {

    public abstract void puedoMoverA(Espacio espacio);
    public abstract void puedoMoverA(Moho moho);
    public abstract void puedoMoverA(Tierra tierra);
    public abstract void puedoMoverA(TierraEnergizada tierraEnergizada);
}
