package edu.fiuba.algo3.modelo.edificios;

import edu.fiuba.algo3.modelo.errores.ConstruccionNoPermitidaError;
import edu.fiuba.algo3.modelo.estados.Desocupada;
import edu.fiuba.algo3.modelo.estados.Ocupada;
import edu.fiuba.algo3.modelo.interfaces.AtacableTerrestre;
import edu.fiuba.algo3.modelo.interfaces.Atacante;
import edu.fiuba.algo3.modelo.juego.*;
import edu.fiuba.algo3.modelo.razas.Protoss;
import edu.fiuba.algo3.modelo.terrenos.*;

public class Pilon extends Entidad implements Construible, AtacableTerrestre,EdificioConArea {
    private int rango;

    public Pilon(Casilla casilla) {
        super(new VidaProtoss(300, 300), 100, 0, 5, new Protoss(), casilla);
        this.rango = 3;

    }

    @Override
    public void avanzarTurno() {
        tiempoConstruccion -= 1;
        vida.regenerar();
    }

    public void generar(Terreno terreno, Mapa mapa) {
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


    public void recibirAtaque(Atacante atacante, Mapa mapa) {
        atacante.atacarA(this);
    }

    public void actualizarTerreno(Mapa mapa){
        generar(new TierraEnergizada(),mapa);
    }
    @Override
    public  void destruir(Jugador jugador,Mapa mapa){
        casilla.cambiarEstado(new Desocupada(casilla.obtenerTerreno(),casilla.obtenerRecurso()));
        generar(new Tierra(),mapa);
        jugador.degenerarPoblacion();
    }

}
