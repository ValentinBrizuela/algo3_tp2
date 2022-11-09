package edu.fiuba.algo3.modelo;

public class Acceso extends EdificioProtoss{

    private int escudo;
    public Acceso() {
        super(500, 500,8, 150, 0);
        this.escudo = 500;
        this.raza = new Protoss();
    }
}
