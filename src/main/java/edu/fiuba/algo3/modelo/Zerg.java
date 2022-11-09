package edu.fiuba.algo3.modelo;

public class Zerg extends Raza{

    public Zerg(){

    }

    public void construir(Edificio edificio, Casilla casilla) {
        if(edificio instanceof Criadero){
            //se puede
        }else{
            throw new ConstruccionNoPermitidaError();
        }
    }
}
