package edu.fiuba.algo3.modelo.costos;

import edu.fiuba.algo3.modelo.juego.Almacen;

public class CostoGas implements Costo{

    private double costo;

    public CostoGas(double costo){
        this.costo = costo;
    }

    @Override
    public void cobrar(Almacen almacen) {
        almacen.cobrarGas(costo);
    }

    @Override
    public void meAlcanza(Almacen almacen) {
        almacen.meAlcanzaGas(costo);
    }
}
