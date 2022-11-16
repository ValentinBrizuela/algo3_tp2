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

public abstract class EdificioZerg extends Edificio {

    public EdificioZerg(int vida, int tiempoConstruccion, int costoMinerales, int costoGas, Casilla casilla) {
        super(vida, tiempoConstruccion, costoMinerales, costoGas, casilla);
    }

    public void recibirDanio(int dano) {
        vida -= dano;
        if (vida <= 0){
            Estado estado = casilla.obtenerEstado();
            casilla.cambiarEstado(new Desocupada(estado.obtenerTerreno(), estado.obtenerRecurso()));
        }
    }
    @Override
    public void regenerar() {
        if (vidaMax-vida > 0) {
            vida += vidaMax*0.1;
            if (vida > vidaMax) {
                vida = vidaMax;
            }
        }
    }

    public void avanzarTurno() {
        regenerar();
        tiempoConstruccion -= 1;
    }

    public void construir(Moho moho, Almacen almacen) {
        almacen.cobrar(this.costo);
        casilla.cambiarEstado(new Ocupada(moho, new RecursoVacio(), this));
    }

    public void construir(Tierra tierra, Almacen almacen) {
        throw new ConstruccionNoPermitidaError();
    }

    public void construir(TierraEnergizada tierraEnergizada, Almacen almacen) {
        throw new ConstruccionNoPermitidaError();
    }

}
