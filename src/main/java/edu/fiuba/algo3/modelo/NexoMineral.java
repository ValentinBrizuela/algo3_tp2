package edu.fiuba.algo3.modelo;

public class NexoMineral extends Edificio {

    private Mena mena;

    public NexoMineral(Mena mena) {
        super(250, 50, 4);
        this.mena = mena;
    }

    public void extraerMineral(Almacen almacen) {
        almacen.almacenarMineral(mena.extraer(20));
    }
}
