package edu.fiuba.algo3.modelo;

public class NexoMineral extends EdificioProtoss implements Mina {

    public NexoMineral() {
        super(250, 250, 4, 50, 0);

    }

    public void extraerMineral(Almacen almacen, Mena mena) {
        almacen.almacenarMineral(mena.extraer(20));
    }
}
