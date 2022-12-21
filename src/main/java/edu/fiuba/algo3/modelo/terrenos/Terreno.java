package edu.fiuba.algo3.modelo.terrenos;

import edu.fiuba.algo3.modelo.edificios.Construible;
import edu.fiuba.algo3.modelo.juego.Almacen;
import edu.fiuba.algo3.modelo.unidades.Unidad;

public interface Terreno {

    public void construir(Construible entidad, Almacen almacen);


    
    public  void puedoMover(Unidad unidad);

    public void puedoCambiar();

    public boolean esTierraEnergizada();

    //movVolador tiene moverA(Espacio) NADA y moverA(Terreno) EXC

    //movTerrestre tiene moverA(Espacio) TIRA EXC y moverA(Terreno) NADA
}
