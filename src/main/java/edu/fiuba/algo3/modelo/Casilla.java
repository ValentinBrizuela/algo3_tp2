package edu.fiuba.algo3.modelo;

public class Casilla {
    protected int posX;
    protected int posY;
    protected Terreno tipoDeSuelo;
    protected Estado estado;
    public Casilla(int posX, int posY, Terreno tipoDeSuelo, Estado estado){
        this.posX = posX;
        this.posY = posY;
        this.tipoDeSuelo = tipoDeSuelo;
        this.estado = estado;

    }

    public Casilla construir(Edificio edificio){
        estado.construir(edificio);
    }

}
