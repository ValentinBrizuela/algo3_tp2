package edu.fiuba.algo3.modelo.edificios;

import edu.fiuba.algo3.modelo.costos.Costo;
import edu.fiuba.algo3.modelo.costos.CostoMineral;
import edu.fiuba.algo3.modelo.errores.ConstruccionNoPermitidaError;
import edu.fiuba.algo3.modelo.estados.Ocupada;
import edu.fiuba.algo3.modelo.interfaces.AtacableTerrestre;
import edu.fiuba.algo3.modelo.interfaces.Atacante;
import edu.fiuba.algo3.modelo.juego.*;
import edu.fiuba.algo3.modelo.razas.Protoss;
import edu.fiuba.algo3.modelo.recursos.Mena;
import edu.fiuba.algo3.modelo.recursos.RecursoVacio;
import edu.fiuba.algo3.modelo.terrenos.Espacio;
import edu.fiuba.algo3.modelo.terrenos.Moho;
import edu.fiuba.algo3.modelo.terrenos.Tierra;
import edu.fiuba.algo3.modelo.terrenos.TierraEnergizada;

import java.util.ArrayList;
import java.util.List;

public class NexoMineral extends Entidad implements Mina, Construible, AtacableTerrestre {

    private Almacen almacen;

    public NexoMineral(Casilla casilla, Almacen almacen) {
        super(new VidaProtoss(250, 250), new ArrayList<>(List.of(new CostoMineral(50))), 4, new Protoss(), casilla);
        this.almacen = almacen;
    }
    public void extraerMineral(Almacen almacen, Mena mena) {
        esUsable();
        almacen.almacenarMineral(mena.extraer(20));
    }

    @Override
    public void construir(Tierra tierra, Almacen almacen) {
        this.cobrar(almacen);
        casilla.cambiarEstado(new Ocupada(new TierraEnergizada(), new RecursoVacio(), this));
    }

    public void construir(TierraEnergizada tierraEnergizada, Almacen almacen) {
        this.cobrar(almacen);
        casilla.cambiarEstado(new Ocupada(tierraEnergizada, casilla.obtenerRecurso(), this));
    }

    @Override
    public void construir(Moho moho, Almacen almacen) {
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
            casilla.intentarExtraerMineral(almacen, this);
        } catch (Exception e){
        }

        tiempoConstruccion -= 1;
        vida.regenerar();
    }

}
