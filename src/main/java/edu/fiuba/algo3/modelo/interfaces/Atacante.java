package edu.fiuba.algo3.modelo.interfaces;

import edu.fiuba.algo3.modelo.edificios.Construible;
import edu.fiuba.algo3.modelo.unidades.Unidad;

public interface Atacante {

    public void atacarA(AtacableAereo atacableAereo);

    public void atacarA(AtacableTerrestre atacableTerrestre);

}
