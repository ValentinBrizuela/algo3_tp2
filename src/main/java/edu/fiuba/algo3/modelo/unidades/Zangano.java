package edu.fiuba.algo3.modelo.unidades;

import edu.fiuba.algo3.modelo.edificios.Mina;
import edu.fiuba.algo3.modelo.edificios.VidaZerg;
import edu.fiuba.algo3.modelo.edificios.ZanganoTrabajador;
import edu.fiuba.algo3.modelo.interfaces.AtacableTerrestre;
import edu.fiuba.algo3.modelo.interfaces.Atacante;
import edu.fiuba.algo3.modelo.juego.Almacen;
import edu.fiuba.algo3.modelo.juego.Casilla;
import edu.fiuba.algo3.modelo.juego.Mapa;
import edu.fiuba.algo3.modelo.juego.Poblacion;
import edu.fiuba.algo3.modelo.razas.Zerg;
import edu.fiuba.algo3.modelo.recursos.Mena;

public class Zangano extends Unidad implements Mina, AtacableTerrestre, ConsumidorDeSuministro {

    private ZanganoTrabajador edificioDeExtraccion;

    private int costoSuministro;

    public Zangano(Casilla casilla){
        super(new VidaZerg(25), 25, 0, 1, new Zerg(), casilla, new UnidadTerrestre());
        this.edificioDeExtraccion= null;
        this.costoSuministro=1;
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
    public void recibirAtaque(Atacante atacante, Mapa mapa) {
        atacante.atacarA(this);
    }

    public boolean tenesEspacioConEstaCapacidad(int capacidadUsable) {
        return costoSuministro<=capacidadUsable;
    }
    public void comunicarDescuentoDePoblacion(Poblacion poblacion){
        poblacion.utilizarPoblacion(costoSuministro);
    }
}
