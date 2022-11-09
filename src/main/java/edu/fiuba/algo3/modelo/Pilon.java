package edu.fiuba.algo3.modelo;

public class Pilon extends Edificio{
    private int escudo;
    public Pilon() {
        super(100, 4, 100, 0);
        escudo = 300;
        this.raza = new Protoss();
    }
}
