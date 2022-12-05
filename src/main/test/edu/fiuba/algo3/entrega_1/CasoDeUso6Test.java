package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.juego.AlgoStar;
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
        Mapa mapa = new Mapa(2);
        AlgoStar algoStar=new AlgoStar(mapa);
        Jugador jugador1=new Jugador("camila", Color.RED,new Zerg());
        Jugador jugador2=new Jugador("tomasa",Color.BLUE,new Protoss());
        algoStar.registrarJugador(jugador1);
        algoStar.registrarJugador(jugador2);
        //Casilla casilla = mapa.obtenerCasilla(25,25);
        algoStar.construirEdificio("Criadero", 25, 25);

        //Casilla casilla = mapa.obtenerCasilla(25,25);

        algoStar.avanzarTurno();
        assertEquals(Moho.class, mapa.obtenerCasilla(30, 30).obtenerEstado().obtenerTerreno().getClass());
        assertEquals(Tierra.class, mapa.obtenerCasilla(31, 31).obtenerEstado().obtenerTerreno().getClass());

        algoStar.avanzarTurno();
        assertEquals(Moho.class, mapa.obtenerCasilla(30, 30).obtenerEstado().obtenerTerreno().getClass());
        assertEquals(Tierra.class, mapa.obtenerCasilla(31, 31).obtenerEstado().obtenerTerreno().getClass());

        algoStar.avanzarTurno();
        assertEquals(Moho.class, mapa.obtenerCasilla(30, 30).obtenerEstado().obtenerTerreno().getClass());
        assertEquals(Moho.class, mapa.obtenerCasilla(31, 31).obtenerEstado().obtenerTerreno().getClass());
    }
}
