package edu.fiuba.algo3.modelo.razas;

public interface Raza {
    public void recibirAtaque(Zerg zerg);

    public void recibirAtaque(Protoss protoss);

    public void seleccionarEntidad(Zerg zerg);

    public void seleccionarEntidad(Protoss protoss);

    public void puedoSeleccionar(Raza raza);

}
