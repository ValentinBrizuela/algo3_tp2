package edu.fiuba.algo3.modelo.edificios;

import edu.fiuba.algo3.modelo.errores.ConstruccionNoPermitidaError;
import edu.fiuba.algo3.modelo.errores.CreacionDeUnidadInvalida;
import edu.fiuba.algo3.modelo.errores.PoblacionInsuficienteError;
import edu.fiuba.algo3.modelo.juego.Casilla;
import edu.fiuba.algo3.modelo.juego.IMapa;
import edu.fiuba.algo3.modelo.juego.Jugador;
import edu.fiuba.algo3.modelo.unidades.*;

public class EntidadesFactory {

    public void construirEntidad(String entidad, Casilla casilla, Jugador jugadorActual, IMapa mapa){
        switch (entidad) {
            case "Criadero":
                construirCriadero(casilla, jugadorActual, mapa);
                break;

            case "Pilon":
                construirPilon(casilla, jugadorActual, mapa);
                break;

            case "ReservaDeReproduccion":
                construirReservaDeReproduccion(casilla, jugadorActual);
                break;

            case "Espiral":
                construirEspiral(casilla, jugadorActual);
                break;

            case "Acceso":
                construirAcceso(casilla, jugadorActual);
                break;

            case "PuertoEstelar":
                construirPuertoEstelar(casilla, jugadorActual);
                break;

            case "Extractor":
                construirExtractor(casilla, jugadorActual);
                break;

            case "Guarida":
                construirGuarida(casilla, jugadorActual);
                break;

            case "NexoMineral":
                construirNexoMineral(casilla, jugadorActual);
                break;

            case "Asimilador":
                construirAsimilador(casilla, jugadorActual);
                break;

            case "Zerling":
                crearZerling(casilla, jugadorActual);
                break;

            case "Zangano":
                crearZangano(casilla, jugadorActual);
                break;

            case "Hidralisco":
                crearHidralisco(casilla, jugadorActual);
                break;

            case "Mutalisco":
                crearMutalisco(casilla, jugadorActual);
                break;

            case "Zealot":
                crearZealot(casilla, jugadorActual);
                break;

            case "Dragon":
                crearDragon(casilla, jugadorActual);
                break;

            case "Scout":
                crearScout(casilla, jugadorActual);
                break;

            case "AmoSupremo":
                crearAmoSupremo(casilla, jugadorActual);
                break;
        }
    }

    public void construirCriadero(Casilla casilla, Jugador jugadorActual, IMapa mapa){
        try {
            Criadero c = new Criadero(casilla);
            jugadorActual.puedeSeleccionar(c.obtenerRaza());
            casilla.construir(c, jugadorActual.obtenerAlmacen());
            jugadorActual.construyo("Criadero");
            jugadorActual.generarPoblacion();
            jugadorActual.agregarEdificio(c);
            jugadorActual.agregarEdificioConArea(c);
            c.actualizarTerreno(mapa);

        } catch (Exception e){
            System.out.println("No se pudo construir el Criadero. ");
        }
    }

    public void construirPilon(Casilla casilla, Jugador jugadorActual, IMapa mapa){
        try {
            Pilon p = new Pilon(casilla);
            jugadorActual.puedeSeleccionar(p.obtenerRaza());
            casilla.construir(p, jugadorActual.obtenerAlmacen());
            jugadorActual.construyo("Pilon");
            jugadorActual.generarPoblacion();
            jugadorActual.agregarEdificio(p);
            jugadorActual.agregarEdificioConArea(p);
            p.actualizarTerreno(mapa);

        } catch (Exception e){
            System.out.println("No se pudo construir el Pilon. ");
        }
    }

    public void construirReservaDeReproduccion(Casilla casilla, Jugador jugadorActual){
        try {
            ReservaDeReproduccion r = new ReservaDeReproduccion(casilla);
            jugadorActual.puedeSeleccionar(r.obtenerRaza());
            casilla.construir(r, jugadorActual.obtenerAlmacen());
            jugadorActual.construyo("ReservaDeReproduccion");
            jugadorActual.agregarEdificio(r);

        } catch (Exception e){
            System.out.println("No se pudo construir la Reserva de Reproduccion. ");
        }
    }

    public void construirEspiral(Casilla casilla, Jugador jugadorActual){
        try {
            if (!jugadorActual.yaTiene("Guarida")){
                throw new ConstruccionNoPermitidaError();
            }

        } catch (ConstruccionNoPermitidaError e) {
            System.out.println("Para construir un Espiral necesitas una Guarida. ");
            return;
        }

        try {
            Espiral e = new Espiral(casilla);
            jugadorActual.puedeSeleccionar(e.obtenerRaza());
            casilla.construir(e, jugadorActual.obtenerAlmacen());
            jugadorActual.construyo("Espiral");
            jugadorActual.agregarEdificio(e);

        } catch (Exception e) {
            System.out.println("No se pudo construir el Espiral. ");
        }
    }

    public void construirPuertoEstelar(Casilla casilla, Jugador jugadorActual) {
        try {
            if (!jugadorActual.yaTiene("Acceso")){
                throw new ConstruccionNoPermitidaError();
            }

        } catch (ConstruccionNoPermitidaError e) {
            System.out.println("Para construir un Puerto Estelar necesitas un Acceso. ");
            return;
        }

        try {
            PuertoEstelar p = new PuertoEstelar(casilla);
            jugadorActual.puedeSeleccionar(p.obtenerRaza());
            casilla.construir(p, jugadorActual.obtenerAlmacen());
            jugadorActual.construyo("PuertoEstelar");
            jugadorActual.agregarEdificio(p);

        } catch (Exception e) {
            System.out.println("No se pudo construir el Puerto Estelar. ");
        }
    }

    public void construirAcceso(Casilla casilla, Jugador jugadorActual) {
        try {
            Acceso a = new Acceso(casilla);
            jugadorActual.puedeSeleccionar(a.obtenerRaza());
            casilla.construir(a, jugadorActual.obtenerAlmacen());
            jugadorActual.construyo("Acceso");
            jugadorActual.agregarEdificio(a);

        } catch (Exception e){
            System.out.println("No se pudo construir el Acceso. ");
        }
    }

    public void construirExtractor(Casilla casilla, Jugador jugadorActual){
        try{
            Extractor e = new Extractor(casilla, jugadorActual.obtenerAlmacen());
            jugadorActual.puedeSeleccionar(e.obtenerRaza());
            casilla.construir(e, jugadorActual.obtenerAlmacen());
            jugadorActual.construyo("Extractor");
            jugadorActual.agregarEdificio(e);

        } catch (Exception e){
            System.out.println("No se pudo construir el Extractor. ");
        }
    }

    public void construirGuarida(Casilla casilla, Jugador jugadorActual){
        try {
            if (!jugadorActual.yaTiene("ReservaDeReproduccion")){
                throw new ConstruccionNoPermitidaError();
            }
        } catch (ConstruccionNoPermitidaError e) {
            System.out.println("Para construir una guarida necesitas una Reserva de Reproduccion. ");
            return;
        }

        try {
            Guarida g = new Guarida(casilla);
            jugadorActual.puedeSeleccionar(g.obtenerRaza());
            casilla.construir(g, jugadorActual.obtenerAlmacen());
            jugadorActual.construyo("Guarida");
            jugadorActual.agregarEdificio(g);

        } catch (Exception e) {
            System.out.println("No se pudo construir la Guarida. ");
        }
    }

    public void construirNexoMineral(Casilla casilla, Jugador jugadorActual){
        try {
            NexoMineral n = new NexoMineral(casilla, jugadorActual.obtenerAlmacen());
            jugadorActual.puedeSeleccionar(n.obtenerRaza());
            casilla.construir(n, jugadorActual.obtenerAlmacen());
            jugadorActual.construyo("NexoMineral");
            jugadorActual.agregarEdificio(n);

        } catch (Exception e){
            System.out.println("No se pudo construir el Nexo Mineral. ");
        }
    }

    public void construirAsimilador(Casilla casilla, Jugador jugadorActual){
        try {
            Asimilador a = new Asimilador(casilla, jugadorActual.obtenerAlmacen());
            jugadorActual.puedeSeleccionar(a.obtenerRaza());
            casilla.construir(a, jugadorActual.obtenerAlmacen());
            jugadorActual.construyo("Asimilador");
            jugadorActual.agregarEdificio(a);

        } catch (Exception e) {
            System.out.println("No se pudo construir el Asimilador. ");
        }
    }

    public void crearZerling(Casilla casilla, Jugador jugadorActual){

        //crear logica
        try {
            if (!jugadorActual.yaTiene("ReservaDeReproduccion")){
                throw new CreacionDeUnidadInvalida();
            }
        } catch (CreacionDeUnidadInvalida e) {
            System.out.println("Para crear un Zerling necesitas una Reserva de Reproduccion. ");
            return;
        }

        try {
            Zerling z = new Zerling(casilla);
            jugadorActual.puedeSeleccionar(z.obtenerRaza());
            jugadorActual.verificarYConsumirSuministro(z);
            casilla.construir(z,jugadorActual.obtenerAlmacen());

        } catch (ConstruccionNoPermitidaError e){
            return;
        }
        catch (PoblacionInsuficienteError e) {
            System.out.println("Población insuficiente para crear un Zerling (1 Pob).");
            return;
        }
    }

    public void crearZangano(Casilla casilla, Jugador jugadorActual){

        //crear logica
        try {
            if (!jugadorActual.yaTiene("Criadero")){
                throw new CreacionDeUnidadInvalida();
            }
        } catch (CreacionDeUnidadInvalida e) {
            System.out.println("Para crear un Zangano necesitas un Criadero. ");
            return;
        }

        try {
            Zangano z = new Zangano(casilla, jugadorActual.obtenerAlmacen());
            jugadorActual.puedeSeleccionar(z.obtenerRaza());
            jugadorActual.verificarYConsumirSuministro(z);
            casilla.construir(z,jugadorActual.obtenerAlmacen());

        } catch (ConstruccionNoPermitidaError e){
            return;
        }
        catch (PoblacionInsuficienteError e) {
            System.out.println("Población insuficiente para crear un Zangano (1 Pob).");
            return;
        }
    }

    public void crearHidralisco(Casilla casilla, Jugador jugadorActual){

        //crear logica
        try {
            if (!jugadorActual.yaTiene("Guarida")){
                throw new CreacionDeUnidadInvalida();

            }
        } catch (CreacionDeUnidadInvalida e) {
            System.out.println("Para crear un Hidralisco necesitas una Guarida. ");
            return;
        }

        try {
            Hidralisco h = new Hidralisco(casilla);
            jugadorActual.puedeSeleccionar(h.obtenerRaza());
            jugadorActual.verificarYConsumirSuministro(h);
            casilla.construir(h,jugadorActual.obtenerAlmacen());

        } catch (ConstruccionNoPermitidaError e){
            return ;
        }
        catch (PoblacionInsuficienteError e) {
            System.out.println("Población insuficiente para crear un Hidralisco (2 Pob). ");
            return ;
        }
    }

    public void crearMutalisco(Casilla casilla, Jugador jugadorActual){

        try {
            if (!jugadorActual.yaTiene("Espiral")){
                throw new CreacionDeUnidadInvalida();
            }
        } catch (CreacionDeUnidadInvalida e) {
            System.out.println("Para crear un Mutalisco necesitas un Espiral. ");
            return;
        }

        try {
            Mutalisco m = new Mutalisco(casilla);
            jugadorActual.puedeSeleccionar(m.obtenerRaza());
            jugadorActual.verificarYConsumirSuministro(m);
            casilla.construir(m,jugadorActual.obtenerAlmacen());

        } catch (ConstruccionNoPermitidaError e){
            return ;
        }
        catch (PoblacionInsuficienteError e) {
            System.out.println("Población insuficiente para crear un Mutalisco (4 Pob).");
            return ;
        }
    }

    public void crearZealot(Casilla casilla, Jugador jugadorActual){

        try {
            if (!jugadorActual.yaTiene("Acceso")){
                throw new CreacionDeUnidadInvalida();
            }
        } catch (CreacionDeUnidadInvalida e) {
            System.out.println("Para crear un Zealot necesitas un Acceso. ");
            return;
        }

        try {
            Zealot z = new Zealot(casilla);
            jugadorActual.puedeSeleccionar(z.obtenerRaza());
            jugadorActual.verificarYConsumirSuministro(z);
            casilla.construir(z,jugadorActual.obtenerAlmacen());

        } catch (ConstruccionNoPermitidaError e){
            return ;
        }
        catch (PoblacionInsuficienteError e) {
            System.out.println("Población insuficiente para crear un Zealot (2 Pob).");
            return ;
        }
    }

    public void crearDragon(Casilla casilla, Jugador jugadorActual){

        try {
            if (!jugadorActual.yaTiene("Acceso")){
                throw new CreacionDeUnidadInvalida();
            }
        } catch (CreacionDeUnidadInvalida e) {
            System.out.println("Para crear un Dragon necesitas un Acceso. ");
            return;
        }

        try {
            Dragon d = new Dragon(casilla);
            jugadorActual.puedeSeleccionar(d.obtenerRaza());
            jugadorActual.verificarYConsumirSuministro(d);
            casilla.construir(d,jugadorActual.obtenerAlmacen());

        } catch (ConstruccionNoPermitidaError e){
            return ;
        }
        catch (PoblacionInsuficienteError e) {
            System.out.println("Población insuficiente para crear un Dragon (3 Pob).");
            return ;
        }
    }

    public void crearScout(Casilla casilla, Jugador jugadorActual){

        try {
            if (!jugadorActual.yaTiene("PuertoEstelar")){
                throw new CreacionDeUnidadInvalida();
            }
        } catch (CreacionDeUnidadInvalida e) {
            System.out.println("Para crear un Scout necesitas un Puerto Estelar. ");
            return;
        }

        try {
            Scout s = new Scout(casilla);
            jugadorActual.puedeSeleccionar(s.obtenerRaza());
            jugadorActual.verificarYConsumirSuministro(s);
            casilla.construir(s,jugadorActual.obtenerAlmacen());

        } catch (ConstruccionNoPermitidaError e){
            return ;
        }
        catch (PoblacionInsuficienteError e) {
            System.out.println("Población insuficiente para crear un Scout (4 Pob).");
            return ;
        }
    }

    public void crearAmoSupremo(Casilla casilla, Jugador jugadorActual){

        try {
            AmoSupremo a = new AmoSupremo(casilla);
            jugadorActual.puedeSeleccionar(a.obtenerRaza());
            jugadorActual.generarPoblacion();
            casilla.construir(a, jugadorActual.obtenerAlmacen());

        } catch (Exception e) {
            //System.out.println("No se pudo crear el AmoSupremo. ");
            return;
        }
    }
}
