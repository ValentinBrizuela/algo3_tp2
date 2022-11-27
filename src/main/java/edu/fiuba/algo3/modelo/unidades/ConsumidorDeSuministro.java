package edu.fiuba.algo3.modelo.unidades;

import edu.fiuba.algo3.modelo.juego.Poblacion;

public interface ConsumidorDeSuministro {

    public abstract boolean tenesEspacioConEstaCapacidad(int capacidadUsable);
    public abstract void comunicarDescuentoDePoblacion(Poblacion poblacion);
}
