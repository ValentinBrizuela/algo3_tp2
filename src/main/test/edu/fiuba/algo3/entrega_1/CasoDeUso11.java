package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.edificios.Pilon;
import edu.fiuba.algo3.modelo.juego.Casilla;
import edu.fiuba.algo3.modelo.juego.Mapa;
import edu.fiuba.algo3.modelo.recursos.RecursoVacio;
import edu.fiuba.algo3.modelo.terrenos.TierraEnergizada;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CasoDeUso11 {
    @Test
    public void construccionProtossRecuperaEscudoPorTurnoHastaElMaximo() {
        Mapa mapa = new Mapa();
        Casilla casilla = new Casilla(25,25, new TierraEnergizada(), new RecursoVacio());
        Pilon pilon = new Pilon(mapa, casilla);
        pilon.recibirAtaque(100);

        assertEquals(200, pilon.escudo());

        pilon.avanzarTurno();

        assertEquals(230, pilon.escudo());

        pilon.avanzarTurno();

        assertEquals(260, pilon.escudo());

        pilon.avanzarTurno();

        assertEquals(290, pilon.escudo());

        pilon.avanzarTurno();

        assertEquals(300, pilon.escudo());

    }
}
