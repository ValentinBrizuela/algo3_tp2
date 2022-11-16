package edu.fiuba.algo3.modelo.unidades;

import edu.fiuba.algo3.modelo.edificios.Construible;
import edu.fiuba.algo3.modelo.edificios.VidaZerg;
import edu.fiuba.algo3.modelo.interfaces.Atacante;
import edu.fiuba.algo3.modelo.juego.Almacen;
import edu.fiuba.algo3.modelo.juego.Casilla;
import edu.fiuba.algo3.modelo.razas.Zerg;

import java.util.ArrayList;

public class Guardian extends Unidad  implements Atacante {


    private int rangoAtaque;

    public Guardian(Casilla casilla) {
        super(new VidaZerg(100), 50, 100, 4, new Zerg(), casilla,  new UnidadAerea(),  new ArrayList<TipoDeUnidad>(){{
            add(new UnidadTerrestre(25));
        }});
        this.rangoAtaque = 10;
    }

    @Override
    public void atacarA(Unidad unidad) {
        unidad.estasEnRango(casilla, rangoAtaque);
        unidad.recibirAtaque(this.obtenerTiposDeAtaque());
    }
    @Override
    public void recibirAtaque(int danio) {
        vida.recibirAtaque(danio);
    }

    @Override
    public void atacarA(Construible edificio) {

    }

    public void crear(Almacen almacen){
        almacen.cobrar(costo);
    }

    @Override
    public void avanzarTurno() {
        tiempoConstruccion -= 1;
        /*regenerar*/
    }
}
