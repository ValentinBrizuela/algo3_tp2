package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.juego.*;
import edu.fiuba.algo3.modelo.razas.Protoss;
import edu.fiuba.algo3.modelo.razas.Zerg;
import edu.fiuba.algo3.modelo.terrenos.Moho;
import edu.fiuba.algo3.modelo.terrenos.Tierra;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CasoDeUso6Test {
    @Test
    public void mohoSeExpandeSegunLoEsperado() {
        FakeMapa mapa = new FakeMapa(2);
        AlgoStar algoStar=new AlgoStar(mapa);
        Jugador jugador1=new Jugador("camila", new AlgoColores("rojo"),new Zerg());
        Jugador jugador2=new Jugador("tomasa",new AlgoColores("azul"),new Protoss());
        algoStar.registrarJugadores(jugador1, jugador2);

        algoStar.construirEntidad("Criadero", 5, 5);

        algoStar.avanzarTurno();
        assertEquals(Moho.class, mapa.obtenerCasilla(10, 10).obtenerEstado().obtenerTerreno().getClass());
        assertEquals(Tierra.class, mapa.obtenerCasilla(11, 11).obtenerEstado().obtenerTerreno().getClass());

        algoStar.avanzarTurno();
        assertEquals(Moho.class, mapa.obtenerCasilla(10, 10).obtenerEstado().obtenerTerreno().getClass());
        assertEquals(Tierra.class, mapa.obtenerCasilla(11, 11).obtenerEstado().obtenerTerreno().getClass());

        algoStar.avanzarTurno();
        algoStar.avanzarTurno();
        algoStar.avanzarTurno();
        assertEquals(Moho.class, mapa.obtenerCasilla(10, 10).obtenerEstado().obtenerTerreno().getClass());
        assertEquals(Moho.class, mapa.obtenerCasilla(11, 11).obtenerEstado().obtenerTerreno().getClass());
    }
}
