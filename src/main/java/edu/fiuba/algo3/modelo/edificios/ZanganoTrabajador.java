package edu.fiuba.algo3.modelo.edificios;

import edu.fiuba.algo3.modelo.juego.Almacen;
import edu.fiuba.algo3.modelo.juego.Casilla;
import edu.fiuba.algo3.modelo.recursos.Mena;

public class ZanganoTrabajador extends EdificioZerg implements Mina{


    public ZanganoTrabajador(Casilla casilla){
        super(50, 0, 0, 0, casilla);
    }
    public void extraerMineral(Almacen almacen, Mena mena){
        almacen.almacenarMineral(mena.extraer(10));
    }


    public void avanzarTurno(){regenerar();}
}

