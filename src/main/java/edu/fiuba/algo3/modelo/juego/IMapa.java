package edu.fiuba.algo3.modelo.juego;

public interface IMapa {

    public int tamanioMapa();

    public Casilla obtenerCasilla(int i, int j);

    public void avanzarTurno();

    public boolean estaDentroDelMapa(int posX, int posY);

    public boolean hayAmoSupremo(int x, int y,int radio);
}
