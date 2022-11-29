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
        atacado.recibirAtaque(atacante, mapa);
        if (atacado.estaDestruido()){
            atacado.destruir(jugador,mapa);
        }

    }

    public void construirGuarida(int x, int y){
        if(jugadorActual.yaTiene(ReservaDeReproduccion.class)) {
            Casilla casilla = mapa.obtenerCasilla(x,y);
            Guarida g = new Guarida(casilla);
            casilla.construir(g, jugadorActual.obtenerAlmacen());
            jugadorActual.agregarEdificio(g);
        }else{
            throw new ConstruccionNoPermitidaError();
        }
    }

    public void construirCriadero(int x, int y){
        Casilla casilla = mapa.obtenerCasilla(x,y);
        Criadero c = new Criadero(casilla);
        casilla.construir(c, jugadorActual.obtenerAlmacen());
        jugadorActual.generarPoblacion();
        jugadorActual.agregarEdificio(c);
        jugadorActual.agregarEdificioConArea(c);
        c.actualizarTerreno(mapa);
    }

    public void construirPilon(int x, int y){
        Casilla casilla = mapa.obtenerCasilla(x,y);
        Pilon p = new Pilon(casilla);
        casilla.construir(p, jugadorActual.obtenerAlmacen());
        jugadorActual.generarPoblacion();
        jugadorActual.agregarEdificio(p);
        jugadorActual.agregarEdificioConArea(p);
        p.actualizarTerreno(mapa);
    }
    public void construirReservaDeReproduccion(int x, int y){
        Casilla casilla = mapa.obtenerCasilla(x, y);
        ReservaDeReproduccion r = new ReservaDeReproduccion(casilla);
        casilla.construir(r, jugadorActual.obtenerAlmacen());
        jugadorActual.agregarEdificio(r);
    }

    public void construirEspiral(int x, int y){
        if(jugadorActual.yaTiene(Guarida.class)) {
            Casilla casilla = mapa.obtenerCasilla(x, y);
            Espiral e = new Espiral(casilla);
            casilla.construir(e, jugadorActual.obtenerAlmacen());
            jugadorActual.agregarEdificio(e);
        }else{
            throw new ConstruccionNoPermitidaError();
        }
    }

    public void construirPuertoEstelar(int x, int y) {
        if(jugadorActual.yaTiene(Acceso.class)) {
            Casilla casilla = mapa.obtenerCasilla(x, y);
            PuertoEstelar p = new PuertoEstelar(casilla);
            casilla.construir(p, jugadorActual.obtenerAlmacen());
            jugadorActual.agregarEdificio(p);
        }else{
            throw new ConstruccionNoPermitidaError();
        }
    }

    public void construirAcceso(int x, int y) {
        Casilla casilla = mapa.obtenerCasilla(x, y);
        Acceso a = new Acceso(casilla);
        casilla.construir(a, jugadorActual.obtenerAlmacen());
        jugadorActual.agregarEdificio(a);
    }

    private boolean chequearNombre(Jugador jugador){
        return jugador.obtenerNombre().length()<6;
    }

    public Zerling crearZerling(Jugador j, int x, int y){
        Casilla casilla = mapa.obtenerCasilla(x, y);

        //crear logica
        if(j.yaTiene(ReservaDeReproduccion.class)){
            Zerling z = new Zerling(casilla);
            j.verificarYConsumirSuministro(z);
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
            j.verificarYConsumirSuministro(z);
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
            j.verificarYConsumirSuministro(h);
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
            j.verificarYConsumirSuministro(m);
            casilla.cambiarEstado(new Ocupada(casilla.obtenerTerreno(), casilla.obtenerRecurso(), m));
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
            j.verificarYConsumirSuministro(z);
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
            j.verificarYConsumirSuministro(d);
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
            j.verificarYConsumirSuministro(s);
            return s;
        }
        else{
            throw new CreacionDeUnidadInvalida();
        }

    }

    public AmoSupremo crearAmoSupremo(Jugador j, int x, int y){
        Casilla casilla = mapa.obtenerCasilla(x, y);

        //crear logica

        AmoSupremo amoSupremo = new AmoSupremo(casilla);
        jugadorActual.generarPoblacion();
        return amoSupremo;
    }

}

