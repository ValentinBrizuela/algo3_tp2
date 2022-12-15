package edu.fiuba.algo3.modelo.edificios;

public class VidaProtoss extends Vida{

    private int escudo;
    private int escudoMaximo;

    public VidaProtoss(int vida, int escudo) {
        super(vida);
        this.escudo = escudo;
        this.escudoMaximo = escudo;
    }

    @Override
    public void recibirAtaque(int danio) {
        if (danio > escudo) {
            vida -= (danio - escudo);
            escudo = 0;
        }
        else {
            escudo -= danio;
        }
    }

    @Override
    public void regenerar() {
        if (escudoMaximo - escudo > 0) {
            escudo += escudoMaximo * 0.01;
            if (escudo > escudoMaximo) {
                escudo = escudoMaximo;
            }
        }
    }

    public int obtenerEscudo() {
        return escudo;
    }
}
