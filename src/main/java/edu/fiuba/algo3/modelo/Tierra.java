package edu.fiuba.algo3.modelo;

public class Tierra extends Terreno{
    @Override
    public void construir(EdificioZerg edificio) {
        throw new ConstruccionNoPermitidaError();
    }
    @Override
    public void construir(EdificioProtoss edificio) {
        throw new ConstruccionNoPermitidaError();
    }
}
