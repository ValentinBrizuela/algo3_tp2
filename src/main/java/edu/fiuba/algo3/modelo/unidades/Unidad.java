package edu.fiuba.algo3.modelo.unidades;

import edu.fiuba.algo3.modelo.edificios.Vida;
import edu.fiuba.algo3.modelo.edificios.VidaZerg;
import edu.fiuba.algo3.modelo.errores.AtaqueInvalidoError;
import edu.fiuba.algo3.modelo.estados.Ocupada;
import edu.fiuba.algo3.modelo.juego.Casilla;
import edu.fiuba.algo3.modelo.juego.Entidad;
import edu.fiuba.algo3.modelo.razas.Raza;
import edu.fiuba.algo3.modelo.terrenos.Terreno;

import java.util.List;

public abstract class Unidad extends Entidad {

    private TipoDeUnidad tipoUnidad;


    public Unidad(Vida vida, int costoMineral, int costoGas, int tiempoConstruccion, Raza raza, Casilla casilla, TipoDeUnidad tipo, List<TipoDeUnidad> tiposdeataques){
        super(vida, costoMineral, costoGas, tiempoConstruccion, raza, casilla);
        tipoUnidad = tipo;
    }

    public void moverA(Casilla casillaDestino){
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
