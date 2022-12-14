package edu.fiuba.algo3.modelo.unidades;

import edu.fiuba.algo3.modelo.costos.CostoMineral;
import edu.fiuba.algo3.modelo.edificios.Construible;
import edu.fiuba.algo3.modelo.edificios.VidaProtoss;
import edu.fiuba.algo3.modelo.errores.AtaquePorAireInvalidoError;
import edu.fiuba.algo3.modelo.errores.ZealotInvisibleError;
import edu.fiuba.algo3.modelo.interfaces.AtacableAereo;
import edu.fiuba.algo3.modelo.interfaces.AtacableTerrestre;
import edu.fiuba.algo3.modelo.interfaces.Atacante;
import edu.fiuba.algo3.modelo.juego.Casilla;
import edu.fiuba.algo3.modelo.juego.IMapa;
import edu.fiuba.algo3.modelo.juego.Poblacion;
import edu.fiuba.algo3.modelo.razas.Protoss;

import java.util.ArrayList;
import java.util.List;

public class Zealot extends Unidad implements Atacante, AtacableTerrestre, ConsumidorDeSuministro, Construible {

    private int rangoAtaque;
    private int danio;
    private int costoSuministro;

    private int cantMuertes;

    public Zealot(Casilla casilla){
        super(new VidaProtoss(100, 60), new ArrayList<>(List.of(new CostoMineral(100))), 4, new Protoss(), casilla,new UnidadTerrestre());
        this.rangoAtaque = 1;
        this.danio = 8;
        this.costoSuministro=2;
        this.cantMuertes = 0;
    }

    public void atacarA(AtacableTerrestre atacableTerrestre) {
        esUsable();
        atacableTerrestre.estasEnRango(casilla, rangoAtaque);
        atacableTerrestre.aplicarDanio(danio);
        if (atacableTerrestre.estaDestruido()) {
            cantMuertes += 1;
        }
    }

    public void atacarA(AtacableAereo atacableAereo) {
        throw new AtaquePorAireInvalidoError();
    }

    public void recibirAtaque(Atacante atacante, IMapa mapa) {
        if (cantMuertes < 3 || mapa.hayDetector(casilla.obtenerPosX(), casilla.obtenerPosY(), 4)) {
            atacante.atacarA(this);
        }
        else {
            throw new ZealotInvisibleError();
        }
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
