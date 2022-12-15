package edu.fiuba.algo3.modelo.unidades;

import edu.fiuba.algo3.modelo.costos.CostoGas;
import edu.fiuba.algo3.modelo.costos.CostoMineral;
import edu.fiuba.algo3.modelo.edificios.Construible;
import edu.fiuba.algo3.modelo.edificios.VidaProtoss;
import edu.fiuba.algo3.modelo.interfaces.*;
import edu.fiuba.algo3.modelo.juego.Casilla;
import edu.fiuba.algo3.modelo.juego.IMapa;
import edu.fiuba.algo3.modelo.juego.Mapa;
import edu.fiuba.algo3.modelo.juego.Poblacion;
import edu.fiuba.algo3.modelo.razas.Protoss;

import java.util.ArrayList;
import java.util.List;

public class Dragon extends Unidad implements Atacante, AtacableTerrestre, ConsumidorDeSuministro, Construible {

    private int rangoAtaque;

    private int danioTerrestre;

    private int danioAereo;
    private int costoSuministro;

    public Dragon(Casilla casilla){
        super(new VidaProtoss(100, 80), new ArrayList<>(List.of(new CostoMineral(125), new CostoGas(50))), 6, new Protoss(), casilla, new UnidadTerrestre());

        this.rangoAtaque = 4;
        this.danioAereo = 20;
        this.danioTerrestre = 20;
        this.costoSuministro=3;
    }

    public void atacarA(AtacableTerrestre atacableTerrestre) {
        esUsable();
        atacableTerrestre.estasEnRango(casilla, rangoAtaque);
        atacableTerrestre.aplicarDanio(danioTerrestre);
    }


    public void atacarA(AtacableAereo atacableAereo) {
        esUsable();
        atacableAereo.estasEnRango(casilla, rangoAtaque);
        atacableAereo.aplicarDanio(danioAereo);
    }

    public void recibirAtaque(Atacante atacante, IMapa mapa) {
        atacante.atacarA(this);
    }

    @Override
    public void avanzarTurno() {
        tiempoConstruccion -= 1;
        vida.regenerar();
    }

    public boolean tenesEspacioConEstaCapacidad(int capacidadUsable) {
        return costoSuministro<=capacidadUsable;
    }
    public void comunicarDescuentoDePoblacion(Poblacion poblacion){
        poblacion.utilizarPoblacion(costoSuministro);
    }
}
