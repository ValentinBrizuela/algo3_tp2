package edu.fiuba.algo3.modelo.unidades;

import edu.fiuba.algo3.modelo.edificios.Edificio;
import edu.fiuba.algo3.modelo.interfaces.*;
import edu.fiuba.algo3.modelo.juego.Casilla;
import edu.fiuba.algo3.modelo.razas.Protoss;

public class Dragon extends UnidadTerrestre implements Atacante {

    private int danioTerrestre;
    private int danioAereo;
    private int rangoAtaque;
    private int escudo;

    public Dragon(Casilla casilla){
        super(100, 125, 50, 6, new Protoss(), casilla);
        this.danioTerrestre = 20;
        this.danioAereo = 20;
        this.escudo = 80;
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
    public void atacarA(UnidadVoladora unidadVoladora) {
        unidadVoladora.recibirAtaque(this.danioAereo);
    }

    @Override
    public void atacarA(Edificio edificio) {
    }

    @Override
    public void atacarA(UnidadTerrestre unidadTerrestre) {
        unidadTerrestre.recibirAtaque(this.danioTerrestre);
    }

    public int obtenerEscudo(){
        return escudo;
    }
}
