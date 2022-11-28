package edu.fiuba.algo3.modelo.juego;

import edu.fiuba.algo3.modelo.edificios.Costo;
import edu.fiuba.algo3.modelo.edificios.Vida;
import edu.fiuba.algo3.modelo.errores.AtaqueInvalidoError;
import edu.fiuba.algo3.modelo.errores.EnConstruccionError;
import edu.fiuba.algo3.modelo.estados.Desocupada;
import edu.fiuba.algo3.modelo.estados.Estado;
import edu.fiuba.algo3.modelo.interfaces.Atacable;
import edu.fiuba.algo3.modelo.interfaces.AtacableAereo;
import edu.fiuba.algo3.modelo.interfaces.Atacante;
import edu.fiuba.algo3.modelo.razas.Raza;

public abstract class Entidad {
    protected Costo costo;
    protected int tiempoConstruccion;
    protected Raza raza;
    protected Casilla casilla;
    protected Vida vida;

    public Entidad(Vida vida, int costoMineral, int costoGas, int tiempoConstruccion, Raza raza, Casilla casilla){
        this.vida = vida;
        this.costo = new Costo(costoMineral, costoGas);
        this.tiempoConstruccion = tiempoConstruccion;
        this.raza = raza;
        this.casilla = casilla;
    }

    public boolean estaDestruido() {
        return vida.obtenerVida() <= 0;
    }

    public void estasEnRango(Casilla casilla, int rango){
        if (!(this.casilla.estasEnRango(casilla.obtenerPosX(), casilla.obtenerPosY(), rango))){
            throw new AtaqueInvalidoError();
        }
    }

    public abstract void avanzarTurno();

    public abstract void recibirAtaque(Atacante atacante, Mapa mapa);

    public void esUsable() {
        if (tiempoConstruccion > 0){
            throw new EnConstruccionError();
        };
    }

    public void finalizarConstruccion() {
        tiempoConstruccion = 0;
    }

    public int tiempoDeConstruccion() {
        return tiempoConstruccion;
    }

    public int vida() {
        return vida.obtenerVida();
    }

    public int escudo() {
        return vida.obtenerEscudo();
    }

    public void aplicarDanio(int danio) {
        vida.recibirAtaque(danio);
       /* if (estaDestruido()){
            casilla.cambiarEstado(new Desocupada(casilla.obtenerTerreno(), casilla.obtenerRecurso()));
        }*/
    }


    public  void destruir(Jugador jugador){
        casilla.cambiarEstado(new Desocupada(casilla.obtenerTerreno(),casilla.obtenerRecurso()));
    }

}
