package edu.fiuba.algo3.entrega_3;

import edu.fiuba.algo3.modelo.juego.AlgoColores;
import edu.fiuba.algo3.modelo.juego.AlgoStar;
import edu.fiuba.algo3.modelo.juego.FakeMapa;
import edu.fiuba.algo3.modelo.juego.Jugador;
import edu.fiuba.algo3.modelo.razas.Protoss;
import edu.fiuba.algo3.modelo.razas.Zerg;
;
import edu.fiuba.algo3.modelo.terrenos.Moho;
import edu.fiuba.algo3.modelo.terrenos.TierraEnergizada;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/*Verificar que para construir unidades se cuente con la capacidad de suministro
        correspondiente.*/

public class CasoDeUso26Test {

    @Test
    public void test01NoSePuedeConstruirUnZerlingSin2DeSuministro(){
        FakeMapa mapa = new FakeMapa(2);
        AlgoStar algoStar = new AlgoStar(mapa);

        Jugador jugador1=new Jugador("camila", new AlgoColores("rojo"),new Zerg());
        Jugador jugador2 = new Jugador("pepito", new AlgoColores("azul"), new Protoss());

        algoStar.registrarJugadores(jugador1, jugador2);
        jugador1.llenarArcas();

        mapa.obtenerCasilla(5,5).cambiarTerreno(new Moho());
        algoStar.construirEntidad("ReservaDeReproduccion", 5, 5);
        algoStar.construirEntidad("Zerling", 5, 6);
        assertEquals(null,mapa.obtenerCasilla(5,6).obtenerEstado().obtenerEntidad());

    }

    @Test
    public void test02SePuedeConstruirUnZerlingSiAntesSeConstruyoUnCriadero(){
        FakeMapa mapa = new FakeMapa(2);
        AlgoStar algoStar = new AlgoStar(mapa);

        Jugador jugador1=new Jugador("camila",new AlgoColores("azul"),new Zerg());
        Jugador jugador2 = new Jugador("pepito", new AlgoColores("rojo"), new Protoss());

        algoStar.registrarJugadores(jugador1, jugador2);
        jugador1.llenarArcas();

        algoStar.construirEntidad("Criadero", 5, 5);
        algoStar.construirEntidad("ReservaDeReproduccion", 5, 6);
        algoStar.construirEntidad("Zerling", 5, 7);
        assertEquals(4,jugador1.obtenerPoblacionUsable());

    }

    @Test
    public void test03NoSePuedeConstruirUnDragonSin3DeSuministro(){
        FakeMapa mapa = new FakeMapa(2);
        AlgoStar algoStar = new AlgoStar(mapa);

        Jugador jugador1=new Jugador("camila",new AlgoColores("rojo"),new Protoss());
        Jugador jugador2 = new Jugador("pepito", new AlgoColores("azul"), new Zerg());

        algoStar.registrarJugadores(jugador1, jugador2);
        jugador1.llenarArcas();

        mapa.obtenerCasilla(5,5).cambiarTerreno(new TierraEnergizada());
        algoStar.construirEntidad("Acceso", 5, 5);
        algoStar.construirEntidad("Dragon", 5, 6);

        assertEquals(null,mapa.obtenerCasilla(5,6).obtenerEstado().obtenerEntidad());

    }

    @Test
    public void test04SePuedeConstruirUnDragonSiAntesSeConstruyoUnPilon(){
        FakeMapa mapa = new FakeMapa(2);
        AlgoStar algoStar = new AlgoStar(mapa);

        Jugador jugador1=new Jugador("camila",new AlgoColores("rojo"),new Protoss());
        Jugador jugador2 = new Jugador("pepito", new AlgoColores("azul"), new Zerg());

        algoStar.registrarJugadores(jugador1, jugador2);
        jugador1.llenarArcas();

        algoStar.construirEntidad("Pilon", 5, 5);
        algoStar.construirEntidad("Acceso", 5, 6);
        algoStar.construirEntidad("Dragon", 5, 7);
        assertEquals(2,jugador1.obtenerPoblacionUsable());

    }

    @Test
    public void test05SePuedeConstruirUnDragonSiAntesSeConstruyoUnAmoSupremo(){
        FakeMapa mapa = new FakeMapa(2);
        AlgoStar algoStar = new AlgoStar(mapa);

        Jugador jugador1=new Jugador("camila",new AlgoColores("rojo"),new Zerg());
        Jugador jugador2 = new Jugador("pepito", new AlgoColores("azul"), new Protoss());

        algoStar.registrarJugadores(jugador1, jugador2);
        jugador1.llenarArcas();

        algoStar.construirEntidad("AmoSupremo", 5,5);
        mapa.obtenerCasilla(5,6).cambiarTerreno(new Moho());
        algoStar.construirEntidad("ReservaDeReproduccion", 5, 6);
        algoStar.construirEntidad("Zerling", 5,7);
        assertEquals(4,jugador1.obtenerPoblacionUsable());

    }

}