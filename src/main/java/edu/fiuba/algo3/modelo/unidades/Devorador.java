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
import edu.fiuba.algo3.modelo.juego.Mapa;
import edu.fiuba.algo3.modelo.razas.Zerg;

import java.util.ArrayList;
import java.util.List;

public class Devorador extends Unidad implements Atacante, AtacableAereo {
    private int rangoAtaque;
    private int danio;

    public Devorador(Casilla casilla){
        super(new VidaZerg(200), new ArrayList<>(List.of(new CostoMineral(150), new CostoGas(50))), 4, new Zerg(), casilla, new UnidadAerea());
        this.rangoAtaque = 5;
        this.danio = 15;
    }

    @Override
    public void recibirAtaque(Atacante atacante, Mapa mapa) {
        atacante.atacarA(this);
    }

    @Override
    public void atacarA(AtacableAereo atacableAereo) {
        esUsable();
        atacableAereo.estasEnRango(casilla, rangoAtaque);
        atacableAereo.aplicarDanio(danio);
    }

    @Override
    public void atacarA(AtacableTerrestre atacableTerrestre) {
        throw new AtaqueInvalidoError();
    }

    @Override
    public void avanzarTurno() {
        tiempoConstruccion -= 1;
        vida.regenerar();
    }

    public void crear(Almacen almacen){
        this.cobrar(almacen);
    }
}
