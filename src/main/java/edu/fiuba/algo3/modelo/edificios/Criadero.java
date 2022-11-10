package edu.fiuba.algo3.modelo.edificios;

import edu.fiuba.algo3.modelo.errores.EdificioEnConstruccionError;
import edu.fiuba.algo3.modelo.juego.Mapa;
import edu.fiuba.algo3.modelo.razas.Zerg;
import edu.fiuba.algo3.modelo.terrenos.Moho;

public class Criadero extends EdificioZerg {
    private int cantidadLarvas;
    private int x;
    private int y;
    private Mapa mapa;

    private int radio;
    private int contador;


    public Criadero(Mapa mapa, int x, int y){

        super(500, 4, 50, 0);
        this.cantidadLarvas = 3;
        this.x = x;
        this.y = y;
        this.mapa = mapa;
        this.radio = 5;
        this.contador = 0;
        this.raza = new Zerg();
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
        incrementarRadio();
    }

    public void generarMoho() {
        for (int i = x-radio; i <= x+radio; i++) {
            for (int j = y-radio; j <= y+radio; j++) {
                mapa.obtenerCasilla(i, j).cambiarTerreno(new Moho());
            }
        }
    }

    private void incrementarRadio() {
        if (contador%2 == 0) {
            radio += 1;
        }
    }

    public int cantidadLarvas(){
        return this.cantidadLarvas;
    }

}
