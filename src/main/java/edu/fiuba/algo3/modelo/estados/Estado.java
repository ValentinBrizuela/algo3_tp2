package edu.fiuba.algo3.modelo.estados;

import edu.fiuba.algo3.modelo.edificios.Edificio;
import edu.fiuba.algo3.modelo.juego.Almacen;
import edu.fiuba.algo3.modelo.recursos.Recurso;
import edu.fiuba.algo3.modelo.terrenos.Terreno;

public abstract class Estado {
    protected Terreno terreno;
    protected Recurso recurso;
    protected Edificio edificio;

    public abstract void construir(Edificio edificio, Almacen almacen);

    public abstract void avanzarTurno();

    public Terreno obtenerTerreno(){
        return terreno;
    }

    public Recurso obtenerRecurso(){
        return recurso;
    }

    public void cambiarTerreno(Terreno terreno){
        this.terreno = terreno;
    }

    public Edificio obtenerEdificio(){
        return edificio;
    }

    public void cambiarEdificio(Edificio edificio){
        this.edificio = edificio;
    }
}
