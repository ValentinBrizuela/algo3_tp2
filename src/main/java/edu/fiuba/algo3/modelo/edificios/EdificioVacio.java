package edu.fiuba.algo3.modelo.edificios;

import edu.fiuba.algo3.modelo.juego.Almacen;
import edu.fiuba.algo3.modelo.juego.Casilla;
import edu.fiuba.algo3.modelo.terrenos.Moho;
import edu.fiuba.algo3.modelo.terrenos.Tierra;
import edu.fiuba.algo3.modelo.terrenos.TierraEnergizada;

public class EdificioVacio extends Edificio{

    public EdificioVacio(Casilla casilla) {
        super(100, 0, 0, 0, casilla);
    }

    @Override
    public void recibirDanio(int dano) {

    }

    @Override
    public void regenerar() {

    }

    @Override
    public void avanzarTurno() {

    }

    @Override
    public void construir(Moho moho, Almacen almacen) {

    }

    @Override
    public void construir(Tierra tierra, Almacen almacen) {

    }

    @Override
    public void construir(TierraEnergizada tierraEnergizada, Almacen almacen) {

    }
}
