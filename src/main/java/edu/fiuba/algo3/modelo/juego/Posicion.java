package edu.fiuba.algo3.modelo.juego;

import java.util.ArrayList;

public class Posicion {
    private int posX;
    private int posY;

    public Posicion(int posX, int posY){
        this.posX = posX;
        this.posY = posY;
    }

    public int obtenerPosX(){
        return posX;
    }

    public int obtenerPosY(){
        return posY;
    }
    public ArrayList<Posicion> obtenerPosicionesAdyacentes(int rango){
        ArrayList<Posicion> posicionesAdyacentes = new ArrayList<>();

        for (int i=(posX - rango); i<(posX + rango); i++){
            for (int j=(posY - rango); i<(posY + rango); j++){
                Posicion posicionij = new Posicion(i, j);
                posicionesAdyacentes.add(posicionij);
            }
        }
        return posicionesAdyacentes;
    }
}
