package edu.fiuba.algo3.entrega_2;

import edu.fiuba.algo3.modelo.errores.EnConstruccionError;
import edu.fiuba.algo3.modelo.juego.*;
import edu.fiuba.algo3.modelo.razas.Protoss;
import edu.fiuba.algo3.modelo.razas.Zerg;
import edu.fiuba.algo3.modelo.recursos.RecursoVacio;
import edu.fiuba.algo3.modelo.terrenos.Tierra;
import edu.fiuba.algo3.modelo.unidades.Dragon;
import edu.fiuba.algo3.modelo.unidades.Zerling;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CasoDeUso22Test {
    @Test
    public void NoPuedoUsarUnidadSiNoSeTerminoDeConstruir(){
        Mapa mapa = new Mapa(2);
        Almacen a=new Almacen();
        a.almacenarMineral(10000);
        a.almacenarGas(10000);
        Casilla casilla1 = mapa.obtenerCasilla(15,15);
        Casilla casilla2 = mapa.obtenerCasilla(15,16);
        Zerling z = new Zerling(casilla1);
        Dragon d = new Dragon(casilla2);

        assertThrows(EnConstruccionError.class, () -> {z.atacarA(d);});
    }

    @Test
    public void NoPuedoConstruirUnZerlingSinReservaDeReproduccion(){
        Mapa mockMapa = mock(Mapa.class);
        AlgoStar algoStar = new AlgoStar(mockMapa);
        when(mockMapa.obtenerCasilla(50,50)).thenReturn(new Casilla(50, 50, new Tierra(), new RecursoVacio()));
        when(mockMapa.obtenerCasilla(25,25)).thenReturn(new Casilla(25, 25, new Tierra(), new RecursoVacio()));

        Jugador j1 = new Jugador("mariano guglieri", new AlgoColores("rojo"),new Zerg());
        Jugador j2 = new Jugador("guglieri mariano",new AlgoColores("azul"),new Protoss());

        algoStar.registrarJugador(j1);
        algoStar.registrarJugador(j2);

        algoStar.construirEdificio("Criadero", 50, 50);
        algoStar.crearZerling(j1, 25, 25);

        assertEquals(5, j1.obtenerPoblacionUsable());
    }

    @Test
    public void NoPuedoConstruirUnZanganoSinCriadero(){
        Mapa mockMapa = mock(Mapa.class);
        AlgoStar algoStar = new AlgoStar(mockMapa);
        when(mockMapa.obtenerCasilla(50,50)).thenReturn(new Casilla(50, 50, new Tierra(), new RecursoVacio()));
        when(mockMapa.obtenerCasilla(25,25)).thenReturn(new Casilla(25, 25, new Tierra(), new RecursoVacio()));

        Jugador j1 = new Jugador("mariano guglieri",new AlgoColores("azul"),new Zerg());
        Jugador j2 = new Jugador("guglieri mariano",new AlgoColores("rojo"),new Protoss());

        algoStar.registrarJugador(j1);
        algoStar.registrarJugador(j2);

        algoStar.crearAmoSupremo(j1, 50,50);
        algoStar.crearZangano(j1, 25,25);

        assertEquals(5, j1.obtenerPoblacionUsable());
    }

    @Test
    public void NoPuedoConstruirUnHidraliscoSinGuarida(){
        Mapa mockMapa = mock(Mapa.class);
        AlgoStar algoStar = new AlgoStar(mockMapa);
        when(mockMapa.obtenerCasilla(50,50)).thenReturn(new Casilla(50, 50, new Tierra(), new RecursoVacio()));
        when(mockMapa.obtenerCasilla(25,25)).thenReturn(new Casilla(25, 25, new Tierra(), new RecursoVacio()));

        Jugador j1 = new Jugador("mariano guglieri",new AlgoColores("azul"),new Zerg());
        Jugador j2 = new Jugador("guglieri mariano",new AlgoColores("rojo"),new Protoss());

        algoStar.registrarJugador(j1);
        algoStar.registrarJugador(j2);

        algoStar.construirEdificio("Criadero", 50, 50);
        algoStar.crearHidralisco(j1, 25,25);

        assertEquals(5, j1.obtenerPoblacionUsable());
    }

    @Test
    public void NoPuedoConstruirUnMutaliscoSinEspiral(){
        Mapa mockMapa = mock(Mapa.class);
        AlgoStar algoStar = new AlgoStar(mockMapa);
        when(mockMapa.obtenerCasilla(50,50)).thenReturn(new Casilla(50, 50, new Tierra(), new RecursoVacio()));
        when(mockMapa.obtenerCasilla(25,25)).thenReturn(new Casilla(25, 25, new Tierra(), new RecursoVacio()));

        Jugador j1 = new Jugador("mariano guglieri",new AlgoColores("azul"),new Zerg());
        Jugador j2 = new Jugador("guglieri mariano",new AlgoColores("rojo"),new Protoss());

        algoStar.registrarJugador(j1);
        algoStar.registrarJugador(j2);

        algoStar.construirEdificio("Criadero", 50, 50);
        algoStar.crearMutalisco(j1, 25,25);

        assertEquals(5, j1.obtenerPoblacionUsable());
    }

    @Test
    public void NoPuedoConstruirUnZealotSinAcceso(){
        Mapa mockMapa = mock(Mapa.class);
        AlgoStar algoStar = new AlgoStar(mockMapa);
        when(mockMapa.obtenerCasilla(50,50)).thenReturn(new Casilla(50, 50, new Tierra(), new RecursoVacio()));
        when(mockMapa.obtenerCasilla(25,25)).thenReturn(new Casilla(25, 25, new Tierra(), new RecursoVacio()));

        Jugador j1 = new Jugador("mariano guglieri",new AlgoColores("azul"),new Zerg());
        Jugador j2 = new Jugador("guglieri mariano",new AlgoColores("rojo"),new Protoss());

        algoStar.registrarJugador(j1);
        algoStar.registrarJugador(j2);

        algoStar.construirEdificio("Criadero", 50, 50);

        algoStar.crearZealot(j1, 25,25);

        assertEquals(5, j1.obtenerPoblacionUsable());
    }

    @Test
    public void NoPuedoConstruirUnDragonSinAcceso(){
        Mapa mockMapa = mock(Mapa.class);
        AlgoStar algoStar = new AlgoStar(mockMapa);
        when(mockMapa.obtenerCasilla(50,50)).thenReturn(new Casilla(50, 50, new Tierra(), new RecursoVacio()));
        when(mockMapa.obtenerCasilla(25,25)).thenReturn(new Casilla(25, 25, new Tierra(), new RecursoVacio()));

        Jugador j1 = new Jugador("mariano guglieri",new AlgoColores("azul"),new Zerg());
        Jugador j2 = new Jugador("guglieri mariano",new AlgoColores("rojo"),new Protoss());

        algoStar.registrarJugador(j1);
        algoStar.registrarJugador(j2);

        algoStar.construirEdificio("Criadero", 50, 50);
        algoStar.crearDragon(j1, 25,25);

        assertEquals(5, j1.obtenerPoblacionUsable());
    }

    @Test
    public void NoPuedoConstruirUnScoutSinPuertoEstelar(){
        Mapa mockMapa = mock(Mapa.class);
        AlgoStar algoStar = new AlgoStar(mockMapa);
        when(mockMapa.obtenerCasilla(50,50)).thenReturn(new Casilla(50, 50, new Tierra(), new RecursoVacio()));
        when(mockMapa.obtenerCasilla(25,25)).thenReturn(new Casilla(25, 25, new Tierra(), new RecursoVacio()));

        Jugador j1 = new Jugador("mariano guglieri",new AlgoColores("azul"),new Zerg());
        Jugador j2 = new Jugador("guglieri mariano",new AlgoColores("rojo"),new Protoss());

        algoStar.registrarJugador(j1);
        algoStar.registrarJugador(j2);

        algoStar.construirEdificio("Criadero", 50, 50);
        algoStar.crearScout(j1, 25,25);

        assertEquals(5, j1.obtenerPoblacionUsable());
    }
}
