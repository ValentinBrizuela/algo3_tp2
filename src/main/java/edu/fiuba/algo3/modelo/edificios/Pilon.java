package edu.fiuba.algo3.modelo.edificios;

import edu.fiuba.algo3.modelo.costos.CostoMineral;
import edu.fiuba.algo3.modelo.errores.ConstruccionNoPermitidaError;
import edu.fiuba.algo3.modelo.errores.ConstruccionNoPermitidaTerrenoError;
import edu.fiuba.algo3.modelo.estados.Desocupada;
import edu.fiuba.algo3.modelo.estados.Ocupada;
import edu.fiuba.algo3.modelo.interfaces.AtacableTerrestre;
import edu.fiuba.algo3.modelo.interfaces.Atacante;
import edu.fiuba.algo3.modelo.juego.*;
import edu.fiuba.algo3.modelo.razas.Protoss;
import edu.fiuba.algo3.modelo.terrenos.*;

import java.util.ArrayList;
import java.util.List;

public class Pilon extends Entidad implements Construible, AtacableTerrestre,EdificioConArea {
    private int rango;

    public Pilon(Casilla casilla) {
        super(new VidaProtoss(300, 300), new ArrayList<>(List.of(new CostoMineral(100))), 5, new Protoss(), casilla);
        this.rango = 3;

    }

    @Override
    public void avanzarTurno() {
        tiempoConstruccion -= 1;
        vida.regenerar();
    }

    public void generar(Terreno terreno, IMapa mapa) {
            for (int i = casilla.obtenerPosX()-rango; i <= casilla.obtenerPosX()+rango; i++) {
                for (int j = casilla.obtenerPosY()-rango; j <= casilla.obtenerPosY()+rango; j++) {

                    try {
                        mapa.obtenerCasilla(i, j).cambiarTerreno(terreno);
                    } catch (Exception e){}

                }
            }
    }

    public void construir(TierraEnergizada tierraEnergizada, Almacen almacen) {
        this.cobrar(almacen);
        casilla.cambiarEstado(new Ocupada(tierraEnergizada, casilla.obtenerRecurso(), this));
    }

    @Override
    public void construir(Tierra tierra, Almacen almacen) {
        this.cobrar(almacen);
        casilla.cambiarEstado(new Ocupada(tierra, casilla.obtenerRecurso(), this));
    }

    @Override
    public void construir(Moho moho, Almacen almacen) {
        throw new ConstruccionNoPermitidaTerrenoError();
    }

    @Override
    public void construir(Espacio espacio, Almacen almacen) {
        throw new ConstruccionNoPermitidaTerrenoError();
    }


    public void recibirAtaque(Atacante atacante, IMapa mapa) {
        atacante.atacarA(this);
    }

    public void actualizarTerreno(IMapa mapa){
        if (!estaDestruido()) {
            generar(new TierraEnergizada(),mapa);
        }
    }
    @Override
    public  void destruir(Jugador jugador,IMapa mapa){
        casilla.cambiarEstado(new Desocupada(casilla.obtenerTerreno(),casilla.obtenerRecurso()));
        generar(new Tierra(),mapa);
        jugador.degenerarPoblacion();
    }

}
