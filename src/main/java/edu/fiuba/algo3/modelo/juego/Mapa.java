package edu.fiuba.algo3.modelo.juego;

import edu.fiuba.algo3.modelo.estados.Desocupada;
import edu.fiuba.algo3.modelo.recursos.RecursoVacio;
import edu.fiuba.algo3.modelo.terrenos.Tierra;

public class Mapa {
    private Casilla[][] casillas;

    public Mapa(){

        casillas = new Casilla[50][50];

        for (int i=0; i<50; i++){
            for (int j=0; j<50; j++){
                casillas[i][j] = new Casilla(i, j, new Tierra(), new RecursoVacio(), new Desocupada());
            }
        }
    }

    public Casilla obtenerCasilla(int i, int j) {
        return casillas[i][j];
    }

    public void avanzarTurno(){
        for (Casilla[] Filacasilla : casillas){
            for (Casilla casilla : Filacasilla) {
                casilla.avanzarTurno();
            }
        }
    }

}
