package edu.fiuba.algo3.modelo.unidades;

import edu.fiuba.algo3.modelo.edificios.EdificioVacio;
import edu.fiuba.algo3.modelo.edificios.Mina;
import edu.fiuba.algo3.modelo.edificios.ZanganoTrabajador;
import edu.fiuba.algo3.modelo.juego.Almacen;
import edu.fiuba.algo3.modelo.juego.Casilla;
import edu.fiuba.algo3.modelo.razas.Zerg;
import edu.fiuba.algo3.modelo.recursos.Mena;

import java.util.ArrayList;

public class Zangano extends Unidad implements Mina {

    private ZanganoTrabajador edificioDeExtraccion;

    public Zangano(Casilla casilla){
        super(25, 25, 0, 1, new Zerg(), casilla, new Terrestre(), new ArrayList<TipoDeUnidad>(){{}});
        this.edificioDeExtraccion= null;
    }

    public void extraerMineral(Almacen almacen, Mena mena) {
        edificioDeExtraccion.extraerMineral(almacen,mena);
    }

    public void asentarseEnMena(Casilla casilla,Almacen almacen) {
        ZanganoTrabajador zanganoTrabajador=new ZanganoTrabajador(casilla);
        casilla.construir(zanganoTrabajador,almacen);
        edificioDeExtraccion=zanganoTrabajador;
    }

    @Override
    public void recibirAtaque(int danio) {
        vida -= danio;
    }
}
