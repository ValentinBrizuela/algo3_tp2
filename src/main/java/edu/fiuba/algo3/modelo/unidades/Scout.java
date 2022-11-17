package edu.fiuba.algo3.modelo.unidades;

import edu.fiuba.algo3.modelo.edificios.Construible;
import edu.fiuba.algo3.modelo.edificios.VidaProtoss;
import edu.fiuba.algo3.modelo.interfaces.*;
import edu.fiuba.algo3.modelo.juego.Casilla;
import edu.fiuba.algo3.modelo.razas.Protoss;

import java.util.ArrayList;

public class Scout extends Unidad  implements Atacante, AtacableAereo {

    private int rangoAtaque;
    private int danioTerrestre;
    private int danioAereo;

    public Scout(Casilla casilla){
        super(new VidaProtoss(150, 100), 300, 150, 9, new Protoss(), casilla, new UnidadAerea());
        this.rangoAtaque = 4;
        this.danioAereo = 14;
        this.danioTerrestre = 8;
    }

    public void atacarA(AtacableTerrestre atacableTerrestre) {
        esUsable();
        atacableTerrestre.estasEnRango(casilla, rangoAtaque);
        atacableTerrestre.aplicarDanio(danioTerrestre);
    }


    public void atacarA(AtacableAereo atacableAereo) {
        esUsable();
        atacableAereo.estasEnRango(casilla, rangoAtaque);
        atacableAereo.aplicarDanio(danioAereo);
    }

    public void recibirAtaque(Atacante atacante) {
        atacante.atacarA(this);
    }

    @Override
    public void avanzarTurno() {
        tiempoConstruccion -= 1;
        /*regenerar*/
    }
}
