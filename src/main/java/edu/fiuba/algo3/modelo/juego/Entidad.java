package edu.fiuba.algo3.modelo.juego;

import edu.fiuba.algo3.modelo.costos.Costo;
import edu.fiuba.algo3.modelo.edificios.Vida;
import edu.fiuba.algo3.modelo.errores.AtaqueInvalidoError;
import edu.fiuba.algo3.modelo.errores.EnConstruccionError;
import edu.fiuba.algo3.modelo.estados.Desocupada;
import edu.fiuba.algo3.modelo.interfaces.Atacante;
import edu.fiuba.algo3.modelo.razas.Raza;

import java.util.ArrayList;

public abstract class Entidad {
    protected ArrayList<Costo> costos;
    protected int tiempoConstruccion;
    protected Raza raza;
    protected Casilla casilla;
    protected Vida vida;

    public Entidad(Vida vida, ArrayList<Costo> costos, int tiempoConstruccion, Raza raza, Casilla casilla){
        this.vida = vida;
        this.costos = costos;
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

    public abstract void recibirAtaque(Atacante atacante, IMapa mapa);

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
    }


    public  void destruir(Jugador jugador,IMapa mapa){
        casilla.cambiarEstado(new Desocupada(casilla.obtenerTerreno(),casilla.obtenerRecurso()));
    }

    public void cobrar(Almacen almacen){
        for (Costo costo: costos){
            costo.meAlcanza(almacen);
        }

        for (Costo costo: costos){
            costo.cobrar(almacen);
        }
    }
    public boolean esAtacante() {
        return false;
    }

}
