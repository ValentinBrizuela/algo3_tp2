package edu.fiuba.algo3.modelo;

public class Asimilador extends RefineriaGas{

    private int escudo;

    public Asimilador() {
        super(450,6, 100, 0);
        this.escudo = 450;
        this.raza = new Protoss();
    }

    public void extraerGas(Almacen almacen){  /*verificar construccion*/
        almacen.almacenarGas(20);
    }

}
