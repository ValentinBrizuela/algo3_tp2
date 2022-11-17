package edu.fiuba.algo3.modelo.unidades;

import edu.fiuba.algo3.modelo.edificios.Mina;
import edu.fiuba.algo3.modelo.edificios.VidaZerg;
import edu.fiuba.algo3.modelo.edificios.ZanganoTrabajador;
import edu.fiuba.algo3.modelo.interfaces.AtacableTerrestre;
import edu.fiuba.algo3.modelo.interfaces.Atacante;
import edu.fiuba.algo3.modelo.juego.Almacen;
import edu.fiuba.algo3.modelo.juego.Casilla;
import edu.fiuba.algo3.modelo.razas.Zerg;
import edu.fiuba.algo3.modelo.recursos.Mena;

import java.util.ArrayList;

public class Zangano extends Unidad implements Mina, AtacableTerrestre {

    private ZanganoTrabajador edificioDeExtraccion;

    public Zangano(Casilla casilla){
        super(new VidaZerg(25), 25, 0, 1, new Zerg(), casilla, new UnidadTerrestre());
        this.edificioDeExtraccion= null;
    }

    public void extraerMineral(Almacen almacen, Mena mena) {
        esUsable();
        edificioDeExtraccion.extraerMineral(almacen,mena);
    }

    public void asentarseEnMena(Casilla casilla,Almacen almacen) {
        esUsable();
        ZanganoTrabajador zanganoTrabajador=new ZanganoTrabajador(casilla);
        casilla.construir(zanganoTrabajador,almacen);
        edificioDeExtraccion=zanganoTrabajador;
    }

    @Override
    public void avanzarTurno() {
        tiempoConstruccion -= 1;
        /*regenerar*/
    }

    @Override
    public void recibirAtaque(Atacante atacante) {
        atacante.atacarA(this);
    }
}
