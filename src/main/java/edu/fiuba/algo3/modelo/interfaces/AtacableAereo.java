package edu.fiuba.algo3.modelo.interfaces;

import edu.fiuba.algo3.modelo.juego.Casilla;
import edu.fiuba.algo3.modelo.juego.Mapa;

public interface AtacableAereo {

    public void recibirAtaque(Atacante atacante, Mapa mapa);

    public void aplicarDanio(int danio);

    public void estasEnRango(Casilla casilla, int rango);
}
