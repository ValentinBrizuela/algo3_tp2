package edu.fiuba.algo3.modelo.unidades;

import edu.fiuba.algo3.modelo.edificios.Construible;
import edu.fiuba.algo3.modelo.edificios.VidaProtoss;
import edu.fiuba.algo3.modelo.interfaces.*;
import edu.fiuba.algo3.modelo.juego.Casilla;
import edu.fiuba.algo3.modelo.razas.Protoss;

import java.util.ArrayList;

public class Dragon extends Unidad implements Atacante {

    private int rangoAtaque;
    private int escudo;

    public Dragon(Casilla casilla){
        super(new VidaProtoss(100, 80), 125, 50, 6, new Protoss(), casilla, new UnidadTerrestre(), new ArrayList<TipoDeUnidad>(){{
            add(new UnidadTerrestre(20));
            add(new UnidadAerea(20));
        }});

        this.escudo = 80;
        this.rangoAtaque = 4;
    }

    @Override
    public void recibirAtaque(int danio) {
        vida.recibirAtaque(danio);
    }

    @Override
    public void atacarA(Unidad unidad) {
        esUsable();
        unidad.estasEnRango(casilla, rangoAtaque);
        unidad.recibirAtaque(this.obtenerTiposDeAtaque());
    }

    @Override
    public void atacarA(Construible edificio) {
    }

    /*@Override
    public void atacarA(Unidad unidad) {
        unidadTerrestre.recibirAtaque(this.danioTerrestre);
    }*/

    @Override
    public void avanzarTurno() {
        tiempoConstruccion -= 1;
        /*regenerar*/
    }
}
