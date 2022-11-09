package edu.fiuba.algo3.modelo;

public class Extractor extends EdificioZerg implements RefineriaGas{

    private int cantZanganos;

    public Extractor(){
        super(750,6, 100, 0);
        cantZanganos = 0;
        this.raza = new Zerg();
    }

    @Override
    public void extraerGas(Almacen almacen, Geiser geiser) {  /*verificar construccion*/
        geiser.extraerGas(cantZanganos*10);
        almacen.almacenarGas(cantZanganos*10);
    }

    public void meterZangano() {  /*verificar construccion*/
        if (cantZanganos == 3) {
            throw new ExtractorLlenoError();
        }
        cantZanganos += 1;
    }
}
