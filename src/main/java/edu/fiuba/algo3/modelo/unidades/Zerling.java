package edu.fiuba.algo3.modelo.unidades;

import edu.fiuba.algo3.modelo.edificios.Edificio;
import edu.fiuba.algo3.modelo.errores.AtaqueInvalido;
import edu.fiuba.algo3.modelo.interfaces.*;
import edu.fiuba.algo3.modelo.juego.Casilla;
import edu.fiuba.algo3.modelo.razas.Zerg;

import java.util.ArrayList;

public class Zerling extends Unidad implements Atacante{

    private int rangoAtaque;



    public Zerling(Casilla casilla){
        super(35, 25, 0, 4, new Zerg(), casilla,new Terrestre(),new ArrayList<TipoDeUnidad>(){{
            add(new Terrestre(4));
        }});
        this.rangoAtaque = 1;
    }

    @Override
    public void atacarA(Unidad unidad) {
        unidad.estasEnRango(casilla, rangoAtaque);
        unidad.recibirAtaque(this.obtenerTiposDeAtaque());
    }

    @Override
    public void atacarA(Edificio edificio) {

    }

    @Override
    public void recibirAtaque(int danio) {
        vida -= danio;
    }

}
