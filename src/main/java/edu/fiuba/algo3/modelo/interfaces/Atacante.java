package edu.fiuba.algo3.modelo.interfaces;

import edu.fiuba.algo3.modelo.edificios.Edificio;
import edu.fiuba.algo3.modelo.juego.Entidad;

public interface Atacante {
    public void atacarA(UnidadVoladora unidadVoladora);

    public void atacarA(UnidadTerrestre unidadTerrestre);

    public void atacarA(Edificio edificio);
}
