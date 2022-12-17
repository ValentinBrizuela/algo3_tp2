package edu.fiuba.algo3.modelo.estados;

import edu.fiuba.algo3.modelo.edificios.Construible;
import edu.fiuba.algo3.modelo.juego.Almacen;
import edu.fiuba.algo3.modelo.recursos.Recurso;
import edu.fiuba.algo3.modelo.terrenos.Terreno;
import edu.fiuba.algo3.modelo.unidades.Unidad;

public class Desocupada extends Estado {


    public Desocupada(Terreno terreno, Recurso recurso) {
            this.terreno = terreno;
            this.recurso = recurso;
            this.entidad = null;
    }

    public void construir(Construible entidad, Almacen almacen){
        recurso.construir(entidad);
        terreno.construir(entidad, almacen);
    }


    public void sustituirUnidad(Unidad unidad,Almacen almacen){
    }


    public void avanzarTurno() {
    }

    public void estaLibre(){}

}
