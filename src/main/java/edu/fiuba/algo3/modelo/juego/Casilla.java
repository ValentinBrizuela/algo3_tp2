package edu.fiuba.algo3.modelo.juego;

import edu.fiuba.algo3.modelo.edificios.*;
import edu.fiuba.algo3.modelo.estados.Desocupada;
import edu.fiuba.algo3.modelo.estados.Estado;
import edu.fiuba.algo3.modelo.recursos.Recurso;
import edu.fiuba.algo3.modelo.terrenos.Terreno;
import edu.fiuba.algo3.modelo.unidades.Unidad;
import edu.fiuba.algo3.modelo.unidades.Zangano;

public class Casilla {
    private final int posX;
    private final int posY;
    private Estado estado;

    public Casilla(int posX, int posY, Terreno terreno, Recurso recurso){
        this.posX = posX;
        this.posY = posY;
        this.estado = new Desocupada(terreno, recurso);
    }

    public void construir(Construible entidad, Almacen almacen){
        try {
            estado.construir(entidad, almacen);

        } catch (Exception e) {
            throw e;
        }
    }


    public void sustituirUnidad(Unidad unidad,Almacen almacen){
        try {
            estado.sustituirUnidad(unidad, almacen);

        } catch (Exception e) {
            throw e;
        }
    }

    public void cambiarEstado(Estado estado){
        this.estado = estado;
    }
    public void cambiarTerreno(Terreno terreno){
        estado.cambiarTerreno(terreno);
    }

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

    public void intentarExtraerMineral(Almacen almacen, Mina mina){
        estado.intentarExtraerMineral(almacen,mina);
    }

    public void intentarExtraerGas(Almacen almacen, RefineriaGas refineria){
        estado.intentarExtraerGas(almacen, refineria);
    }
}
