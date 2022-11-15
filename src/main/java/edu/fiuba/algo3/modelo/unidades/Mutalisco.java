package edu.fiuba.algo3.modelo.unidades;

import edu.fiuba.algo3.modelo.edificios.Costo;
import edu.fiuba.algo3.modelo.edificios.Edificio;
import edu.fiuba.algo3.modelo.errores.RecursosInsuficientes;
import edu.fiuba.algo3.modelo.interfaces.Atacante;
import edu.fiuba.algo3.modelo.juego.Almacen;
import edu.fiuba.algo3.modelo.juego.Casilla;
import edu.fiuba.algo3.modelo.razas.Zerg;

public class Mutalisco extends UnidadVoladora  implements Atacante {

    private int danioAereo;
    private int danioTerrestre;

    private int rangoAtaque;

    public Mutalisco(Casilla casilla){
        super(120, 100, 100, 7, new Zerg(), casilla);
        this.danioAereo = 9;
        this.danioTerrestre = 9;
        this.rangoAtaque = 3;
    }

    @Override
    public void atacarA(UnidadVoladora unidadVoladora) {
        unidadVoladora.estasEnRango(casilla, rangoAtaque);
        unidadVoladora.recibirAtaque(danioAereo);
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

    public Guardian evolucionar(Almacen almacen) {
        Costo costo = new Costo(50, 100);
        if (costo.puedoComprar(almacen)) {
            return new Guardian(casilla);
        }
        else{
            throw new RecursosInsuficientes();
        }
    }
}
