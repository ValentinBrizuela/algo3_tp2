package edu.fiuba.algo3.modelo.razas;

import edu.fiuba.algo3.modelo.edificios.Edificio;
import edu.fiuba.algo3.modelo.edificios.Pilon;
import edu.fiuba.algo3.modelo.errores.AtaqueInvalido;
import edu.fiuba.algo3.modelo.errores.ConstruccionNoPermitidaError;
import edu.fiuba.algo3.modelo.juego.Casilla;

public class Protoss implements Raza {
    public Protoss(){

    }

    @Override
    public void recibirAtaque(Zerg zerg) {

    }

    @Override
    public void recibirAtaque(Protoss protoss) {
        throw new AtaqueInvalido();
    }
}
