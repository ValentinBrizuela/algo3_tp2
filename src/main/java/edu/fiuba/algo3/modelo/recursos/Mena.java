package edu.fiuba.algo3.modelo.recursos;

import edu.fiuba.algo3.modelo.edificios.Construible;
import edu.fiuba.algo3.modelo.edificios.Mina;
import edu.fiuba.algo3.modelo.edificios.RefineriaGas;
import edu.fiuba.algo3.modelo.errores.ConstruccionNoPermitidaError;
import edu.fiuba.algo3.modelo.errores.NoHayGasEnLaCasillaError;
import edu.fiuba.algo3.modelo.juego.Almacen;
import edu.fiuba.algo3.modelo.unidades.Zangano;

public class Mena implements Recurso {
    private int cant;
    public Mena() {
        cant = 2000;
    }

    public void construir(Construible entidad) {
        if (!(entidad instanceof Mina)) {
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

    public void intentarExtraerMineral(Almacen almacen, Mina mina){
        mina.extraerMineral(almacen,this);
    }

    @Override
    public void intentarExtraerGas(Almacen almacen, RefineriaGas refineria) {
        throw new NoHayGasEnLaCasillaError();
    }
}
