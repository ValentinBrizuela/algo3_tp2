package edu.fiuba.algo3.modelo.recursos;

import edu.fiuba.algo3.modelo.edificios.Construible;
import edu.fiuba.algo3.modelo.edificios.Mina;
import edu.fiuba.algo3.modelo.errores.ConstruccionNoPermitidaError;

public class Mena implements Recurso {
    private int cant;
    public Mena() {
        cant = 2000;
    }

    public void construir(Construible edificio) {
        if (!(edificio instanceof Mina)) {
            throw new ConstruccionNoPermitidaError();
        }
    }

    public int extraer(int cant) {
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
