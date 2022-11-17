package edu.fiuba.algo3.modelo.edificios;

import edu.fiuba.algo3.modelo.errores.ConstruccionNoPermitidaError;
import edu.fiuba.algo3.modelo.errores.EdificioEnConstruccionError;
import edu.fiuba.algo3.modelo.estados.Desocupada;
import edu.fiuba.algo3.modelo.estados.Estado;
import edu.fiuba.algo3.modelo.estados.Ocupada;
import edu.fiuba.algo3.modelo.interfaces.AtacableTerrestre;
import edu.fiuba.algo3.modelo.interfaces.Atacante;
import edu.fiuba.algo3.modelo.juego.Almacen;
import edu.fiuba.algo3.modelo.juego.Casilla;
import edu.fiuba.algo3.modelo.juego.Entidad;
import edu.fiuba.algo3.modelo.juego.Mapa;
import edu.fiuba.algo3.modelo.razas.Zerg;
import edu.fiuba.algo3.modelo.recursos.RecursoVacio;
import edu.fiuba.algo3.modelo.terrenos.Espacio;
import edu.fiuba.algo3.modelo.terrenos.Moho;
import edu.fiuba.algo3.modelo.terrenos.Tierra;
import edu.fiuba.algo3.modelo.terrenos.TierraEnergizada;

public class Criadero extends Entidad implements Construible, AtacableTerrestre {
    private int cantidadLarvas;

    Casilla casilla;
    private Mapa mapa;

    private int rango;
    private int contador;


    public Criadero(Mapa mapa, Casilla casilla){

        super(new VidaZerg(500), 50, 0, 4, new Zerg(), casilla);
        this.cantidadLarvas = 3;
        this.casilla = casilla;
        this.mapa = mapa;
        this.rango = 5;
        this.contador = 0;
        generarMoho();
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
        generarMoho();
        incrementarRango();
    }

    public void generarMoho() {
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


    public void recibirAtaque(int danio) {
        vida.recibirAtaque(danio);
        if (vida.obtenerVida() <= 0) {
            casilla.cambiarEstado(new Desocupada(casilla.obtenerTerreno(), casilla.obtenerRecurso()));
        }
    }

    public void recibirAtaque(Atacante atacante) {
        atacante.atacarA(this);
    }

}
