package edu.fiuba.algo3.modelo.unidades;

import edu.fiuba.algo3.modelo.edificios.Edificio;
import edu.fiuba.algo3.modelo.errores.AtaqueInvalido;
import edu.fiuba.algo3.modelo.estados.Desocupada;
import edu.fiuba.algo3.modelo.interfaces.*;
import edu.fiuba.algo3.modelo.juego.Casilla;
import edu.fiuba.algo3.modelo.razas.Zerg;

public class Zerling extends UnidadTerrestre  implements Atacante{
    private int danio;
    private int rangoAtaque;

    public Zerling(Casilla casilla){
        super(35, 25, 0, 4, new Zerg(), casilla);
        this.danio = 4;
        this.rangoAtaque = 1;
    }

    @Override
    public void atacarA(UnidadVoladora unidadVoladora) {
        throw new AtaqueInvalido();
    }

    @Override
    public void atacarA(UnidadTerrestre unidadTerrestre) {
        unidadTerrestre.recibirAtaque(this.danio);
    }

    @Override
    public void atacarA(Edificio edificio) {

    }

    @Override
    public void recibirAtaque(int danio) {
        vida -= danio;
    }

}
