package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.juego.Casilla;
import edu.fiuba.algo3.modelo.recursos.RecursoVacio;
import edu.fiuba.algo3.modelo.terrenos.Moho;
import org.junit.jupiter.api.Test;
import edu.fiuba.algo3.modelo.edificios.Criadero;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CasoDeUso1Test {
    @Test
    public void test01CriaderoRegeneraUnaLarvaAlConsumirLuegoDeUnTurno(){
        Casilla casilla = new Casilla(25,25, new Moho(), new RecursoVacio());
        Criadero c = new Criadero(casilla);

        c.avanzarTurno();
        c.avanzarTurno();
        c.avanzarTurno();
        c.avanzarTurno();
        c.engendrarZangano();

        assertEquals(2, c.cantidadLarvas());

        c.avanzarTurno();

        assertEquals(3, c.cantidadLarvas());
    }

    @Test
    public void test02CriaderoRegeneraDosLarvasAlConsumir2LuegoDeDosTurnos(){
        Casilla casilla = new Casilla(25,25, new Moho(), new RecursoVacio());
        Criadero c = new Criadero(casilla);
        c.avanzarTurno();
        c.avanzarTurno();
        c.avanzarTurno();
        c.avanzarTurno();

        c.engendrarZangano();
        c.engendrarZangano();

        assertEquals(1, c.cantidadLarvas());

        c.avanzarTurno();
        c.avanzarTurno();

        assertEquals(3, c.cantidadLarvas());
    }
}
