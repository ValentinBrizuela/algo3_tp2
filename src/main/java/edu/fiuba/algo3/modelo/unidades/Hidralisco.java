package edu.fiuba.algo3.modelo.unidades;

import edu.fiuba.algo3.modelo.edificios.Construible;
import edu.fiuba.algo3.modelo.edificios.VidaZerg;
import edu.fiuba.algo3.modelo.errores.AtaqueInvalidoError;
import edu.fiuba.algo3.modelo.interfaces.AtacableAereo;
import edu.fiuba.algo3.modelo.interfaces.AtacableTerrestre;
import edu.fiuba.algo3.modelo.interfaces.Atacante;
import edu.fiuba.algo3.modelo.juego.Casilla;
import edu.fiuba.algo3.modelo.razas.Zerg;

import java.util.ArrayList;

public class Hidralisco extends Unidad implements Atacante, AtacableTerrestre {

    private int rangoAtaque;
    private int danioTerrestre;
    private int danioAereo;

    public Hidralisco(Casilla casilla){
        super(new VidaZerg(80), 75, 25, 4, new Zerg(), casilla,new UnidadTerrestre(),new ArrayList<TipoDeUnidad>(){{
            add(new UnidadTerrestre(10));
            add(new UnidadAerea(10));
        }});
        this.rangoAtaque = 4;
        this.danioAereo = 10;
        this.danioTerrestre = 10;
    }

    public void atacarA(AtacableTerrestre atacableTerrestre) {
        esUsable();
        atacableTerrestre.estasEnRango(casilla, rangoAtaque);
        atacableTerrestre.aplicarDanio(danioTerrestre);
    }


    public void atacarA(AtacableAereo atacableAereo) {
        esUsable();
        atacableAereo.estasEnRango(casilla, rangoAtaque);
        atacableAereo.aplicarDanio(danioTerrestre);
    }

    public void recibirAtaque(Atacante atacante) {
        atacante.atacarA(this);
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
