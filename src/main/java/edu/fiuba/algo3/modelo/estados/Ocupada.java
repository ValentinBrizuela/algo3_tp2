package edu.fiuba.algo3.modelo.estados;

import edu.fiuba.algo3.modelo.errores.EdificioYaConstruidoError;

public class Ocupada implements Estado {

    public void construir(){
        throw new EdificioYaConstruidoError();
    }

}
