package edu.fiuba.algo3.entrega_3;

import edu.fiuba.algo3.modelo.juego.*;
import edu.fiuba.algo3.modelo.razas.Protoss;
import edu.fiuba.algo3.modelo.razas.Zerg;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CasoDeUso29Test {

    @Test
    public void test01UnCriaderoNoGeneraPoblacionSiYaSeAlcanzoLaCapacidadMaxima(){
        FakeMapa mapa = new FakeMapa(2);
        AlgoStar algoStar = new AlgoStar(mapa);

        Jugador jugador1=new Jugador("camila", new AlgoColores("rojo"),new Zerg());
        Jugador jugador2 = new Jugador("pepito", new AlgoColores("azul"), new Protoss());
        algoStar.registrarJugadores(jugador1, jugador2);
        jugador1.llenarArcas();
        //Criadero +5 de poblacion * 50 criaderos = 250 de poblacion
        for (int i=0;i<20;i++){
            algoStar.construirEntidad("Criadero", 5, i);
        }
        for (int i=0;i<20;i++){
            algoStar.construirEntidad("Criadero", 6, i);
        }
        for (int i=0;i<10;i++){
            algoStar.construirEntidad("Criadero", 7, i);
        }

        assertEquals(200,jugador1.obtenerPoblacionUsable());
    }
    @Test
    public void test02UnPilonNoGeneraPoblacionSiYaSeAlcanzoLaCapacidadMaxima(){
        FakeMapa mapa = new FakeMapa(2);
        AlgoStar algoStar = new AlgoStar(mapa);

        Jugador jugador1=new Jugador("camila",new AlgoColores("rojo"),new Protoss());
        Jugador jugador2 = new Jugador("pepito", new AlgoColores("azul"), new Zerg());
        algoStar.registrarJugadores(jugador1, jugador2);
        jugador1.llenarArcas();
        //Pilon +5 de poblacion * 50 pilones = 250 de poblacion
        for (int i=0;i<20;i++){
            algoStar.construirEntidad("Pilon", 5, i);
        }
        for (int i=0;i<20;i++){
            algoStar.construirEntidad("Pilon", 6, i);
        }
        for (int i=0;i<10;i++){
            algoStar.construirEntidad("Pilon", 7, i);
        }

        assertEquals(200,jugador1.obtenerPoblacionUsable());
    }
    @Test
    public void test03UnAmoSupremoNoGeneraPoblacionSiYaSeAlcanzoLaCapacidadMaxima(){
        FakeMapa mapa = new FakeMapa(2);
        AlgoStar algoStar = new AlgoStar(mapa);

        Jugador jugador1=new Jugador("camila",new AlgoColores("rojo"),new Protoss());
        Jugador jugador2 = new Jugador("pepito", new AlgoColores("azul"), new Zerg());
        algoStar.registrarJugadores(jugador1, jugador2);
        jugador1.llenarArcas();
        //Pilon +5 de poblacion * 40 pilones = 200 de poblacion
        for (int i=0;i<20;i++){
            algoStar.construirEntidad("Pilon", 5, i);
        }
        for (int i=0; i<20; i++){
            algoStar.construirEntidad("Pilon", 6, i);
        }

        algoStar.construirEntidad("AmoSupremo", 7,5);

        assertEquals(200,jugador1.obtenerPoblacionUsable());
    }
}