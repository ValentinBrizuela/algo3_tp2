package edu.fiuba.algo3.modelo;

public class Ocupada implements Estado{

    private Edificio edificio;
    public void construir(Edificio edificio, Casilla casilla){
        throw new EdificioYaConstruidoError();
    }
}
