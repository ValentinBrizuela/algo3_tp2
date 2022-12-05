package edu.fiuba.algo3.modelo.costos;

import edu.fiuba.algo3.modelo.juego.Almacen;

public interface Costo {
    public void cobrar(Almacen almacen);

    public void meAlcanza(Almacen almacen);
}
