package edu.fiuba.algo3.modelo.juego;

import edu.fiuba.algo3.modelo.edificios.*;
import edu.fiuba.algo3.modelo.estados.Desocupada;
import edu.fiuba.algo3.modelo.estados.Estado;
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

    public void construir(Construible edificio, Almacen almacen){
        estado.construir(edificio, almacen);
    }

    public void cambiarEstado(Estado estado){
        this.estado = estado;
    }

    /*public void cambiarEdificio(Edificio edificio){
        this.edificio = edificio;
    }*/

    public void cambiarTerreno(Terreno terreno){
        estado.cambiarTerreno(terreno);
    }

    /*public Edificio obtenerEdificio(){
        return edificio;
    }*/

    public Estado obtenerEstado(){
        return estado;
    }

    public Terreno obtenerTerreno(){
        return estado.obtenerTerreno();
    }

    public void avanzarTurno() {
        estado.avanzarTurno();
    }

    public int obtenerPosX(){
        return posX;
    }

    public int obtenerPosY(){
        return posY;
    }

    public boolean estasEnRango(int posX, int posY, int rango){
        for (int i=(this.posX - rango); i <= (this.posX + rango); i++){
            for (int j=(this.posY - rango); j <= (this.posY + rango); j++){

                if (i == posX && j == posY){
                    return true;
                }
            }
        }
        return false;
    }

    public Recurso obtenerRecurso(){
        return estado.obtenerRecurso();
    }

    public void estaLibre(){
        estado.estaLibre();
    }
}
