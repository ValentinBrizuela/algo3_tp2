package edu.fiuba.algo3.modelo.estados;

import edu.fiuba.algo3.modelo.edificios.Edificio;
import edu.fiuba.algo3.modelo.edificios.EdificioProtoss;
import edu.fiuba.algo3.modelo.edificios.EdificioVacio;
import edu.fiuba.algo3.modelo.estados.Estado;
import edu.fiuba.algo3.modelo.juego.Almacen;
import edu.fiuba.algo3.modelo.juego.Casilla;
import edu.fiuba.algo3.modelo.recursos.Recurso;
import edu.fiuba.algo3.modelo.recursos.RecursoVacio;
import edu.fiuba.algo3.modelo.terrenos.Terreno;
import edu.fiuba.algo3.modelo.terrenos.Tierra;

public class Desocupada extends Estado {


    public Desocupada(Terreno terreno, Recurso recurso) {
            this.terreno = terreno;
            this.recurso = recurso;
            this.edificio = null;
    }

    public void construir(Edificio edificio, Almacen almacen){
        terreno.construir(edificio, almacen);
        recurso.construir(edificio);
    }

    public void avanzarTurno() {
    }

}
