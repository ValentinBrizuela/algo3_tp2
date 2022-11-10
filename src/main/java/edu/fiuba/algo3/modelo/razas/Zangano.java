package edu.fiuba.algo3.modelo.razas;

import edu.fiuba.algo3.modelo.edificios.Mina;
import edu.fiuba.algo3.modelo.edificios.ZanganoTrabajador;
import edu.fiuba.algo3.modelo.juego.Almacen;
import edu.fiuba.algo3.modelo.juego.Casilla;
import edu.fiuba.algo3.modelo.recursos.Mena;

public class Zangano implements Mina {

    public void extraerMineral(Almacen almacen, Mena mena) {
        almacen.almacenarMineral(mena.extraer(10));
    }

    public void asentarseEnMena(Casilla casilla,Almacen almacen) {
        casilla.construir(new ZanganoTrabajador(casilla),almacen);
    }
}
