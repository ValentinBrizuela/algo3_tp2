package edu.fiuba.algo3.modelo.estados;

import edu.fiuba.algo3.modelo.edificios.Construible;
import edu.fiuba.algo3.modelo.errores.CasillaOcupadaError;
import edu.fiuba.algo3.modelo.juego.Almacen;
import edu.fiuba.algo3.modelo.juego.Entidad;
import edu.fiuba.algo3.modelo.recursos.Recurso;
import edu.fiuba.algo3.modelo.terrenos.Terreno;
import edu.fiuba.algo3.modelo.unidades.Unidad;

public class Ocupada extends Estado {

    public Ocupada(Terreno terreno, Recurso recurso, Entidad entidad) {
        this.entidad = entidad;
        this.recurso = recurso;
        this.terreno = terreno;
    }

    public void construir(Construible entidad, Almacen almacen){
        throw new CasillaOcupadaError();
    }

    public void sustituirUnidad(Unidad unidad,Almacen almacen){
        unidad.construir(terreno,almacen);
        entidad=unidad;
    }

    public void avanzarTurno() {
        entidad.avanzarTurno();
    }

    @Override
    public void cambiarEntidad(Entidad entidad) {
        this.entidad = entidad;
    }

    public void estaLibre(){
        throw new CasillaOcupadaError();
    }

}
