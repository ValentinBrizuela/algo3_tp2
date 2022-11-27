package edu.fiuba.algo3.modelo.unidades;

import edu.fiuba.algo3.modelo.edificios.VidaZerg;
import edu.fiuba.algo3.modelo.interfaces.AtacableAereo;
import edu.fiuba.algo3.modelo.interfaces.AtacableTerrestre;
import edu.fiuba.algo3.modelo.interfaces.Atacante;
import edu.fiuba.algo3.modelo.juego.Almacen;
import edu.fiuba.algo3.modelo.juego.Casilla;
import edu.fiuba.algo3.modelo.juego.Poblacion;
import edu.fiuba.algo3.modelo.razas.Zerg;

public class Mutalisco extends Unidad  implements Atacante, AtacableAereo, ConsumidorDeSuministro {


    private int rangoAtaque;
    private int danioTerrestre;
    private int danioAereo;
    private int costoSuministro;

    public Mutalisco(Casilla casilla){
        super(new VidaZerg(120), 100, 100, 7, new Zerg(), casilla, new UnidadAerea());
        this.rangoAtaque = 3;
        this.danioAereo = 9;
        this.danioTerrestre = 9;
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
        atacableAereo.aplicarDanio(danioTerrestre);
    }

    public void recibirAtaque(Atacante atacante) {
        atacante.atacarA(this);
    }

    public Guardian evolucionar(Almacen almacen) {
        esUsable();
        Guardian guardian=new Guardian(casilla);
        guardian.crear(almacen);

        return guardian;

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
