package edu.fiuba.algo3.modelo.juego;

import edu.fiuba.algo3.modelo.edificios.Costo;
import edu.fiuba.algo3.modelo.estados.Desocupada;
import edu.fiuba.algo3.modelo.interfaces.Atacable;
import edu.fiuba.algo3.modelo.razas.Raza;

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
            casilla.cambiarEstado(new Desocupada());
        }
    }

}
