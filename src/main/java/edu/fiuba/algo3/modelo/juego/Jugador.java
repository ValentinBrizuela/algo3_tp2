package edu.fiuba.algo3.modelo.juego;



import edu.fiuba.algo3.modelo.edificios.EdificioConArea;
import edu.fiuba.algo3.modelo.razas.Raza;

import edu.fiuba.algo3.modelo.terrenos.Terreno;
import edu.fiuba.algo3.modelo.unidades.ConsumidorDeSuministro;
import java.util.ArrayList;


public class Jugador {

    private ArrayList<Entidad> edificiosConstruidos;

    private ArrayList<EdificioConArea> edificiosConAreas;

    private Almacen almacen;
    private String nombre;
    private String color;
    private Raza raza;

    private Poblacion poblacion;

    private int posx;
    private int posy;

    public Jugador(String nombre, String color, Raza raza){
        this.edificiosConstruidos= new ArrayList<Entidad>();
        this.edificiosConAreas= new ArrayList<EdificioConArea>();
        this.almacen= new Almacen();
        this.almacen.almacenarMineral(200);
        this.nombre=nombre;
        this.color=color;
        this.raza=raza;
        this.poblacion=new Poblacion();

    }

    public boolean yaTiene(Class edificio){
        for (Entidad e: edificiosConstruidos){
            if (e.getClass() == edificio){
                return true;
            }
        }
        return false;
    }

    public void agregarEdificio(Entidad edificio){edificiosConstruidos.add(edificio);}

    public void agregarEdificioConArea(EdificioConArea edificio){edificiosConAreas.add(edificio);}

    public void actualizarAreas(Mapa mapa){
        for (EdificioConArea edificio: edificiosConAreas){
            edificio.actualizarTerreno(mapa);
        }
    }

    public Almacen obtenerAlmacen(){
        return almacen;
    }

    public void llenarArcas(){
        almacen.almacenarMineral(10000);
        almacen.almacenarGas(10000);
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

    public int obtenerPoblacionEnUso(){
        return this.poblacion.cantidadEnUso();
    }

    public void generarPoblacion(){
        this.poblacion.aumentarPoblacion();
    }

    public void degenerarPoblacion(){this.poblacion.disminuirPoblacion();}


    public boolean perdio(){
        if (edificiosConstruidos.size() == 0){
            return false;
        }

        for (Entidad edificio: edificiosConstruidos){
            if (!edificio.estaDestruido()){
                return false;
            }
        }
        return true;
    }

}
