package edu.fiuba.algo3.modelo.estados;

import edu.fiuba.algo3.modelo.edificios.Construible;
import edu.fiuba.algo3.modelo.juego.Almacen;
import edu.fiuba.algo3.modelo.juego.Entidad;
import edu.fiuba.algo3.modelo.recursos.Recurso;
import edu.fiuba.algo3.modelo.terrenos.Terreno;
import edu.fiuba.algo3.modelo.unidades.Unidad;
import edu.fiuba.algo3.modelo.unidades.Zangano;

public abstract class Estado {
    protected Terreno terreno;
    protected Recurso recurso;
    protected Entidad entidad;

    public abstract void construir(Construible entidad, Almacen almacen);

    public abstract void sustituirUnidad(Unidad unidad,Almacen almacen);

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

    public void intentarExtraerMineral(Almacen almacen, Zangano zangano){
        recurso.intentarExtraerMineral(almacen,zangano);
    }

}
