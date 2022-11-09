package edu.fiuba.algo3.modelo;

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

    public void cobrar(Costo costo){
        gas -= costo.obtenerCostoGas();
        mineral -= costo.obtenerCostoMineral();
    }

    public int cantGas() {
        return gas;
    }
    public int cantMineral() {
        return mineral;
    }
}
