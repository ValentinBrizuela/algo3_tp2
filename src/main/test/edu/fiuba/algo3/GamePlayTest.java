package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.edificios.Extractor;
import edu.fiuba.algo3.modelo.unidades.Hidralisco;
import edu.fiuba.algo3.modelo.unidades.Zangano;
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

        Jugador jugador1 = new Jugador("Valentin", new AlgoColores("rojo"), new Zerg());
        Jugador jugador2 = new Jugador("Manuel", new AlgoColores("azul"), new Protoss());

        algostar.registrarJugadores(jugador1, jugador2);

        algostar.construirEntidad("Criadero", 1, 1);

        algostar.avanzarTurno();

        algostar.construirEntidad("Pilon", 19, 18);

        avanzarTurnos(3, algostar);

        algostar.construirEntidad("Zangano", 3, 4);
        algostar.construirEntidad("Zangano", 4, 4);

        avanzarTurnos(10, algostar);

        algostar.construirEntidad("ReservaDeReproduccion", 2, 1);

        avanzarTurnos(4, algostar);

        algostar.construirEntidad("Extractor", 3,3);

        avanzarTurnos(6, algostar);

        algostar.construirEntidad("Zangano", 5, 5);
        algostar.construirEntidad("Zangano", 5, 6);
        algostar.construirEntidad("Zangano", 5, 7);
        Zangano z1 = (Zangano) fakeMapa.obtenerEntidad(5,5);
        Zangano z2 = (Zangano) fakeMapa.obtenerEntidad(5,6);
        Zangano z3 = (Zangano) fakeMapa.obtenerEntidad(5,7);

        avanzarTurnos(2, algostar);

        Extractor extractor = (Extractor) fakeMapa.obtenerEntidad(3, 3);
        extractor.meterZangano(z1);
        extractor.meterZangano(z2);
        extractor.meterZangano(z3);

        avanzarTurnos(6, algostar);

        algostar.construirEntidad("Guarida", 2,2);

        avanzarTurnos(4, algostar);


        algostar.construirEntidad("Hidralisco", 4,3);
        // Me falta suministro

        avanzarTurnos(6, algostar);

        algostar.construirEntidad("Criadero", 1, 2);


        avanzarTurnos(4, algostar);

        algostar.construirEntidad("Hidralisco", 4,3);
        Hidralisco h = (Hidralisco) fakeMapa.obtenerEntidad(4,3);

        avanzarTurnos(4, algostar);

        h.moverA(fakeMapa.obtenerCasilla(17, 18));

        for (int i=0; i<60; i++) {
            algostar.ataque(h, fakeMapa.obtenerEntidad(19, 18), algostar.obtenerJugadorRival());
        }

        assertTrue(algostar.hayGanador());
    }

    private void avanzarTurnos(int nro, AlgoStar algoStar){
        for (int i=0; i<nro; i++){
            algoStar.avanzarTurno();
        }
    }

}
