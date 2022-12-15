package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.unidades.Hidralisco;
import javafx.scene.paint.Color;
import edu.fiuba.algo3.modelo.juego.*;
import edu.fiuba.algo3.modelo.razas.Protoss;
import edu.fiuba.algo3.modelo.razas.Zerg;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class GamePlayTest {

    @Test
    public void gameplayTest () {

        FakeMapa fakeMapa = new FakeMapa(2);


        AlgoStar algostar = new AlgoStar(fakeMapa);

        Jugador jugador1 = new Jugador("Valentin", Color.RED, new Zerg());
        Jugador jugador2 = new Jugador("Manuel", Color.WHITE, new Protoss());

        algostar.registrarJugadores(jugador1, jugador2);

        algostar.construirEdificio("Criadero", 1, 1);

        algostar.avanzarTurno();

        algostar.construirEdificio("Pilon", 19, 18);

        algostar.avanzarTurno();

        algostar.crearZangano(algostar.obtenerJugadorActual(), 3, 4);
        algostar.crearZangano(algostar.obtenerJugadorActual(), 4, 4);

        for (int i=0; i<10; i++){
            algostar.avanzarTurno();
        }

        algostar.construirEdificio("ReservaDeReproduccion", 2, 1);

        for (int i=0; i<4; i++){
            algostar.avanzarTurno();
        }

        algostar.construirEdificio("Extractor", 2, 2);
        Hidralisco h = algostar.crearHidralisco(algostar.obtenerJugadorActual(), 4,3);

        algostar.avanzarTurno();
        algostar.avanzarTurno();

        for (int i=0; i<85; i++) {
            algostar.ataque(h, fakeMapa.obtenerCasilla(4, 4).obtenerEstado().obtenerEdificio(), algostar.obtenerJugadorActual());
        }

        assertTrue(algostar.hayGanador());
    }

}
