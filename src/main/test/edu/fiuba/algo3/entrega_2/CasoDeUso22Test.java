package edu.fiuba.algo3.entrega_2;

import edu.fiuba.algo3.modelo.errores.CreacionDeUnidadInvalida;
import edu.fiuba.algo3.modelo.errores.EnConstruccionError;
import edu.fiuba.algo3.modelo.juego.AlgoStar;
import edu.fiuba.algo3.modelo.juego.Casilla;
import edu.fiuba.algo3.modelo.juego.Jugador;
import edu.fiuba.algo3.modelo.juego.Mapa;
import edu.fiuba.algo3.modelo.razas.Protoss;
import edu.fiuba.algo3.modelo.razas.Zerg;
import edu.fiuba.algo3.modelo.unidades.Dragon;
import edu.fiuba.algo3.modelo.unidades.Zerling;
import javafx.scene.paint.Color;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CasoDeUso22Test {
    @Test
    public void NoPuedoUsarUnidadSiNoSeTerminoDeConstruir(){
        Mapa mapa = new Mapa(2);
        Casilla casilla1 = mapa.obtenerCasilla(5,5);
        Casilla casilla2 = mapa.obtenerCasilla(5,6);
        Zerling z = new Zerling(casilla1);
        Dragon d = new Dragon(casilla2);

        assertThrows(EnConstruccionError.class, () -> {z.atacarA(d);});
    }

    @Test
    public void NoPuedoConstruirUnZerlingSinReservaDeReproduccion(){
        Mapa mapa = new Mapa(2);
        AlgoStar algoStar = new AlgoStar(mapa);

        Jugador j1 = new Jugador("mariano guglieri", Color.RED,new Zerg());
        Jugador j2 = new Jugador("guglieri mariano",Color.BLUE,new Protoss());

        algoStar.registrarJugador(j1);
        algoStar.registrarJugador(j2);

        algoStar.construirEdificio("Criadero", 50, 50);
        algoStar.crearZerling(j1, 25, 25);

        assertEquals(5, j1.obtenerPoblacionUsable());
    }

    @Test
    public void NoPuedoConstruirUnZanganoSinCriadero(){
        Mapa mapa = new Mapa(2);
        AlgoStar algoStar = new AlgoStar(mapa);

        Jugador j1 = new Jugador("mariano guglieri",Color.BLUE,new Zerg());
        Jugador j2 = new Jugador("guglieri mariano",Color.RED,new Protoss());

        algoStar.registrarJugador(j1);
        algoStar.registrarJugador(j2);

        algoStar.crearAmoSupremo(j1, 50,50);
        algoStar.crearZangano(j1, 25,25);

        assertEquals(5, j1.obtenerPoblacionUsable());
    }

    @Test
    public void NoPuedoConstruirUnHidraliscoSinGuarida(){
        Mapa mapa = new Mapa(2);
        AlgoStar algoStar = new AlgoStar(mapa);

        Jugador j1 = new Jugador("mariano guglieri",Color.BLUE,new Zerg());
        Jugador j2 = new Jugador("guglieri mariano",Color.RED,new Protoss());

        algoStar.registrarJugador(j1);
        algoStar.registrarJugador(j2);

        algoStar.construirEdificio("Criadero", 50, 50);
        algoStar.crearHidralisco(j1, 25,25);

        assertEquals(5, j1.obtenerPoblacionUsable());
    }

    @Test
    public void NoPuedoConstruirUnMutaliscoSinEspiral(){
        Mapa mapa = new Mapa(2);
        AlgoStar algoStar = new AlgoStar(mapa);

        Jugador j1 = new Jugador("mariano guglieri",Color.BLUE,new Zerg());
        Jugador j2 = new Jugador("guglieri mariano",Color.RED,new Protoss());

        algoStar.registrarJugador(j1);
        algoStar.registrarJugador(j2);

        algoStar.construirEdificio("Criadero", 50, 50);
        algoStar.crearMutalisco(j1, 25,25);

        assertEquals(5, j1.obtenerPoblacionUsable());
    }

    @Test
    public void NoPuedoConstruirUnZealotSinAcceso(){
        Mapa mapa = new Mapa(2);
        AlgoStar algoStar = new AlgoStar(mapa);

        Jugador j1 = new Jugador("mariano guglieri",Color.BLUE,new Zerg());
        Jugador j2 = new Jugador("guglieri mariano",Color.RED,new Protoss());

        algoStar.registrarJugador(j1);
        algoStar.registrarJugador(j2);

        algoStar.construirEdificio("Criadero", 50, 50);

        algoStar.crearZealot(j1, 25,25);

        assertEquals(5, j1.obtenerPoblacionUsable());
    }

    @Test
    public void NoPuedoConstruirUnDragonSinAcceso(){
        Mapa mapa = new Mapa(2);
        AlgoStar algoStar = new AlgoStar(mapa);

        Jugador j1 = new Jugador("mariano guglieri",Color.BLUE,new Zerg());
        Jugador j2 = new Jugador("guglieri mariano",Color.RED,new Protoss());

        algoStar.registrarJugador(j1);
        algoStar.registrarJugador(j2);

        algoStar.construirEdificio("Criadero", 50, 50);
        algoStar.crearDragon(j1, 25,25);

        assertEquals(5, j1.obtenerPoblacionUsable());
    }

    @Test
    public void NoPuedoConstruirUnScoutSinPuertoEstelar(){
        Mapa mapa = new Mapa(2);
        AlgoStar algoStar = new AlgoStar(mapa);

        Jugador j1 = new Jugador("mariano guglieri",Color.BLUE,new Zerg());
        Jugador j2 = new Jugador("guglieri mariano",Color.RED,new Protoss());

        algoStar.registrarJugador(j1);
        algoStar.registrarJugador(j2);

        algoStar.construirEdificio("Criadero", 50, 50);
        algoStar.crearScout(j1, 25,25);

        assertEquals(5, j1.obtenerPoblacionUsable());
    }
}
