package edu.fiuba.algo3.modelo;

public class Protoss extends Raza{
    public Protoss(){

    }

    public void construir(Edificio edificio, Casilla casilla) {
        if(edificio instanceof Pilon) {
            //se puede
        } else {
            throw new ConstruccionNoPermitidaError();
        }
    }
}
