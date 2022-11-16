package edu.fiuba.algo3.modelo.unidades;

import edu.fiuba.algo3.modelo.terrenos.Espacio;
import edu.fiuba.algo3.modelo.terrenos.Terreno;

public abstract class TipoDeUnidad {

    private int danio;

    public TipoDeUnidad(int danio){
        danio = danio;
    }

    public TipoDeUnidad(){
        danio=0;
    }
    public void puedoMoverA(Espacio espacio) {
    }
    public void puedoMoverA(Terreno terreno){
    }

    public void Atacar(Unidad unidad) {
        unidad.recibirAtaque(danio);
    }
}
