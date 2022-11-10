package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.juego.Mapa;
import org.junit.jupiter.api.Test;
import edu.fiuba.algo3.modelo.edificios.Criadero;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CasoDeUso1 {
    @Test
    public void test01CriaderoRegeneraUnaLarvaAlConsumirLuegoDeUnTurno(){
        Criadero c = new Criadero(new Mapa(), 25, 25);
        //Se hizo avanzarTurno() asi temporalmente para poder avanzar con los tests
        //Hay que hacer una funcion donde se pasen la cantidad de turnos
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
        Criadero c = new Criadero(new Mapa(), 25, 25);
        c.avanzarTurno();
        c.avanzarTurno();
        c.avanzarTurno();
        c.avanzarTurno();

        //Idem a lo que pasa con avanzarTurno()
        c.engendrarZangano();
        c.engendrarZangano();

        assertEquals(1, c.cantidadLarvas());

        c.avanzarTurno();
        c.avanzarTurno();

        assertEquals(3, c.cantidadLarvas());
    }
}
