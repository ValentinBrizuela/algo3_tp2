package edu.fiuba.algo3.modelo;

public class Tierra extends Terreno{
    @Override
    public void construir(Edificio edificio, Casilla casilla) {

            Raza raza = edificio.obtenerRaza();
            raza.construir(edificio, casilla);
    }
}
