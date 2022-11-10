package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.estados.Desocupada;
import edu.fiuba.algo3.modelo.juego.Casilla;
import edu.fiuba.algo3.modelo.juego.Mapa;
import edu.fiuba.algo3.modelo.recursos.RecursoVacio;
import edu.fiuba.algo3.modelo.terrenos.Moho;
import org.junit.jupiter.api.Test;
import edu.fiuba.algo3.modelo.edificios.Criadero;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CasoDeUso1 {
    @Test
    public void test01CriaderoRegeneraUnaLarvaAlConsumirLuegoDeUnTurno(){
        Casilla casilla = new Casilla(25,25, new Moho(), new RecursoVacio(), new Desocupada());
        Criadero c = new Criadero(new Mapa(), casilla);
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
        Casilla casilla = new Casilla(25,25, new Moho(), new RecursoVacio(), new Desocupada());
        Criadero c = new Criadero(new Mapa(), casilla);
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
