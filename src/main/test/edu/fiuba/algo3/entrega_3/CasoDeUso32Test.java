package edu.fiuba.algo3.entrega_3;

import edu.fiuba.algo3.modelo.edificios.Criadero;
import edu.fiuba.algo3.modelo.juego.*;
import edu.fiuba.algo3.modelo.razas.Protoss;
import edu.fiuba.algo3.modelo.razas.Zerg;
import edu.fiuba.algo3.modelo.recursos.RecursoVacio;
import edu.fiuba.algo3.modelo.terrenos.Tierra;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.mock;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;


public class CasoDeUso32Test {

    @Test
    public void laPartidaSeTerminaCuandoAUnJugadorLeDestruyenTodosSusEdificios(){

        Mapa mockMapa = mock(Mapa.class);
        AlgoStar algoStar = new AlgoStar(mockMapa);
        when(mockMapa.obtenerCasilla(50,50)).thenReturn(new Casilla(50, 50, new Tierra(), new RecursoVacio()));

        algoStar.registrarJugador(new Jugador("Lionel Messi", new AlgoColores("azul"), new Zerg()));
        algoStar.registrarJugador(new Jugador("Cristiano Ronaldo", new AlgoColores("rojo"), new Protoss()));

        algoStar.construirEdificio("Criadero", 50, 50);
        Criadero c = (Criadero) mockMapa.obtenerCasilla(50,50).obtenerEstado().obtenerEntidad();
        c.aplicarDanio(1000);

        assertTrue(algoStar.hayGanador());
    }

    @Test
    public void laPartidaNoSeTerminaCuandoAmbosJugadoresTienenAlgunEdificio(){
        Mapa mockMapa = mock(Mapa.class);
        AlgoStar algoStar = new AlgoStar(mockMapa);
        when(mockMapa.obtenerCasilla(50,50)).thenReturn(new Casilla(50, 50, new Tierra(), new RecursoVacio()));

        algoStar.registrarJugador(new Jugador("Lionel Messi", new AlgoColores("azul"), new Zerg()));
        algoStar.registrarJugador(new Jugador("Cristiano Ronaldo", new AlgoColores("rojo"), new Protoss()));

        algoStar.construirEdificio("Criadero", 50, 50);
        Criadero c = (Criadero) mockMapa.obtenerCasilla(50,50).obtenerEstado().obtenerEntidad();

        assertFalse(algoStar.hayGanador());
    }
}
