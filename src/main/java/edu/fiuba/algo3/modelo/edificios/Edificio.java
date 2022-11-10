package edu.fiuba.algo3.modelo.edificios;

import edu.fiuba.algo3.modelo.juego.Almacen;
import edu.fiuba.algo3.modelo.juego.Casilla;
import edu.fiuba.algo3.modelo.razas.Raza;

public abstract class Edificio {
    protected int vida;

    protected int vidaMax;
    protected int tiempoConstruccion;
    protected Costo costo;

    protected int contadorTurnos;

    protected Casilla casilla;

    public Edificio(int vida, int tiempoConstruccion, int costoMinerales, int costoGas, Casilla casilla) {
        this.costo = new Costo(costoMinerales, costoGas);
        this.vida = vida;
        this.vidaMax = vida;
        this.tiempoConstruccion = tiempoConstruccion;
        this.casilla = casilla;
        this.contadorTurnos = 0;
    }

    public boolean esUsable() {
        return this.tiempoConstruccion < 1;
    }

    public abstract void atacar(int dano);

    public abstract void regenerar();

    public int tiempoDeConstruccion() {
        return tiempoConstruccion;
    }

    public boolean puedoComprar(Almacen almacen){
        return costo.puedoComprar(almacen);
    }

    public Costo obtenerCosto(){
        return this.costo;
    }

    public int vida() {
        return this.vida;
    }

    public abstract void avanzarTurno();
}
