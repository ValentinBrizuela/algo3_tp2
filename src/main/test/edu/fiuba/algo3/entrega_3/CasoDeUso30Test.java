package edu.fiuba.algo3.entrega_3;

import edu.fiuba.algo3.modelo.errores.PoblacionInsuficienteError;
import edu.fiuba.algo3.modelo.juego.AlgoStar;
import edu.fiuba.algo3.modelo.juego.Jugador;
import edu.fiuba.algo3.modelo.juego.Mapa;
import edu.fiuba.algo3.modelo.razas.Protoss;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CasoDeUso30Test {

    @Test
    public void test01UnScoutNoSePuedeConstruirSiYaSeAlcanzoLaPoblacionMaximaUsada(){
        Mapa mapa = new Mapa(2);
        AlgoStar algoStar = new AlgoStar(mapa);

        Jugador jugador1=new Jugador("camila","rojo",new Protoss());
        algoStar.registrarJugador(jugador1);
        jugador1.llenarArcas();
        for (int i=0;i<50;i++){
            algoStar.construirPilon(30,10+i);
        }

        assertEquals(200,jugador1.obtenerPoblacionUsable());
        algoStar.construirAcceso(31,11);
        algoStar.construirPuertoEstelar(29,11);

        for (int i=0;i<50;i++){
            algoStar.crearScout(jugador1,10,10+i);
        }
        assertEquals(200,jugador1.obtenerPoblacionEnUso());

        algoStar.crearScout(jugador1, 40, 5);

        assertEquals(null,mapa.obtenerCasilla(40,5).obtenerEstado().obtenerEdificio());
    }
}
