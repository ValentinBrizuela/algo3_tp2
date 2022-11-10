package edu.fiuba.algo3.modelo.edificios;

import edu.fiuba.algo3.modelo.juego.Almacen;
import edu.fiuba.algo3.modelo.razas.Protoss;
import edu.fiuba.algo3.modelo.recursos.Geiser;

public class Asimilador extends EdificioProtoss implements RefineriaGas {

    public Asimilador() {
        super(450,450, 6, 100, 0);
        this.raza = new Protoss();
    }

    public void extraerGas(Almacen almacen, Geiser geiser){  /*verificar construccion*/
        geiser.extraerGas(20);
        almacen.almacenarGas(20);
    }

    @Override
    public void avanzarTurno(){
        regenerar();
    }

}
