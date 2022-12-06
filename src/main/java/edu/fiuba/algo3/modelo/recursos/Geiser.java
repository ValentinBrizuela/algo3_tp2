package edu.fiuba.algo3.modelo.recursos;

import edu.fiuba.algo3.modelo.edificios.Construible;
import edu.fiuba.algo3.modelo.edificios.RefineriaGas;
import edu.fiuba.algo3.modelo.errores.ConstruccionNoPermitidaError;
import edu.fiuba.algo3.modelo.errores.NoHayMenaEnLaCasillaError;
import edu.fiuba.algo3.modelo.juego.Almacen;
import edu.fiuba.algo3.modelo.unidades.Zangano;


public class Geiser implements Recurso {

    private int cant;
    public Geiser() {
        this.cant = 5000;
    }

    public void construir(Construible entidad) {
        if (!(entidad instanceof RefineriaGas)) { // Resolver el instanceof
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

    public void intentarExtraerMineral(Almacen almacen, Zangano zangano){
        throw new NoHayMenaEnLaCasillaError();
    }
}
