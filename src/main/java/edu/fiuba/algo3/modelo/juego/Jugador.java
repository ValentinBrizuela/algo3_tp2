package edu.fiuba.algo3.modelo.juego;



import edu.fiuba.algo3.modelo.edificios.Construible;
import edu.fiuba.algo3.modelo.edificios.Criadero;
import edu.fiuba.algo3.modelo.edificios.EdificioConArea;
import edu.fiuba.algo3.modelo.errores.LarvasInsuficientesError;
import edu.fiuba.algo3.modelo.errores.NombreDeJugadorInvalidoError;
import edu.fiuba.algo3.modelo.razas.Raza;

import edu.fiuba.algo3.modelo.unidades.ConsumidorDeSuministro;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class Jugador {

    private ArrayList<Construible> edificiosConstruidos;

    private ArrayList<EdificioConArea> edificiosConAreas;

    private Almacen almacen;
    private String nombre;
    private AlgoColores color;
    private Raza raza;

    private Poblacion poblacion;

    private Map<String,Boolean> diccEdificios;

    private int posx;
    private int posy;

    public Jugador(String nombre, AlgoColores color, Raza raza){
        this.edificiosConstruidos= new ArrayList<Construible>();
        if (nombre.length() < 6) {
            throw new NombreDeJugadorInvalidoError();
        }
        this.edificiosConstruidos= new ArrayList<Construible>();
        this.edificiosConAreas= new ArrayList<EdificioConArea>();
        this.almacen= new Almacen();
        this.almacen.almacenarMineral(250);
        this.almacen.almacenarGas(0);
        this.nombre=nombre;
        this.color=color;
        this.raza=raza;
        this.poblacion=new Poblacion();
        this.diccEdificios=new HashMap<String, Boolean>();
        diccEdificios.put("ReservaDeReproduccion",false);
        diccEdificios.put("Guarida",false);
        diccEdificios.put("Acceso",false);
        diccEdificios.put("PuertoEstelar",false);
        diccEdificios.put("Espiral",false);
        diccEdificios.put("Criadero",false);
    }

    public boolean yaTiene(String edificio){

        return diccEdificios.get(edificio);
    }

    public void construyo(String edificio){
        diccEdificios.put(edificio,true);
    }

    public void agregarEdificio(Construible edificio){edificiosConstruidos.add(edificio);}

    public void agregarEdificioConArea(EdificioConArea edificio){edificiosConAreas.add(edificio);}

    public void actualizarAreas(IMapa mapa){
        for (EdificioConArea edificio: edificiosConAreas){
            edificio.actualizarTerreno(mapa);
        }
    }

    public Almacen obtenerAlmacen(){
        return almacen;
    }

    public void llenarArcas(){
        almacen.almacenarMineral(1000000);
        almacen.almacenarGas(1000000);
    }

    public boolean sosIgualA(Jugador jugador){
        return (nombre.equals(jugador.nombre) || color.esIgualA(jugador.obtenerColor()) || raza.getClass()==jugador.obtenerRaza().getClass());
    }


    public void consumirSuministro(ConsumidorDeSuministro unidad){
        poblacion.consumirCapacidad(unidad);
    }

    public void verificarSuministro(ConsumidorDeSuministro unidad){
        poblacion.verificarCapacidad(unidad);
    }


    public String obtenerNombre(){
        return nombre;
    }

    public Raza obtenerRaza(){
        return raza;
    }

    public AlgoColores obtenerColor(){
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

    public void puedeSeleccionar(Raza raza){
        raza.puedoSeleccionar(this.raza);
    }

    public void verificarLarvas(){
        for (EdificioConArea e: edificiosConAreas){
            Criadero c = (Criadero) e;
            if ( c.engendrarUnidad()){
                return;
            }
        }
        throw new LarvasInsuficientesError();
    }

    public int obtenerGas() {
        return almacen.cantGas();
    }

    public int obtenerMineral() {
        return almacen.cantMineral();
    }
}
