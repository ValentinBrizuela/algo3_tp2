package edu.fiuba.algo3.modelo.edificios;

import edu.fiuba.algo3.modelo.costos.CostoMineral;
import edu.fiuba.algo3.modelo.errores.ConstruccionNoPermitidaError;
import edu.fiuba.algo3.modelo.errores.ExtractorLlenoError;
import edu.fiuba.algo3.modelo.estados.Ocupada;
import edu.fiuba.algo3.modelo.interfaces.AtacableTerrestre;
import edu.fiuba.algo3.modelo.interfaces.Atacante;
import edu.fiuba.algo3.modelo.juego.*;
import edu.fiuba.algo3.modelo.razas.Zerg;
import edu.fiuba.algo3.modelo.recursos.Geiser;
import edu.fiuba.algo3.modelo.terrenos.Espacio;
import edu.fiuba.algo3.modelo.terrenos.Moho;
import edu.fiuba.algo3.modelo.terrenos.Tierra;
import edu.fiuba.algo3.modelo.terrenos.TierraEnergizada;

import java.util.ArrayList;
import java.util.List;

public class Extractor extends Entidad implements RefineriaGas, Construible, AtacableTerrestre {

    private int cantZanganos;
    private Almacen almacen;

    public Extractor(Casilla casilla, Almacen almacen){
        super(new VidaZerg(750),new ArrayList<>(List.of(new CostoMineral(100))), 6, new Zerg(), casilla);
        cantZanganos = 0;
        this.almacen = almacen;
    }

    @Override
    public void extraerGas(Almacen almacen, Geiser geiser) {
        esUsable();
        almacen.almacenarGas(geiser.extraerGas(cantZanganos*10));
    }

    public void meterZangano() {
        esUsable();
        if (cantZanganos == 3) {
            throw new ExtractorLlenoError();
        }
        cantZanganos += 1;
    }

    public void construir(Moho moho, Almacen almacen) {
        this.cobrar(almacen);
        casilla.cambiarEstado(new Ocupada(moho, casilla.obtenerRecurso(), this));
    }

    @Override
    public void construir(Tierra tierra, Almacen almacen) {
        throw new ConstruccionNoPermitidaError();
    }

    @Override
    public void construir(TierraEnergizada tierraEnergizada, Almacen almacen) {
        throw new ConstruccionNoPermitidaError();
    }

    @Override
    public void construir(Espacio espacio, Almacen almacen) {
        throw new ConstruccionNoPermitidaError();
    }

    public void recibirAtaque(Atacante atacante, IMapa mapa) {
        atacante.atacarA(this);
    }

    @Override
    public void avanzarTurno() {
        try{
            esUsable();
            casilla.intentarExtraerGas(almacen, this);
        } catch (Exception e){
        }

        tiempoConstruccion -= 1;
        vida.regenerar();
    }


}
