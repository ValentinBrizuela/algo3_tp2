package edu.fiuba.algo3.modelo.estados;

import edu.fiuba.algo3.modelo.edificios.Construible;
import edu.fiuba.algo3.modelo.juego.Almacen;

public class EstadoMock extends Estado{
    @Override
    public void construir(Construible edificio, Almacen almacen) {

    }

    @Override
    public void avanzarTurno() {

    }

    @Override
    public void estaLibre() {

    }

    @Override
    public boolean tieneEntidad(Class entidad) {
        return true;
    }
}
