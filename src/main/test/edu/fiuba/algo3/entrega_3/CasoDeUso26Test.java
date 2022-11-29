package edu.fiuba.algo3.entrega_3;

import edu.fiuba.algo3.modelo.errores.PoblacionInsuficienteError;
import edu.fiuba.algo3.modelo.juego.AlgoStar;
import edu.fiuba.algo3.modelo.juego.Jugador;
import edu.fiuba.algo3.modelo.juego.Mapa;
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
        Mapa mapa = new Mapa(2);
        AlgoStar algoStar = new AlgoStar(mapa);

        Jugador jugador1=new Jugador("camila","rojo",new Zerg());
        algoStar.registrarJugador(jugador1);
        jugador1.llenarArcas();
        mapa.obtenerCasilla(35,10).cambiarTerreno(new Moho());
        algoStar.construirReservaDeReproduccion(35,10);
        assertThrows(PoblacionInsuficienteError.class, () -> {algoStar.crearZerling(jugador1, 5, 5);});

    }

    @Test
    public void test02SePuedeConstruirUnZerlingSiAntesSeConstruyoUnCriadero(){
        Mapa mapa = new Mapa(2);
        AlgoStar algoStar = new AlgoStar(mapa);

        Jugador jugador1=new Jugador("camila","rojo",new Zerg());
        algoStar.registrarJugador(jugador1);
        jugador1.llenarArcas();

        mapa.obtenerCasilla(36,10).cambiarTerreno(new Moho());
        algoStar.construirCriadero(36,10);
        mapa.obtenerCasilla(35,10).cambiarTerreno(new Moho());
        algoStar.construirReservaDeReproduccion(35,10);
        algoStar.crearZerling(jugador1, 5, 5);
        assertEquals(4,jugador1.obtenerPoblacionUsable());

    }

    @Test
    public void test03NoSePuedeConstruirUnDragonSin3DeSuministro(){
        Mapa mapa = new Mapa(2);
        AlgoStar algoStar = new AlgoStar(mapa);

        Jugador jugador1=new Jugador("camila","rojo",new Protoss());
        algoStar.registrarJugador(jugador1);
        jugador1.llenarArcas();
        mapa.obtenerCasilla(35,10).cambiarTerreno(new TierraEnergizada());
        algoStar.construirAcceso(35,10);
        assertThrows(PoblacionInsuficienteError.class, () -> {algoStar.crearDragon(jugador1, 5, 5);});

    }

    @Test
    public void test04SePuedeConstruirUnDragonSiAntesSeConstruyoUnPilon(){
        Mapa mapa = new Mapa(2);
        AlgoStar algoStar = new AlgoStar(mapa);

        Jugador jugador1=new Jugador("camila","rojo",new Zerg());
        algoStar.registrarJugador(jugador1);
        jugador1.llenarArcas();
        algoStar.construirPilon(36,10);
        algoStar.construirAcceso(35,10);
        algoStar.crearDragon(jugador1, 5, 5);
        assertEquals(2,jugador1.obtenerPoblacionUsable());

    }

    @Test
    public void test05SePuedeConstruirUnDragonSiAntesSeConstruyoUnAmoSupremo(){
        Mapa mapa = new Mapa(2);
        AlgoStar algoStar = new AlgoStar(mapa);

        Jugador jugador1=new Jugador("camila","rojo",new Zerg());
        algoStar.registrarJugador(jugador1);
        jugador1.llenarArcas();
        algoStar.crearAmoSupremo(jugador1,36,10);
        mapa.obtenerCasilla(50,10).cambiarTerreno(new Moho());
        algoStar.construirReservaDeReproduccion(50,10);
        algoStar.crearZerling(jugador1, 5, 5);
        assertEquals(4,jugador1.obtenerPoblacionUsable());

    }

}