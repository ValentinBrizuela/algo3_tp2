package edu.fiuba.algo3.modelo;

public class Desocupada implements Estado {
    public void construir(Edificio edificio, Casilla casilla){
        casilla.tipoDeSuelo.construir(edificio, casilla);
    }
}
