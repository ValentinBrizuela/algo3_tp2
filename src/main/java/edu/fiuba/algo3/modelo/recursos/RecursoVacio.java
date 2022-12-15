package edu.fiuba.algo3.modelo.recursos;

import edu.fiuba.algo3.modelo.edificios.Construible;
import edu.fiuba.algo3.modelo.edificios.Mina;
import edu.fiuba.algo3.modelo.edificios.RefineriaGas;
import edu.fiuba.algo3.modelo.errores.NoHayGasEnLaCasillaError;
import edu.fiuba.algo3.modelo.errores.NoHayMenaEnLaCasillaError;
import edu.fiuba.algo3.modelo.juego.Almacen;
import edu.fiuba.algo3.modelo.unidades.Zangano;

public class RecursoVacio implements Recurso {

    public void construir(Construible entidad) {
    }

    public void intentarExtraerMineral(Almacen almacen, Mina mina){
        throw new NoHayMenaEnLaCasillaError();
    }

    @Override
    public void intentarExtraerGas(Almacen almacen, RefineriaGas refineria) {
        throw new NoHayGasEnLaCasillaError();
    }
}
