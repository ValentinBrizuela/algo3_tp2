package edu.fiuba.algo3.modelo.edificios;

import edu.fiuba.algo3.modelo.juego.Almacen;
import edu.fiuba.algo3.modelo.juego.Casilla;
import edu.fiuba.algo3.modelo.juego.Entidad;
import edu.fiuba.algo3.modelo.terrenos.Moho;
import edu.fiuba.algo3.modelo.terrenos.Tierra;
import edu.fiuba.algo3.modelo.terrenos.TierraEnergizada;

public abstract class Edificio{
    protected int vida;

    protected int vidaMax;
    protected int tiempoConstruccion;
    protected Costo costo;

    protected Casilla casilla;

    public Edificio(int vida, int tiempoConstruccion, int costoMinerales, int costoGas, Casilla casilla) {
        this.costo = new Costo(costoMinerales, costoGas);
        this.vida = vida;
        this.vidaMax = vida;
        this.tiempoConstruccion = tiempoConstruccion;
        this.casilla = casilla;
    }

    public boolean esUsable() {
        return this.tiempoConstruccion < 1;
    }

    public abstract void recibirDanio(int dano);

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

    public boolean estaDestruido() {
        return vida <= 0;
    }
    public void finalizarConstruccion() {
        tiempoConstruccion = 0;
    }

    public abstract void construir(Moho moho, Almacen almacen);

    public abstract void construir(Tierra tierra, Almacen almacen);

    public abstract void construir(TierraEnergizada tierraEnergizada, Almacen almacen);
}
