package edu.fiuba.algo3.modelo.edificios;

import edu.fiuba.algo3.modelo.errores.EdificioEnConstruccionError;
import edu.fiuba.algo3.modelo.juego.Almacen;
import edu.fiuba.algo3.modelo.juego.Casilla;
import edu.fiuba.algo3.modelo.razas.Protoss;
import edu.fiuba.algo3.modelo.recursos.Geiser;

public class Asimilador extends EdificioProtoss implements RefineriaGas {

    public Asimilador(Casilla casilla) {
        super(450,450, 6, 100, 0, casilla);
    }

    public void extraerGas(Almacen almacen, Geiser geiser){
        if (!esUsable()) {
            throw new EdificioEnConstruccionError();
        }
        geiser.extraerGas(20);
        almacen.almacenarGas(20);
    }

}
