package edu.fiuba.algo3.entrega_3;

import edu.fiuba.algo3.modelo.juego.AlgoStar;
import edu.fiuba.algo3.modelo.juego.FakeMapa;
import edu.fiuba.algo3.modelo.juego.Jugador;
import edu.fiuba.algo3.modelo.juego.*;
import edu.fiuba.algo3.modelo.razas.Protoss;
import edu.fiuba.algo3.modelo.razas.Zerg;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CasoDeUso30Test {

    @Test
    public void test01UnScoutNoSePuedeConstruirSiYaSeAlcanzoLaPoblacionMaximaUsada(){
        FakeMapa mapa = new FakeMapa(2);
        AlgoStar algoStar = new AlgoStar(mapa);

        Jugador jugador1=new Jugador("camila", new AlgoColores("rojo"),new Protoss());
        Jugador jugador2 = new Jugador("pepito", new AlgoColores("azul"), new Zerg());

        algoStar.registrarJugadores(jugador1, jugador2);
        jugador1.llenarArcas();

        for (int i=0;i<20;i++){
            algoStar.construirEntidad("Pilon", 5, i);
        }
        for (int i=0; i<20; i++){
            algoStar.construirEntidad("Pilon", 6, i);
        }

        assertEquals(200,jugador1.obtenerPoblacionUsable());

        algoStar.construirEntidad("Acceso", 7, 1);
        algoStar.construirEntidad("PuertoEstelar", 7, 2);

        for (int i=0;i<20;i++){
            algoStar.construirEntidad("Scout", 8, i);
        }
        for (int i=0;i<20;i++){
            algoStar.construirEntidad("Scout", 9, i);
        }
        for (int i=0;i<10;i++){
            algoStar.construirEntidad("Scout", 10, i);
        }

        assertEquals(200,jugador1.obtenerPoblacionEnUso());

        algoStar.construirEntidad("Scout", 11, 1);

        assertEquals(null,mapa.obtenerEntidad(11, 1));
    }
}
