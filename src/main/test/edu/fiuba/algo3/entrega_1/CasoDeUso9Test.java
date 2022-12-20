package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.edificios.Pilon;
import edu.fiuba.algo3.modelo.juego.*;
import edu.fiuba.algo3.modelo.razas.Protoss;
import edu.fiuba.algo3.modelo.razas.Zerg;
import edu.fiuba.algo3.modelo.terrenos.TierraEnergizada;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CasoDeUso9Test {
    @Test
    public void EdificioProtossSigueEnergizadoSiLeDestruyenElPilonQueLoEnergizaPeroTieneOtroEnRango(){
        FakeMapa mapa = new FakeMapa(2);
        AlgoStar algoStar=new AlgoStar(mapa);
        Jugador jugador1=new Jugador("camila", new AlgoColores("rojo"),new Protoss());
        Jugador jugador2=new Jugador("tomasa",new AlgoColores("azul"),new Zerg());
        algoStar.registrarJugadores(jugador1, jugador2);
        jugador1.llenarArcas();

        algoStar.construirEntidad("Pilon", 6, 6);
        algoStar.construirEntidad("Pilon", 6, 7);

        Pilon pilon2 = (Pilon) mapa.obtenerEntidad(6, 7);

        algoStar.construirEntidad("Acceso", 7, 7);

        assertEquals(mapa.obtenerCasilla(7, 7).obtenerEstado().obtenerTerreno().getClass(), TierraEnergizada.class);

        pilon2.aplicarDanio(2000);

        algoStar.avanzarTurno();

        assertEquals(mapa.obtenerCasilla(7, 7).obtenerEstado().obtenerTerreno().getClass(), TierraEnergizada.class);
    }
}
