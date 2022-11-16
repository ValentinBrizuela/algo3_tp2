package edu.fiuba.algo3.modelo.terrenos;

import edu.fiuba.algo3.modelo.edificios.Edificio;
import edu.fiuba.algo3.modelo.edificios.EdificioProtoss;
import edu.fiuba.algo3.modelo.edificios.EdificioZerg;
import edu.fiuba.algo3.modelo.juego.Almacen;
import edu.fiuba.algo3.modelo.unidades.Unidad;
import edu.fiuba.algo3.modelo.unidades.UnidadAerea;
import edu.fiuba.algo3.modelo.unidades.UnidadTerrestre;

public interface Terreno {

    public void construir(Edificio edificio, Almacen almacen);

    
    public abstract void puedoMover(Unidad unidad);

    //movVolador tiene moverA(Espacio) NADA y moverA(Terreno) EXC

    //movTerrestre tiene moverA(Espacio) TIRA EXC y moverA(Terreno) NADA
}
