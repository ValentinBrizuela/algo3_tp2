package edu.fiuba.algo3.entrega_2;

import edu.fiuba.algo3.modelo.juego.AlgoStar;
import edu.fiuba.algo3.modelo.juego.Jugador;
import edu.fiuba.algo3.modelo.juego.Mapa;
import edu.fiuba.algo3.modelo.razas.Protoss;
import edu.fiuba.algo3.modelo.razas.Zerg;
import javafx.scene.paint.Color;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CasoDeUso24Test {
    @Test
    public void losJugadoresArrancanEnExtremosOpuestos() {
        Mapa mapa=new Mapa(2);
        AlgoStar algoStar= new AlgoStar(mapa);

        Jugador jugador1=new Jugador("Manuel", Color.RED,new Protoss());
        algoStar.registrarJugador(jugador1);
        Jugador jugador2=new Jugador("camila",Color.BLUE,new Zerg());
        algoStar.registrarJugador(jugador2);
        assertEquals(jugador1.posX(), 10);
        assertEquals(jugador1.posY(), 10);
        assertEquals(jugador2.posX(), 90);
        assertEquals(jugador2.posY(), 90);
    }
}
