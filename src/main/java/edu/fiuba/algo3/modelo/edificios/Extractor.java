package edu.fiuba.algo3.modelo.edificios;

import edu.fiuba.algo3.modelo.errores.EdificioEnConstruccionError;
import edu.fiuba.algo3.modelo.errores.ExtractorLlenoError;
import edu.fiuba.algo3.modelo.juego.Almacen;
import edu.fiuba.algo3.modelo.juego.Casilla;
import edu.fiuba.algo3.modelo.razas.Zerg;
import edu.fiuba.algo3.modelo.recursos.Geiser;

public class Extractor extends EdificioZerg implements RefineriaGas {

    private int cantZanganos;

    public Extractor(Casilla casilla){
        super(750,6, 100, 0, casilla);
        cantZanganos = 0;
    }

    @Override
    public void extraerGas(Almacen almacen, Geiser geiser) {
        if (!esUsable()) {
            throw new EdificioEnConstruccionError();
        }
        almacen.almacenarGas(geiser.extraerGas(cantZanganos*10));
    }

    public void meterZangano() {
        if (!esUsable()) {
            throw new EdificioEnConstruccionError();
        }
        if (cantZanganos == 3) {
            throw new ExtractorLlenoError();
        }
        cantZanganos += 1;
    }

}
