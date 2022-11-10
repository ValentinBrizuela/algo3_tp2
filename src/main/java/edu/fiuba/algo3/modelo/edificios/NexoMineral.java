package edu.fiuba.algo3.modelo.edificios;

import edu.fiuba.algo3.modelo.juego.Almacen;
import edu.fiuba.algo3.modelo.recursos.Mena;

public class NexoMineral extends EdificioProtoss implements Mina {

    public NexoMineral() {
        super(250, 250, 4, 50, 0);

    }
    @Override
    public void avanzarTurno(){
        this.tiempoConstruccion -= 1;
        this.contadorTurnos += 1;
        regenerar();
    }
    public void extraerMineral(Almacen almacen, Mena mena) {
        almacen.almacenarMineral(mena.extraer(20));
    }
}
