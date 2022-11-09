package edu.fiuba.algo3.modelo;

public class Geiser extends Recurso {

    private int cant;
    public Geiser() {
        this.cant = 5000;
    }

    public void construir(Edificio edificio) {
        if (!(edificio instanceof RefineriaGas)) {
            throw new ConstruccionNoPermitidaError();
        }
    }

    public void extraerGas(int cant) {
        if (this.cant <= 0) {
            throw new RecursosInsuficientes();
        }
        this.cant -= cant;
    }
}
