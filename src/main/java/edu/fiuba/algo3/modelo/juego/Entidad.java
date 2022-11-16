package edu.fiuba.algo3.modelo.juego;

import edu.fiuba.algo3.modelo.edificios.Costo;
import edu.fiuba.algo3.modelo.errores.AtaqueInvalido;
import edu.fiuba.algo3.modelo.estados.Desocupada;
import edu.fiuba.algo3.modelo.estados.Estado;
import edu.fiuba.algo3.modelo.interfaces.Atacable;
import edu.fiuba.algo3.modelo.razas.Raza;

import java.util.concurrent.Callable;

public abstract class Entidad implements Atacable {
    protected int vida;
    protected Costo costo;
    protected int tiempoConstruccion;
    protected Raza raza;
    protected Casilla casilla;

    public Entidad(int vida, int costoMineral, int costoGas, int tiempoConstruccion, Raza raza, Casilla casilla){
        this.vida = vida;
        this.costo = new Costo(costoMineral, costoGas);
        this.tiempoConstruccion = tiempoConstruccion;
        this.raza = raza;
        this.casilla = casilla;
    }

    public int obtenerVida(){
        return vida;
    }

    public void meQuedeSinVida() {
        if (vida <= 0){
            Estado estado = casilla.obtenerEstado();
            casilla.cambiarEstado(new Desocupada(estado.terreno, estado.recurso));
        }
    }

    public void estasEnRango(Casilla casilla, int rango){
        if (!(this.casilla.estasEnRango(casilla.obtenerPosX(), casilla.obtenerPosY(), rango))){
            throw new AtaqueInvalido();
        }
    }

}
