package edu.fiuba.algo3.modelo.juego;

import edu.fiuba.algo3.modelo.edificios.*;
import edu.fiuba.algo3.modelo.errores.*;
import edu.fiuba.algo3.modelo.interfaces.Atacante;
import edu.fiuba.algo3.modelo.unidades.*;
import java.util.ArrayList;

public class AlgoStar {

    private ArrayList<Jugador> jugadores;
    private EntidadesFactory entidadesFactory;

    public IMapa mapa;
    private int turno;
    private Jugador jugadorActual;

    public AlgoStar(IMapa mapa){
        this.jugadores=new ArrayList<Jugador>();
        this.mapa=mapa;
        this.turno = 0;
        this.jugadorActual = null;
        this.entidadesFactory = new EntidadesFactory();
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

    public void ataque(Atacante atacante, Entidad atacado, Jugador jugadorAtacado){
        try {
            atacado.recibirAtaque(atacante, mapa);
            if (atacado.estaDestruido()){
                atacado.destruir(jugadorAtacado,mapa);
            }

        } catch (Exception e) {
            System.out.println("No se pudo realizar el ataque.");
        }

    }

    public void atacaraPosicion(int x1, int y1, int x2, int y2) {
        Entidad atacante = mapa.obtenerEntidad(x1, y1);
        if (!atacante.esAtacante()) {
            throw new AtaqueInvalidoError();
        }
        Entidad atacable = mapa.obtenerEntidad(x2, y2);
        ataque((Atacante) atacante, atacable, jugadores.get((turno + 1) % 2));
    }

    public void mover(int x1, int y1, int x2, int y2) {
        try {
            Entidad entidad = mapa.obtenerEntidad(x1, y1);
            ((Unidad) entidad).moverA(mapa.obtenerCasilla(x2, y2));
        } catch (MovimientoInvalidoError e) {
            System.out.println("No se pudo realizar el movimiento.");
        } catch (Exception e) {
            System.out.println("aaaaaa.");
        }

    }

    public void construirEntidad(String entidad, int x, int y){
        Casilla casilla = mapa.obtenerCasilla(x, y);
        entidadesFactory.construirEntidad(entidad, casilla, jugadorActual, mapa);
    }

    public Jugador obtenerJugadorActual() {
        return jugadorActual;
    }

    public Jugador obtenerJugadorRival() { return jugadores.get(turno%2 + 1);}

}

