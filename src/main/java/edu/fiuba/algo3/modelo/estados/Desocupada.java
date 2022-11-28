package edu.fiuba.algo3.modelo.estados;

import edu.fiuba.algo3.modelo.edificios.Construible;
import edu.fiuba.algo3.modelo.juego.Almacen;
import edu.fiuba.algo3.modelo.recursos.Recurso;
import edu.fiuba.algo3.modelo.terrenos.Terreno;

public class Desocupada extends Estado {


    public Desocupada(Terreno terreno, Recurso recurso) {
            this.terreno = terreno;
            this.recurso = recurso;
            this.entidad = null;
    }

    public void construir(Construible edificio, Almacen almacen){
        recurso.construir(edificio);
        terreno.construir(edificio, almacen);
    }

    public void avanzarTurno() {
    }

    public void estaLibre(){}

    @Override
    public boolean tieneEntidad(Class entidad) {
        return false;
    }

}
