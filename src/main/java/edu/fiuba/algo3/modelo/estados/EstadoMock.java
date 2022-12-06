package edu.fiuba.algo3.modelo.estados;

import edu.fiuba.algo3.modelo.edificios.Construible;
import edu.fiuba.algo3.modelo.juego.Almacen;
import edu.fiuba.algo3.modelo.unidades.Unidad;

public class EstadoMock extends Estado{
    @Override
    public void construir(Construible edificio, Almacen almacen) {

    }

    public void sustituirUnidad(Unidad unidad,Almacen almacen){
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
