package edu.fiuba.algo3.modelo.edificios;

import edu.fiuba.algo3.modelo.errores.ConstruccionNoPermitidaError;
import edu.fiuba.algo3.modelo.estados.Desocupada;
import edu.fiuba.algo3.modelo.estados.Ocupada;
import edu.fiuba.algo3.modelo.interfaces.AtacableTerrestre;
import edu.fiuba.algo3.modelo.interfaces.Atacante;
import edu.fiuba.algo3.modelo.juego.*;
import edu.fiuba.algo3.modelo.razas.Zerg;
import edu.fiuba.algo3.modelo.recursos.RecursoVacio;
import edu.fiuba.algo3.modelo.terrenos.*;

public class Criadero extends Entidad implements Construible, AtacableTerrestre, EdificioConArea {
    private int cantidadLarvas;

    Casilla casilla;

    private int rango;
    private int contador;


    public Criadero(Casilla casilla){

        super(new VidaZerg(500), 50, 0, 4, new Zerg(), casilla);
        this.cantidadLarvas = 3;
        this.casilla = casilla;
        this.rango = 5;
        this.contador = 0;

    }
    public void engendrarZangano(){
        esUsable();
        cantidadLarvas -= 1;
    }

    @Override
    public void avanzarTurno() {
        if (cantidadLarvas() < 3) {
        cantidadLarvas += 1;
        }
        this.tiempoConstruccion -= 1;
        vida.regenerar();
        this.contador += 1;
        incrementarRango();
    }

    public void generarMoho(Mapa mapa) {
        for (int i = casilla.obtenerPosX() - rango; i <= casilla.obtenerPosX() + rango; i++) {
            for (int j = casilla.obtenerPosY() - rango; j <= casilla.obtenerPosY() + rango; j++) {
                if (mapa.obtenerCasilla(i, j).obtenerEstado().getClass() == Desocupada.class) {
                    mapa.obtenerCasilla(i, j).cambiarTerreno(new Moho());
                }
            }
        }
    }

    private void incrementarRango() {
        if (contador%2 == 0) {
            rango += 1;
        }
    }

    public int cantidadLarvas(){
        return this.cantidadLarvas;
    }

    @Override
    public void construir(Moho moho, Almacen almacen) {
        almacen.cobrar(this.costo);
        casilla.cambiarEstado(new Ocupada(new Moho(), new RecursoVacio(), this));
    }

    @Override
    public void construir(Tierra tierra, Almacen almacen) {
        almacen.cobrar(this.costo);
        casilla.cambiarEstado(new Ocupada(new Moho(), new RecursoVacio(), this));
    }

    @Override
    public void construir(TierraEnergizada tierraEnergizada, Almacen almacen) {
        throw new ConstruccionNoPermitidaError();
    }

    @Override
    public void construir(Espacio espacio, Almacen almacen) {
        throw new ConstruccionNoPermitidaError();
    }

    public void recibirAtaque(Atacante atacante, Mapa mapa) {
        atacante.atacarA(this);
    }

    public void actualizarTerreno(Mapa mapa){
        generarMoho(mapa);
    }

    @Override
    public  void destruir(Jugador jugador,Mapa mapa){
        casilla.cambiarEstado(new Desocupada(casilla.obtenerTerreno(),casilla.obtenerRecurso()));
        jugador.degenerarPoblacion();
    }

}
