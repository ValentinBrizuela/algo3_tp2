package edu.fiuba.algo3.entrega_3;

import edu.fiuba.algo3.modelo.juego.AlgoStar;
import edu.fiuba.algo3.modelo.juego.Jugador;
import edu.fiuba.algo3.modelo.juego.Mapa;
import edu.fiuba.algo3.modelo.razas.Protoss;
import edu.fiuba.algo3.modelo.razas.Zerg;
import javafx.scene.paint.Color;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CasoDeUso29Test {

    @Test
    public void test01UnCriaderoNoGeneraPoblacionSiYaSeAlcanzoLaCapacidadMaxima(){
        Mapa mapa = new Mapa(2);
        AlgoStar algoStar = new AlgoStar(mapa);

        Jugador jugador1=new Jugador("camila", Color.RED,new Zerg());
        algoStar.registrarJugador(jugador1);
        jugador1.llenarArcas();
        //Criadero +5 de poblacion * 50 criaderos = 250 de poblacion
        for (int i=0;i<50;i++){
            algoStar.construirEdificio("Criadero", 50, 10+i);
        }

        assertEquals(200,jugador1.obtenerPoblacionUsable());
    }
    @Test
    public void test02UnPilonNoGeneraPoblacionSiYaSeAlcanzoLaCapacidadMaxima(){
        Mapa mapa = new Mapa(2);
        AlgoStar algoStar = new AlgoStar(mapa);

        Jugador jugador1=new Jugador("camila",Color.RED,new Protoss());
        algoStar.registrarJugador(jugador1);
        jugador1.llenarArcas();
        //Pilon +5 de poblacion * 50 pilones = 250 de poblacion
        for (int i=0;i<50;i++){
            algoStar.construirEdificio("Pilon", 50, 10+i);
        }

        assertEquals(200,jugador1.obtenerPoblacionUsable());
    }
    @Test
    public void test03UnAmoSupremoNoGeneraPoblacionSiYaSeAlcanzoLaCapacidadMaxima(){
        Mapa mapa = new Mapa(2);
        AlgoStar algoStar = new AlgoStar(mapa);

        Jugador jugador1=new Jugador("camila",Color.RED,new Protoss());
        algoStar.registrarJugador(jugador1);
        jugador1.llenarArcas();
        //Pilon +5 de poblacion * 40 pilones = 200 de poblacion
        for (int i=0;i<40;i++){
            algoStar.construirEdificio("Pilon", 50, 10+i);
        }
        algoStar.crearAmoSupremo(jugador1,30,30);

        assertEquals(200,jugador1.obtenerPoblacionUsable());
    }
}
