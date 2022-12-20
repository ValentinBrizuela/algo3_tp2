package edu.fiuba.algo3.test_unitarios;

import edu.fiuba.algo3.modelo.juego.*;
import edu.fiuba.algo3.modelo.razas.Protoss;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class JugadorTest {
    @Test
    public void siElJugadorNuncaConstruyoUnEdificioNoPerdio(){
        Jugador jugador = new Jugador("Lionel Messi", new AlgoColores("azul"), new Protoss());
        assertFalse(jugador.perdio());
    }

    @Test
    public void unJugadorArrancaCon0DeCapacidadDePoblacion(){
        Jugador jugador = new Jugador("Lionel Messi", new AlgoColores("azul"), new Protoss());
        assertEquals(0, jugador.obtenerPoblacionUsable());
    }
}
