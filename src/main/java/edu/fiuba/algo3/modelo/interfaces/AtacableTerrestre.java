package edu.fiuba.algo3.modelo.interfaces;

import edu.fiuba.algo3.modelo.juego.Casilla;
import edu.fiuba.algo3.modelo.juego.Jugador;

public interface AtacableTerrestre {

    public void recibirAtaque(Atacante atacante);

    public void aplicarDanio(int danio);

    void estasEnRango(Casilla casilla, int rango);

}
