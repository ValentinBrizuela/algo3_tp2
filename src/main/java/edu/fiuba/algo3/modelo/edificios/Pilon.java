package edu.fiuba.algo3.modelo.edificios;

import edu.fiuba.algo3.modelo.errores.ConstruccionNoPermitidaError;
import edu.fiuba.algo3.modelo.estados.Desocupada;
import edu.fiuba.algo3.modelo.estados.Estado;
import edu.fiuba.algo3.modelo.estados.Ocupada;
import edu.fiuba.algo3.modelo.interfaces.AtacableTerrestre;
import edu.fiuba.algo3.modelo.interfaces.Atacante;
import edu.fiuba.algo3.modelo.juego.Almacen;
import edu.fiuba.algo3.modelo.juego.Casilla;
import edu.fiuba.algo3.modelo.juego.Entidad;
import edu.fiuba.algo3.modelo.juego.Mapa;
import edu.fiuba.algo3.modelo.razas.Protoss;
import edu.fiuba.algo3.modelo.recursos.RecursoVacio;
import edu.fiuba.algo3.modelo.terrenos.*;

public class Pilon extends Entidad implements Construible, AtacableTerrestre {
    private int rango;
    private Mapa mapa;
    public Pilon(Mapa mapa, Casilla casilla) {
        super(new VidaProtoss(300, 300), 100, 0, 5, new Protoss(), casilla);
        this.mapa = mapa;
        this.rango = 3;
        generar(new TierraEnergizada());
    }

    @Override
    public void avanzarTurno() {
        tiempoConstruccion -= 1;
        vida.regenerar();
        generar(new TierraEnergizada());
    }

    public void generar(Terreno terreno) {
        for (int i = casilla.obtenerPosX()-rango; i <= casilla.obtenerPosX()+rango; i++) {
            for (int j = casilla.obtenerPosY()-rango; j <= casilla.obtenerPosY()+rango; j++) {
                if (!(mapa.obtenerCasilla(i, j).obtenerEstado().obtenerTerreno().getClass() == Moho.class)) {
                    mapa.obtenerCasilla(i, j).cambiarTerreno(terreno);
                }
            }
        }
    }

    public void construir(TierraEnergizada tierraEnergizada, Almacen almacen) {
        almacen.cobrar(this.costo);
        casilla.cambiarEstado(new Ocupada(tierraEnergizada, casilla.obtenerRecurso(), this));
    }

    @Override
    public void construir(Tierra tierra, Almacen almacen) {
        almacen.cobrar(this.costo);
        casilla.cambiarEstado(new Ocupada(tierra, casilla.obtenerRecurso(), this));
    }

    @Override
    public void construir(Moho moho, Almacen almacen) {
        throw new ConstruccionNoPermitidaError();
    }

    @Override
    public void construir(Espacio espacio, Almacen almacen) {
        throw new ConstruccionNoPermitidaError();
    }


    public void recibirAtaque(Atacante atacante) {
        atacante.atacarA(this);
    }
}
