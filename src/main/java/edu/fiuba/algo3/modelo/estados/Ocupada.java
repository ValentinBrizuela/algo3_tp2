package edu.fiuba.algo3.modelo.estados;

import edu.fiuba.algo3.modelo.edificios.Construible;
import edu.fiuba.algo3.modelo.errores.EdificioYaConstruidoError;
import edu.fiuba.algo3.modelo.juego.Almacen;
import edu.fiuba.algo3.modelo.juego.Entidad;
import edu.fiuba.algo3.modelo.recursos.Recurso;
import edu.fiuba.algo3.modelo.terrenos.Terreno;

public class Ocupada extends Estado {

    public Ocupada(Terreno terreno, Recurso recurso, Entidad edificio) {
        this.entidad = edificio;
        this.recurso = recurso;
        this.terreno = terreno;
    }

    public void construir(Construible edificio, Almacen almacen){
        throw new EdificioYaConstruidoError();
    }

    public void avanzarTurno() {
        entidad.avanzarTurno();
    }
}
