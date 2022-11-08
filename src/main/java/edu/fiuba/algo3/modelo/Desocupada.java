package edu.fiuba.algo3.modelo;

public class Desocupada implements Estado {
    public void construir(Edificio edificio, Casilla casilla){
        Terreno terreno = casilla.obtenerTerreno();
        terreno.construir(edificio, casilla);
    }
}
