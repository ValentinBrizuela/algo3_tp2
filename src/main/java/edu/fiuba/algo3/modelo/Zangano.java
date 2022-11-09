package edu.fiuba.algo3.modelo;

public class Zangano implements Mina {

    public void extraerMineral(Almacen almacen, Mena mena) {
        almacen.almacenarMineral(mena.extraer(10));
    }
}
