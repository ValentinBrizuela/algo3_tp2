package edu.fiuba.algo3.modelo.juego;

import edu.fiuba.algo3.modelo.edificios.Costo;
import edu.fiuba.algo3.modelo.edificios.Edificio;
import edu.fiuba.algo3.modelo.edificios.EdificioProtoss;
import edu.fiuba.algo3.modelo.edificios.EdificioZerg;
import edu.fiuba.algo3.modelo.errores.RecursosInsuficientes;
import edu.fiuba.algo3.modelo.estados.Estado;
import edu.fiuba.algo3.modelo.estados.Ocupada;
import edu.fiuba.algo3.modelo.recursos.Recurso;
import edu.fiuba.algo3.modelo.terrenos.Terreno;

public class Casilla {
    private final int posX;
    private final int posY;
    private Terreno terreno;

    private Recurso recurso;
    private Estado estado;

    private Edificio edificio;
    public Casilla(int posX, int posY, Terreno terreno, Recurso recurso, Estado estado){
        this.posX = posX;
        this.posY = posY;
        this.terreno = terreno;
        this.estado = estado;
        this.recurso = recurso;
        this.edificio = null;
    }

    public void construir(EdificioProtoss edificio, Almacen almacen){

        estado.construir();
        terreno.construir(edificio);
        recurso.construir(edificio);

        if (edificio.puedoComprar(almacen)){
            cambiarEstado(new Ocupada());
            cambiarEdificio(edificio);
            Costo costo = edificio.obtenerCosto();
            almacen.cobrar(costo);

        } else {
            throw new RecursosInsuficientes();
        }
    }

    public void construir(EdificioZerg edificio, Almacen almacen){

        estado.construir();
        terreno.construir(edificio);
        recurso.construir(edificio);

        if (edificio.puedoComprar(almacen)){
            cambiarEstado(new Ocupada());
            cambiarEdificio(edificio);
            Costo costo = edificio.obtenerCosto();
            almacen.cobrar(costo);

        } else {
            throw new RecursosInsuficientes();
        }
    }

    public void cambiarEstado(Estado estado){
        this.estado = estado;
    }

    private void cambiarEdificio(Edificio edificio){
        this.edificio = edificio;
    }

    public void cambiarTerreno(Terreno terreno){
        this.terreno = terreno;
    }

    public Edificio obtenerEdificio(){
        return edificio;
    }

    public Estado obtenerEstado(){
        return estado;
    }

    public Terreno obtenerTerreno(){
        return terreno;
    }

    public void avanzarTurno(){
        edificio.avanzarTurno();
    }
}
