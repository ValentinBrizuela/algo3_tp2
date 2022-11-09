package edu.fiuba.algo3.modelo;

public class Edificio {
    protected int vida;
    protected int costo;
    protected int tiempoContruccion;

    protected Raza raza;

    public Edificio(int vida, int costo, int tiempoContruccion) {
        this.vida = vida;
        this.costo = costo;
        this.tiempoContruccion = tiempoContruccion;
    }

    public boolean esUsable() {
        return this.tiempoContruccion < 1;
    }

    public void atacar(int dano) {
        vida -= dano;
    }

    public int tiempoDeConstruccion() {
        return tiempoContruccion;
    }

    public Raza obtenerRaza(){return raza;}
}
