package edu.fiuba.algo3.modelo.unidades;

import edu.fiuba.algo3.modelo.costos.Costo;
import edu.fiuba.algo3.modelo.edificios.Vida;
import edu.fiuba.algo3.modelo.errores.ConstruccionNoPermitidaError;
import edu.fiuba.algo3.modelo.estados.Desocupada;
import edu.fiuba.algo3.modelo.estados.Ocupada;
import edu.fiuba.algo3.modelo.juego.Almacen;
import edu.fiuba.algo3.modelo.juego.Casilla;
import edu.fiuba.algo3.modelo.juego.Entidad;
import edu.fiuba.algo3.modelo.razas.Raza;
import edu.fiuba.algo3.modelo.terrenos.*;

import java.util.ArrayList;

public abstract class Unidad extends Entidad {

    private TipoDeUnidad tipoUnidad;

    private int costoSuministro;

    public void construir(Terreno terreno, Almacen almacen){
        this.cobrar(almacen);
        casilla.cambiarEstado(new Ocupada(terreno, casilla.obtenerRecurso(), this));
    }

    public void construir(Moho moho, Almacen almacen){
        this.cobrar(almacen);
        casilla.cambiarEstado(new Ocupada(moho, casilla.obtenerRecurso(), this));
    }

    public void construir(Tierra tierra, Almacen almacen){
        this.cobrar(almacen);
        casilla.cambiarEstado(new Ocupada(tierra, casilla.obtenerRecurso(), this));
    }

    public void construir(TierraEnergizada tierraEnergizada, Almacen almacen){
        this.cobrar(almacen);
        casilla.cambiarEstado(new Ocupada(tierraEnergizada, casilla.obtenerRecurso(), this));
    }

    public void construir(Espacio espacio, Almacen almacen){throw new ConstruccionNoPermitidaError();}

    public Unidad(Vida vida, ArrayList<Costo> costos, int tiempoConstruccion, Raza raza, Casilla casilla, TipoDeUnidad tipo){
        super(vida, costos, tiempoConstruccion, raza, casilla);
        tipoUnidad = tipo;
    }

    public void moverA(Casilla casillaDestino){
        esUsable();
        casillaDestino.estaLibre();
        Terreno terreno = casillaDestino.obtenerTerreno();
        terreno.puedoMover(this);
        casilla.cambiarEstado(new Desocupada(casilla.obtenerTerreno(), casilla.obtenerRecurso()));
        casilla = casillaDestino;
        casillaDestino.cambiarEstado(new Ocupada(terreno, casillaDestino.obtenerRecurso(), this));
    }

    public TipoDeUnidad obtenerTipoMovimiento(){
        return tipoUnidad;
    }

    @Override
    public boolean esAtacante() {
        return true;
    }

}
