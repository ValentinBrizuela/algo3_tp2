package edu.fiuba.algo3.modelo.edificios;

import edu.fiuba.algo3.modelo.juego.Almacen;
import edu.fiuba.algo3.modelo.juego.Casilla;
import edu.fiuba.algo3.modelo.recursos.Mena;

public class NexoMineral extends EdificioProtoss implements Mina {

    public NexoMineral(Casilla casilla) {
        super(250, 250, 4, 50, 0, casilla);

    }
    @Override
    public void avanzarTurno(){
        regenerar();
    }
    public void extraerMineral(Almacen almacen, Mena mena) {
        almacen.almacenarMineral(mena.extraer(20));
    }
}
