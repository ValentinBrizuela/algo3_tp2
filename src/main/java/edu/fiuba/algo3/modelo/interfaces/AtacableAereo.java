package edu.fiuba.algo3.modelo.interfaces;

import edu.fiuba.algo3.modelo.juego.Casilla;

public interface AtacableAereo {

    public void recibirAtaque(Atacante atacante);

    public void aplicarDanio(int danio);

    public void estasEnRango(Casilla casilla, int rango);
}
