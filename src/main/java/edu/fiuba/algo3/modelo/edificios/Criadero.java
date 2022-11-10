package edu.fiuba.algo3.modelo.edificios;

import edu.fiuba.algo3.modelo.errores.EdificioEnConstruccionError;
import edu.fiuba.algo3.modelo.estados.Desocupada;
import edu.fiuba.algo3.modelo.juego.Casilla;
import edu.fiuba.algo3.modelo.juego.Mapa;
import edu.fiuba.algo3.modelo.razas.Zerg;
import edu.fiuba.algo3.modelo.terrenos.Moho;

public class Criadero extends EdificioZerg {
    private int cantidadLarvas;

    Casilla casilla;
    private Mapa mapa;

    private int rango;
    private int contador;


    public Criadero(Mapa mapa, Casilla casilla){

        super(500, 4, 50, 0, casilla);
        this.cantidadLarvas = 3;
        this.casilla = casilla;
        this.mapa = mapa;
        this.rango = 5;
        this.contador = 0;
        generarMoho();
    }
    public void engendrarZangano(){
        if (!esUsable()) {
            throw new EdificioEnConstruccionError();
        }
        cantidadLarvas -= 1;
    }

    @Override
    public void avanzarTurno() {
        if (cantidadLarvas() < 3) {
        cantidadLarvas += 1;
        }
        this.tiempoConstruccion -= 1;
        this.regenerar();
        this.contador += 1;
        generarMoho();
        incrementarRango();
    }

    public void generarMoho() {
        for (int i = casilla.obtenerPosX()-rango; i <= casilla.obtenerPosX()+rango; i++) {
            for (int j = casilla.obtenerPosY()-rango; j <= casilla.obtenerPosY()+rango; j++) {
                mapa.obtenerCasilla(i, j).cambiarTerreno(new Moho());
            }
        }
    }

    private void incrementarRango() {
        if (contador%2 == 0) {
            rango += 1;
        }
    }

    public int cantidadLarvas(){
        return this.cantidadLarvas;
    }

    @Override
    public void atacar(int danio){
        vida -= danio;
        if (estaDestruido()){
            casilla.cambiarEstado(new Desocupada());
            casilla.cambiarEdificio(new EdificioVacio(casilla));
        }
    }

}
