package edu.fiuba.algo3.entrega_1.entrega_2;

import edu.fiuba.algo3.modelo.errores.JugadorInvalidoError;
import edu.fiuba.algo3.modelo.errores.NombreDeJugadorInvalidoError;
import edu.fiuba.algo3.modelo.juego.*;
import edu.fiuba.algo3.modelo.razas.Protoss;
import edu.fiuba.algo3.modelo.razas.Zerg;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class CasoDeUso25Test {

    @Test
    public void NoSePuedenIniciarDosJugadoresConNombresIguales(){
        FakeMapa mapa=new FakeMapa(2);
        AlgoStar algoStar= new AlgoStar(mapa);

        Jugador jugador1=new Jugador("camila", new AlgoColores("rojo"),new Protoss());
        Jugador jugador2=new Jugador("camila",new AlgoColores("azul"),new Zerg());

        assertThrows(JugadorInvalidoError.class, () -> {algoStar.registrarJugadores(jugador1, jugador2);});

    }

    @Test
    public void NoSePuedenIniciarDosJugadoresConColoresIguales(){
        FakeMapa mapa=new FakeMapa(2);
        AlgoStar algoStar= new AlgoStar(mapa);

        Jugador jugador1=new Jugador("agustin",new AlgoColores("rojo"),new Protoss());
        Jugador jugador2=new Jugador("camila",new AlgoColores("rojo"),new Zerg());

        assertThrows(JugadorInvalidoError.class, () -> {algoStar.registrarJugadores(jugador1, jugador2);});

    }

    @Test
    public void NoSePuedenIniciarDosJugadoresConRazasIguales(){
        FakeMapa mapa=new FakeMapa(2);
        AlgoStar algoStar= new AlgoStar(mapa);

        Jugador jugador1=new Jugador("agustin",new AlgoColores("azul"),new Zerg());
        Jugador jugador2=new Jugador("camila",new AlgoColores("rojo"),new Zerg());

        assertThrows(JugadorInvalidoError.class, () -> {algoStar.registrarJugadores(jugador1, jugador2);});

    }

    @Test
    public void NoSePuedeRegistrarUnJugadorConUnNombreQueTengaMenosDe6Caracteres(){
        assertThrows(NombreDeJugadorInvalidoError.class, () -> {new Jugador("ola",new AlgoColores("rojo"),new Zerg());});

    }
}
