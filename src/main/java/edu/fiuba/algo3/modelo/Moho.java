package edu.fiuba.algo3.modelo;

public class Moho extends Terreno{

    @Override
    public void construir(EdificioZerg edificio) {
    }
    @Override
    public void construir(EdificioProtoss edificio) {
        throw new ConstruccionNoPermitidaError();
    }
}
