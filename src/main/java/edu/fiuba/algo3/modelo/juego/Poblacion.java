package edu.fiuba.algo3.modelo.juego;

import edu.fiuba.algo3.modelo.errores.PoblacionInsuficienteError;
import edu.fiuba.algo3.modelo.unidades.ConsumidorDeSuministro;

public class Poblacion {

    private int capacidad;
    private int capacidadMaxima;
    private int capacidadEnUso;

    public Poblacion(){
        capacidad=0;
        capacidadEnUso=0;
        capacidadMaxima=200;
    }

    public void verificarYDescontarCapacidad(ConsumidorDeSuministro unidad){
        if(!unidad.tenesEspacioConEstaCapacidad(this.cantidadUsable())){
            throw new PoblacionInsuficienteError();
        }else{
            unidad.comunicarDescuentoDePoblacion(this);
        }
    }

    public int cantidadUsable(){
        if(capacidad-capacidadEnUso<0){
            return 0;
        }
        return capacidad-capacidadEnUso;
    }

    public int cantidadEnUso(){
        return capacidadEnUso;
    }

    public void aumentarPoblacion(){
        if(capacidad<capacidadMaxima) {
            capacidad += 5;
        }
    }
    public void disminuirPoblacion(){
        capacidad-=5;
    }

    public void utilizarPoblacion(int suministroConsumido){

        capacidadEnUso += suministroConsumido;
    }

}
