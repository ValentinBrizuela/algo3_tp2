package edu.fiuba.algo3.test_unitarios;

import edu.fiuba.algo3.modelo.juego.*;
import edu.fiuba.algo3.modelo.razas.Protoss;
import edu.fiuba.algo3.modelo.razas.Zerg;
import edu.fiuba.algo3.modelo.terrenos.Moho;
import edu.fiuba.algo3.modelo.terrenos.Terreno;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

public class CriaderoTest {
    @Test
    public void puedoCrearUnCriaderoEnUnBordeDelMapaYAlExpandirseFuncionaCorrectamente(){
        FakeMapa mapa = new FakeMapa(2);
        AlgoStar algoStar = new AlgoStar(mapa);
        Jugador jugador1 = new Jugador("Jugador1", new AlgoColores("azul"), new Zerg());
        Jugador jugador2 = new Jugador("Jugador2", new AlgoColores("rojo"), new Protoss());
        algoStar.registrarJugador(jugador1);
        algoStar.registrarJugador(jugador2);

        algoStar.construirEntidad("Criadero", 0, 5);

        for (int i=1; i<5; i++){
            assertEquals(Moho.class, mapa.obtenerCasilla(i, 5).obtenerTerreno().getClass());
        }

        for (int j=5; j<10; j++){
            assertEquals(Moho.class, mapa.obtenerCasilla(0, j).obtenerTerreno().getClass());
        }


    }

    @Test
    public void mientrasSeEstaConstruyendoElCriaderoNoAumentaSuRango(){
        FakeMapa mapa = new FakeMapa(2);
        AlgoStar algoStar = new AlgoStar(mapa);
        Jugador jugador1 = new Jugador("Jugador1", new AlgoColores("azul"), new Zerg());
        Jugador jugador2 = new Jugador("Jugador2", new AlgoColores("rojo"), new Protoss());
        algoStar.registrarJugador(jugador1);
        algoStar.registrarJugador(jugador2);

        algoStar.construirEntidad("Criadero", 5, 5);
        Terreno terrenoEsperado = mapa.obtenerCasilla(11,5).obtenerTerreno();
        algoStar.avanzarTurno();
        algoStar.avanzarTurno();

        assertEquals(terrenoEsperado, mapa.obtenerCasilla(11,5).obtenerTerreno());
    }
}
