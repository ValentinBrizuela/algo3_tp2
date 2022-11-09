package edu.fiuba.algo3.modelo;

public abstract class RefineriaGas extends Edificio{
    public RefineriaGas (int vida, int tiempo){
        super(vida,tiempo);
    };
    public abstract void extraerGas(Almacen almacen);
}
