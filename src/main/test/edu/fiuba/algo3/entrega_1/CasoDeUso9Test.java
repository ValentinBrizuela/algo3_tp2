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
        Mapa mapa = new Mapa(2);
        AlgoStar algoStar=new AlgoStar(mapa);
        Jugador jugador1=new Jugador("camila","rojo",new Zerg());
        Jugador jugador2=new Jugador("tomasa","azul",new Protoss());
        algoStar.registrarJugador(jugador1);
        algoStar.registrarJugador(jugador2);
        jugador1.llenarArcas();

        Casilla casilla = mapa.obtenerCasilla(49, 49);



        algoStar.construirEdificio("Pilon", 50, 50);
        algoStar.construirEdificio("Pilon", 50, 51);

        Pilon pilon2=(Pilon)mapa.obtenerCasilla(50,51).obtenerEstado().obtenerEdificio();
        //Acceso acceso = new Acceso(casilla);
        algoStar.construirEdificio("Acceso", 49, 49);

        assertEquals(casilla.obtenerEstado().obtenerTerreno().getClass(), TierraEnergizada.class);

        pilon2.aplicarDanio(2000);

        algoStar.avanzarTurno();

        assertEquals(casilla.obtenerEstado().obtenerTerreno().getClass(), TierraEnergizada.class);
        /*assertTrue(acceso.estaEnergizado());*/
    }
}
