package edu.fiuba.algo3.entrega_3;

import edu.fiuba.algo3.modelo.edificios.Criadero;
import edu.fiuba.algo3.modelo.edificios.Pilon;
import edu.fiuba.algo3.modelo.juego.AlgoColores;
import edu.fiuba.algo3.modelo.juego.AlgoStar;
import edu.fiuba.algo3.modelo.juego.FakeMapa;
import edu.fiuba.algo3.modelo.juego.Jugador;
import edu.fiuba.algo3.modelo.razas.Protoss;
import edu.fiuba.algo3.modelo.razas.Zerg;
import edu.fiuba.algo3.modelo.unidades.Dragon;
import edu.fiuba.algo3.modelo.unidades.Hidralisco;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CasoDeUso31Test {

    @Test
    public void test01DestruirUnPiloDisminuyeLaPoblacionDeUnJugador(){
        FakeMapa mapa = new FakeMapa(2);
        AlgoStar algoStar = new AlgoStar(mapa);

        Jugador jugador1 = new Jugador("camila", new AlgoColores("rojo"),new Protoss());
        Jugador jugador2 = new Jugador("pepito", new AlgoColores("azul"), new Zerg());
        algoStar.registrarJugadores(jugador1, jugador2);
        jugador1.llenarArcas();

        algoStar.construirEntidad("Pilon", 5, 0);
        Pilon pilon=(Pilon)mapa.obtenerEntidad(5, 0);
        assertEquals(5,jugador1.obtenerPoblacionUsable());

        algoStar.construirEntidad("Acceso", 5, 2);
        algoStar.construirEntidad("Dragon", 5, 3);
        Dragon dragon = (Dragon) mapa.obtenerEntidad(5, 3);
        dragon.finalizarConstruccion();

        for (int i=0; i<30; i++){
            algoStar.ataque(dragon,pilon,jugador1);
        }

        assertEquals(true,pilon.estaDestruido());
        assertEquals(0,jugador1.obtenerPoblacionUsable());
    }
    @Test
    public void test02DestruirUnCriaderoDisminuyeLaPoblacionDeUnJugador(){
        FakeMapa mapa = new FakeMapa(2);
        AlgoStar algoStar = new AlgoStar(mapa);

        Jugador jugador1=new Jugador("camila",new AlgoColores("rojo"),new Zerg());
        Jugador jugador2 = new Jugador("pepito", new AlgoColores("azul"), new Protoss());
        algoStar.registrarJugadores(jugador1, jugador2);
        jugador1.llenarArcas();
        algoStar.construirEntidad("Criadero", 5, 0);

        Criadero criadero=(Criadero) mapa.obtenerEntidad(5, 0);
        assertEquals(5,jugador1.obtenerPoblacionUsable());

        algoStar.construirEntidad("ReservaDeReproduccion", 5, 2);
        algoStar.construirEntidad("Guarida", 5, 3);
        algoStar.construirEntidad("Hidralisco", 6, 1);
        Hidralisco hidralisco = (Hidralisco) mapa.obtenerEntidad(6, 1);
        hidralisco.finalizarConstruccion();

        for (int i=0; i<50; i++){
            algoStar.ataque(hidralisco,criadero,jugador1);
        }

        assertEquals(true,criadero.estaDestruido());
        assertEquals(0,jugador1.obtenerPoblacionUsable());
    }
}
