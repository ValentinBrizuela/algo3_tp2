package edu.fiuba.algo3.modelo.unidades;

import edu.fiuba.algo3.modelo.edificios.Construible;
import edu.fiuba.algo3.modelo.edificios.VidaZerg;
import edu.fiuba.algo3.modelo.interfaces.*;
import edu.fiuba.algo3.modelo.juego.Casilla;
import edu.fiuba.algo3.modelo.razas.Zerg;

import java.util.ArrayList;

public class Zerling extends Unidad implements Atacante{

    private int rangoAtaque;



    public Zerling(Casilla casilla){
        super(new VidaZerg(35), 25, 0, 4, new Zerg(), casilla,new UnidadTerrestre(),new ArrayList<TipoDeUnidad>(){{
            add(new UnidadTerrestre(4));
        }});
        this.rangoAtaque = 1;
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

    @Override
    public void recibirAtaque(int danio) {
        vida.recibirAtaque(danio);
    }

    @Override
    public void avanzarTurno() {
        tiempoConstruccion -= 1;
        /*regenerar*/
    }
}
