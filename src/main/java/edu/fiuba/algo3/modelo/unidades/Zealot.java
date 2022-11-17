package edu.fiuba.algo3.modelo.unidades;

import edu.fiuba.algo3.modelo.edificios.Construible;
import edu.fiuba.algo3.modelo.edificios.VidaProtoss;
import edu.fiuba.algo3.modelo.edificios.VidaZerg;
import edu.fiuba.algo3.modelo.interfaces.Atacante;
import edu.fiuba.algo3.modelo.juego.Casilla;
import edu.fiuba.algo3.modelo.razas.Protoss;
import edu.fiuba.algo3.modelo.razas.Zerg;

import java.util.ArrayList;

public class Zealot extends Unidad implements Atacante {

    private int rangoAtaque;

    public Zealot(Casilla casilla){
        super(new VidaProtoss(100, 60), 100, 0, 4, new Protoss(), casilla,new UnidadTerrestre(),new ArrayList<TipoDeUnidad>(){{
            add(new UnidadTerrestre(8));
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
    public void avanzarTurno() {
        tiempoConstruccion -= 1;
        /*regenerar*/
    }

    @Override
    public void recibirAtaque(int danio) {
        vida.recibirAtaque(danio);
    }
}
