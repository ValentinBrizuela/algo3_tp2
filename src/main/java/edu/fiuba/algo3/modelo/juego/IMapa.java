package edu.fiuba.algo3.modelo.juego;

public interface IMapa {

    public int tamanioMapa();

    public Casilla obtenerCasilla(int i, int j);

    public void avanzarTurno();

    public boolean estaDentroDelMapa(int posX, int posY);

    public boolean hayDetector(int x, int y, int radio);

    public Entidad obtenerEntidad(int x, int y);
}
