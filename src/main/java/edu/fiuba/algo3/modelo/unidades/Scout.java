package edu.fiuba.algo3.modelo.unidades;

import edu.fiuba.algo3.modelo.edificios.Edificio;
import edu.fiuba.algo3.modelo.interfaces.*;
import edu.fiuba.algo3.modelo.juego.Casilla;
import edu.fiuba.algo3.modelo.razas.Protoss;

public class Scout extends UnidadVoladora  implements Atacante {

    private int escudo;
    private int danioAereo;
    private int danioTerrestre;

    private int rangoAtaque;

    public Scout(Casilla casilla){
        super(150, 300, 150, 9, new Protoss(), casilla);
        this.danioAereo = 14;
        this.danioTerrestre = 8;
        this.escudo = 100;
        this.rangoAtaque = 4;
    }

    @Override
    public void atacarA(UnidadVoladora unidadVoladora) {
        unidadVoladora.estasEnRango(casilla, rangoAtaque);
        unidadVoladora.recibirAtaque(danioAereo);
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
    public void atacarA(UnidadTerrestre unidadTerrestre) {
        unidadTerrestre.recibirAtaque(danioTerrestre);
    }

    @Override
    public void atacarA(Edificio edificio) {

    }
}
