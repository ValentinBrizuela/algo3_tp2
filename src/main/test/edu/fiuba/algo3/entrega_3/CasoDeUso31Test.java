package edu.fiuba.algo3.entrega_3;

import edu.fiuba.algo3.modelo.edificios.Criadero;
import edu.fiuba.algo3.modelo.edificios.Pilon;
import edu.fiuba.algo3.modelo.juego.AlgoColores;
import edu.fiuba.algo3.modelo.juego.AlgoStar;
import edu.fiuba.algo3.modelo.juego.FakeMapa;
import edu.fiuba.algo3.modelo.juego.Jugador;
import edu.fiuba.algo3.modelo.juego.Mapa;
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

        Jugador jugador1=new Jugador("camila", new AlgoColores("rojo"),new Protoss());
        algoStar.registrarJugador(jugador1);
        jugador1.llenarArcas();

        algoStar.construirEdificio("Pilon", 5, 0);
        Pilon pilon=(Pilon)mapa.obtenerEntidad(5, 0);
        assertEquals(5,jugador1.obtenerPoblacionUsable());

        algoStar.construirEdificio("Acceso", 5, 2);
        Dragon dragon=algoStar.crearDragon(jugador1,5,3);
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
        algoStar.registrarJugador(jugador1);
        jugador1.llenarArcas();
        algoStar.construirEdificio("Criadero", 5, 0);

        Criadero criadero=(Criadero) mapa.obtenerEntidad(5, 0);
        assertEquals(5,jugador1.obtenerPoblacionUsable());

        algoStar.construirEdificio("ReservaDeReproduccion", 5, 2);
        algoStar.construirEdificio("Guarida", 5, 3);
        Hidralisco hidralisco=algoStar.crearHidralisco(jugador1,6,1);
        hidralisco.finalizarConstruccion();

        for (int i=0; i<50; i++){
            algoStar.ataque(hidralisco,criadero,jugador1);
        }

        assertEquals(true,criadero.estaDestruido());
        assertEquals(0,jugador1.obtenerPoblacionUsable());
    }
}
