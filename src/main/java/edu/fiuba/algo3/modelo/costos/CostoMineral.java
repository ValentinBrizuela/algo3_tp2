package edu.fiuba.algo3.modelo.costos;

import edu.fiuba.algo3.modelo.juego.Almacen;

public class CostoMineral implements Costo {

    private double costo;

    public CostoMineral(double costo){
        this.costo = costo;
    }

    @Override
    public void cobrar(Almacen almacen) {
        almacen.cobrarMineral(costo);
    }

    @Override
    public void meAlcanza(Almacen almacen) {
        almacen.meAlcanzaMineral(costo);
    }
}
