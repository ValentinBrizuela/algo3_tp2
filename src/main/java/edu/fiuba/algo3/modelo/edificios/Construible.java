package edu.fiuba.algo3.modelo.edificios;

import edu.fiuba.algo3.modelo.juego.Almacen;
import edu.fiuba.algo3.modelo.terrenos.*;

public interface Construible {

    public void construir(Moho moho, Almacen almacen);

    public void construir(Tierra Tierra, Almacen almacen);

    public void construir(TierraEnergizada tierraEnergizada, Almacen almacen);

    public void construir(Espacio espacio, Almacen almacen);

}
