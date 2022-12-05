package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.juego.AlgoStar;
import edu.fiuba.algo3.modelo.juego.Jugador;
import edu.fiuba.algo3.modelo.juego.Mapa;
import edu.fiuba.algo3.modelo.razas.Protoss;
import edu.fiuba.algo3.modelo.razas.Zerg;
import edu.fiuba.algo3.modelo.terrenos.Moho;
import edu.fiuba.algo3.modelo.terrenos.TierraEnergizada;
import javafx.scene.paint.Color;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CasoDeUso14Test {
    @Test
    public void unPilonNoPuedeEnergizarUnAreaCubiertaPorMoho() {
        Mapa mapa = new Mapa(2);
        AlgoStar algoStar=new AlgoStar(mapa);
        Jugador jugador1=new Jugador("camila", Color.RED,new Zerg());
        Jugador jugador2=new Jugador("tomasa",Color.BLUE,new Protoss());
        algoStar.registrarJugador(jugador1);
        algoStar.registrarJugador(jugador2);
        jugador1.llenarArcas();

        algoStar.construirEdificio("Pilon", 24, 27);
        algoStar.construirEdificio("Criadero", 24, 23);

        assertEquals(mapa.obtenerCasilla(24, 24).obtenerEstado().obtenerTerreno().getClass(), Moho.class);
    }

    @Test
    public void mohoNoSePuedeExpandirPorUnaCasillaOcupada() {
        Mapa mapa = new Mapa(2);
        AlgoStar algoStar=new AlgoStar(mapa);
        Jugador jugador1=new Jugador("camila",Color.RED,new Zerg());
        Jugador jugador2=new Jugador("tomasa",Color.BLUE,new Protoss());
        algoStar.registrarJugador(jugador1);
        algoStar.registrarJugador(jugador2);
        jugador1.llenarArcas();


        algoStar.construirEdificio("Pilon", 25, 25);
        algoStar.construirEdificio("Criadero", 25, 29);

        assertEquals(mapa.obtenerCasilla(25, 25).obtenerEstado().obtenerTerreno().getClass(), TierraEnergizada.class);
    }
}
