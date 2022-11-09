package edu.fiuba.algo3.modelo;

public class Mena {
    private int cant;

    public Mena() {
        cant = 2000;
    }

    public void construir(NexoMineral nexo) {

    }
    public int extraer(int cant) {
        if (this.cant - cant >= 0) {
            this.cant -= cant;
            return cant;
        }
        return 0;
    }
}
