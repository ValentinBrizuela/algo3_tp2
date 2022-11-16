package edu.fiuba.algo3.modelo.unidades;

import edu.fiuba.algo3.modelo.edificios.Construible;
import edu.fiuba.algo3.modelo.edificios.VidaZerg;
import edu.fiuba.algo3.modelo.interfaces.Atacante;
import edu.fiuba.algo3.modelo.juego.Almacen;
import edu.fiuba.algo3.modelo.juego.Casilla;
import edu.fiuba.algo3.modelo.razas.Zerg;

import java.util.ArrayList;

public class Mutalisco extends Unidad  implements Atacante {


    private int rangoAtaque;

    public Mutalisco(Casilla casilla){
        super(new VidaZerg(120), 100, 100, 7, new Zerg(), casilla, new UnidadAerea(),  new ArrayList<TipoDeUnidad>(){{
            add(new UnidadTerrestre(9));
            add(new UnidadAerea(9));
        }});
        this.rangoAtaque = 3;
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

    public Guardian evolucionar(Almacen almacen) {
        esUsable();
        Guardian guardian=new Guardian(casilla);
        guardian.crear(almacen);

        return guardian;

    }

    @Override
    public void avanzarTurno() {
        tiempoConstruccion -= 1;
        /*regenerar*/
    }
}
