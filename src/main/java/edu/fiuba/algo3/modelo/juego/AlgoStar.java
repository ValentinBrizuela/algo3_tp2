package edu.fiuba.algo3.modelo.juego;

import edu.fiuba.algo3.modelo.edificios.*;
import edu.fiuba.algo3.modelo.errores.*;
import edu.fiuba.algo3.modelo.estados.Ocupada;
import edu.fiuba.algo3.modelo.interfaces.Atacante;
import edu.fiuba.algo3.modelo.unidades.*;

import java.util.ArrayList;

public class AlgoStar {

    private ArrayList<Jugador> jugadores;


    private Mapa mapa;
    private int cantJugadores;
    private int turno;

    private Jugador jugadorActual;

    public AlgoStar(Mapa mapa){
        this.jugadores=new ArrayList<Jugador>();
        this.mapa=mapa;
        this.turno = 0;
        this.jugadorActual = null;
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

    /*public Jugador jugarPartida(){
        if (jugadores.size() != 2){ throw new JugadoresInsuficientesError();}

        Turno turnero = new Turno(this, jugadores[0]);


        while (!hayGanador()){

            turno +=1;
            esperar respuesta usuario
            jugadorActual.


        }


    }*/
    public void avanzarTurno(){
        mapa.avanzarTurno();
        jugadorActual.actualizarAreas(mapa);
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
            atacado.recibirAtaque(atacante, mapa);
            if (atacado.estaDestruido()){
                atacado.destruir(jugador,mapa);
            }
    }

    public void construirGuarida(int x, int y){
        try {
            if (!jugadorActual.yaTiene("ReservaDeReproduccion")){
                throw new ConstruccionNoPermitidaError();
            }
        } catch (ConstruccionNoPermitidaError e) {
            System.out.println("Para construir una guarida necesitas una Reserva de Reproduccion. ");
            return;
        }

        try {
                Casilla casilla = mapa.obtenerCasilla(x,y);
                Guarida g = new Guarida(casilla);
                casilla.construir(g, jugadorActual.obtenerAlmacen());
                jugadorActual.construyo("Guarida");
                jugadorActual.agregarEdificio(g);

        } catch (Exception e) {
            System.out.println("No se pudo construir la Guarida. ");
        }
    }

    public void construirCriadero(int x, int y){
        try {
            Casilla casilla = mapa.obtenerCasilla(x,y);
            Criadero c = new Criadero(casilla);
            casilla.construir(c, jugadorActual.obtenerAlmacen());
            jugadorActual.construyo("Criadero");
            jugadorActual.generarPoblacion();
            jugadorActual.agregarEdificio(c);
            jugadorActual.agregarEdificioConArea(c);
            c.actualizarTerreno(mapa);

        } catch (Exception e){
            System.out.println("No se pudo construir el Criadero. ");
        }
    }

    public void construirPilon(int x, int y){
        try {
            Casilla casilla = mapa.obtenerCasilla(x,y);
            Pilon p = new Pilon(casilla);
            casilla.construir(p, jugadorActual.obtenerAlmacen());
            jugadorActual.generarPoblacion();
            jugadorActual.agregarEdificio(p);
            jugadorActual.agregarEdificioConArea(p);
            p.actualizarTerreno(mapa);

        } catch (Exception e){
            System.out.println("No se pudo construir el Pilon. ");
        }
    }
    public void construirReservaDeReproduccion(int x, int y){
        try {
            Casilla casilla = mapa.obtenerCasilla(x, y);
            ReservaDeReproduccion r = new ReservaDeReproduccion(casilla);
            casilla.construir(r, jugadorActual.obtenerAlmacen());
            jugadorActual.construyo("ReservaDeReproduccion");
            jugadorActual.agregarEdificio(r);

        } catch (Exception e){
            System.out.println("No se pudo construir la Reserva de Reproduccion. ");
        }
    }

    public void construirEspiral(int x, int y){
        try {
            if (!jugadorActual.yaTiene("Guarida")){
                throw new ConstruccionNoPermitidaError();
            }

        } catch (ConstruccionNoPermitidaError e) {
            System.out.println("Para construir un Espiral necesitas una Guarida. ");
            return;
        }

        try {
            Casilla casilla = mapa.obtenerCasilla(x, y);
            Espiral e = new Espiral(casilla);
            casilla.construir(e, jugadorActual.obtenerAlmacen());
            jugadorActual.construyo("Espiral");
            jugadorActual.agregarEdificio(e);

        } catch (Exception e) {
            System.out.println("No se pudo construir el Espiral. ");
        }
    }

    public void construirPuertoEstelar(int x, int y) {
        try {
            if (!jugadorActual.yaTiene("Acceso")){
                throw new ConstruccionNoPermitidaError();
            }

        } catch (ConstruccionNoPermitidaError e) {
            System.out.println("Para construir un Puerto Estelar necesitas un Acceso. ");
            return;
        }

        try {
            Casilla casilla = mapa.obtenerCasilla(x, y);
            PuertoEstelar p = new PuertoEstelar(casilla);
            casilla.construir(p, jugadorActual.obtenerAlmacen());
            jugadorActual.construyo("PuertoEstelar");
            jugadorActual.agregarEdificio(p);

        } catch (Exception e) {
            System.out.println("No se pudo construir el Puerto Estelar. ");
        }
    }

    public void construirAcceso(int x, int y) {
        try {
            Casilla casilla = mapa.obtenerCasilla(x, y);
            Acceso a = new Acceso(casilla);
            casilla.construir(a, jugadorActual.obtenerAlmacen());
            jugadorActual.construyo("Acceso");
            jugadorActual.agregarEdificio(a);

        } catch (Exception e){
            System.out.println("No se pudo construir el Acceso. ");
        }
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
            Zangano z = new Zangano(casilla);
            j.verificarYConsumirSuministro(z);
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
            casilla.cambiarEstado(new Ocupada(casilla.obtenerTerreno(), casilla.obtenerRecurso(), m));
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
            jugadorActual.generarPoblacion();
            return amoSupremo;

        } catch (Exception e){
            System.out.println("No se pudo crear el Amo Supremo");
            return null;
        }

    }

}

