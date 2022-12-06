package edu.fiuba.algo3.test_unitarios;

import edu.fiuba.algo3.modelo.juego.AlgoStar;
import edu.fiuba.algo3.modelo.juego.Casilla;
import edu.fiuba.algo3.modelo.juego.Jugador;
import edu.fiuba.algo3.modelo.juego.Mapa;
import edu.fiuba.algo3.modelo.razas.Protoss;
import edu.fiuba.algo3.modelo.razas.Zerg;
import edu.fiuba.algo3.modelo.terrenos.Moho;
import edu.fiuba.algo3.modelo.terrenos.Terreno;
import javafx.scene.paint.Color;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

public class CriaderoTest {
    @Test
    public void puedoCrearUnCriaderoEnUnBordeDelMapaYAlExpandirseFuncionaCorrectamente(){
        Mapa mapa = new Mapa(2);
        AlgoStar algoStar = new AlgoStar(mapa);
        Jugador jugador1 = new Jugador("Jugador1", Color.BLUE, new Zerg());
        Jugador jugador2 = new Jugador("Jugador2", Color.RED, new Protoss());
        algoStar.registrarJugador(jugador1);
        algoStar.registrarJugador(jugador2);

        algoStar.construirEdificio("Criadero", 0, 50);

        for (int i=1; i<5; i++){
            assertEquals(Moho.class, mapa.obtenerCasilla(i, 50).obtenerTerreno().getClass());
        }

        for (int j=45; j<55; j++){
            assertEquals(Moho.class, mapa.obtenerCasilla(0, j).obtenerTerreno().getClass());
        }


    }

    @Test
    public void mientrasSeEstaConstruyendoElCriaderoNoAumentaSuRango(){
        Mapa mapa = new Mapa(2);
        AlgoStar algoStar = new AlgoStar(mapa);
        Jugador jugador1 = new Jugador("Jugador1", Color.BLUE, new Zerg());
        Jugador jugador2 = new Jugador("Jugador2", Color.RED, new Protoss());
        algoStar.registrarJugador(jugador1);
        algoStar.registrarJugador(jugador2);

        algoStar.construirEdificio("Criadero", 50, 50);
        Terreno terrenoEsperado = mapa.obtenerCasilla(56,50).obtenerTerreno();
        algoStar.avanzarTurno();
        algoStar.avanzarTurno();

        assertEquals(terrenoEsperado, mapa.obtenerCasilla(56,50).obtenerTerreno());
    }
}
