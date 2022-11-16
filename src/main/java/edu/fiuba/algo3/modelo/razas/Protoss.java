package edu.fiuba.algo3.modelo.razas;

import edu.fiuba.algo3.modelo.errores.AtaqueInvalidoError;

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
}
