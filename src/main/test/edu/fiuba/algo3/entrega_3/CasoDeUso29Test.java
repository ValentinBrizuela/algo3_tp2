package edu.fiuba.algo3.entrega_3;

import edu.fiuba.algo3.modelo.juego.AlgoStar;
import edu.fiuba.algo3.modelo.juego.Jugador;
import edu.fiuba.algo3.modelo.juego.Mapa;
import edu.fiuba.algo3.modelo.razas.Protoss;
import edu.fiuba.algo3.modelo.razas.Zerg;
import edu.fiuba.algo3.modelo.terrenos.Moho;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CasoDeUso29Test {

    @Test
    public void test01UnCriaderoNoGeneraPoblacionSiYaSeAlcanzoLaCapacidadMaxima(){
        Mapa mapa = new Mapa(2);
        AlgoStar algoStar = new AlgoStar(mapa);

        Jugador jugador1=new Jugador("camila","rojo",new Zerg());
        algoStar.registrarJugador(jugador1);
        jugador1.llenarArcas();
        for (int i=0;i<50;i++){
            algoStar.construirCriadero(50,10+i);
        }

        assertEquals(200,jugador1.obtenerPoblacionUsable());
    }
    @Test
    public void test02UnPilonNoGeneraPoblacionSiYaSeAlcanzoLaCapacidadMaxima(){
        Mapa mapa = new Mapa(2);
        AlgoStar algoStar = new AlgoStar(mapa);

        Jugador jugador1=new Jugador("camila","rojo",new Protoss());
        algoStar.registrarJugador(jugador1);
        jugador1.llenarArcas();
        for (int i=0;i<50;i++){
            algoStar.construirPilon(50,10+i);
        }

        assertEquals(200,jugador1.obtenerPoblacionUsable());
    }
}
