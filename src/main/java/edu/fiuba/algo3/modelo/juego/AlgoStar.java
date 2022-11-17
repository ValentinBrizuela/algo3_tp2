package edu.fiuba.algo3.modelo.juego;

import edu.fiuba.algo3.modelo.edificios.*;
import edu.fiuba.algo3.modelo.errores.ConstruccionNoPermitidaError;
import edu.fiuba.algo3.modelo.errores.CreacionDeUnidadInvalida;
import edu.fiuba.algo3.modelo.errores.JugadorInvalidoError;
import edu.fiuba.algo3.modelo.errores.NombreDeJugadorInvalidoError;
import edu.fiuba.algo3.modelo.unidades.Zerling;

import java.util.ArrayList;

public class AlgoStar {

    private ArrayList<Jugador> jugadores;

    private Mapa mapa;

    public AlgoStar(Mapa mapa){
        this.jugadores=new ArrayList<Jugador>();
        this.mapa=mapa;
    }

    public void registrarJugador(Jugador jugador){
       if(this.chequearNombre(jugador)){
           throw new NombreDeJugadorInvalidoError();
       }
        if(jugadores.isEmpty()) {
            jugadores.add(jugador);
        }else{
            if(jugador.sosIgualA(jugadores.get(0))){
                throw new JugadorInvalidoError();
            }
        }
    }
    public void construirGuarida(int x, int y){
        if(jugadores.get(0).yaTiene(ReservaDeReproduccion.class)) {
            Casilla casilla = mapa.obtenerCasilla(x,y);
            casilla.construir(new Guarida(casilla), jugadores.get(0).obtenerAlmacen());
            jugadores.get(0).agregarEdificio(Guarida.class);
        }else{
            throw new ConstruccionNoPermitidaError();
        }
    }

    public void construirReservaDeReproduccion(int x, int y){
        Casilla casilla = mapa.obtenerCasilla(x, y);
        casilla.construir(new ReservaDeReproduccion(casilla), jugadores.get(0).obtenerAlmacen());
        jugadores.get(0).agregarEdificio(ReservaDeReproduccion.class);
    }

    public void construirEspiral(int x, int y){
        if(jugadores.get(0).yaTiene(Guarida.class)) {
            Casilla casilla = mapa.obtenerCasilla(x, y);
            casilla.construir(new Espiral(casilla), jugadores.get(0).obtenerAlmacen());
            jugadores.get(0).agregarEdificio(Espiral.class);
        }else{
            throw new ConstruccionNoPermitidaError();
        }
    }

    public void construirPuertoEstelar(int x, int y) {
        if(jugadores.get(0).yaTiene(Acceso.class)) {
            Casilla casilla = mapa.obtenerCasilla(x, y);
            casilla.construir(new PuertoEstelar(casilla), jugadores.get(0).obtenerAlmacen());
            jugadores.get(0).agregarEdificio(PuertoEstelar.class);
        }else{
            throw new ConstruccionNoPermitidaError();
        }
    }

    public void construirAcceso(int x, int y) {
        Casilla casilla = mapa.obtenerCasilla(x, y);
        casilla.construir(new Acceso(casilla), jugadores.get(0).obtenerAlmacen());
        jugadores.get(0).agregarEdificio(Acceso.class);
    }

    private boolean chequearNombre(Jugador jugador){
        return jugador.obtenerNombre().length()<6;
    }

    public Zerling crearZerling(Jugador j, int x, int y){
        Casilla casilla = mapa.obtenerCasilla(x, y);

        //crear logica
        if(j.yaTiene(ReservaDeReproduccion.class)){
            Zerling z = new Zerling(casilla);
            return z;
        }
        else{
            throw new CreacionDeUnidadInvalida();
        }

    }
}

