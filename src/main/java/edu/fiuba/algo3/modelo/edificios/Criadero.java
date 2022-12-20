package edu.fiuba.algo3.modelo.edificios;

import edu.fiuba.algo3.modelo.costos.CostoMineral;
import edu.fiuba.algo3.modelo.errores.ConstruccionNoPermitidaTerrenoError;
import edu.fiuba.algo3.modelo.terrenos.Espacio;
import edu.fiuba.algo3.modelo.terrenos.Moho;
import edu.fiuba.algo3.modelo.terrenos.Tierra;
import edu.fiuba.algo3.modelo.terrenos.TierraEnergizada;
import edu.fiuba.algo3.modelo.errores.ConstruccionNoPermitidaError;
import edu.fiuba.algo3.modelo.estados.Desocupada;
import edu.fiuba.algo3.modelo.estados.Ocupada;
import edu.fiuba.algo3.modelo.interfaces.AtacableTerrestre;
import edu.fiuba.algo3.modelo.interfaces.Atacante;
import edu.fiuba.algo3.modelo.juego.*;
import edu.fiuba.algo3.modelo.razas.Zerg;
import edu.fiuba.algo3.modelo.recursos.RecursoVacio;

import java.util.ArrayList;
import java.util.List;

public class Criadero extends Entidad implements Construible, AtacableTerrestre, EdificioConArea {
    private int cantidadLarvas;

    Casilla casilla;

    private int rango;
    private int contador;


    public Criadero(Casilla casilla){

        super(new VidaZerg(500), new ArrayList<>(List.of(new CostoMineral(200))), 4, new Zerg(), casilla);
        this.cantidadLarvas = 3;
        this.casilla = casilla;
        this.rango = 5;
        this.contador = 0;

    }
    public void engendrarZangano(){
        esUsable();
        cantidadLarvas -= 1;
    }

    @Override
    public void avanzarTurno() {
        if (cantidadLarvas() < 3) {
        cantidadLarvas += 1;
        }
        this.tiempoConstruccion -= 1;
        vida.regenerar();
        this.contador += 1;
        incrementarRango();
    }

    public void generarMoho(IMapa mapa) {
        for (int i = casilla.obtenerPosX() - rango; i <= casilla.obtenerPosX() + rango; i++) {
            for (int j = casilla.obtenerPosY() - rango; j <= casilla.obtenerPosY() + rango; j++) {

                if (mapa.estaDentroDelMapa(i, j)){

                    try{
                        mapa.obtenerCasilla(i, j).estaLibre();
                        mapa.obtenerCasilla(i, j).cambiarTerreno(new Moho());
                    } catch (Exception e){}

                }
            }
        }
    }

    private void incrementarRango() {
        try {
            esUsable();
            if (contador%2 == 0) {
                rango += 1;
            }
        } catch (Exception e){

        }
    }

    public int cantidadLarvas(){
        return this.cantidadLarvas;
    }

    @Override
    public void construir(Moho moho, Almacen almacen) {
        this.cobrar(almacen);
        casilla.cambiarEstado(new Ocupada(new Moho(), new RecursoVacio(), this)); //Cambiar esto
    }

    @Override
    public void construir(Tierra tierra, Almacen almacen) {
        this.cobrar(almacen);
        casilla.cambiarEstado(new Ocupada(new Moho(), new RecursoVacio(), this)); //Cambiar esto
    }

    @Override
    public void construir(TierraEnergizada tierraEnergizada, Almacen almacen) {
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
        generarMoho(mapa);
    }

    @Override
    public  void destruir(Jugador jugador,IMapa mapa){
           casilla.cambiarEstado(new Desocupada(casilla.obtenerTerreno(),casilla.obtenerRecurso()));
        jugador.degenerarPoblacion();
    }


}
