package edu.fiuba.algo3.modelo.terrenos;

import edu.fiuba.algo3.modelo.edificios.Edificio;
import edu.fiuba.algo3.modelo.edificios.EdificioProtoss;
import edu.fiuba.algo3.modelo.edificios.EdificioZerg;
import edu.fiuba.algo3.modelo.juego.Almacen;
import edu.fiuba.algo3.modelo.unidades.Unidad;

public abstract class Terreno {

    private Boolean energizado = false;
    public abstract void construir(Edificio edificio, Almacen almacen);

    public void energizarse(){
        energizado = true;
    }


    public void mover(Unidad unidad){
        unidad.obtenerTipoMovimiento().puedoMoverA(this);
    }
    //movVolador tiene moverA(Espacio) NADA y moverA(Terreno) EXC

    //movTerrestre tiene moverA(Espacio) TIRA EXC y moverA(Terreno) NADA
}
