package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.edificios.Pilon;
import edu.fiuba.algo3.modelo.juego.Casilla;
import edu.fiuba.algo3.modelo.juego.Mapa;
import edu.fiuba.algo3.modelo.recursos.RecursoVacio;
import edu.fiuba.algo3.modelo.terrenos.TierraEnergizada;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CasoDeUso12Test {
    @Test
    public void construccionProtossRegeneraEscudoPeroNoVida() {
        Mapa mapa = new Mapa(2);
        Casilla casilla = new Casilla(25,25,new TierraEnergizada(), new RecursoVacio());
        Pilon pilon = new Pilon(mapa, casilla);
        pilon.aplicarDanio(400);

        assertEquals(0, pilon.escudo());
        assertEquals(200, pilon.vida());

        pilon.avanzarTurno();

        assertEquals(30, pilon.escudo());
        assertEquals(200, pilon.vida());

        pilon.avanzarTurno();

        assertEquals(60, pilon.escudo());
        assertEquals(200, pilon.vida());

        pilon.avanzarTurno();

        assertEquals(90, pilon.escudo());
        assertEquals(200, pilon.vida());

        pilon.avanzarTurno();

        assertEquals(120, pilon.escudo());
        assertEquals(200, pilon.vida());

    }
}
