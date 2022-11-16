package edu.fiuba.algo3.modelo.estados;

import edu.fiuba.algo3.modelo.edificios.Edificio;
import edu.fiuba.algo3.modelo.juego.Almacen;
import edu.fiuba.algo3.modelo.recursos.Recurso;
import edu.fiuba.algo3.modelo.terrenos.Terreno;

public abstract class Estado {
    public Terreno terreno;
    public Recurso recurso;
    public Edificio edificio;

    public abstract void construir(Edificio edificio, Almacen almacen);

    public abstract void avanzarTurno();
}
