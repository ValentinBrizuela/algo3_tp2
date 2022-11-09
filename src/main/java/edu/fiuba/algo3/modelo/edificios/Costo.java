package edu.fiuba.algo3.modelo.edificios;

import edu.fiuba.algo3.modelo.juego.Almacen;

public class Costo {
    private int costoMineral;
    private int costoGas;

    public Costo(int costoMineral, int costoGas){
        this.costoMineral = costoMineral;
        this.costoGas = costoGas;
    }

    public boolean puedoComprar(Almacen almacen){
        int mineralDisponible = almacen.cantMineral();
        int gasDisponible = almacen.cantGas();

        return (mineralDisponible >= costoMineral && gasDisponible >= costoGas);
    }

    public int obtenerCostoMineral(){
        return costoMineral;
    }

    public int obtenerCostoGas(){
        return costoGas;
    }
}
