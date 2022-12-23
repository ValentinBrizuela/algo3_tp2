package edu.fiuba.algo3.modelo.juego;

import edu.fiuba.algo3.modelo.errores.NroBasesImparesError;
import edu.fiuba.algo3.modelo.recursos.Geiser;
import edu.fiuba.algo3.modelo.recursos.Mena;
import edu.fiuba.algo3.modelo.recursos.RecursoVacio;
import edu.fiuba.algo3.modelo.terrenos.Espacio;
import edu.fiuba.algo3.modelo.terrenos.Tierra;
import edu.fiuba.algo3.modelo.unidades.AmoSupremo;

public class Mapa implements IMapa{

    final int tamanioMapaPorBases = 50;
    final int tamanioBase = 10;
    final int tamanioEspacio = 10;
    final double principio = 0.05;
    final double ultimo = 0.95;

    private int nroBases;

    private int tamMapa;
    private Casilla[][] casillas;

    public Mapa(int nroBases){

        if (nroBases % 2 != 0 || nroBases < 2){
            throw new NroBasesImparesError();
        }

        this.nroBases = nroBases;
        this.tamMapa = nroBases*tamanioMapaPorBases;
        casillas = new Casilla[tamMapa][tamMapa];

        inicializarMapa();
        crearEspaciosRandom();
        crearBasesEsquinas();
        crearBasesRandomYEspejadas();
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

                if ((Math.floor(Math.random()*300)) < 1){

                    if ((Math.floor(Math.random()*10)) % 2 == 0){
                        casillas[i][j] = new Casilla(i, j, new Tierra(), new Geiser());
                    }else{
                        casillas[i][j] = new Casilla(i, j, new Tierra(), new Mena());
                    }

                } else {
                    casillas[i][j] = new Casilla(i, j, new Tierra(), new RecursoVacio());
                }
            }
        }

    }

    private void crearEspaciosRandom(){
        for ( int i = 0; i < 2; i++) {
            int num1 = (int)(Math.random()*((tamMapa-30)-30+1)+30);
            int num2 = (int)(Math.random()*((tamMapa-30)-30+1)+30);
            crearEspacio(num1, num2);
        }
    }
    private void crearBase(int posX, int posY){
        for (int i=(posX - tamanioBase); i< (posX + tamanioBase); i++){
            for (int j=(posY - tamanioBase); j < (posY + tamanioBase); j++){

                if ((Math.floor(Math.random()*10)) % 10 == 0 && estaDentroDelMapa(i, j)){
                    if ((Math.floor(Math.random()*10)) % 2 == 0){
                        casillas[i][j] = new Casilla(i, j, new Tierra(), new Geiser());
                    }else{
                        casillas[i][j] = new Casilla(i, j, new Tierra(), new Mena());
                    }
                }
            }
        }
    }

    private void crearEspacio(int posX, int posY) {
        for (int i=(posX - tamanioEspacio); i< (posX + tamanioEspacio); i++){
            for (int j=(posY - tamanioEspacio); j < (posY + tamanioEspacio); j++){
                casillas[i][j] = new Casilla(i, j, new Espacio(), new RecursoVacio());
            }
        }
    }

    private void crearBasesEsquinas(){
        int posicionBase1 = (int) (nroBases*(tamMapa/nroBases)*principio);
        int posicionBase2 = (int) (nroBases*(tamMapa/nroBases)*ultimo);

        this.crearBase(posicionBase1, posicionBase1);
        this.crearBase(posicionBase2, posicionBase2);
    }

    private void crearBasesRandomYEspejadas(){
        int nroBasesRandom = (nroBases - 2) / 2;

        if (nroBasesRandom == 0){ return;}

        for (int i=0; i<nroBasesRandom; i++){
            int posicionRandomX = (int) (Math.random()*tamMapa);
            int posicionRandomY = (int) (Math.random()*tamMapa);

            crearBase(posicionRandomX, posicionRandomY);
            crearBase(tamMapa - posicionRandomX, tamMapa - posicionRandomY);
        }
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

    public Entidad obtenerEntidad(int x, int y) {
        return casillas[x][y].obtenerEntidad();
    }

}
