package edu.fiuba.algo3.modelo;

public class Casilla {
    private final int posX;
    private final int posY;
    private Terreno terreno;
    private Estado estado;

    private Edificio edificio;
    public Casilla(int posX, int posY, Terreno terreno, Estado estado){
        this.posX = posX;
        this.posY = posY;
        this.terreno = terreno;
        this.estado = estado;
        this.edificio = null;
    }

    public void construir(Edificio edificio, Almacen almacen){
        estado.construir(edificio, this);

        if (edificio.puedoComprar(almacen)){
            cambiarEstado(new Ocupada());
            cambiarEdificio(edificio);
            Costo costo = edificio.obtenerCosto();
            almacen.cobrar(costo);

        } else {
            throw new RecursosInsuficientes();
        }
    }

    public void cambiarEstado(Estado estado){
        this.estado = estado;
    }

    private void cambiarEdificio(Edificio edificio){
        this.edificio = edificio;
    }

    public void cambiarTerreno(Terreno terreno){
        this.terreno = terreno;
    }

    public Edificio obtenerEdificio(){
        return edificio;
    }

    public Estado obtenerEstado(){
        return estado;
    }

    public Terreno obtenerTerreno(){
        return terreno;
    }

    public void energizarse(){
        terreno.energizarse();
    }

}
