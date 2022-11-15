package edu.fiuba.algo3.modelo.interfaces;

import edu.fiuba.algo3.modelo.edificios.Edificio;
import edu.fiuba.algo3.modelo.unidades.UnidadTerrestre;
import edu.fiuba.algo3.modelo.unidades.UnidadVoladora;

public interface Atacante {
    public void atacarA(UnidadVoladora unidadVoladora);

    public void atacarA(UnidadTerrestre unidadTerrestre);

    public void atacarA(Edificio edificio);
}
