package edu.fiuba.algo3.modelo.edificios;

import edu.fiuba.algo3.modelo.errores.EdificioEnConstruccionError;
import edu.fiuba.algo3.modelo.estados.Ocupada;
import edu.fiuba.algo3.modelo.juego.Almacen;
import edu.fiuba.algo3.modelo.juego.Casilla;
import edu.fiuba.algo3.modelo.recursos.Mena;
import edu.fiuba.algo3.modelo.recursos.RecursoVacio;
import edu.fiuba.algo3.modelo.terrenos.Tierra;
import edu.fiuba.algo3.modelo.terrenos.TierraEnergizada;

public class NexoMineral extends EdificioProtoss implements Mina {

    public NexoMineral(Casilla casilla) {
        super(250, 250, 4, 50, 0, casilla);

    }
    public void extraerMineral(Almacen almacen, Mena mena) {
        if (!esUsable()) {
            throw new EdificioEnConstruccionError();
        }
        almacen.almacenarMineral(mena.extraer(20));
    }

    @Override
    public void construir(Tierra tierra, Almacen almacen) {
        almacen.cobrar(this.costo);
        casilla.cambiarEstado(new Ocupada(new TierraEnergizada(), new RecursoVacio(), this));
    }
}
