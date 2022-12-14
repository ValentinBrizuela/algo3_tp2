package edu.fiuba.algo3.modelo.recursos;

import edu.fiuba.algo3.modelo.edificios.Construible;
import edu.fiuba.algo3.modelo.edificios.Mina;
import edu.fiuba.algo3.modelo.edificios.RefineriaGas;
import edu.fiuba.algo3.modelo.juego.Almacen;
import edu.fiuba.algo3.modelo.unidades.Zangano;

public interface Recurso {

    public abstract void construir(Construible entidad);

    public void intentarExtraerMineral(Almacen almacen, Mina mina);

    public void intentarExtraerGas(Almacen almacen, RefineriaGas refineria);

}
