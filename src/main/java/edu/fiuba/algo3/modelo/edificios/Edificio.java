package edu.fiuba.algo3.modelo.edificios;

import edu.fiuba.algo3.modelo.juego.Almacen;
import edu.fiuba.algo3.modelo.razas.Raza;

public abstract class Edificio {
    protected int vida;

    protected int vidaMax;
    protected int tiempoConstruccion;
    protected Costo costo;

    protected Raza raza;

    public Edificio(int vida, int tiempoConstruccion, int costoMinerales, int costoGas) {
        this.costo = new Costo(costoMinerales, costoGas);
        this.vida = vida;
        this.vidaMax = vida;
        this.tiempoConstruccion = tiempoConstruccion;
    }

    public boolean esUsable() {
        return this.tiempoConstruccion < 1;
    }

    public void atacar(int dano) {
        vida -= dano;
    }

    public int tiempoDeConstruccion() {
        return tiempoConstruccion;
    }

    public Raza obtenerRaza(){return raza;}

    public boolean puedoComprar(Almacen almacen){
        return costo.puedoComprar(almacen);
    }

    public Costo obtenerCosto(){
        return this.costo;
    }
}
