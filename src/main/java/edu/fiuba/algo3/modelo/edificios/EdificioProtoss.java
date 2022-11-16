package edu.fiuba.algo3.modelo.edificios;

import edu.fiuba.algo3.modelo.errores.ConstruccionNoPermitidaError;
import edu.fiuba.algo3.modelo.estados.Desocupada;
import edu.fiuba.algo3.modelo.estados.Estado;
import edu.fiuba.algo3.modelo.estados.Ocupada;
import edu.fiuba.algo3.modelo.juego.Almacen;
import edu.fiuba.algo3.modelo.juego.Casilla;
import edu.fiuba.algo3.modelo.recursos.RecursoVacio;
import edu.fiuba.algo3.modelo.terrenos.Moho;
import edu.fiuba.algo3.modelo.terrenos.Tierra;
import edu.fiuba.algo3.modelo.terrenos.TierraEnergizada;

public abstract class EdificioProtoss extends Edificio {
    protected int escudo;
    protected int escudoMax;

    public EdificioProtoss(int vida, int escudo, int tiempoConstruccion, int costoMinerales, int costoGas, Casilla casilla) {
        super(vida, tiempoConstruccion, costoMinerales, costoGas, casilla);
        this.escudo = escudo;
        this.escudoMax = escudo;
    }
    @Override
    public void recibirDanio(int cant) {
        if (cant > escudo) {
            vida -= (cant - escudo);
            escudo = 0;
        }
        else {
            escudo -= cant;
        }
        if (vida <= 0){
            Estado estado = casilla.obtenerEstado();
            casilla.cambiarEstado(new Desocupada(estado.obtenerTerreno(), estado.obtenerRecurso()));
        }
    }

    @Override
    public void regenerar() {
        if (escudoMax-escudo > 0) {
            escudo += escudoMax*0.1;
            if (escudo > escudoMax) {
                escudo = escudoMax;
            }
        }
    }

    public int escudo() {
        return escudo;
    }

    public void avanzarTurno() {
        regenerar();
        tiempoConstruccion -= 1;
    }

    /*public boolean estaEnergizado(){
        if (casilla.obtenerEstado().terreno.getClass() == TierraEnergizada.class){
            return true;
        }
        return false;
    }*/


    public void construir(Moho moho, Almacen almacen) {
        throw new ConstruccionNoPermitidaError();
    }

    public void construir(Tierra tierra, Almacen almacen) {
        throw new ConstruccionNoPermitidaError();
    }

    public void construir(TierraEnergizada tierraEnergizada, Almacen almacen) {
        almacen.cobrar(this.costo);
        casilla.cambiarEstado(new Ocupada(tierraEnergizada, casilla.obtenerRecurso(), this));
    }
}
