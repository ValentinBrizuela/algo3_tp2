package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.edificios.Pilon;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CasoDeUso11 {
    @Test
    public void construccionProtossRecuperaEscudoPorTurnoHastaElMaximo() {
        Pilon pilon = new Pilon();
        pilon.atacar(100);

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
