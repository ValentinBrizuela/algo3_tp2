package edu.fiuba.algo3.modelo.juego;



import edu.fiuba.algo3.modelo.edificios.Construible;
import edu.fiuba.algo3.modelo.edificios.EdificioConArea;
import edu.fiuba.algo3.modelo.errores.NombreDeJugadorInvalidoError;
import edu.fiuba.algo3.modelo.razas.Raza;

import edu.fiuba.algo3.modelo.terrenos.Terreno;
import edu.fiuba.algo3.modelo.unidades.ConsumidorDeSuministro;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class Jugador {

    private ArrayList<Construible> edificiosConstruidos;

    private ArrayList<EdificioConArea> edificiosConAreas;

    private Almacen almacen;
    private String nombre;
    private Color color;
    private Raza raza;

    private Poblacion poblacion;

    private Map<String,Boolean> diccionario;

    private int posx;
    private int posy;

    public Jugador(String nombre, Color color, Raza raza){
        this.edificiosConstruidos= new ArrayList<Construible>();
        if (nombre.length() < 6) {
            throw new NombreDeJugadorInvalidoError();
        }
        this.edificiosConstruidos= new ArrayList<Construible>();
        this.edificiosConAreas= new ArrayList<EdificioConArea>();
        this.almacen= new Almacen();
        this.almacen.almacenarMineral(200);
        this.nombre=nombre;
        this.color=color;
        this.raza=raza;
        this.poblacion=new Poblacion();
        this.diccionario=new HashMap<String, Boolean>();
        diccionario.put("ReservaDeReproduccion",false);
        diccionario.put("Guarida",false);
        diccionario.put("Acceso",false);
        diccionario.put("PuertoEstelar",false);
        diccionario.put("Espiral",false);
        diccionario.put("Criadero",false);
    }

    public boolean yaTiene(String edificio){

        return diccionario.get(edificio);
    }

    public void construyo(String edificio){
        diccionario.put(edificio,true);
    }

    public void agregarEdificio(Construible edificio){edificiosConstruidos.add(edificio);}

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
        return (nombre.equals(jugador.nombre)  || raza.getClass()==jugador.obtenerRaza().getClass());
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

    public Color obtenerColor(){
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

        for (Construible edificio: edificiosConstruidos){
            if (!edificio.estaDestruido()){
                return false;
            }
        }
        return true;
    }




}
