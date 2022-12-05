package edu.fiuba.algo3.entrega_2;

import edu.fiuba.algo3.modelo.errores.JugadorInvalidoError;
import edu.fiuba.algo3.modelo.errores.NombreDeJugadorInvalidoError;
import edu.fiuba.algo3.modelo.juego.AlgoStar;
import edu.fiuba.algo3.modelo.juego.Jugador;
import edu.fiuba.algo3.modelo.juego.Mapa;
import edu.fiuba.algo3.modelo.razas.Protoss;
import edu.fiuba.algo3.modelo.razas.Zerg;
import javafx.scene.paint.Color;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class CasoDeUso25Test {

    @Test
    public void NoSePuedenIniciarDosJugadoresConNombresIguales(){
        Mapa mapa=new Mapa(2);
        AlgoStar algoStar= new AlgoStar(mapa);

        Jugador jugador1=new Jugador("camila", Color.RED,new Protoss());
        algoStar.registrarJugador(jugador1);
        Jugador jugador2=new Jugador("camila",Color.BLUE,new Zerg());
        assertThrows(JugadorInvalidoError.class, () -> {algoStar.registrarJugador(jugador2);});

    }

    @Test
    public void NoSePuedenIniciarDosJugadoresConColoresIguales(){
        Mapa mapa=new Mapa(2);
        AlgoStar algoStar= new AlgoStar(mapa);

        Jugador jugador1=new Jugador("agustin",Color.RED,new Protoss());
        algoStar.registrarJugador(jugador1);
        Jugador jugador2=new Jugador("camila",Color.RED,new Zerg());
        assertThrows(JugadorInvalidoError.class, () -> {algoStar.registrarJugador(jugador2);});

    }

    @Test
    public void NoSePuedenIniciarDosJugadoresConRazasIguales(){
        Mapa mapa=new Mapa(2);
        AlgoStar algoStar= new AlgoStar(mapa);

        Jugador jugador1=new Jugador("agustin",Color.BLUE,new Zerg());
        algoStar.registrarJugador(jugador1);
        Jugador jugador2=new Jugador("camila",Color.RED,new Zerg());
        assertThrows(JugadorInvalidoError.class, () -> {algoStar.registrarJugador(jugador2);});

    }

    @Test
    public void NoSePuedeRegistrarUnJugadorConUnNombreQueTengaMenosDe6Caracteres(){
        Mapa mapa=new Mapa(2);
        AlgoStar algoStar= new AlgoStar(mapa);


        assertThrows(NombreDeJugadorInvalidoError.class, () -> {new Jugador("ola",Color.RED,new Zerg());});

    }
}
