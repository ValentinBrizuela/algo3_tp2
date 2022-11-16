package edu.fiuba.algo3.modelo.terrenos;

import edu.fiuba.algo3.modelo.edificios.Construible;
import edu.fiuba.algo3.modelo.juego.Almacen;
import edu.fiuba.algo3.modelo.unidades.Unidad;

public abstract class Terreno {

    /*private boolean energizado = false; */
    public abstract void construir(Construible edificio, Almacen almacen);


    /*public void energizarse(){
        energizado = true;
    }*/


    public abstract void puedoMover(Unidad unidad);
    //movVolador tiene moverA(Espacio) NADA y moverA(Terreno) EXC

    //movTerrestre tiene moverA(Espacio) TIRA EXC y moverA(Terreno) NADA
}
