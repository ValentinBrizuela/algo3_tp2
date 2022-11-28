package edu.fiuba.algo3.modelo.interfaces;

import edu.fiuba.algo3.modelo.juego.Mapa;
import edu.fiuba.algo3.modelo.razas.Raza;

public interface Atacable {
    public void recibirAtaque(int danio, Mapa mapa);

    public void meQuedeSinVida();
}
