package edu.fiuba.algo3.modelo.edificios;

import edu.fiuba.algo3.modelo.terrenos.Espacio;
import edu.fiuba.algo3.modelo.terrenos.Moho;
import edu.fiuba.algo3.modelo.terrenos.Tierra;
import edu.fiuba.algo3.modelo.terrenos.TierraEnergizada;
import edu.fiuba.algo3.modelo.juego.Almacen;

public interface Construible {

    public void construir(Moho moho, Almacen almacen);

    public void construir(Tierra Tierra, Almacen almacen);

    public void construir(TierraEnergizada tierraEnergizada, Almacen almacen);

    public void construir(Espacio espacio, Almacen almacen);


    public boolean estaDestruido();

}
