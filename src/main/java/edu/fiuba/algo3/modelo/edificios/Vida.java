package edu.fiuba.algo3.modelo.edificios;

public abstract class Vida {
    protected int vida;
    protected int vidaMaxima;

    public Vida(int vida) {
        this.vida = vida;
        this.vidaMaxima = vida;
    }

    public abstract void recibirAtaque(int danio);

    public abstract void regenerar();

    public int obtenerVida(){
        return vida;
    }

    public abstract int obtenerEscudo();
}
