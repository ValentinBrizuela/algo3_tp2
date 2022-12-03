package edu.fiuba.algo3.entrega_3;

import edu.fiuba.algo3.modelo.edificios.Criadero;
import edu.fiuba.algo3.modelo.edificios.Pilon;
import edu.fiuba.algo3.modelo.juego.AlgoStar;
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
        Mapa mapa = new Mapa(2);
        AlgoStar algoStar = new AlgoStar(mapa);

        Jugador jugador1=new Jugador("camila","rojo",new Protoss());
        algoStar.registrarJugador(jugador1);
        jugador1.llenarArcas();
        algoStar.construirEdificio("Pilon", 36, 10);
        Pilon pilon=(Pilon)mapa.obtenerCasilla(36,10).obtenerEstado().obtenerEdificio();
        assertEquals(5,jugador1.obtenerPoblacionUsable());
        algoStar.construirEdificio("Acceso", 37, 10);
        Dragon dragon=algoStar.crearDragon(jugador1,36,11);
        dragon.finalizarConstruccion();
        for (int i=0; i<30; i++){
            algoStar.ataque(dragon,pilon,jugador1);
        }
        assertEquals(true,pilon.estaDestruido());
        assertEquals(0,jugador1.obtenerPoblacionUsable());
    }
    @Test
    public void test02DestruirUnCriaderoDisminuyeLaPoblacionDeUnJugador(){
        Mapa mapa = new Mapa(2);
        AlgoStar algoStar = new AlgoStar(mapa);

        Jugador jugador1=new Jugador("camila","rojo",new Zerg());
        algoStar.registrarJugador(jugador1);
        jugador1.llenarArcas();
        algoStar.construirEdificio("Criadero", 36, 10);
        Criadero criadero=(Criadero) mapa.obtenerCasilla(36,10).obtenerEstado().obtenerEdificio();
        assertEquals(5,jugador1.obtenerPoblacionUsable());
        //mapa.obtenerCasilla(37,10).cambiarTerreno(new Moho());
        algoStar.construirEdificio("ReservaDeReproduccion", 36, 9);
        algoStar.construirEdificio("Guarida", 37, 10);
        Hidralisco hidralisco=algoStar.crearHidralisco(jugador1,36,11);
        hidralisco.finalizarConstruccion();
        for (int i=0; i<50; i++){
            algoStar.ataque(hidralisco,criadero,jugador1);
        }
        assertEquals(true,criadero.estaDestruido());
        assertEquals(0,jugador1.obtenerPoblacionUsable());
    }
}
