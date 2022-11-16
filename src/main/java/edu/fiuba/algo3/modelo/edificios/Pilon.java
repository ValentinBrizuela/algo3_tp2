package edu.fiuba.algo3.modelo.edificios;

import edu.fiuba.algo3.modelo.estados.Desocupada;
import edu.fiuba.algo3.modelo.estados.Estado;
import edu.fiuba.algo3.modelo.estados.Ocupada;
import edu.fiuba.algo3.modelo.juego.Almacen;
import edu.fiuba.algo3.modelo.juego.Casilla;
import edu.fiuba.algo3.modelo.juego.Mapa;
import edu.fiuba.algo3.modelo.razas.Protoss;
import edu.fiuba.algo3.modelo.recursos.RecursoVacio;
import edu.fiuba.algo3.modelo.terrenos.Moho;
import edu.fiuba.algo3.modelo.terrenos.Terreno;
import edu.fiuba.algo3.modelo.terrenos.Tierra;
import edu.fiuba.algo3.modelo.terrenos.TierraEnergizada;

public class Pilon extends EdificioProtoss {
    private int rango;
    private Mapa mapa;
    public Pilon(Mapa mapa, Casilla casilla) {
        super(300, 300, 5, 100, 0, casilla);
        this.mapa = mapa;
        this.rango = 3;
        generar(new TierraEnergizada());
    }
    @Override
    public void avanzarTurno() {
        tiempoConstruccion -= 1;
        this.regenerar();
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

    @Override
    public void recibirDanio(int cant){
        if (cant > escudo) {
            vida -= (cant - escudo);
            escudo = 0;
        }
        else {
            escudo -= cant;
        }

        if (estaDestruido()){
            Estado estado = casilla.obtenerEstado();
            casilla.cambiarEstado(new Desocupada(estado.obtenerTerreno(), estado.obtenerRecurso()));
            generar(new Tierra());
        }
    }

    @Override
    public void construir(Tierra tierra, Almacen almacen) {
        almacen.cobrar(this.costo);
        casilla.cambiarEstado(new Ocupada(new TierraEnergizada(), new RecursoVacio(), this));
    }
}
