package edu.fiuba.algo3.modelo.unidades;

import edu.fiuba.algo3.modelo.costos.CostoMineral;
import edu.fiuba.algo3.modelo.edificios.Construible;
import edu.fiuba.algo3.modelo.edificios.Mina;
import edu.fiuba.algo3.modelo.edificios.VidaZerg;
import edu.fiuba.algo3.modelo.estados.Desocupada;
import edu.fiuba.algo3.modelo.interfaces.AtacableTerrestre;
import edu.fiuba.algo3.modelo.interfaces.Atacante;
import edu.fiuba.algo3.modelo.juego.*;
import edu.fiuba.algo3.modelo.razas.Zerg;
import edu.fiuba.algo3.modelo.recursos.Mena;

import java.util.ArrayList;
import java.util.List;

public class Zangano extends Unidad implements Mina, AtacableTerrestre, ConsumidorDeSuministro, Construible {


    private int costoSuministro;
    private Almacen almacen;

    public Zangano(Casilla casilla, Almacen almacen){
        super(new VidaZerg(25), new ArrayList<>(List.of(new CostoMineral(25))), 1, new Zerg(), casilla, new UnidadTerrestre());
        this.costoSuministro=1;
        this.almacen=almacen;
    }

    public void extraerMineral(Almacen almacen, Mena mena) {
        esUsable();
        almacen.almacenarMineral(mena.extraer(10));
    }

    @Override
    public void avanzarTurno() {
        try{
            esUsable();
            casilla.intentarExtraerMineral(almacen,this);
        }catch (Exception e){

        } finally {
            tiempoConstruccion -= 1;
            vida.regenerar();
        }
    }

    @Override
    public void recibirAtaque(Atacante atacante, IMapa mapa) {
        atacante.atacarA(this);
    }

    public boolean tenesEspacioConEstaCapacidad(int capacidadUsable) {
        return costoSuministro<=capacidadUsable;
    }
    public void comunicarDescuentoDePoblacion(Poblacion poblacion){
        poblacion.utilizarPoblacion(costoSuministro);
    }

    @Override
    public boolean esAtacante() {
        return false;
    }

    public void meterseEnExtractor(){
        casilla.cambiarEstado(new Desocupada(casilla.obtenerTerreno(), casilla.obtenerRecurso()));
    }

}
