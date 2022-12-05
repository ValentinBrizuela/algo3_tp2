package edu.fiuba.algo3.modelo.juego;

import edu.fiuba.algo3.modelo.errores.RecursosInsuficientesError;

public class Almacen {
    private int gas;
    private int mineral;

    public Almacen() {
        gas = 0;
        mineral = 0;
    }
    public void almacenarGas(int cant) {
        gas += cant;
    }

    public void almacenarMineral(int cant) {
        mineral += cant;
    }

    public void meAlcanzaGas(double cantGas){
        if (cantGas > gas){
            throw new RecursosInsuficientesError();
        }
    }

    public void meAlcanzaMineral(double cantMineral){
        if (cantMineral > mineral){
            throw new RecursosInsuficientesError();
        }
    }

    public void cobrarGas(double cant){
        gas -= cant;
    }

    public void cobrarMineral(double cant){
        mineral -= cant;
    }

    public int cantGas() {
        return gas;
    }
    public int cantMineral() {
        return mineral;
    }
}
