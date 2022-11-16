package edu.fiuba.algo3.modelo.unidades;

import edu.fiuba.algo3.modelo.errores.MovimientoInvalidoError;
import edu.fiuba.algo3.modelo.terrenos.Espacio;
import edu.fiuba.algo3.modelo.terrenos.Terreno;

public class Terrestre extends TipoDeUnidad {


    public Terrestre() {
    }

    public Terrestre(int danio) {
        super(danio);
    }

    public void puedoMoverA(Espacio espacio) {
        throw new MovimientoInvalidoError();
    }
    public void puedoMoverA(Terreno terreno){
    }
}
