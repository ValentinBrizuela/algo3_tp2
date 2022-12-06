package edu.fiuba.algo3.modelo.recursos;

import edu.fiuba.algo3.modelo.edificios.Construible;
import edu.fiuba.algo3.modelo.errores.NoHayMenaEnLaCasillaError;
import edu.fiuba.algo3.modelo.juego.Almacen;
import edu.fiuba.algo3.modelo.unidades.Unidad;
import edu.fiuba.algo3.modelo.unidades.Zangano;

public class RecursoVacio implements Recurso {

    public void construir(Construible edificio) {
    }

    public void intentarExtraerMineral(Almacen almacen, Zangano zangano){
        throw new NoHayMenaEnLaCasillaError();
    }
}
