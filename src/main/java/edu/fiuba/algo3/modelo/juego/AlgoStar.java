package edu.fiuba.algo3.modelo.juego;

import edu.fiuba.algo3.modelo.edificios.*;
import edu.fiuba.algo3.modelo.errores.ConstruccionNoPermitidaError;
import edu.fiuba.algo3.modelo.errores.CreacionDeUnidadInvalida;
import edu.fiuba.algo3.modelo.errores.JugadorInvalidoError;
import edu.fiuba.algo3.modelo.errores.NombreDeJugadorInvalidoError;
import edu.fiuba.algo3.modelo.unidades.*;

import java.util.ArrayList;

public class AlgoStar {

    private ArrayList<Jugador> jugadores;

    private Mapa mapa;
    private int cantJugadores;

    public AlgoStar(Mapa mapa){
        this.jugadores=new ArrayList<Jugador>();
        this.mapa=mapa;
    }

    public void registrarJugador(Jugador jugador){
       if(this.chequearNombre(jugador)){
           throw new NombreDeJugadorInvalidoError();
       }
        if(jugadores.isEmpty()) {
            jugador.setearPosicion((int) (mapa.tamanioMapa()*(0.1)), (int) (mapa.tamanioMapa()*(0.1)));
        }else{
            if(jugador.sosIgualA(jugadores.get(0))){
                throw new JugadorInvalidoError();
            }
            jugador.setearPosicion((int) (mapa.tamanioMapa()*(0.9)), (int) (mapa.tamanioMapa()*(0.9)));
        }
        jugadores.add(jugador);
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

    /*public void construirZangano(int x, int y) {
        if(jugadores.get(0).yaTiene(Criadero.class)) {
            Casilla casilla = mapa.obtenerCasilla(x, y);
            casilla.construir(new PuertoEstelar(casilla), jugadores.get(0).obtenerAlmacen());
            jugadores.get(0).agregarEdificio(PuertoEstelar.class);
        }else{
            throw new ConstruccionNoPermitidaError();
        }
    }*/

    /*public void construirZangano(int x, int y) {
        Casilla casilla = mapa.obtenerCasilla(x, y);
        casilla.construir(new Acceso(casilla), jugadores.get(0).obtenerAlmacen());
        jugadores.get(0).agregarEdificio(Acceso.class);
    }*/

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

    public Zangano crearZangano(Jugador j, int x, int y){
        Casilla casilla = mapa.obtenerCasilla(x, y);

        //crear logica
        if(j.yaTiene(Criadero.class)){
            Zangano z = new Zangano(casilla);
            return z;
        }
        else{
            throw new CreacionDeUnidadInvalida();
        }

    }

    public Hidralisco crearHidralisco(Jugador j, int x, int y){
        Casilla casilla = mapa.obtenerCasilla(x, y);

        //crear logica
        if(j.yaTiene(Guarida.class)){
            Hidralisco h = new Hidralisco(casilla);
            return h;
        }
        else{
            throw new CreacionDeUnidadInvalida();
        }

    }

    public Mutalisco crearMutalisco(Jugador j, int x, int y){
        Casilla casilla = mapa.obtenerCasilla(x, y);

        //crear logica
        if(j.yaTiene(Espiral.class)){
            Mutalisco m = new Mutalisco(casilla);
            return m;
        }
        else{
            throw new CreacionDeUnidadInvalida();
        }

    }

    public Zealot crearZealot(Jugador j, int x, int y){
        Casilla casilla = mapa.obtenerCasilla(x, y);

        //crear logica
        if(j.yaTiene(Acceso.class)){
            Zealot z = new Zealot(casilla);
            return z;
        }
        else{
            throw new CreacionDeUnidadInvalida();
        }

    }

    public Dragon crearDragon(Jugador j, int x, int y){
        Casilla casilla = mapa.obtenerCasilla(x, y);

        //crear logica
        if(j.yaTiene(Acceso.class)){
            Dragon d = new Dragon(casilla);
            return d;
        }
        else{
            throw new CreacionDeUnidadInvalida();
        }

    }

    public Scout crearScout(Jugador j, int x, int y){
        Casilla casilla = mapa.obtenerCasilla(x, y);

        //crear logica
        if(j.yaTiene(PuertoEstelar.class)){
            Scout s = new Scout(casilla);
            return s;
        }
        else{
            throw new CreacionDeUnidadInvalida();
        }

    }
}

