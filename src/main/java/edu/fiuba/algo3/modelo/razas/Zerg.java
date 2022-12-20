package edu.fiuba.algo3.modelo.razas;

import edu.fiuba.algo3.modelo.errores.AtaqueInvalidoError;
import edu.fiuba.algo3.modelo.errores.AtaquePorAireInvalidoError;
import edu.fiuba.algo3.modelo.errores.SeleccionInvalidaError;

public class Zerg implements Raza {

    public Zerg(){

    }

    @Override
    public void recibirAtaque(Zerg zerg) {
        throw new AtaqueInvalidoError();
    }

    @Override
    public void recibirAtaque(Protoss protoss) {
    }

    @Override
    public void puedoRecibirAtaque(Raza raza) {
        raza.recibirAtaque(this);
    }

    @Override
    public void seleccionarEntidad(Zerg zerg) {

    }

    @Override
    public void seleccionarEntidad(Protoss protoss) {
        throw new SeleccionInvalidaError();
    }

    @Override
    public void puedoSeleccionar(Raza raza) {
        raza.seleccionarEntidad(this);
    }


}
