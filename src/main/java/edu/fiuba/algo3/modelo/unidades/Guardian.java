package edu.fiuba.algo3.modelo.unidades;

import edu.fiuba.algo3.modelo.edificios.Edificio;
import edu.fiuba.algo3.modelo.errores.AtaqueInvalido;
import edu.fiuba.algo3.modelo.interfaces.Atacante;
import edu.fiuba.algo3.modelo.juego.Almacen;
import edu.fiuba.algo3.modelo.juego.Casilla;
import edu.fiuba.algo3.modelo.razas.Zerg;

import java.util.ArrayList;

public class Guardian extends Unidad  implements Atacante {


    private int rangoAtaque;

    public Guardian(Casilla casilla) {
        super(100, 50, 100, 4, new Zerg(), casilla,  new Volador(),  new ArrayList<TipoDeUnidad>(){{
            add(new Terrestre(25));
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
        vida -= danio;
    }

    @Override
    public void atacarA(Edificio edificio) {

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
