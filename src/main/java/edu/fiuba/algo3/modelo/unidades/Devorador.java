package edu.fiuba.algo3.modelo.unidades;

import edu.fiuba.algo3.modelo.costos.CostoGas;
import edu.fiuba.algo3.modelo.costos.CostoMineral;
import edu.fiuba.algo3.modelo.edificios.VidaZerg;
import edu.fiuba.algo3.modelo.errores.AtaqueInvalidoError;
import edu.fiuba.algo3.modelo.estados.Ocupada;
import edu.fiuba.algo3.modelo.interfaces.AtacableAereo;
import edu.fiuba.algo3.modelo.interfaces.AtacableTerrestre;
import edu.fiuba.algo3.modelo.interfaces.Atacante;
import edu.fiuba.algo3.modelo.juego.Almacen;
import edu.fiuba.algo3.modelo.juego.Casilla;
import edu.fiuba.algo3.modelo.juego.IMapa;
import edu.fiuba.algo3.modelo.juego.Mapa;
import edu.fiuba.algo3.modelo.razas.Zerg;
import edu.fiuba.algo3.modelo.terrenos.Terreno;

import java.util.ArrayList;
import java.util.List;

public class Devorador extends Unidad implements Atacante, AtacableAereo {
    private int rangoAtaque;
    private int danio;

    public Devorador(Casilla casilla, Almacen almacen){
        super(new VidaZerg(200), new ArrayList<>(List.of(new CostoMineral(150), new CostoGas(50))), 4, new Zerg(), casilla, new UnidadAerea());
        this.rangoAtaque = 5;
        this.danio = 15;
        casilla.sustituirUnidad(this,almacen);
    }

    @Override
    public void recibirAtaque(Atacante atacante, IMapa mapa) {
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
    @Override
    public void construir(Terreno terreno, Almacen almacen){
        this.cobrar(almacen);
    }
}
