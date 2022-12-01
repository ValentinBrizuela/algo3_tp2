package edu.fiuba.algo3.modelo.juego;

import edu.fiuba.algo3.modelo.edificios.*;
import edu.fiuba.algo3.modelo.errores.*;
import edu.fiuba.algo3.modelo.estados.Desocupada;
import edu.fiuba.algo3.modelo.estados.Ocupada;
import edu.fiuba.algo3.modelo.interfaces.Atacable;
import edu.fiuba.algo3.modelo.interfaces.AtacableTerrestre;
import edu.fiuba.algo3.modelo.interfaces.Atacante;
import edu.fiuba.algo3.modelo.terrenos.Moho;
import edu.fiuba.algo3.modelo.terrenos.TierraEnergizada;
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
        try {
            atacado.recibirAtaque(atacante, mapa);
            if (atacado.estaDestruido()){
                atacado.destruir(jugador,mapa);
            }

        } catch (Exception e) {
            System.out.println("No se pudo realizar el ataque.");
        }

    }

    public void construirGuarida(int x, int y){
        try {
            jugadorActual.yaTiene(ReservaDeReproduccion.class);
        } catch (ConstruccionNoPermitidaError e) {
            System.out.println("Para construir una guarida necesitas una Reserva de Reproduccion. ");
        }

        try {
                Casilla casilla = mapa.obtenerCasilla(x,y);
                Guarida g = new Guarida(casilla);
                casilla.construir(g, jugadorActual.obtenerAlmacen());
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
            jugadorActual.agregarEdificio(r);

        } catch (Exception e){
            System.out.println("No se pudo construir la Reserva de Reproduccion. ");
        }
    }

    public void construirEspiral(int x, int y){
        try {
            jugadorActual.yaTiene(Guarida.class);

        } catch (ConstruccionNoPermitidaError e) {
            System.out.println("Para construir un Espiral necesitas una Guarida. ");
        }

        try {
            Casilla casilla = mapa.obtenerCasilla(x, y);
            Espiral e = new Espiral(casilla);
            casilla.construir(e, jugadorActual.obtenerAlmacen());
            jugadorActual.agregarEdificio(e);

        } catch (Exception e) {
            System.out.println("No se pudo construir el Espiral. ");
        }
    }

    public void construirPuertoEstelar(int x, int y) {
        try {
            jugadorActual.yaTiene(Acceso.class);

        } catch (ConstruccionNoPermitidaError e) {
            System.out.println("Para construir un Puerto Estelar necesitas un Acceso. ");
        }

        try {
            Casilla casilla = mapa.obtenerCasilla(x, y);
            PuertoEstelar p = new PuertoEstelar(casilla);
            casilla.construir(p, jugadorActual.obtenerAlmacen());
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
            j.yaTiene(ReservaDeReproduccion.class);
        } catch (Exception e) {
            System.out.println("Para crear un Zerling necesitas una Reserva de Reproduccion. ");
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
            j.yaTiene(Criadero.class);
        } catch (Exception e) {
            System.out.println("Para crear un Zangano necesitas un Criadero. ");
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
            j.yaTiene(Guarida.class);
        } catch (Exception e) {
            System.out.println("Para crear un Hidralisco necesitas una Guarida. ");
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
            j.yaTiene(Espiral.class);
        } catch (Exception e) {
            System.out.println("Para crear un Mutalisco necesitas un Espiral. ");
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
            j.yaTiene(Acceso.class);
        } catch (Exception e){
            System.out.println("Para crear un Mutalisco necesitas un Acceso. ");
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
            j.yaTiene(Acceso.class);
        } catch (Exception e) {
            System.out.println("Para crear un Dragon necesitas un Acceso. ");
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
            j.yaTiene(PuertoEstelar.class);
        } catch (Exception e) {
            System.out.println("Para crear un Dragon necesitas un Acceso. ");
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

