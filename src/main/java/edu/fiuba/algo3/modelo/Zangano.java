package edu.fiuba.algo3.modelo;

public class Zangano {

    private Mena mena;

    public void trabajarSobreMena(Mena mena) {
        this.mena = mena;
    }

    public void extraerMineral(Almacen almacen) {
        almacen.almacenarMineral(mena.extraer(10));
    }
}
