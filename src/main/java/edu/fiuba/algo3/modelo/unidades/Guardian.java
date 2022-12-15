package edu.fiuba.algo3.modelo.unidades;

import edu.fiuba.algo3.modelo.costos.CostoGas;
import edu.fiuba.algo3.modelo.costos.CostoMineral;
import edu.fiuba.algo3.modelo.edificios.VidaZerg;
import edu.fiuba.algo3.modelo.errores.AtaqueInvalidoError;
import edu.fiuba.algo3.modelo.interfaces.AtacableAereo;
import edu.fiuba.algo3.modelo.interfaces.AtacableTerrestre;
import edu.fiuba.algo3.modelo.interfaces.Atacante;
import edu.fiuba.algo3.modelo.juego.Almacen;
import edu.fiuba.algo3.modelo.juego.Casilla;
import edu.fiuba.algo3.modelo.juego.IMapa;
import edu.fiuba.algo3.modelo.juego.Mapa;
import edu.fiuba.algo3.modelo.razas.Zerg;

import java.util.ArrayList;
import java.util.List;

public class Guardian extends Unidad  implements Atacante, AtacableAereo {


    private int rangoAtaque;
    private int danio;

    public Guardian(Casilla casilla, Almacen almacen) {
        super(new VidaZerg(100), new ArrayList<>(List.of(new CostoMineral(50), new CostoGas(100))), 4, new Zerg(), casilla,  new UnidadAerea());
        this.rangoAtaque = 10;
        this.danio = 25;
        casilla.sustituirUnidad(this,almacen);
    }

    public void atacarA(AtacableTerrestre atacableTerrestre) {
        esUsable();
        atacableTerrestre.estasEnRango(casilla, rangoAtaque);
        atacableTerrestre.aplicarDanio(danio);
    }

    public void atacarA(AtacableAereo atacableAereo) {
        throw new AtaqueInvalidoError();
    }

    public void recibirAtaque(Atacante atacante, IMapa mapa) {
        atacante.atacarA(this);
    }

    /*public void crear(Almacen almacen){
        this.cobrar(almacen);
    }*/

    @Override
    public void avanzarTurno() {
        tiempoConstruccion -= 1;
        vida.regenerar();
    }

}
