package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.edificios.Espiral;
import edu.fiuba.algo3.modelo.edificios.Guarida;
import edu.fiuba.algo3.modelo.edificios.PuertoEstelar;
import edu.fiuba.algo3.modelo.errores.ConstruccionNoPermitidaError;
import edu.fiuba.algo3.modelo.estados.Desocupada;
import edu.fiuba.algo3.modelo.juego.*;
import edu.fiuba.algo3.modelo.razas.Protoss;
import edu.fiuba.algo3.modelo.terrenos.Moho;
import edu.fiuba.algo3.modelo.terrenos.TierraEnergizada;
import javafx.scene.paint.Color;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CasoDeUso17Test {

    @Test
    public void test01UnaGuaridaNoSePuedeConstruirSiNoHayYaConstruidaUnaReservaDeReproduccion(){
        Mapa mapa = new Mapa(2);
        Almacen almacen = new Almacen();
        Jugador jugador1=new Jugador("andres", Color.RED,new Protoss());
        AlgoStar algoStar =new AlgoStar(mapa);
        algoStar.registrarJugador(jugador1);

        jugador1.llenarArcas();
        Casilla casilla = mapa.obtenerCasilla(50,50);
        casilla.cambiarTerreno(new Moho());
        algoStar.construirEdificio("Guarida", 50, 50);

        assertEquals(Desocupada.class, casilla.obtenerEstado().getClass());
    }

    @Test
    public void test02UnaGuaridaSePuedeConstruirSiAntesSeConstruyoUnaReservaDeReproduccion(){
        Mapa mapa = new Mapa(2);
        Almacen almacen = new Almacen();
        Jugador jugador1=new Jugador("andres",Color.RED,new Protoss());
        AlgoStar algoStar =new AlgoStar(mapa);
        algoStar.registrarJugador(jugador1);

        jugador1.llenarArcas();
        mapa.obtenerCasilla(50,50).cambiarTerreno(new Moho());
        mapa.obtenerCasilla(51,50).cambiarTerreno(new Moho());

        algoStar.construirEdificio("ReservaDeReproduccion", 50, 50);
        algoStar.construirEdificio("Guarida", 51, 50);

        assertSame(Guarida.class, mapa.obtenerCasilla(51,50).obtenerEstado().obtenerEdificio().getClass());

    }

    @Test
    public void test03UnEspiralNoSePuedeConstruirSiNoHayYaConstruidaUnaGuarida(){
        Mapa mapa = new Mapa(2);
        Almacen almacen = new Almacen();
        Jugador jugador1=new Jugador("andres",Color.RED,new Protoss());
        AlgoStar algoStar =new AlgoStar(mapa);
        algoStar.registrarJugador(jugador1);

        jugador1.llenarArcas();
        Casilla casilla = mapa.obtenerCasilla(50,50);
        casilla.cambiarTerreno(new Moho());
        algoStar.construirEdificio("Espiral", 50, 50);

        assertEquals(Desocupada.class, casilla.obtenerEstado().getClass());
    }

    @Test
    public void test04UnEspiralSePuedeConstruirSiAntesSeConstruyoUnaGuarida(){
        Mapa mapa = new Mapa(2);
        Almacen almacen = new Almacen();
        Jugador jugador1=new Jugador("andres",Color.RED,new Protoss());
        AlgoStar algoStar =new AlgoStar(mapa);
        algoStar.registrarJugador(jugador1);

        jugador1.llenarArcas();
        mapa.obtenerCasilla(50,50).cambiarTerreno(new Moho());
        mapa.obtenerCasilla(51,50).cambiarTerreno(new Moho());
        mapa.obtenerCasilla(51,51).cambiarTerreno(new Moho());

        algoStar.construirEdificio("ReservaDeReproduccion", 50, 50);
        algoStar.construirEdificio("Guarida", 51, 50);
        algoStar.construirEdificio("Espiral", 51, 51);

        assertSame(Espiral.class, mapa.obtenerCasilla(51,51).obtenerEstado().obtenerEdificio().getClass());

    }

    @Test
    public void test05UnPuertoEstelarNoSePuedeConstruirSiNoHayYaConstruidoUnAcceso(){
        Mapa mapa = new Mapa(2);
        Almacen almacen = new Almacen();
        Jugador jugador1=new Jugador("andres",Color.RED,new Protoss());
        AlgoStar algoStar =new AlgoStar(mapa);
        algoStar.registrarJugador(jugador1);

        jugador1.llenarArcas();
        Casilla casilla = mapa.obtenerCasilla(50,50);
        casilla.cambiarTerreno(new TierraEnergizada());
        algoStar.construirEdificio("PuertoEstelar", 50, 50);

        assertEquals(Desocupada.class, casilla.obtenerEstado().getClass());
    }

    @Test
    public void test06UnPuertoEstelarSePuedeConstruirSiHayYaConstruidoUnAcceso(){
        Mapa mapa = new Mapa(2);
        Almacen almacen = new Almacen();
        Jugador jugador1=new Jugador("andres",Color.RED,new Protoss());
        AlgoStar algoStar =new AlgoStar(mapa);
        algoStar.registrarJugador(jugador1);

        jugador1.llenarArcas();
        mapa.obtenerCasilla(50,50).cambiarTerreno(new TierraEnergizada());
        mapa.obtenerCasilla(51,50).cambiarTerreno(new TierraEnergizada());

        algoStar.construirEdificio("Acceso", 50, 50);
        algoStar.construirEdificio("PuertoEstelar", 51, 50);

        assertSame(PuertoEstelar.class, mapa.obtenerCasilla(51,50).obtenerEstado().obtenerEdificio().getClass());
    }

}
