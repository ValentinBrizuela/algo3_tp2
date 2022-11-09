package edu.fiuba.algo3.modelo;

public abstract class RefineriaGas extends Edificio{
    public RefineriaGas (int vida, int tiempo, int costoMineral, int costoGas){
        super(vida,tiempo, costoMineral, costoGas);
    };
    public abstract void extraerGas(Almacen almacen);
}
