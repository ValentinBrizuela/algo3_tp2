package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.edificios.Pilon;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CasoDeUso12 {
    @Test
    public void construccionProtossRegeneraEscudoPeroNoVida() {
        Pilon pilon = new Pilon();
        pilon.atacar(400);

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
