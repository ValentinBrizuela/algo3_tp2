package edu.fiuba.algo3.modelo;

public class Moho extends Terreno{

    @Override
    public void construir(Edificio edificio, Casilla casilla) {

        Raza raza = edificio.obtenerRaza();
        raza.construir(edificio, casilla);
    }
}
