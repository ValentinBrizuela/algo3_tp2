package edu.fiuba.algo3.modelo.edificios;

public class VidaZerg extends Vida{

    public VidaZerg(int vida) {
        super(vida);
    }

    @Override
    public void recibirAtaque(int danio) {
        vida -= danio;
    }

    @Override
    public void regenerar() {
        if (vidaMaxima-vida > 0) {
            vida += vidaMaxima*0.01;
            if (vida > vidaMaxima) {
                vida = vidaMaxima;
            }
        }
    }

    public int obtenerEscudo() {
        return 0;
    }

}
