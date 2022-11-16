package edu.fiuba.algo3.modelo.unidades;

import edu.fiuba.algo3.modelo.edificios.Edificio;
import edu.fiuba.algo3.modelo.interfaces.*;
import edu.fiuba.algo3.modelo.juego.Casilla;
import edu.fiuba.algo3.modelo.razas.Protoss;

import java.util.ArrayList;
import java.util.List;

public class Dragon extends Unidad implements Atacante {

    private int rangoAtaque;
    private int escudo;

    public Dragon(Casilla casilla){
        super(100, 125, 50, 6, new Protoss(), casilla, new Terrestre(), new ArrayList<TipoDeUnidad>(){{
            add(new Terrestre(20));
            add(new Volador(20));
        }});

        this.escudo = 80;
        this.rangoAtaque = 4;
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
    public void atacarA(Unidad unidad) {
        unidad.estasEnRango(casilla, rangoAtaque);
        unidad.recibirAtaque(this.obtenerTiposDeAtaque());
    }

    @Override
    public void atacarA(Edificio edificio) {
    }

    /*@Override
    public void atacarA(Unidad unidad) {
        unidadTerrestre.recibirAtaque(this.danioTerrestre);
    }*/

    public int obtenerEscudo(){
        return escudo;
    }
}
