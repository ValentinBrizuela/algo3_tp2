package edu.fiuba.algo3.modelo.juego;



import edu.fiuba.algo3.modelo.razas.Raza;
import edu.fiuba.algo3.modelo.unidades.ConsumidorDeSuministro;

import java.util.ArrayList;


public class Jugador {

    private ArrayList<Class> edificiosConstruidos;

    private Almacen almacen;
    private String nombre;
    private String color;
    private Raza raza;

    private Poblacion poblacion;

    private int posx;
    private int posy;

    public Jugador(String nombre, String color, Raza raza){
        this.edificiosConstruidos= new ArrayList<Class>();
        this.almacen= new Almacen();
        this.almacen.almacenarMineral(200);
        this.nombre=nombre;
        this.color=color;
        this.raza=raza;
        this.poblacion=new Poblacion();

    }

    public boolean yaTiene(Class edificio){
        return edificiosConstruidos.contains(edificio);
    }

    public void agregarEdificio(Class edificio){edificiosConstruidos.add(edificio);}

    public Almacen obtenerAlmacen(){
        return almacen;
    }

    public void llenarArcas(){
        almacen.almacenarMineral(1000);
        almacen.almacenarGas(1000);
    }

    public boolean sosIgualA(Jugador jugador){
        return (nombre==jugador.obtenerNombre() || color== jugador.obtenerColor() || raza.getClass()==jugador.obtenerRaza().getClass());
    }

    public void verificarYConsumirSuministro(ConsumidorDeSuministro unidad){
        poblacion.verificarYDescontarCapacidad(unidad);
    }


    public String obtenerNombre(){
        return nombre;
    }

    public Raza obtenerRaza(){
        return raza;
    }

    public String obtenerColor(){
        return color;
    }

    public void setearPosicion(int x, int y) {
        this.posx = x;
        this.posy = y;
    }

    public int posX() {
        return posx;
    }

    public int posY() {
        return posy;
    }

    public int obtenerPoblacionUsable(){
        return this.poblacion.cantidadUsable();
    }

    public void generarPoblacion(){
        this.poblacion.aumentarPoblacion();
    }


}
