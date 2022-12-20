package edu.fiuba.algo3.entrega_3;

import edu.fiuba.algo3.modelo.edificios.Criadero;
import edu.fiuba.algo3.modelo.edificios.Pilon;
import edu.fiuba.algo3.modelo.juego.AlgoColores;
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

        Jugador jugador1 = new Jugador("camila", new AlgoColores("rojo"),new Protoss());
        Jugador jugador2 = new Jugador("pepito", new AlgoColores("azul"), new Zerg());
        algoStar.registrarJugadores(jugador1, jugador2);
        jugador1.llenarArcas();
        algoStar.construirEntidad("Pilon", 36, 10);
        Pilon pilon=(Pilon)mapa.obtenerCasilla(36,10).obtenerEstado().obtenerEntidad();
        assertEquals(5,jugador1.obtenerPoblacionUsable());
        algoStar.construirEntidad("Acceso", 37, 10);
        algoStar.construirEntidad("Dragon",36,11);
        Dragon dragon= (Dragon) mapa.obtenerEntidad(36,11);
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

        Jugador jugador1=new Jugador("camila",new AlgoColores("rojo"),new Zerg());
        Jugador jugador2 = new Jugador("pepito", new AlgoColores("azul"), new Protoss());
        algoStar.registrarJugadores(jugador1, jugador2);
        jugador1.llenarArcas();
        algoStar.construirEntidad("Criadero", 36, 10);
        Criadero criadero=(Criadero) mapa.obtenerCasilla(36,10).obtenerEstado().obtenerEntidad();
        assertEquals(5,jugador1.obtenerPoblacionUsable());
        //mapa.obtenerCasilla(37,10).cambiarTerreno(new Moho());
        algoStar.construirEntidad("ReservaDeReproduccion", 36, 9);
        algoStar.construirEntidad("Guarida", 37, 10);
        algoStar.construirEntidad("Hidralisco",36,11);
        Hidralisco hidralisco = (Hidralisco) mapa.obtenerEntidad(36,11);
        hidralisco.finalizarConstruccion();
        for (int i=0; i<50; i++){
            algoStar.ataque(hidralisco,criadero,jugador1);
        }
        assertEquals(true,criadero.estaDestruido());
        assertEquals(0,jugador1.obtenerPoblacionUsable());
    }
}
