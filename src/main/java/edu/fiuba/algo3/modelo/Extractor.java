package edu.fiuba.algo3.modelo;

public class Extractor extends RefineriaGas{

    private int cantZanganos;

    public Extractor(){
        super(750, 100, 6);
        cantZanganos = 0;

    }

    @Override
    public void extraerGas(Almacen almacen) {  /*verificar construccion*/
        almacen.almacenarGas(cantZanganos*10);
    }

    public void meterZangano() {  /*verificar construccion*/
        if (cantZanganos == 3) {
            throw new ExtractorLlenoError();
        }
        cantZanganos += 1;
    }
}
