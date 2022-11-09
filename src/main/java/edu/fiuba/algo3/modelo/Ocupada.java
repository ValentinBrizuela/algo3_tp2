package edu.fiuba.algo3.modelo;

public class Ocupada implements Estado{

    public void construir(){
        throw new EdificioYaConstruidoError();
    }

}
