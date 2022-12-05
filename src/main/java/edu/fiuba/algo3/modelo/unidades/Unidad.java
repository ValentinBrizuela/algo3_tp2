package edu.fiuba.algo3.modelo.unidades;

import edu.fiuba.algo3.modelo.costos.Costo;
import edu.fiuba.algo3.modelo.edificios.Vida;
import edu.fiuba.algo3.modelo.estados.Ocupada;
import edu.fiuba.algo3.modelo.juego.Casilla;
import edu.fiuba.algo3.modelo.juego.Entidad;
import edu.fiuba.algo3.modelo.razas.Raza;
import edu.fiuba.algo3.modelo.terrenos.Terreno;

import java.util.ArrayList;

public abstract class Unidad extends Entidad {

    private TipoDeUnidad tipoUnidad;

    private int costoSuministro;


    public Unidad(Vida vida, ArrayList<Costo> costos, int tiempoConstruccion, Raza raza, Casilla casilla, TipoDeUnidad tipo){
        super(vida, costos, tiempoConstruccion, raza, casilla);
        tipoUnidad = tipo;
    }

    public void moverA(Casilla casillaDestino){
        esUsable();
        casillaDestino.estaLibre();
        Terreno terreno = casillaDestino.obtenerTerreno();
        terreno.puedoMover(this);
        casilla = casillaDestino;
        casillaDestino.cambiarEstado(new Ocupada(terreno, casillaDestino.obtenerRecurso(), this));
    }

    public void avanzarCasilla(){

    }

    public TipoDeUnidad obtenerTipoMovimiento(){
        return tipoUnidad;
    }


}
