package edu.fiuba.algo3.entrega_1;

import org.junit.jupiter.api.Test;
import edu.fiuba.algo3.modelo.Criadero;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CasoDeUso1 {
    @Test
    public void test01CriaderoRegeneraUnaLarvaAlConsumirLuegoDeUnTurno(){
        Criadero c = new Criadero();
        c.engendrarZangano();

        assertEquals(2, c.cantidadLarvas());

        c.avanzarTurno();

        assertEquals(3, c.cantidadLarvas());
    }

    @Test
    public void test02CriaderoRegeneraDosLarvasAlConsumir2LuegoDeDosTurnos(){
        Criadero c = new Criadero();
        c.engendrarZangano();
        c.engendrarZangano();

        assertEquals(1, c.cantidadLarvas());

        c.avanzarTurno();
        c.avanzarTurno();

        assertEquals(3, c.cantidadLarvas());
    }
}
