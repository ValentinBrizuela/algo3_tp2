package edu.fiuba.algo3.modelo.juego;

import edu.fiuba.algo3.modelo.errores.NroBasesImparesError;
import edu.fiuba.algo3.modelo.recursos.Geiser;
import edu.fiuba.algo3.modelo.recursos.Mena;
import edu.fiuba.algo3.modelo.recursos.RecursoVacio;
import edu.fiuba.algo3.modelo.terrenos.Tierra;
import edu.fiuba.algo3.modelo.unidades.AmoSupremo;

public class FakeMapa implements IMapa{
    private int nroBases;

    private int tamMapa;
    private Casilla[][] casillas;

    public FakeMapa(int nroBases){

        if (nroBases % 2 != 0 || nroBases < 2){
            throw new NroBasesImparesError();
        }

        this.nroBases = nroBases;
        this.tamMapa = nroBases*10;
        casillas = new Casilla[tamMapa][tamMapa];

        inicializarMapa();
        crearBasesEsquinas();
    }

    public int tamanioMapa() {
        return tamMapa;
    }

    public Casilla obtenerCasilla(int i, int j) {
        return casillas[i][j];
    }

    public void avanzarTurno(){
        for (Casilla[] Filacasilla : casillas){
            for (Casilla casilla : Filacasilla) {
                casilla.avanzarTurno();
            }
        }
    }

    private void inicializarMapa(){
        for (int i=0; i<tamMapa; i++){
            for (int j=0; j<tamMapa; j++){
                casillas[i][j] = new Casilla(i, j, new Tierra(), new RecursoVacio());
            }
        }

    }

    private void crearBasesEsquinas(){
        casillas[3][3] = new Casilla(3, 3, new Tierra(), new Geiser());
        casillas[3][4] = new Casilla(3, 4, new Tierra(), new Mena());
        casillas[4][4] = new Casilla(3, 4, new Tierra(), new Mena());


        casillas[17][17] = new Casilla(17, 17, new Tierra(), new Geiser());
        casillas[17][18] = new Casilla(17, 18, new Tierra(), new Mena());
        casillas[18][18] = new Casilla(17, 18, new Tierra(), new Mena());
    }



    public boolean estaDentroDelMapa(int posX, int posY){
        if (posX < 0 || posY < 0){
            return false;
        }

        if (posX >= tamanioMapa() || posY >= tamanioMapa()){
            return false;
        }

        return true;
    }

    public boolean hayDetector(int x, int y, int radio) {
        for (int i = x - radio; i <= x + radio ; i++) {
            for (int j = y -radio; j <= y + radio; j++) {

                Entidad entidad = this.obtenerEntidad(i, j);
                try {
                    if (entidad.esDetector()) {
                        return true;
                    }
                } catch (Exception e){
                }
            }
        }
        return false;
    }

    @Override
    public Entidad obtenerEntidad(int x, int y) {
        return casillas[x][y].obtenerEntidad();
    }
}
