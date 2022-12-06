package edu.fiuba.algo3;

import javafx.scene.paint.Color;
import edu.fiuba.algo3.modelo.edificios.Criadero;
import edu.fiuba.algo3.modelo.estados.Estado;
import edu.fiuba.algo3.modelo.juego.*;
import edu.fiuba.algo3.modelo.razas.Protoss;
import edu.fiuba.algo3.modelo.razas.Zerg;
import edu.fiuba.algo3.modelo.recursos.Geiser;
import edu.fiuba.algo3.modelo.recursos.Mena;
import edu.fiuba.algo3.modelo.recursos.RecursoVacio;
import edu.fiuba.algo3.modelo.terrenos.Tierra;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class GamePlayTest {

    @Test
    public void gameplayTest () {

        /*Mapa mapaMock = mock(Mapa.class);

        Casilla casilla1 = new Casilla(1, 1, new Tierra(), new RecursoVacio());
        Casilla casilla2 = new Casilla(2, 2, new Tierra(), new RecursoVacio());
        Casilla casilla3 = new Casilla(1, 2, new Tierra(), new Mena());
        Casilla casilla4 = new Casilla(2, 1, new Tierra(), new Geiser());
        Casilla casilla5 = new Casilla(4, 4, new Tierra(), new RecursoVacio());
        Casilla casilla6 = new Casilla(3, 3, new Tierra(), new RecursoVacio());
        Casilla casilla7 = new Casilla(4, 3, new Tierra(), new Mena());
        Casilla casilla8 = new Casilla(3, 4, new Tierra(), new Geiser());

        when(mapaMock.obtenerCasilla(1, 1)).thenReturn(casilla1);
        when(mapaMock.obtenerCasilla(2, 2)).thenReturn(casilla2);
        when(mapaMock.obtenerCasilla(1, 2)).thenReturn(casilla3);
        when(mapaMock.obtenerCasilla(2, 1)).thenReturn(casilla4);
        when(mapaMock.obtenerCasilla(4, 4)).thenReturn(casilla5);
        when(mapaMock.obtenerCasilla(3, 3)).thenReturn(casilla6);
        when(mapaMock.obtenerCasilla(4, 3)).thenReturn(casilla7);
        when(mapaMock.obtenerCasilla(3, 4)).thenReturn(casilla8);

        AlgoStar algostar = new AlgoStar(mapaMock);

        Jugador jugador1 = new Jugador("Valentin", Color.RED, new Zerg());
        Jugador jugador2 = new Jugador("Manuel", Color.WHITE, new Protoss());

        algostar.registrarJugadores(jugador1, jugador2);

        algostar.construirEdificio("Criadero", 1, 1);

        algostar.avanzarTurno();

        algostar.construirEdificio("Pilon", 4, 4);

        algostar.avanzarTurno();*/

    }

}
