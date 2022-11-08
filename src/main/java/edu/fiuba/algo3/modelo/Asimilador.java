package edu.fiuba.algo3.modelo;

public class Asimilador extends RefineriaGas{

    private int escudo;

    public Asimilador() {
        super(450, 100, 6);
        this.escudo = 450;
    }

    public void extraerGas(Almacen almacen){  /*verificar construccion*/
        almacen.almacenarGas(20);
    }

}
