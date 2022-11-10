package edu.fiuba.algo3.modelo.juego;

import edu.fiuba.algo3.modelo.edificios.*;
import edu.fiuba.algo3.modelo.errores.ConstruccionNoPermitidaError;

public class AlgoStar {

    private Jugador jugador;

    private Mapa mapa;

    public AlgoStar(Jugador jugador, Mapa mapa){
        this.jugador=jugador;
        this.mapa=mapa;
    }

    public void construirGuarida(int x, int y){
        if(jugador.yaTiene(ReservaDeReproduccion.class)) {
            Casilla casilla = mapa.obtenerCasilla(x,y);
            casilla.construir(new Guarida(casilla), jugador.obtenerAlmacen());
            jugador.agregarEdificio(Guarida.class);
        }else{
            throw new ConstruccionNoPermitidaError();
        }
    }

    public void construirReservaDeReproduccion(int x, int y){
        Casilla casilla = mapa.obtenerCasilla(x, y);
        casilla.construir(new ReservaDeReproduccion(casilla), jugador.obtenerAlmacen());
        jugador.agregarEdificio(ReservaDeReproduccion.class);
    }

    public void construirEspiral(int x, int y){
        if(jugador.yaTiene(Guarida.class)) {
            Casilla casilla = mapa.obtenerCasilla(x, y);
            casilla.construir(new Espiral(casilla), jugador.obtenerAlmacen());
            jugador.agregarEdificio(Espiral.class);
        }else{
            throw new ConstruccionNoPermitidaError();
        }
    }

    public void construirPuertoEstelar(int x, int y) {
        if(jugador.yaTiene(Acceso.class)) {
            Casilla casilla = mapa.obtenerCasilla(x, y);
            casilla.construir(new PuertoEstelar(casilla), jugador.obtenerAlmacen());
            jugador.agregarEdificio(PuertoEstelar.class);
        }else{
            throw new ConstruccionNoPermitidaError();
        }
    }

    public void construirAcceso(int x, int y) {
        Casilla casilla = mapa.obtenerCasilla(x, y);
        casilla.construir(new Acceso(casilla), jugador.obtenerAlmacen());
        jugador.agregarEdificio(Acceso.class);
    }
}
