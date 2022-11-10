package edu.fiuba.algo3.modelo.juego;



import java.util.ArrayList;


public class Jugador {

    private ArrayList<Class> edificiosConstruidos;

    private Almacen almacen;
    public Jugador(Almacen almacen){
        this.almacen = almacen;
        this.edificiosConstruidos= new ArrayList<Class>();
    }

    public boolean yaTiene(Class edificio){
        return edificiosConstruidos.contains(edificio);
    }

    public void agregarEdificio(Class edificio){edificiosConstruidos.add(edificio);}

    public Almacen obtenerAlmacen(){
        return almacen;
    }
}
