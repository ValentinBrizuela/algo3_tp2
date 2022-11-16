package edu.fiuba.algo3.modelo.unidades;

import edu.fiuba.algo3.modelo.terrenos.*;

public abstract class TipoDeUnidad {

    protected int danio;

    public TipoDeUnidad(int danio){
        this.danio = danio;
    }

    public TipoDeUnidad(){
        danio=0;
    }
    public abstract void puedoMoverA(Espacio espacio);
    public abstract void puedoMoverA(Moho moho);
    public abstract void puedoMoverA(Tierra tierra);
    public abstract void puedoMoverA(TierraEnergizada tierraEnergizada);

    public void atacar(Unidad unidad) {
        unidad.recibirAtaque(danio);
    }
}
