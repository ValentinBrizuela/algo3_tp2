package edu.fiuba.algo3.modelo.unidades;

import edu.fiuba.algo3.modelo.edificios.Construible;
import edu.fiuba.algo3.modelo.edificios.VidaZerg;
import edu.fiuba.algo3.modelo.interfaces.Atacante;
import edu.fiuba.algo3.modelo.juego.Casilla;
import edu.fiuba.algo3.modelo.razas.Zerg;

import java.util.ArrayList;

public class Hidralisco extends Unidad implements Atacante {

    private int rangoAtaque;

    public Hidralisco(Casilla casilla){
        super(new VidaZerg(80), 75, 25, 4, new Zerg(), casilla,new UnidadTerrestre(),new ArrayList<TipoDeUnidad>(){{
            add(new UnidadTerrestre(10));
            add(new UnidadAerea(10));
        }});
        this.rangoAtaque = 4;
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
    public void avanzarTurno() {
        tiempoConstruccion -= 1;
        /*regenerar*/
    }

    @Override
    public void recibirAtaque(int danio) {
        vida.recibirAtaque(danio);
    }
}
