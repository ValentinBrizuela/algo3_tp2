package edu.fiuba.algo3.modelo.edificios;

import edu.fiuba.algo3.modelo.errores.ConstruccionNoPermitidaError;
import edu.fiuba.algo3.modelo.errores.EdificioEnConstruccionError;
import edu.fiuba.algo3.modelo.estados.Desocupada;
import edu.fiuba.algo3.modelo.estados.Ocupada;
import edu.fiuba.algo3.modelo.interfaces.AtacableTerrestre;
import edu.fiuba.algo3.modelo.interfaces.Atacante;
import edu.fiuba.algo3.modelo.juego.Almacen;
import edu.fiuba.algo3.modelo.juego.Casilla;
import edu.fiuba.algo3.modelo.juego.Entidad;
import edu.fiuba.algo3.modelo.razas.Zerg;
import edu.fiuba.algo3.modelo.recursos.Mena;
import edu.fiuba.algo3.modelo.terrenos.Espacio;
import edu.fiuba.algo3.modelo.terrenos.Moho;
import edu.fiuba.algo3.modelo.terrenos.Tierra;
import edu.fiuba.algo3.modelo.terrenos.TierraEnergizada;

public class ZanganoTrabajador extends Entidad implements Mina, Construible, AtacableTerrestre {

    public ZanganoTrabajador(Casilla casilla){
        super(new VidaZerg(25), 0, 0, 0, new Zerg(), casilla);
    }

    public void extraerMineral(Almacen almacen, Mena mena){
        esUsable();
        almacen.almacenarMineral(mena.extraer(10));
    }

    public void construir(Moho moho, Almacen almacen) {
        almacen.cobrar(this.costo);
        casilla.cambiarEstado(new Ocupada(moho, casilla.obtenerRecurso(), this));
    }

    @Override
    public void construir(Tierra tierra, Almacen almacen) {
        throw new ConstruccionNoPermitidaError();
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
        } /*Revisar esto*/
    }

    public void recibirAtaque(Atacante atacante) {
        atacante.atacarA(this);
    }

    @Override
    public void avanzarTurno() {
        tiempoConstruccion -= 1;
        vida.regenerar();
    }

}

