package edu.fiuba.algo3.modelo.unidades;

import edu.fiuba.algo3.modelo.edificios.Edificio;
import edu.fiuba.algo3.modelo.errores.AtaqueInvalido;
import edu.fiuba.algo3.modelo.interfaces.Atacante;
import edu.fiuba.algo3.modelo.juego.Almacen;
import edu.fiuba.algo3.modelo.juego.Casilla;
import edu.fiuba.algo3.modelo.razas.Zerg;

public class Guardian extends UnidadVoladora  implements Atacante {

    private int danioTerrestre;

    private int rangoAtaque;

    public Guardian(Casilla casilla) {
        super(100, 50, 100, 4, new Zerg(), casilla);
        this.danioTerrestre = 25;
        this.rangoAtaque = 10;
    }

    @Override
    public void atacarA(UnidadVoladora unidadVoladora) {
        throw new AtaqueInvalido();
    }

    @Override
    public void recibirAtaque(int danio) {
        vida -= danio;
    }

    @Override
    public void atacarA(UnidadTerrestre unidadTerrestre) {
        unidadTerrestre.recibirAtaque(danioTerrestre);
    }

    @Override
    public void atacarA(Edificio edificio) {

    }

    public void crear(Almacen almacen){
        almacen.cobrar(costo);
    }
}
