package edu.fiuba.algo3.modelo.recursos;

import edu.fiuba.algo3.modelo.edificios.Edificio;
import edu.fiuba.algo3.modelo.edificios.Mina;
import edu.fiuba.algo3.modelo.errores.ConstruccionNoPermitidaError;

public class Mena extends Recurso {
    private int cant;
    public Mena() {
        cant = 2000;
    }

    public void construir(Edificio edificio) {
        if (!(edificio instanceof Mina)) {
            throw new ConstruccionNoPermitidaError();
        }
    }

    public int extraer(int cant) {
        if (this.cant - cant >= 0) {
            this.cant -= cant;
            return cant;
        }
        return 0;
    }
}
