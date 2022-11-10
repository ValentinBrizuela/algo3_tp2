package edu.fiuba.algo3.modelo.juego;

import edu.fiuba.algo3.modelo.edificios.*;
import edu.fiuba.algo3.modelo.errores.ConstruccionNoPermitidaError;

public class AlgoStar {

    private Jugador jugador;

    public AlgoStar(Jugador jugador){
        this.jugador=jugador;
    }

    public void construirGuarida(Casilla casilla,Almacen almacen){
        if(jugador.yaTiene(ReservaDeReproduccion.class)) {
            casilla.construir(new Guarida(casilla), almacen);
            jugador.agregarEdificio(Guarida.class);
        }else{
            throw new ConstruccionNoPermitidaError();
        }
    }

    public void construirReservaDeReproduccion(Casilla casilla,Almacen almacen){
        casilla.construir(new ReservaDeReproduccion(casilla), almacen);
        jugador.agregarEdificio(ReservaDeReproduccion.class);
    }

    public void construirEspiral(Casilla casilla,Almacen almacen){
        if(jugador.yaTiene(Guarida.class)) {
            casilla.construir(new Espiral(casilla), almacen);
            jugador.agregarEdificio(Espiral.class);
        }else{
            throw new ConstruccionNoPermitidaError();
        }
    }

    public void construirPuertoEstelar(Casilla casilla, Almacen almacen) {
        if(jugador.yaTiene(Acceso.class)) {
            casilla.construir(new PuertoEstelar(casilla), almacen);
            jugador.agregarEdificio(PuertoEstelar.class);
        }else{
            throw new ConstruccionNoPermitidaError();
        }
    }

    public void construirAcceso(Casilla casilla, Almacen almacen) {
        casilla.construir(new Acceso(casilla), almacen);
        jugador.agregarEdificio(Acceso.class);
    }
}
