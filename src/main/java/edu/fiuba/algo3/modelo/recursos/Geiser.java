package edu.fiuba.algo3.modelo.recursos;

import edu.fiuba.algo3.modelo.edificios.Construible;
import edu.fiuba.algo3.modelo.edificios.Mina;
import edu.fiuba.algo3.modelo.edificios.RefineriaGas;
import edu.fiuba.algo3.modelo.errores.ConstruccionNoPermitidaError;
import edu.fiuba.algo3.modelo.errores.ConstruccionNoPermitidaRecursoError;
import edu.fiuba.algo3.modelo.errores.ConstruccionNoPermitidaTerrenoError;
import edu.fiuba.algo3.modelo.errores.NoHayMenaEnLaCasillaError;
import edu.fiuba.algo3.modelo.juego.Almacen;
import edu.fiuba.algo3.modelo.unidades.Zangano;


public class Geiser implements Recurso {

    private int cant;
    public Geiser() {
        this.cant = 5000;
    }

    public void construir(Construible entidad) {
        if (!(entidad.puedeExtraerDeGeiser())) { // Resolver el instanceof
            throw new ConstruccionNoPermitidaRecursoError();
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

    public void intentarExtraerMineral(Almacen almacen, Mina mina){
        throw new NoHayMenaEnLaCasillaError();
    }

    @Override
    public void intentarExtraerGas(Almacen almacen, RefineriaGas refineria) {
        refineria.extraerGas(almacen, this);
    }
}
