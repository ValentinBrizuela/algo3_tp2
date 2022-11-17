package edu.fiuba.algo3.modelo.unidades;

import edu.fiuba.algo3.modelo.edificios.Construible;
import edu.fiuba.algo3.modelo.edificios.VidaZerg;
import edu.fiuba.algo3.modelo.errores.AtaqueInvalidoError;
import edu.fiuba.algo3.modelo.interfaces.*;
import edu.fiuba.algo3.modelo.juego.Casilla;
import edu.fiuba.algo3.modelo.razas.Zerg;

import java.util.ArrayList;

public class Zerling extends Unidad implements Atacante, AtacableTerrestre{

    private int rangoAtaque;
    private int danio;



    public Zerling(Casilla casilla){
        super(new VidaZerg(35), 25, 0, 2, new Zerg(), casilla,new UnidadTerrestre(),new ArrayList<TipoDeUnidad>(){{
            add(new UnidadTerrestre(4));
        }});
        this.rangoAtaque = 1;
        this.danio = 4;
    }

    @Override
    public void atacarA(AtacableTerrestre atacableTerrestre) {
        esUsable();
        atacableTerrestre.estasEnRango(casilla, rangoAtaque);
        atacableTerrestre.aplicarDanio(danio);
    }

    @Override
    public void atacarA(AtacableAereo atacableAereo) {
        throw new AtaqueInvalidoError();
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
