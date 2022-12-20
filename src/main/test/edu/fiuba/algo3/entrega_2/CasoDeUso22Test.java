package edu.fiuba.algo3.entrega_2;

import edu.fiuba.algo3.modelo.errores.EnConstruccionError;
import edu.fiuba.algo3.modelo.juego.*;
import edu.fiuba.algo3.modelo.razas.Protoss;
import edu.fiuba.algo3.modelo.razas.Zerg;
import edu.fiuba.algo3.modelo.unidades.Dragon;
import edu.fiuba.algo3.modelo.unidades.Zerling;
import javafx.scene.paint.Color;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;

public class CasoDeUso22Test {
    @Test
    public void NoPuedoUsarUnidadSiNoSeTerminoDeConstruir(){
        FakeMapa mapa = new FakeMapa(2);
        Almacen a=new Almacen();
        a.almacenarMineral(10000);
        a.almacenarGas(10000);

        Casilla casilla1 = mapa.obtenerCasilla(5,5);
        Casilla casilla2 = mapa.obtenerCasilla(5,6);
        Zerling z = new Zerling(casilla1);
        Dragon d = new Dragon(casilla2);

        assertThrows(EnConstruccionError.class, () -> {z.atacarA(d);});
    }

    @Test
    public void NoPuedoConstruirUnZerlingSinReservaDeReproduccion(){
        FakeMapa mapa = new FakeMapa(2);
        AlgoStar algoStar = new AlgoStar(mapa);

        Jugador j1 = new Jugador("mariano guglieri", Color.RED,new Zerg());
        Jugador j2 = new Jugador("guglieri mariano",Color.BLUE,new Protoss());

        algoStar.registrarJugador(j1);
        algoStar.registrarJugador(j2);

        algoStar.construirEntidad("Criadero", 5, 5);
        algoStar.construirEntidad("Zerling", 6, 6);

        assertEquals(5, j1.obtenerPoblacionUsable());
    }

    @Test
    public void NoPuedoConstruirUnZanganoSinCriadero(){
        FakeMapa mapa = new FakeMapa(2);
        AlgoStar algoStar = new AlgoStar(mapa);

        Jugador j1 = new Jugador("mariano guglieri",Color.BLUE,new Zerg());
        Jugador j2 = new Jugador("guglieri mariano",Color.RED,new Protoss());

        algoStar.registrarJugador(j1);
        algoStar.registrarJugador(j2);

        algoStar.construirEntidad("AmoSupremo", 5, 5);
        algoStar.construirEntidad("Zangano", 6,6);

        assertEquals(5, j1.obtenerPoblacionUsable());
    }

    @Test
    public void NoPuedoConstruirUnHidraliscoSinGuarida(){
        FakeMapa mapa = new FakeMapa(2);
        AlgoStar algoStar = new AlgoStar(mapa);

        Jugador j1 = new Jugador("mariano guglieri",Color.BLUE,new Zerg());
        Jugador j2 = new Jugador("guglieri mariano",Color.RED,new Protoss());

        algoStar.registrarJugador(j1);
        algoStar.registrarJugador(j2);

        algoStar.construirEntidad("Criadero", 5, 5);
        algoStar.construirEntidad("Hidralisco", 6, 6);

        assertEquals(5, j1.obtenerPoblacionUsable());
    }

    @Test
    public void NoPuedoConstruirUnMutaliscoSinEspiral(){
        FakeMapa mapa = new FakeMapa(2);
        AlgoStar algoStar = new AlgoStar(mapa);

        Jugador j1 = new Jugador("mariano guglieri",Color.BLUE,new Zerg());
        Jugador j2 = new Jugador("guglieri mariano",Color.RED,new Protoss());

        algoStar.registrarJugador(j1);
        algoStar.registrarJugador(j2);

        algoStar.construirEntidad("Criadero", 5, 5);
        algoStar.construirEntidad("Mutalisco", 6,6);

        assertEquals(5, j1.obtenerPoblacionUsable());
    }

    @Test
    public void NoPuedoConstruirUnZealotSinAcceso(){
        FakeMapa mapa = new FakeMapa(2);
        AlgoStar algoStar = new AlgoStar(mapa);

        Jugador j1 = new Jugador("mariano guglieri",Color.BLUE,new Zerg());
        Jugador j2 = new Jugador("guglieri mariano",Color.RED,new Protoss());

        algoStar.registrarJugador(j1);
        algoStar.registrarJugador(j2);

        algoStar.construirEntidad("Criadero", 5, 5);

        algoStar.construirEntidad("Zealot", 6,6);

        assertEquals(5, j1.obtenerPoblacionUsable());
    }

    @Test
    public void NoPuedoConstruirUnDragonSinAcceso(){
        FakeMapa mapa = new FakeMapa(2);
        AlgoStar algoStar = new AlgoStar(mapa);

        Jugador j1 = new Jugador("mariano guglieri",Color.BLUE,new Zerg());
        Jugador j2 = new Jugador("guglieri mariano",Color.RED,new Protoss());

        algoStar.registrarJugador(j1);
        algoStar.registrarJugador(j2);

        algoStar.construirEntidad("Criadero", 5, 5);
        algoStar.construirEntidad("Dragon", 6,6);

        assertEquals(5, j1.obtenerPoblacionUsable());
    }

    @Test
    public void NoPuedoConstruirUnScoutSinPuertoEstelar(){
        FakeMapa mapa = new FakeMapa(2);
        AlgoStar algoStar = new AlgoStar(mapa);

        Jugador j1 = new Jugador("mariano guglieri",Color.BLUE,new Zerg());
        Jugador j2 = new Jugador("guglieri mariano",Color.RED,new Protoss());

        algoStar.registrarJugador(j1);
        algoStar.registrarJugador(j2);

        algoStar.construirEntidad("Criadero", 5, 5);
        algoStar.construirEntidad("Scout", 6,6);

        assertEquals(5, j1.obtenerPoblacionUsable());
    }
}
