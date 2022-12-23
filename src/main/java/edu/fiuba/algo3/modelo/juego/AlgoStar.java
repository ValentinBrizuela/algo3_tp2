package edu.fiuba.algo3.modelo.juego;

import edu.fiuba.algo3.modelo.edificios.*;
import edu.fiuba.algo3.modelo.errores.*;
import edu.fiuba.algo3.modelo.interfaces.Atacante;
import edu.fiuba.algo3.modelo.unidades.*;

import java.util.ArrayList;

public class AlgoStar {

    final double puntaInicial = 0.1;
    final double puntaFinal = 0.9;

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
        jugador1.setearPosicion((int) (mapa.tamanioMapa()*(puntaInicial)), (int) (mapa.tamanioMapa()*(puntaInicial)));
        jugador2.setearPosicion((int) (mapa.tamanioMapa()*(puntaFinal)), (int) (mapa.tamanioMapa()*(puntaFinal)));
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

    public String ataque(Atacante atacante, Entidad atacado, Jugador jugadorAtacado){
        try {
            atacado.recibirAtaque(atacante, mapa);
            if (atacado.estaDestruido()){
                atacado.destruir(jugadorAtacado,mapa);
            }

        } catch (AtaquePorAireInvalidoError e) {
            System.out.println("La unidad seleccionada no realiza ataques por aire.");
            return "La unidad seleccionada no realiza ataques por aire.";
        } catch (AtaquePorTierraInvalidoError e) {
            System.out.println("La unidad seleccionada no realiza ataques por tierra.");
            return "La unidad seleccionada no realiza ataques por tierra.";
        } catch (FueraDeRangoError e) {
            System.out.println("La unidad no tiene el rango suficiente.");
            return "La unidad no tiene el rango suficiente.";
        } catch (EnConstruccionError e){
            System.out.println("La unidad esta en construccion.");
            return "La unidad esta en construccion.";
        }
        return null;
    }

    public String atacaraPosicion(int x1, int y1, int x2, int y2) {
        Jugador jugadorActual = obtenerJugadorActual();
        Entidad atacante = mapa.obtenerEntidad(x1, y1);
        Entidad atacable = mapa.obtenerEntidad(x2, y2);

        try {
            if (!atacante.esAtacante()) {
                throw new UnidadNoPuedeAtacarError();
            }

            jugadorActual.puedeSeleccionar(atacante.raza);

            atacante.puedoAtacar(atacable.raza);

        } catch (UnidadNoPuedeAtacarError u){
            System.out.println("La unidad seleccionada no puede atacar");
            return "La unidad seleccionada no puede atacar";

        } catch (SeleccionInvalidaError s){
            System.out.println("Esta unidad no te pertenece");
            return "Esta unidad no te pertenece";

        } catch (AtaqueInvalidoError a){
            System.out.println("No podes atacar a una unidad de tu misma raza");
            return "No podes atacar a una unidad de tu misma raza";
        }



        return ataque((Atacante) atacante, atacable, jugadores.get((turno + 1) % 2));
    }

    public String mover(int x1, int y1, int x2, int y2) {
        try {
            Entidad entidad = mapa.obtenerEntidad(x1, y1);
            jugadorActual.puedeSeleccionar(entidad.raza);
            ((Unidad) entidad).moverA(mapa.obtenerCasilla(x2, y2));
        } catch (MovimientoAEspacioError e) {
            System.out.println("La unidad seleccionado no se puede mover a una zona aerea.");
            return "La unidad seleccionado no se puede mover a una zona aerea.";

        } catch (CasillaOcupadaError e) {
            System.out.println("La casilla destino seleccionada debe estar desocupada.");
            return "La casilla destino seleccionada debe estar desocupada.";

        } catch (EnConstruccionError e) {
            System.out.println("La unidad esta en construccion.");
            return "La unidad esta en construccion.";
        }
        return null;
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

