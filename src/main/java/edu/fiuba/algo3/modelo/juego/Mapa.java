package edu.fiuba.algo3.modelo.juego;

import edu.fiuba.algo3.modelo.errores.NroBasesImparesError;
import edu.fiuba.algo3.modelo.recursos.Geiser;
import edu.fiuba.algo3.modelo.recursos.Mena;
import edu.fiuba.algo3.modelo.recursos.RecursoVacio;
import edu.fiuba.algo3.modelo.terrenos.Tierra;

public class Mapa {

    private int nroBases;

    private int tamMapa;
    private Casilla[][] casillas;

    public Mapa(int nroBases){

        if (nroBases % 2 != 0 || nroBases < 2){
            throw new NroBasesImparesError();
        }

        this.nroBases = nroBases;
        this.tamMapa = nroBases*50;
        casillas = new Casilla[tamMapa][tamMapa];

        inicializarMapa();
        /* crear zonas espaciales */
        crearBasesEsquinas();
        crearBasesRandomYEspejadas();
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
    private void crearBase(int posX, int posY){
        for (int i=(posX - 10); i< (posX + 10); i++){
            for (int j=(posY - 10); j < (posY + 10); j++){

                if ((Math.floor(Math.random()*10)) % 2 == 0 && estaDentroDelMapa(i, j)){
                    if ((Math.floor(Math.random()*10)) % 2 == 0){
                        casillas[i][j] = new Casilla(i, j, new Tierra(), new Geiser());
                    }else{
                        casillas[i][j] = new Casilla(i, j, new Tierra(), new Mena());
                    }
                }
            }
        }
    }
    private void crearBasesEsquinas(){
        int posicionBase1 = (int) (nroBases*50*0.05);
        int posicionBase2 = (int) (nroBases*50*0.95);

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

    private boolean estaDentroDelMapa(int posX, int posY){
        if (posX < 0 || posY < 0){
            return false;
        }

        if (posX >= tamMapa || posY >= tamMapa){
            return false;
        }

        return true;
    }
}
