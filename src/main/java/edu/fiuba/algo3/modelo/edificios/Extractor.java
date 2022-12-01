package edu.fiuba.algo3.modelo.edificios;

import edu.fiuba.algo3.modelo.errores.ConstruccionNoPermitidaError;
import edu.fiuba.algo3.modelo.errores.ExtractorLlenoError;
import edu.fiuba.algo3.modelo.estados.Ocupada;
import edu.fiuba.algo3.modelo.interfaces.AtacableTerrestre;
import edu.fiuba.algo3.modelo.interfaces.Atacante;
import edu.fiuba.algo3.modelo.juego.Almacen;
import edu.fiuba.algo3.modelo.juego.Casilla;
import edu.fiuba.algo3.modelo.juego.Entidad;
import edu.fiuba.algo3.modelo.juego.Mapa;
import edu.fiuba.algo3.modelo.razas.Zerg;
import edu.fiuba.algo3.modelo.recursos.Geiser;
import edu.fiuba.algo3.modelo.terrenos.Espacio;
import edu.fiuba.algo3.modelo.terrenos.Moho;
import edu.fiuba.algo3.modelo.terrenos.Tierra;
import edu.fiuba.algo3.modelo.terrenos.TierraEnergizada;

public class Extractor extends Entidad implements RefineriaGas, Construible, AtacableTerrestre {

    private int cantZanganos;

    public Extractor(Casilla casilla){
        super(new VidaZerg(750),100, 0, 6, new Zerg(), casilla);
        cantZanganos = 0;
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
        almacen.cobrar(this.costo);
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

    public void recibirAtaque(Atacante atacante, Mapa mapa) {
        atacante.atacarA(this);
    }

    @Override
    public void avanzarTurno() {
        tiempoConstruccion -= 1;
        vida.regenerar();
    }


}
