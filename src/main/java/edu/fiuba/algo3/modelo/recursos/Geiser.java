package edu.fiuba.algo3.modelo.recursos;

import edu.fiuba.algo3.modelo.edificios.Edificio;
import edu.fiuba.algo3.modelo.edificios.RefineriaGas;
import edu.fiuba.algo3.modelo.errores.ConstruccionNoPermitidaError;
import edu.fiuba.algo3.modelo.errores.RecursosInsuficientes;

public class Geiser extends Recurso {

    private int cant;
    public Geiser() {
        this.cant = 5000;
    }

    public void construir(Edificio edificio) {
        if (!(edificio instanceof RefineriaGas)) {
            throw new ConstruccionNoPermitidaError();
        }
    }

    public void extraerGas(int cant) {
        if (this.cant <= 0) {
            throw new RecursosInsuficientes();
        }
        this.cant -= cant;
    }
}
