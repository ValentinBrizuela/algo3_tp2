package edu.fiuba.algo3.modelo;

public class Asimilador extends EdificioProtoss implements RefineriaGas {

    public Asimilador() {
        super(450,450, 6, 100, 0);
        this.raza = new Protoss();
    }

    public void extraerGas(Almacen almacen, Geiser geiser){  /*verificar construccion*/
        geiser.extraerGas(20);
        almacen.almacenarGas(20);
    }

}
