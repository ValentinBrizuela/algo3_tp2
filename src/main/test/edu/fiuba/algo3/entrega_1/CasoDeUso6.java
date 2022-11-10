package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.edificios.Criadero;
import edu.fiuba.algo3.modelo.juego.Almacen;
import edu.fiuba.algo3.modelo.juego.Casilla;
import edu.fiuba.algo3.modelo.juego.Mapa;
import edu.fiuba.algo3.modelo.juego.Posicion;
import edu.fiuba.algo3.modelo.terrenos.Moho;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CasoDeUso6 {
    @Test
    public void elCriaderoSeConstruyeConUnRangoDe5Casillas(){
        Mapa mapa = new Mapa();
        Posicion posicion = new Posicion(10, 10);
        Criadero criadero = new Criadero();
        Almacen almacen = new Almacen();
        Moho moho = new Moho()

        almacen.almacenarMineral(1000);
        mapa.construirEdificioEnPosicion(criadero, posicion, almacen);

        for (int i=0; i<4; i++){
            mapa.avanzarTurno();   /* hasta que el criadero se construya*/
        }

        ArrayList<Posicion> posicionesEnRango = posicion.obtenerPosicionesAdyacentes(5);
        Casilla[][] casillas = mapa.obtenerCasillas();

        for (Posicion posicionEnRango : posicionesEnRango){
            assertEquals(moho, casillas[posicionEnRango.obtenerPosX()][posicionEnRango.obtenerPosY()].obtenerTerreno());
        }
    }
}
