package edu.fiuba.algo3.modelo.juego;

import edu.fiuba.algo3.modelo.edificios.*;
import edu.fiuba.algo3.modelo.errores.*;
import edu.fiuba.algo3.modelo.interfaces.Atacante;

import edu.fiuba.algo3.modelo.unidades.*;


import java.util.ArrayList;

public class AlgoStar {

    private ArrayList<Jugador> jugadores;
    private EdificiosFactory edificiosFactory;

    public Mapa mapa;
    private int turno;
    private Jugador jugadorActual;

    public AlgoStar(Mapa mapa){
        this.jugadores=new ArrayList<Jugador>();
        this.mapa=mapa;
        this.turno = 0;
        this.jugadorActual = null;
        this.edificiosFactory = new EdificiosFactory();
    }

    public void registrarJugador(Jugador jugador){
       if(this.chequearNombre(jugador)){
           throw new NombreDeJugadorInvalidoError();
       }
        if(jugadores.isEmpty()) {
            jugador.setearPosicion((int) (mapa.tamanioMapa()*(0.1)), (int) (mapa.tamanioMapa()*(0.1)));
            jugadorActual = jugador;
        }else{
            if(jugador.sosIgualA(jugadores.get(0))){
                throw new JugadorInvalidoError();
            }
            jugador.setearPosicion((int) (mapa.tamanioMapa()*(0.9)), (int) (mapa.tamanioMapa()*(0.9)));
        }
        jugadores.add(jugador);
    }

    public void registrarJugadores(Jugador jugador1, Jugador jugador2){
        if(jugador1.sosIgualA(jugador2)){
            throw new JugadorInvalidoError();
        }
        jugador1.setearPosicion((int) (mapa.tamanioMapa()*(0.1)), (int) (mapa.tamanioMapa()*(0.1)));
        jugador2.setearPosicion((int) (mapa.tamanioMapa()*(0.9)), (int) (mapa.tamanioMapa()*(0.9)));
        jugadores.add(jugador1);
        jugadores.add(jugador2);
        jugadorActual = jugador1;
    }

    public void avanzarTurno(){
        mapa.avanzarTurno();
        for (Jugador jugador: jugadores){
            jugador.actualizarAreas(mapa);
        }

        turno += 1;
        jugadorActual = jugadores.get(turno%2);
    }
    public boolean hayGanador(){
        for (Jugador j: jugadores){
            if (j.perdio()){
                return true;
            }
        }

        return false;
    }

    public void ataque(Atacante atacante, Entidad atacado, Jugador jugador){
        try {
            atacado.recibirAtaque(atacante, mapa);
            if (atacado.estaDestruido()){
                atacado.destruir(jugador,mapa);
            }

        } catch (Exception e) {
            System.out.println("No se pudo realizar el ataque.");
        }

    }

    public void atacaraPosicion(int x1, int y1, int x2, int y2) {
        Entidad atacante = mapa.obtenerCasilla(x1, y1).obtenerEstado().obtenerEdificio();
        if (!atacante.esAtacante()) {
            throw new AtaqueInvalidoError();
        }
        Entidad atacable = mapa.obtenerCasilla(x2, y2).obtenerEstado().obtenerEdificio();
        ataque((Atacante) atacante, atacable, jugadores.get((turno + 1) % 2));
    }

    public void construirEdificio(String edificio, int x, int y){
        Casilla casilla = mapa.obtenerCasilla(x, y);
        edificiosFactory.crearEdificio(edificio, casilla, jugadorActual, mapa);
    }

    private boolean chequearNombre(Jugador jugador){
        return jugador.obtenerNombre().length()<6;
    }

    public Zerling crearZerling(Jugador j, int x, int y){

        //crear logica
        try {
            if (!j.yaTiene("ReservaDeReproduccion")){
                throw new CreacionDeUnidadInvalida();
            }
        } catch (CreacionDeUnidadInvalida e) {
            System.out.println("Para crear un Zerling necesitas una Reserva de Reproduccion. ");
            return null;
        }

        try {
            Casilla casilla = mapa.obtenerCasilla(x, y);
            Zerling z = new Zerling(casilla);
            j.verificarYConsumirSuministro(z);
            casilla.construir(z,jugadorActual.obtenerAlmacen());
            return z;

        } catch (Exception e) {
            System.out.println("No se pudo crear el Zerling. ");
            return null;
        }

    }

    public Zangano crearZangano(Jugador j, int x, int y){

        //crear logica
        try {
            if (!j.yaTiene("Criadero")){
                throw new CreacionDeUnidadInvalida();
            }
        } catch (CreacionDeUnidadInvalida e) {
            System.out.println("Para crear un Zangano necesitas un Criadero. ");
            return null;
        }

        try {
            Casilla casilla = mapa.obtenerCasilla(x, y);
            Zangano z = new Zangano(casilla,jugadorActual.obtenerAlmacen() );
            j.verificarYConsumirSuministro(z);
            casilla.construir(z,jugadorActual.obtenerAlmacen());
            return z;

        } catch (Exception e){
            System.out.println("No se pudo crear el Zangano. ");
            return null;
        }
    }

    public Hidralisco crearHidralisco(Jugador j, int x, int y){

        //crear logica
        try {
            if (!j.yaTiene("Guarida")){
                throw new CreacionDeUnidadInvalida();
            }
        } catch (CreacionDeUnidadInvalida e) {
            System.out.println("Para crear un Hidralisco necesitas una Guarida. ");
            return null;
        }

        try {
            Casilla casilla = mapa.obtenerCasilla(x, y);
            Hidralisco h = new Hidralisco(casilla);
            j.verificarYConsumirSuministro(h);
            casilla.construir(h,jugadorActual.obtenerAlmacen());
            return h;

        } catch (Exception e) {
            System.out.println("No se pudo crear el Hidralisco. ");
            return null;
        }

    }

    public Mutalisco crearMutalisco(Jugador j, int x, int y){

        //crear logica
        try {
            if (!j.yaTiene("Espiral")){
                throw new CreacionDeUnidadInvalida();
            }
        } catch (CreacionDeUnidadInvalida e) {
            System.out.println("Para crear un Mutalisco necesitas un Espiral. ");
            return null;
        }

        try {
            Casilla casilla = mapa.obtenerCasilla(x, y);
            Mutalisco m = new Mutalisco(casilla);
            j.verificarYConsumirSuministro(m);
            casilla.construir(m,jugadorActual.obtenerAlmacen());
            //casilla.cambiarEstado(new Ocupada(casilla.obtenerTerreno(), casilla.obtenerRecurso(), m));
            return m;

        } catch (Exception e) {
            System.out.println("No se pudo crear el Mutalisco");
            return null;
        }

    }

    public Zealot crearZealot(Jugador j, int x, int y){

        //crear logica
        try {
            if (!j.yaTiene("Acceso")){
                throw new CreacionDeUnidadInvalida();
            }
        } catch (CreacionDeUnidadInvalida e){
            System.out.println("Para crear un Mutalisco necesitas un Acceso. ");
            return null;
        }

        try {
            Casilla casilla = mapa.obtenerCasilla(x, y);
            Zealot z = new Zealot(casilla);
            j.verificarYConsumirSuministro(z);
            casilla.construir(z,jugadorActual.obtenerAlmacen());
            return z;

        } catch (Exception e){
            System.out.println("No se pudo crear el Zealot. ");
            return null;
        }

    }

    public Dragon crearDragon(Jugador j, int x, int y){

        //crear logica
        try {
            if (!j.yaTiene("Acceso")){
                throw new CreacionDeUnidadInvalida();
            }
        } catch (CreacionDeUnidadInvalida e) {
            System.out.println("Para crear un Dragon necesitas un Acceso. ");
            return null;
        }

        try {
            Casilla casilla = mapa.obtenerCasilla(x, y);
            Dragon d = new Dragon(casilla);
            j.verificarYConsumirSuministro(d);
            casilla.construir(d,jugadorActual.obtenerAlmacen());
            return d;

        } catch (Exception e){
            System.out.println("No se pudo crear el Dragon. ");
            return null;
        }

    }

    public Scout crearScout(Jugador j, int x, int y){

        //crear logica
        try {
            if (!j.yaTiene("PuertoEstelar")){
                throw new CreacionDeUnidadInvalida();
            }
        } catch (CreacionDeUnidadInvalida e) {
            System.out.println("Para crear un Dragon necesitas un Acceso. ");
            return null;
        }

        try {
            Casilla casilla = mapa.obtenerCasilla(x, y);
            Scout s = new Scout(casilla);
            j.verificarYConsumirSuministro(s);
            casilla.construir(s,jugadorActual.obtenerAlmacen());
            return s;
        } catch (Exception e) {
            System.out.println("No se pudo crear el Scout. ");
            return null;
        }
    }

    public AmoSupremo crearAmoSupremo(Jugador j, int x, int y){
        try {
            // crear logica
            Casilla casilla = mapa.obtenerCasilla(x, y);
            AmoSupremo amoSupremo = new AmoSupremo(casilla);
            casilla.construir(amoSupremo,jugadorActual.obtenerAlmacen());
            jugadorActual.generarPoblacion();
            return amoSupremo;

        } catch (Exception e){
            System.out.println("No se pudo crear el Amo Supremo");
            return null;
        }

    }

    public Jugador obtenerJugadorActual() {
        return jugadorActual;
    }

}

