package edu.fiuba.algo3.modelo.unidades;

import edu.fiuba.algo3.modelo.errores.MovimientoInvalidoError;
import edu.fiuba.algo3.modelo.terrenos.Espacio;
import edu.fiuba.algo3.modelo.terrenos.Terreno;

public class Volador extends TipoDeUnidad {

    public Volador(int danio) {
        super(danio);
    }

    public Volador() {
    }

    public void puedoMoverA(Espacio espacio) {
    }
    public void puedoMoverA(Terreno terreno){
        throw new MovimientoInvalidoError();
    }
}
