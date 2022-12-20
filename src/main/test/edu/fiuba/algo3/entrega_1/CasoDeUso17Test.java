package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.edificios.Espiral;
import edu.fiuba.algo3.modelo.edificios.Guarida;
import edu.fiuba.algo3.modelo.edificios.PuertoEstelar;
import edu.fiuba.algo3.modelo.estados.Desocupada;
import edu.fiuba.algo3.modelo.juego.*;
import edu.fiuba.algo3.modelo.razas.Protoss;
import edu.fiuba.algo3.modelo.razas.Zerg;
import edu.fiuba.algo3.modelo.terrenos.Moho;
import edu.fiuba.algo3.modelo.terrenos.TierraEnergizada;
import org.junit.jupiter.api.Test;

import javax.sound.sampled.Port;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

public class CasoDeUso17Test {

    @Test
    public void test01UnaGuaridaNoSePuedeConstruirSiNoHayYaConstruidaUnaReservaDeReproduccion(){
        FakeMapa mapa = new FakeMapa(2);
        Jugador jugador1=new Jugador("andres", new AlgoColores("rojo"),new Protoss());
        Jugador jugador2 = new Jugador("pepito", new AlgoColores("azul"), new Zerg());
        AlgoStar algoStar =new AlgoStar(mapa);
        algoStar.registrarJugadores(jugador1, jugador2);

        jugador1.llenarArcas();
        Casilla casilla = mapa.obtenerCasilla(5,5);
        casilla.cambiarTerreno(new Moho());
        algoStar.construirEntidad("Guarida", 5, 5);

        assertEquals(Desocupada.class, casilla.obtenerEstado().getClass());
    }

    @Test
    public void test02UnaGuaridaSePuedeConstruirSiAntesSeConstruyoUnaReservaDeReproduccion(){
        FakeMapa mapa = new FakeMapa(2);
        Jugador jugador1=new Jugador("andres",new AlgoColores("rojo"),new Zerg());
        Jugador jugador2 = new Jugador("pepito", new AlgoColores("azul"), new Protoss());

        AlgoStar algoStar =new AlgoStar(mapa);
        algoStar.registrarJugadores(jugador1, jugador2);

        jugador1.llenarArcas();
        mapa.obtenerCasilla(5,5).cambiarTerreno(new Moho());
        mapa.obtenerCasilla(5,6).cambiarTerreno(new Moho());

        algoStar.construirEntidad("ReservaDeReproduccion", 5, 5);
        algoStar.construirEntidad("Guarida", 5, 6);

        assertSame(Guarida.class, mapa.obtenerEntidad(5, 6).getClass());

    }

    @Test
    public void test03UnEspiralNoSePuedeConstruirSiNoHayYaConstruidaUnaGuarida(){
        FakeMapa mapa = new FakeMapa(2);
        Jugador jugador1=new Jugador("andres",new AlgoColores("rojo"),new Protoss());
        Jugador jugador2 = new Jugador("pepito", new AlgoColores("azul"), new Zerg());

        AlgoStar algoStar =new AlgoStar(mapa);
        algoStar.registrarJugadores(jugador1, jugador2);

        jugador1.llenarArcas();
        Casilla casilla = mapa.obtenerCasilla(5,5);
        casilla.cambiarTerreno(new Moho());
        algoStar.construirEntidad("Espiral", 5, 5);

        assertEquals(Desocupada.class, casilla.obtenerEstado().getClass());
    }

    @Test
    public void test04UnEspiralSePuedeConstruirSiAntesSeConstruyoUnaGuarida(){
        FakeMapa mapa = new FakeMapa(2);
        Jugador jugador1=new Jugador("andres",new AlgoColores("rojo"),new Zerg());
        Jugador jugador2 = new Jugador("pepito", new AlgoColores("azul"), new Protoss());

        AlgoStar algoStar =new AlgoStar(mapa);
        algoStar.registrarJugadores(jugador1, jugador2);

        jugador1.llenarArcas();
        mapa.obtenerCasilla(5,5).cambiarTerreno(new Moho());
        mapa.obtenerCasilla(5,6).cambiarTerreno(new Moho());
        mapa.obtenerCasilla(5,7).cambiarTerreno(new Moho());

        algoStar.construirEntidad("ReservaDeReproduccion", 5, 5);
        algoStar.construirEntidad("Guarida", 5, 6);
        algoStar.construirEntidad("Espiral", 5, 7);

        assertSame(Espiral.class, mapa.obtenerEntidad(5, 7).getClass());

    }

    @Test
    public void test05UnPuertoEstelarNoSePuedeConstruirSiNoHayYaConstruidoUnAcceso(){
        FakeMapa mapa = new FakeMapa(2);
        Jugador jugador1=new Jugador("andres",new AlgoColores("rojo"),new Protoss());
        Jugador jugador2 = new Jugador("pepito", new AlgoColores("azul"), new Zerg());

        AlgoStar algoStar =new AlgoStar(mapa);
        algoStar.registrarJugadores(jugador1, jugador2);

        jugador1.llenarArcas();
        Casilla casilla = mapa.obtenerCasilla(5,5);
        casilla.cambiarTerreno(new TierraEnergizada());
        algoStar.construirEntidad("PuertoEstelar", 5, 5);

        assertEquals(Desocupada.class, casilla.obtenerEstado().getClass());
    }

    @Test
    public void test06UnPuertoEstelarSePuedeConstruirSiHayYaConstruidoUnAcceso(){
        FakeMapa mapa = new FakeMapa(2);
        Jugador jugador1=new Jugador("andres",new AlgoColores("rojo"),new Protoss());
        Jugador jugador2 = new Jugador("pepito", new AlgoColores("azul"), new Zerg());

        AlgoStar algoStar =new AlgoStar(mapa);
        algoStar.registrarJugadores(jugador1, jugador2);

        jugador1.llenarArcas();
        mapa.obtenerCasilla(5,5).cambiarTerreno(new TierraEnergizada());
        mapa.obtenerCasilla(5,6).cambiarTerreno(new TierraEnergizada());

        algoStar.construirEntidad("Acceso", 5, 5);
        algoStar.construirEntidad("PuertoEstelar", 5, 6);

        assertSame(PuertoEstelar.class, mapa.obtenerEntidad(5, 6).getClass());
    }

}
