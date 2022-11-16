package edu.fiuba.algo3.modelo.razas;

import edu.fiuba.algo3.modelo.errores.AtaqueInvalidoError;

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
}
