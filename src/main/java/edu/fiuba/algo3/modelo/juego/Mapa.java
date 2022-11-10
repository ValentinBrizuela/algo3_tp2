package edu.fiuba.algo3.modelo.juego;

import edu.fiuba.algo3.modelo.edificios.Edificio;
import edu.fiuba.algo3.modelo.edificios.EdificioProtoss;
import edu.fiuba.algo3.modelo.edificios.EdificioZerg;
import edu.fiuba.algo3.modelo.estados.Desocupada;
import edu.fiuba.algo3.modelo.juego.AlgoStar;
import edu.fiuba.algo3.modelo.juego.Casilla;
import edu.fiuba.algo3.modelo.recursos.RecursoVacio;
import edu.fiuba.algo3.modelo.terrenos.Terreno;
import edu.fiuba.algo3.modelo.terrenos.Tierra;

import java.util.ArrayList;

public class Mapa extends AlgoStar {
    private Casilla[][] casillas;

    public Mapa(){

        for (int i=0; i<50; i++){
            for (int j=0; j<50; j++){
                casillas[i][j] = new Casilla(i, j, new Tierra(), new RecursoVacio(), new Desocupada());
            }
        }
    }

    public void avanzarTurno(){
        for (Casilla[] Filacasilla : casillas){
            for (Casilla casilla : Filacasilla) {
                casilla.avanzarTurno();
            }
        }
    }

    public void expandirTerreno(Terreno terreno, ArrayList<Posicion> posicionesAdyacentes){
        for (Posicion posicion : posicionesAdyacentes){
            casillas[posicion.obtenerPosX()][posicion.obtenerPosY()].cambiarTerreno(terreno);
        }
    }

    public void construirEdificioEnPosicion(EdificioProtoss edificio, Posicion posicion, Almacen almacen){
        int posX = posicion.obtenerPosX();
        int posY = posicion.obtenerPosY();

        casillas[posX][posY].construir(edificio, almacen);
    }

    public void construirEdificioEnPosicion(EdificioZerg edificio, Posicion posicion, Almacen almacen){
        int posX = posicion.obtenerPosX();
        int posY = posicion.obtenerPosY();

        casillas[posX][posY].construir(edificio, almacen);
    }

    public Casilla[][] obtenerCasillas(){
        return casillas;
    }

}
