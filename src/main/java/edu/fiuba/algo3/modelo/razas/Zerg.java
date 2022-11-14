package edu.fiuba.algo3.modelo.razas;

import edu.fiuba.algo3.modelo.edificios.Criadero;
import edu.fiuba.algo3.modelo.edificios.Edificio;
import edu.fiuba.algo3.modelo.errores.AtaqueInvalido;
import edu.fiuba.algo3.modelo.errores.ConstruccionNoPermitidaError;
import edu.fiuba.algo3.modelo.juego.Casilla;

public class Zerg implements Raza {

    public Zerg(){

    }

    @Override
    public void recibirAtaque(Zerg zerg) {
        throw new AtaqueInvalido();
    }

    @Override
    public void recibirAtaque(Protoss protoss) {
    }
}
