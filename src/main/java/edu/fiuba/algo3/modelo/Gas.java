package edu.fiuba.algo3.modelo;

public class Gas extends Terreno{

    public Gas(){

    }

    public Casilla construir(RefineriaGas edificio, Casilla casilla){
        casilla.estado.construir();
    }
}
