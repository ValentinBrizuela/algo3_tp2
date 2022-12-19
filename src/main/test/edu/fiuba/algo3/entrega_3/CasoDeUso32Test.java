package edu.fiuba.algo3.entrega_3;

import edu.fiuba.algo3.modelo.edificios.Criadero;
import edu.fiuba.algo3.modelo.juego.*;
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

        FakeMapa mapa = new FakeMapa(2);
        AlgoStar algoStar = new AlgoStar(mapa);

        algoStar.registrarJugador(new Jugador("Lionel Messi", Color.BLUE, new Zerg()));
        algoStar.registrarJugador(new Jugador("Cristiano Ronaldo", Color.RED, new Protoss()));

        algoStar.construirEdificio("Criadero", 5, 5);
        Criadero c = (Criadero) mapa.obtenerEntidad(5, 5);
        c.aplicarDanio(1000);

        assertTrue(algoStar.hayGanador());
    }

    @Test
    public void laPartidaNoSeTerminaCuandoAmbosJugadoresTienenAlgunEdificio(){
        FakeMapa mapa = new FakeMapa(2);
        AlgoStar algoStar = new AlgoStar(mapa);

        algoStar.registrarJugador(new Jugador("Lionel Messi", Color.BLUE, new Zerg()));
        algoStar.registrarJugador(new Jugador("Cristiano Ronaldo", Color.RED, new Protoss()));

        algoStar.construirEdificio("Criadero", 5, 5);
        Criadero c = (Criadero) mapa.obtenerEntidad(5,5);

        assertFalse(algoStar.hayGanador());
    }
}
