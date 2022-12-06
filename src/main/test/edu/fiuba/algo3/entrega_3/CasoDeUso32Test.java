package edu.fiuba.algo3.entrega_3;

import edu.fiuba.algo3.modelo.edificios.Criadero;
import edu.fiuba.algo3.modelo.juego.AlgoStar;
import edu.fiuba.algo3.modelo.juego.Casilla;
import edu.fiuba.algo3.modelo.juego.Jugador;
import edu.fiuba.algo3.modelo.juego.Mapa;
import edu.fiuba.algo3.modelo.razas.Protoss;
import edu.fiuba.algo3.modelo.razas.Zerg;
import edu.fiuba.algo3.modelo.recursos.RecursoVacio;
import edu.fiuba.algo3.modelo.terrenos.Tierra;
import javafx.scene.paint.Color;
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

        algoStar.registrarJugador(new Jugador("Lionel Messi", Color.BLUE, new Zerg()));
        algoStar.registrarJugador(new Jugador("Cristiano Ronaldo", Color.RED, new Protoss()));

        algoStar.construirEdificio("Criadero", 50, 50);
        Criadero c = (Criadero) mockMapa.obtenerCasilla(50,50).obtenerEstado().obtenerEdificio();
        c.aplicarDanio(1000);

        assertTrue(algoStar.hayGanador());
    }

    @Test
    public void laPartidaNoSeTerminaCuandoAmbosJugadoresTienenAlgunEdificio(){
        Mapa mockMapa = mock(Mapa.class);
        AlgoStar algoStar = new AlgoStar(mockMapa);
        when(mockMapa.obtenerCasilla(50,50)).thenReturn(new Casilla(50, 50, new Tierra(), new RecursoVacio()));

        algoStar.registrarJugador(new Jugador("Lionel Messi", Color.BLUE, new Zerg()));
        algoStar.registrarJugador(new Jugador("Cristiano Ronaldo", Color.RED, new Protoss()));

        algoStar.construirEdificio("Criadero", 50, 50);
        Criadero c = (Criadero) mockMapa.obtenerCasilla(50,50).obtenerEstado().obtenerEdificio();

        assertFalse(algoStar.hayGanador());
    }
}
