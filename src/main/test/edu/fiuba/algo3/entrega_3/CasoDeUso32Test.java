package edu.fiuba.algo3.entrega_3;

import edu.fiuba.algo3.modelo.edificios.Criadero;
import edu.fiuba.algo3.modelo.juego.AlgoStar;
import edu.fiuba.algo3.modelo.juego.Casilla;
import edu.fiuba.algo3.modelo.juego.Jugador;
import edu.fiuba.algo3.modelo.juego.Mapa;
import edu.fiuba.algo3.modelo.razas.Protoss;
import edu.fiuba.algo3.modelo.razas.Zerg;
import edu.fiuba.algo3.modelo.recursos.RecursoVacio;
import edu.fiuba.algo3.modelo.terrenos.Tierra;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.mock;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;


public class CasoDeUso32Test {

    @Test
    public void laPartidaSeTerminaCuandoAUnJugadorLeDestruyenTodosSusEdificios(){

        Mapa mapa = new Mapa(2);

        AlgoStar algoStar = new AlgoStar(mapa);

        algoStar.registrarJugador(new Jugador("Lionel Messi", "Celeste", new Zerg()));
        algoStar.registrarJugador(new Jugador("Cristiano Ronaldo", "Rojo", new Protoss()));

        algoStar.construirCriadero(50,50);
        Criadero c = (Criadero) mapa.obtenerCasilla(50,50).obtenerEstado().obtenerEdificio();
        c.aplicarDanio(1000);

        assertTrue(algoStar.hayGanador());
    }

    @Test
    public void laPartidaNoSeTerminaCuandoAmbosJugadoresTienenAlgunEdificio(){
        Mapa mapa = new Mapa(2);
        AlgoStar algoStar = new AlgoStar(mapa);

        algoStar.registrarJugador(new Jugador("Lionel Messi", "Celeste", new Zerg()));
        algoStar.registrarJugador(new Jugador("Cristiano Ronaldo", "Rojo", new Protoss()));

        algoStar.construirCriadero(50,50);
        Criadero c = (Criadero) mapa.obtenerCasilla(50,50).obtenerEstado().obtenerEdificio();

        assertFalse(algoStar.hayGanador());
    }
}
