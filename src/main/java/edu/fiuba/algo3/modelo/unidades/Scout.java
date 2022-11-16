package edu.fiuba.algo3.modelo.unidades;

import edu.fiuba.algo3.modelo.edificios.Edificio;
import edu.fiuba.algo3.modelo.interfaces.*;
import edu.fiuba.algo3.modelo.juego.Casilla;
import edu.fiuba.algo3.modelo.razas.Protoss;

import java.util.ArrayList;

public class Scout extends Unidad  implements Atacante {

    private int escudo;

    private int rangoAtaque;

    public Scout(Casilla casilla){
        super(150, 300, 150, 9, new Protoss(), casilla, new UnidadAerea(), new ArrayList<TipoDeUnidad>(){{
            add(new UnidadTerrestre(8));
            add(new UnidadAerea(14));
        }});
        this.escudo = 100;
        this.rangoAtaque = 4;
    }

    @Override
    public void atacarA(Unidad unidad) {
        esUsable();
        unidad.estasEnRango(casilla, rangoAtaque);
        unidad.recibirAtaque(this.obtenerTiposDeAtaque());
    }

    @Override
    public void recibirAtaque(int danio) {
        if (danio > escudo) {
            vida -= (danio - escudo);
            escudo = 0;
        }
        else {
            escudo -= danio;
        }
    }

    @Override
    public void atacarA(Edificio edificio) {

    }

    @Override
    public void avanzarTurno() {
        tiempoConstruccion -= 1;
        /*regenerar*/
    }
}
