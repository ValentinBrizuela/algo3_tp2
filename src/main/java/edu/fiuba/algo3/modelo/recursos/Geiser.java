package edu.fiuba.algo3.modelo.recursos;

import edu.fiuba.algo3.modelo.edificios.Construible;
import edu.fiuba.algo3.modelo.edificios.RefineriaGas;
import edu.fiuba.algo3.modelo.errores.ConstruccionNoPermitidaError;


public class Geiser extends Recurso {

    private int cant;
    public Geiser() {
        this.cant = 5000;
    }

    public void construir(Construible edificio) {
        if (!(edificio instanceof RefineriaGas)) {
            throw new ConstruccionNoPermitidaError();
        }
    }

    public int extraerGas(int cant) {
        if (this.cant - cant >= 0) {
            this.cant -= cant;
            return cant;
        }
        if ((this.cant - cant)>-cant && (this.cant - cant)<0){
            int restante;
            restante=this.cant;
            this.cant=0;
            return restante;
        }
        return 0;
    }
}
