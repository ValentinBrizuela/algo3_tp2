package edu.fiuba.algo3.modelo.interfaces;

import edu.fiuba.algo3.modelo.edificios.Edificio;
import edu.fiuba.algo3.modelo.unidades.Unidad;

public interface Atacante {

    public void atacarA(Unidad unidad);

    public void atacarA(Edificio edificio);
}
