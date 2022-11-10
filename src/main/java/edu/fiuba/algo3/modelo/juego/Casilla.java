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

import java.util.ArrayList;

public class Casilla {
    private final Posicion posicion;
    private Terreno terreno;

    private Recurso recurso;
    private Estado estado;

    private Mapa mapa;

    private Edificio edificio;
    public Casilla(int posX, int posY, Terreno terreno, Recurso recurso, Estado estado, Mapa mapa){
        this.posicion = new Posicion(posX, posY);
        this.terreno = terreno;
        this.estado = estado;
        this.recurso = recurso;
        this.edificio = null;
        this.mapa = mapa;
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

    public void expandirTerreno(int rango){
        ArrayList<Posicion> posicionesAdyacentes = posicion.obtenerPosicionesAdyacentes(rango);
        mapa.expandirTerreno(terreno, posicionesAdyacentes);

    }
}
