package edu.fiuba.algo3.modelo.razas;

import edu.fiuba.algo3.modelo.errores.AtaqueInvalidoError;
import edu.fiuba.algo3.modelo.errores.SeleccionInvalidaError;

public class Protoss implements Raza {
    public Protoss(){

    }

    @Override
    public void recibirAtaque(Zerg zerg) {

    }

    @Override
    public void recibirAtaque(Protoss protoss) {
        throw new AtaqueInvalidoError();
    }

    @Override
    public void seleccionarEntidad(Zerg zerg) {
        throw new SeleccionInvalidaError();
    }

    @Override
    public void seleccionarEntidad(Protoss protoss) {

    }

    @Override
    public void puedoSeleccionar(Raza raza) {
        raza.seleccionarEntidad(this);
    }
}
