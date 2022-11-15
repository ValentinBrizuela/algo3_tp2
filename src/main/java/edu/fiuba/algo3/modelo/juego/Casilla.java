package edu.fiuba.algo3.modelo.juego;

import edu.fiuba.algo3.modelo.edificios.*;
import edu.fiuba.algo3.modelo.errores.RecursosInsuficientes;
import edu.fiuba.algo3.modelo.estados.Desocupada;
import edu.fiuba.algo3.modelo.estados.Estado;
import edu.fiuba.algo3.modelo.estados.Ocupada;
import edu.fiuba.algo3.modelo.recursos.Recurso;
import edu.fiuba.algo3.modelo.terrenos.Terreno;

public class Casilla {
    private final int posX;
    private final int posY;
    private Estado estado;

    public Casilla(int posX, int posY, Terreno terreno, Recurso recurso){
        this.posX = posX;
        this.posY = posY;
        this.estado = new Desocupada(terreno, recurso);
    }

    public void construir(Edificio edificio, Almacen almacen){
        estado.construir(edificio, almacen);
    }

    public void cambiarEstado(Estado estado){
        this.estado = estado;
    }

    /*public void cambiarEdificio(Edificio edificio){
        this.edificio = edificio;
    }*/

    public void cambiarTerreno(Terreno terreno){
        estado.terreno = terreno;
    }

    /*public Edificio obtenerEdificio(){
        return edificio;
    }*/

    public Estado obtenerEstado(){
        return estado;
    }

    /*public Terreno obtenerTerreno(){
        return terreno;
    }*/

    public void avanzarTurno() {
        estado.avanzarTurno();
    }

    public int obtenerPosX(){
        return posX;
    }

    public int obtenerPosY(){
        return posY;
    }
}
