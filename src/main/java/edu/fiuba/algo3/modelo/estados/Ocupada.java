package edu.fiuba.algo3.modelo.estados;

import edu.fiuba.algo3.modelo.edificios.Construible;
import edu.fiuba.algo3.modelo.errores.CasillaOcupadaError;
import edu.fiuba.algo3.modelo.errores.EdificioYaConstruidoError;
import edu.fiuba.algo3.modelo.errores.MovimientoInvalidoError;
import edu.fiuba.algo3.modelo.juego.Almacen;
import edu.fiuba.algo3.modelo.juego.Entidad;
import edu.fiuba.algo3.modelo.recursos.Recurso;
import edu.fiuba.algo3.modelo.terrenos.Terreno;

public class Ocupada extends Estado {

    public Ocupada(Terreno terreno, Recurso recurso, Entidad entidad) {
        this.entidad = entidad;
        this.recurso = recurso;
        this.terreno = terreno;
    }

    public void construir(Construible edificio, Almacen almacen){
        throw new CasillaOcupadaError();
    }

    public void avanzarTurno() {
        entidad.avanzarTurno();
    }

    public void estaLibre(){
        throw new CasillaOcupadaError();
    }

    @Override
    public boolean tieneEntidad(Class entidad) {
        return this.entidad.getClass() == entidad;
    }
}
