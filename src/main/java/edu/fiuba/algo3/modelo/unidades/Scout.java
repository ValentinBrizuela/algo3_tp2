package edu.fiuba.algo3.modelo.unidades;

import edu.fiuba.algo3.modelo.edificios.VidaProtoss;
import edu.fiuba.algo3.modelo.interfaces.*;
import edu.fiuba.algo3.modelo.juego.Casilla;
import edu.fiuba.algo3.modelo.juego.Poblacion;
import edu.fiuba.algo3.modelo.razas.Protoss;

public class Scout extends Unidad  implements Atacante, AtacableAereo, ConsumidorDeSuministro {

    private int rangoAtaque;
    private int danioTerrestre;
    private int danioAereo;

    private int costoSuministro;

    public Scout(Casilla casilla){
        super(new VidaProtoss(150, 100), 300, 150, 9, new Protoss(), casilla, new UnidadAerea());
        this.rangoAtaque = 4;
        this.danioAereo = 14;
        this.danioTerrestre = 8;
        this.costoSuministro=4;
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

    public void recibirAtaque(Atacante atacante) {
        atacante.atacarA(this);
    }

    @Override
    public void avanzarTurno() {
        tiempoConstruccion -= 1;
        /*regenerar*/
    }


    public boolean tenesEspacioConEstaCapacidad(int capacidadUsable) {
        return costoSuministro<=capacidadUsable;
    }
    public void comunicarDescuentoDePoblacion(Poblacion poblacion){
        poblacion.utilizarPoblacion(costoSuministro);
    }
}
