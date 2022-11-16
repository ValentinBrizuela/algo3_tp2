package edu.fiuba.algo3.modelo.unidades;

import edu.fiuba.algo3.modelo.errores.AtaqueInvalidoError;
import edu.fiuba.algo3.modelo.estados.Ocupada;
import edu.fiuba.algo3.modelo.juego.Casilla;
import edu.fiuba.algo3.modelo.juego.Entidad;
import edu.fiuba.algo3.modelo.razas.Raza;
import edu.fiuba.algo3.modelo.terrenos.Terreno;

import java.util.List;

public abstract class Unidad extends Entidad {

    private TipoDeUnidad tipoUnidad;

    private List<TipoDeUnidad> tiposDeAtaque;


    public Unidad(int vida, int costoMineral, int costoGas, int tiempoConstruccion, Raza raza, Casilla casilla, TipoDeUnidad tipo, List<TipoDeUnidad> tiposdeataques){
        super(vida, costoMineral, costoGas, tiempoConstruccion, raza, casilla);
        tipoUnidad = tipo;
        tiposDeAtaque = tiposdeataques;
    }

    public List<TipoDeUnidad> obtenerTiposDeAtaque(){
        return tiposDeAtaque;
    }
    public abstract void recibirAtaque(int danio);

    public void moverA(Casilla casillaDestino){
        Terreno terreno = casillaDestino.obtenerTerreno();
        terreno.puedoMover(this);
        casilla = casillaDestino;
        /*casillaDestino.cambiarEstado(new Ocupada(terreno, casillaDestino.obtenerRecurso(), this));*/
    }

    public void avanzarCasilla(){

    }

    public void recibirAtaque(List<TipoDeUnidad> tipos){
        for(TipoDeUnidad tipo : tipos){
            if (tipo.getClass() == tipoUnidad.getClass()){
                tipo.atacar(this); return;}
        }
        throw new AtaqueInvalidoError();
    }
    public TipoDeUnidad obtenerTipoMovimiento() {return tipoUnidad;}
}
