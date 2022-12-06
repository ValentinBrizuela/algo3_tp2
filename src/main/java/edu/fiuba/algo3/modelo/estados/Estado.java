package edu.fiuba.algo3.modelo.estados;

import edu.fiuba.algo3.modelo.edificios.Construible;
import edu.fiuba.algo3.modelo.juego.Almacen;
import edu.fiuba.algo3.modelo.juego.Entidad;
import edu.fiuba.algo3.modelo.recursos.Recurso;
import edu.fiuba.algo3.modelo.terrenos.Terreno;

public abstract class Estado {
    protected Terreno terreno;
    protected Recurso recurso;
    protected Entidad entidad;

    public abstract void construir(Construible edificio, Almacen almacen);

    public abstract void avanzarTurno();

    public Terreno obtenerTerreno(){
        return terreno;
    }

    public Recurso obtenerRecurso(){
        return recurso;
    }

    public void cambiarTerreno(Terreno terreno){
        this.terreno.puedoCambiar();
        this.terreno = terreno;
    }

    public Entidad obtenerEdificio(){
        return entidad;
    }

    public void cambiarEdificio(Entidad edificio){
        this.entidad = edificio;
    }

    public abstract void estaLibre();

    public abstract boolean tieneEntidad(Class entidad);

}
