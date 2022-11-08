package edu.fiuba.algo3.modelo;

public abstract class RefineriaGas extends Edificio{
    public RefineriaGas (int vida, int costo, int tiempo){
        super(vida,costo,tiempo);
    };
    public abstract void extraerGas();
}
