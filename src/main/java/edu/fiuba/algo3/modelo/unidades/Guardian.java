package edu.fiuba.algo3.modelo.unidades;

import edu.fiuba.algo3.modelo.edificios.Construible;
import edu.fiuba.algo3.modelo.edificios.VidaZerg;
import edu.fiuba.algo3.modelo.errores.AtaqueInvalidoError;
import edu.fiuba.algo3.modelo.interfaces.AtacableAereo;
import edu.fiuba.algo3.modelo.interfaces.AtacableTerrestre;
import edu.fiuba.algo3.modelo.interfaces.Atacante;
import edu.fiuba.algo3.modelo.juego.Almacen;
import edu.fiuba.algo3.modelo.juego.Casilla;
import edu.fiuba.algo3.modelo.razas.Zerg;

import java.util.ArrayList;

public class Guardian extends Unidad  implements Atacante, AtacableAereo {


    private int rangoAtaque;
    private int danio;

    public Guardian(Casilla casilla) {
        super(new VidaZerg(100), 50, 100, 4, new Zerg(), casilla,  new UnidadAerea(),  new ArrayList<TipoDeUnidad>(){{
            add(new UnidadTerrestre(25));
        }});
        this.rangoAtaque = 10;
        this.danio = 25;
    }

    @Override
    public void recibirAtaque(int danio) {
        vida.recibirAtaque(danio);
    }

    public void atacarA(AtacableTerrestre atacableTerrestre) {
        esUsable();
        atacableTerrestre.estasEnRango(casilla, rangoAtaque);
        atacableTerrestre.aplicarDanio(danio);
    }

    public void atacarA(AtacableAereo atacableAereo) {
        throw new AtaqueInvalidoError();
    }

    public void recibirAtaque(Atacante atacante) {
        atacante.atacarA(this);
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
