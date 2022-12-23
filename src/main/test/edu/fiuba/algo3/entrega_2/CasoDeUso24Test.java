package edu.fiuba.algo3.entrega_2;

import edu.fiuba.algo3.modelo.juego.AlgoColores;
import edu.fiuba.algo3.modelo.juego.AlgoStar;
import edu.fiuba.algo3.modelo.juego.FakeMapa;
import edu.fiuba.algo3.modelo.juego.Jugador;
import edu.fiuba.algo3.modelo.juego.Mapa;
import edu.fiuba.algo3.modelo.razas.Protoss;
import edu.fiuba.algo3.modelo.razas.Zerg;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CasoDeUso24Test {
    @Test
    public void losJugadoresArrancanEnExtremosOpuestos() {
        FakeMapa mapa=new FakeMapa(2);
        AlgoStar algoStar= new AlgoStar(mapa);

        Jugador jugador1=new Jugador("Manuel", new AlgoColores("rojo"),new Protoss());
        Jugador jugador2=new Jugador("camila",new AlgoColores("azul"),new Zerg());
        algoStar.registrarJugadores(jugador1, jugador2);

        assertEquals(jugador1.posX(), 2);
        assertEquals(jugador1.posY(), 2);
        assertEquals(jugador2.posX(), 18);
        assertEquals(jugador2.posY(), 18);
    }
}
