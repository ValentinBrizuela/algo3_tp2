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

        Jugador j1 = new Jugador("mariano guglieri","fucsia",new Zerg());
        Jugador j2 = new Jugador("guglieri mariano","bordo",new Protoss());

        algoStar.registrarJugador(j1);
        algoStar.registrarJugador(j2);

        assertThrows(CreacionDeUnidadInvalida.class, () -> {algoStar.crearZerling(j1,5,5);});
    }

    @Test
    public void NoPuedoConstruirUnZanganoSinCriadero(){
        Mapa mapa = new Mapa(2);
        AlgoStar algoStar = new AlgoStar(mapa);

        Jugador j1 = new Jugador("mariano guglieri","fucsia",new Zerg());
        Jugador j2 = new Jugador("guglieri mariano","bordo",new Protoss());

        algoStar.registrarJugador(j1);
        algoStar.registrarJugador(j2);

        assertThrows(CreacionDeUnidadInvalida.class, () -> {algoStar.crearZangano(j1,5,5);});
    }

    @Test
    public void NoPuedoConstruirUnHidraliscoSinGuarida(){
        Mapa mapa = new Mapa(2);
        AlgoStar algoStar = new AlgoStar(mapa);

        Jugador j1 = new Jugador("mariano guglieri","fucsia",new Zerg());
        Jugador j2 = new Jugador("guglieri mariano","bordo",new Protoss());

        algoStar.registrarJugador(j1);
        algoStar.registrarJugador(j2);

        assertThrows(CreacionDeUnidadInvalida.class, () -> {algoStar.crearHidralisco(j1,5,5);});
    }

    @Test
    public void NoPuedoConstruirUnMutaliscoSinEspiral(){
        Mapa mapa = new Mapa(2);
        AlgoStar algoStar = new AlgoStar(mapa);

        Jugador j1 = new Jugador("mariano guglieri","fucsia",new Zerg());
        Jugador j2 = new Jugador("guglieri mariano","bordo",new Protoss());

        algoStar.registrarJugador(j1);
        algoStar.registrarJugador(j2);

        assertThrows(CreacionDeUnidadInvalida.class, () -> {algoStar.crearMutalisco(j1,5,5);});
    }

    @Test
    public void NoPuedoConstruirUnZealotSinAcceso(){
        Mapa mapa = new Mapa(2);
        AlgoStar algoStar = new AlgoStar(mapa);

        Jugador j1 = new Jugador("mariano guglieri","fucsia",new Zerg());
        Jugador j2 = new Jugador("guglieri mariano","bordo",new Protoss());

        algoStar.registrarJugador(j1);
        algoStar.registrarJugador(j2);

        assertThrows(CreacionDeUnidadInvalida.class, () -> {algoStar.crearZealot(j1,5,5);});
    }

    @Test
    public void NoPuedoConstruirUnDragonSinAcceso(){
        Mapa mapa = new Mapa(2);
        AlgoStar algoStar = new AlgoStar(mapa);

        Jugador j1 = new Jugador("mariano guglieri","fucsia",new Zerg());
        Jugador j2 = new Jugador("guglieri mariano","bordo",new Protoss());

        algoStar.registrarJugador(j1);
        algoStar.registrarJugador(j2);

        assertThrows(CreacionDeUnidadInvalida.class, () -> {algoStar.crearDragon(j1,5,5);});
    }

    @Test
    public void NoPuedoConstruirUnScoutSinPuertoEstelar(){
        Mapa mapa = new Mapa(2);
        AlgoStar algoStar = new AlgoStar(mapa);

        Jugador j1 = new Jugador("mariano guglieri","fucsia",new Zerg());
        Jugador j2 = new Jugador("guglieri mariano","bordo",new Protoss());

        algoStar.registrarJugador(j1);
        algoStar.registrarJugador(j2);

        assertThrows(CreacionDeUnidadInvalida.class, () -> {algoStar.crearScout(j1,5,5);});
    }
}
