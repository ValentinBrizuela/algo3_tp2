package edu.fiuba.algo3.modelo.edificios;

import edu.fiuba.algo3.modelo.costos.CostoMineral;
import edu.fiuba.algo3.modelo.errores.ConstruccionNoPermitidaError;
import edu.fiuba.algo3.modelo.estados.Ocupada;
import edu.fiuba.algo3.modelo.interfaces.AtacableTerrestre;
import edu.fiuba.algo3.modelo.interfaces.Atacante;
import edu.fiuba.algo3.modelo.juego.*;
import edu.fiuba.algo3.modelo.razas.Protoss;
import edu.fiuba.algo3.modelo.recursos.Geiser;
import edu.fiuba.algo3.modelo.terrenos.Espacio;
import edu.fiuba.algo3.modelo.terrenos.Moho;
import edu.fiuba.algo3.modelo.terrenos.Tierra;
import edu.fiuba.algo3.modelo.terrenos.TierraEnergizada;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Asimilador extends Entidad implements RefineriaGas, Construible, AtacableTerrestre {

    public Asimilador(Casilla casilla) {
        super(new VidaProtoss(450, 450),new ArrayList<>(List.of(new CostoMineral(100))), 6, new Protoss(), casilla);
    }

    public void extraerGas(Almacen almacen, Geiser geiser){
        esUsable();
        geiser.extraerGas(20);
        almacen.almacenarGas(20);
    }

    @Override
    public void construir(Moho moho, Almacen almacen) {
        throw new ConstruccionNoPermitidaError();
    }

    @Override
    public void construir(Tierra tierra, Almacen almacen) {
        throw new ConstruccionNoPermitidaError();
    }

    @Override
    public void construir(TierraEnergizada tierraEnergizada, Almacen almacen) {
        this.cobrar(almacen);
        casilla.cambiarEstado(new Ocupada(tierraEnergizada, casilla.obtenerRecurso(), this));
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
        tiempoConstruccion -= 1;
        /* extraerGas() */
        vida.regenerar();
    }

}
