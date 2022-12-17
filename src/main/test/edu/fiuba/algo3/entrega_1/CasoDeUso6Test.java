package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.juego.AlgoStar;
import edu.fiuba.algo3.modelo.juego.FakeMapa;
import edu.fiuba.algo3.modelo.juego.Jugador;
import edu.fiuba.algo3.modelo.juego.Mapa;
import edu.fiuba.algo3.modelo.razas.Protoss;
import edu.fiuba.algo3.modelo.razas.Zerg;
import edu.fiuba.algo3.modelo.terrenos.Moho;
import edu.fiuba.algo3.modelo.terrenos.Tierra;
import javafx.scene.paint.Color;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CasoDeUso6Test {
    @Test
    public void mohoSeExpandeSegunLoEsperado() {
        FakeMapa mapa = new FakeMapa(2);
        AlgoStar algoStar=new AlgoStar(mapa);
        Jugador jugador1=new Jugador("camila", Color.RED,new Zerg());
        Jugador jugador2=new Jugador("tomasa",Color.BLUE,new Protoss());
        algoStar.registrarJugador(jugador1);
        algoStar.registrarJugador(jugador2);

        algoStar.construirEdificio("Criadero", 5, 5);

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
