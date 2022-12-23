package edu.fiuba.algo3.modelo.edificios;

import edu.fiuba.algo3.modelo.errores.*;
import edu.fiuba.algo3.modelo.juego.Casilla;
import edu.fiuba.algo3.modelo.juego.IMapa;
import edu.fiuba.algo3.modelo.juego.Jugador;
import edu.fiuba.algo3.modelo.unidades.*;

public class EntidadesFactory {

    public String construirEntidad(String entidad, Casilla casilla, Jugador jugadorActual, IMapa mapa){
        String s = null;

        switch (entidad) {

            case "Criadero":
                s = construirCriadero(casilla, jugadorActual, mapa);
                return s;

            case "Pilon":
                s = construirPilon(casilla, jugadorActual, mapa);
                return s;

            case "ReservaDeReproduccion":
                s = construirReservaDeReproduccion(casilla, jugadorActual);
                return s;

            case "Espiral":
                s = construirEspiral(casilla, jugadorActual);
                return s;

            case "Acceso":
                s = construirAcceso(casilla, jugadorActual);
                return s;

            case "PuertoEstelar":
                s = construirPuertoEstelar(casilla, jugadorActual);
                return s;

            case "Extractor":
                s = construirExtractor(casilla, jugadorActual);
                return s;

            case "Guarida":
                s = construirGuarida(casilla, jugadorActual);
                return s;

            case "NexoMineral":
                s = construirNexoMineral(casilla, jugadorActual);
                return s;

            case "Asimilador":
                s = construirAsimilador(casilla, jugadorActual);
                return s;

            case "Zerling":
                crearZerling(casilla, jugadorActual);
                return null;

            case "Zangano":
                crearZangano(casilla, jugadorActual);
                return null;

            case "Hidralisco":
                crearHidralisco(casilla, jugadorActual);
                return null;

            case "Mutalisco":
                crearMutalisco(casilla, jugadorActual);
                return null;

            case "Zealot":
                crearZealot(casilla, jugadorActual);
                return null;

            case "Dragon":
                crearDragon(casilla, jugadorActual);
                return null;

            case "Scout":
                crearScout(casilla, jugadorActual);
                return null;

            case "AmoSupremo":
                crearAmoSupremo(casilla, jugadorActual);
                return null;
        }
        return null;
    }

    private String construirCriadero(Casilla casilla, Jugador jugadorActual, IMapa mapa){
        try {
            Criadero c = new Criadero(casilla);
            jugadorActual.puedeSeleccionar(c.obtenerRaza());
            casilla.construir(c, jugadorActual.obtenerAlmacen());
            jugadorActual.construyo("Criadero");
            jugadorActual.generarPoblacion();
            jugadorActual.agregarEdificio(c);
            jugadorActual.agregarEdificioConArea(c);
            c.actualizarTerreno(mapa);

        } catch (SeleccionInvalidaError e){
            System.out.println("Este edificio no te pertenece. ");
            return "Este edificio no te pertenece. ";

        } catch (CasillaOcupadaError e){
            System.out.println("Construcción invalida por casilla ocupada.");
            return "Construcción invalida por casilla ocupada.";

        } catch (ConstruccionNoPermitidaRecursoError e){
            System.out.println("No se puede construir sobre un recurso.");
            return "No se puede construir sobre un recurso.";

        } catch (ConstruccionNoPermitidaTerrenoError e){
            System.out.println("No se puede construir sobre un terreno incompatible con el edificio.");
            return "No se puede construir sobre un terreno incompatible con el edificio.";
        }
        return null;
    }

    private String construirPilon(Casilla casilla, Jugador jugadorActual, IMapa mapa){
        try {
            Pilon p = new Pilon(casilla);
            jugadorActual.puedeSeleccionar(p.obtenerRaza());
            casilla.construir(p, jugadorActual.obtenerAlmacen());
            jugadorActual.construyo("Pilon");
            jugadorActual.generarPoblacion();
            jugadorActual.agregarEdificio(p);
            jugadorActual.agregarEdificioConArea(p);
            p.actualizarTerreno(mapa);

        } catch (SeleccionInvalidaError e){
            System.out.println("Este edificio no te pertenece. ");
            return "Este edificio no te pertenece. ";

        } catch (CasillaOcupadaError e){
            System.out.println("Construcción invalida por casilla ocupada.");
            return "Construcción invalida por casilla ocupada.";

        } catch (ConstruccionNoPermitidaRecursoError e){
            System.out.println("No se puede construir sobre un recurso.");
            return "No se puede construir sobre un recurso.";

        } catch (ConstruccionNoPermitidaTerrenoError e){
            System.out.println("No se puede construir sobre un terreno incompatible con el edificio.");
            return "No se puede construir sobre un terreno incompatible con el edificio.";
        }
        return null;
    }

    private String construirReservaDeReproduccion(Casilla casilla, Jugador jugadorActual){
        try {
            ReservaDeReproduccion r = new ReservaDeReproduccion(casilla);
            jugadorActual.puedeSeleccionar(r.obtenerRaza());
            casilla.construir(r, jugadorActual.obtenerAlmacen());
            jugadorActual.construyo("ReservaDeReproduccion");
            jugadorActual.agregarEdificio(r);

        } catch (SeleccionInvalidaError e){
            System.out.println("Este edificio no te pertenece. ");
            return "Este edificio no te pertenece. ";

        } catch (CasillaOcupadaError e){
            System.out.println("Construcción invalida por casilla ocupada.");
            return "Construcción invalida por casilla ocupada.";

        } catch (ConstruccionNoPermitidaRecursoError e){
            System.out.println("No se puede construir sobre un recurso.");
            return "No se puede construir sobre un recurso.";

        } catch (ConstruccionNoPermitidaTerrenoError e){
            System.out.println("No se puede construir sobre un terreno incompatible con el edificio.");
            return "No se puede construir sobre un terreno incompatible con el edificio.";
        }
        return null;
    }

    private String construirEspiral(Casilla casilla, Jugador jugadorActual){
        try {
            if (!jugadorActual.yaTiene("Guarida")){
                throw new ConstruccionNoPermitidaError();
            }

        } catch (ConstruccionNoPermitidaError e) {
            System.out.println("Para construir un Espiral necesitas una Guarida. ");
            return "Para construir un Espiral necesitas una Guarida. ";
        }

        try {
            Espiral e = new Espiral(casilla);
            jugadorActual.puedeSeleccionar(e.obtenerRaza());
            casilla.construir(e, jugadorActual.obtenerAlmacen());
            jugadorActual.construyo("Espiral");
            jugadorActual.agregarEdificio(e);

        } catch (SeleccionInvalidaError e){
            System.out.println("Este edificio no te pertenece. ");
            return "Este edificio no te pertenece. ";

        } catch (CasillaOcupadaError e){
            System.out.println("Construcción invalida por casilla ocupada.");
            return "Construcción invalida por casilla ocupada.";

        } catch (ConstruccionNoPermitidaRecursoError e){
            System.out.println("No se puede construir sobre un recurso.");
            return "No se puede construir sobre un recurso.";

        } catch (ConstruccionNoPermitidaTerrenoError e){
            System.out.println("No se puede construir sobre un terreno incompatible con el edificio.");
            return "No se puede construir sobre un terreno incompatible con el edificio.";
        }
        return null;
    }

    private String construirPuertoEstelar(Casilla casilla, Jugador jugadorActual) {
        try {
            if (!jugadorActual.yaTiene("Acceso")){
                throw new ConstruccionNoPermitidaError();
            }

        } catch (ConstruccionNoPermitidaError e) {
            System.out.println("Para construir un Puerto Estelar necesitas un Acceso. ");
            return "Para construir un Puerto Estelar necesitas un Acceso. ";
        }

        try {
            PuertoEstelar p = new PuertoEstelar(casilla);
            jugadorActual.puedeSeleccionar(p.obtenerRaza());
            casilla.construir(p, jugadorActual.obtenerAlmacen());
            jugadorActual.construyo("PuertoEstelar");
            jugadorActual.agregarEdificio(p);

        } catch (SeleccionInvalidaError e){
            System.out.println("Este edificio no te pertenece. ");
            return "Este edificio no te pertenece. ";

        } catch (CasillaOcupadaError e){
            System.out.println("Construcción invalida por casilla ocupada.");
            return "Construcción invalida por casilla ocupada.";

        } catch (ConstruccionNoPermitidaRecursoError e){
            System.out.println("No se puede construir sobre un recurso.");
            return "No se puede construir sobre un recurso.";

        } catch (ConstruccionNoPermitidaTerrenoError e){
            System.out.println("No se puede construir sobre un terreno incompatible con el edificio.");
            return "No se puede construir sobre un terreno incompatible con el edificio.";
        }
        return null;
    }

    private String construirAcceso(Casilla casilla, Jugador jugadorActual) {
        try {
            Acceso a = new Acceso(casilla);
            jugadorActual.puedeSeleccionar(a.obtenerRaza());
            casilla.construir(a, jugadorActual.obtenerAlmacen());
            jugadorActual.construyo("Acceso");
            jugadorActual.agregarEdificio(a);

        } catch (SeleccionInvalidaError e){
            System.out.println("Este edificio no te pertenece. ");
            return "Este edificio no te pertenece. ";

        } catch (CasillaOcupadaError e){
            System.out.println("Construcción invalida por casilla ocupada.");
            return "Construcción invalida por casilla ocupada.";

        } catch (ConstruccionNoPermitidaRecursoError e){
            System.out.println("No se puede construir sobre un recurso.");
            return "No se puede construir sobre un recurso.";

        } catch (ConstruccionNoPermitidaTerrenoError e){
            System.out.println("No se puede construir sobre un terreno incompatible con el edificio.");
            return "No se puede construir sobre un terreno incompatible con el edificio.";
        }
        return null;
    }

    private String construirExtractor(Casilla casilla, Jugador jugadorActual){
        try{
            Extractor e = new Extractor(casilla, jugadorActual.obtenerAlmacen());
            jugadorActual.puedeSeleccionar(e.obtenerRaza());
            casilla.construir(e, jugadorActual.obtenerAlmacen());
            jugadorActual.construyo("Extractor");
            jugadorActual.agregarEdificio(e);

        } catch (SeleccionInvalidaError e){
            System.out.println("Este edificio no te pertenece. ");
            return "Este edificio no te pertenece. ";

        } catch (CasillaOcupadaError e){
            System.out.println("Construcción invalida por casilla ocupada.");
            return "Construcción invalida por casilla ocupada.";

        } catch (ConstruccionNoPermitidaRecursoError e){
            System.out.println("No se puede construir sobre un recurso.");
            return "No se puede construir sobre un recurso.";

        } catch (ConstruccionNoPermitidaTerrenoError e){
            System.out.println("No se puede construir sobre un terreno incompatible con el edificio.");
            return "No se puede construir sobre un terreno incompatible con el edificio.";
        }
        return null;
    }

    private String construirGuarida(Casilla casilla, Jugador jugadorActual){
        try {
            if (!jugadorActual.yaTiene("ReservaDeReproduccion")){
                throw new ConstruccionNoPermitidaError();
            }
        } catch (ConstruccionNoPermitidaError e) {
            System.out.println("Para construir una guarida necesitas una Reserva de Reproduccion. ");
            return "Para construir una guarida necesitas una Reserva de Reproduccion. ";
        }

        try {
            Guarida g = new Guarida(casilla);
            jugadorActual.puedeSeleccionar(g.obtenerRaza());
            casilla.construir(g, jugadorActual.obtenerAlmacen());
            jugadorActual.construyo("Guarida");
            jugadorActual.agregarEdificio(g);

        } catch (SeleccionInvalidaError e){
            System.out.println("Este edificio no te pertenece. ");
            return "Este edificio no te pertenece. ";

        } catch (CasillaOcupadaError e){
            System.out.println("Construcción invalida por casilla ocupada.");
            return "Construcción invalida por casilla ocupada.";

        } catch (ConstruccionNoPermitidaRecursoError e){
            System.out.println("No se puede construir sobre un recurso.");
            return "No se puede construir sobre un recurso.";

        } catch (ConstruccionNoPermitidaTerrenoError e){
            System.out.println("No se puede construir sobre un terreno incompatible con el edificio.");
            return "No se puede construir sobre un terreno incompatible con el edificio.";
        }
        return null;
    }

    private String construirNexoMineral(Casilla casilla, Jugador jugadorActual){
        try {
            NexoMineral n = new NexoMineral(casilla, jugadorActual.obtenerAlmacen());
            jugadorActual.puedeSeleccionar(n.obtenerRaza());
            casilla.construir(n, jugadorActual.obtenerAlmacen());
            jugadorActual.construyo("NexoMineral");
            jugadorActual.agregarEdificio(n);

        } catch (SeleccionInvalidaError e){
            System.out.println("Este edificio no te pertenece. ");
            return "Este edificio no te pertenece. ";

        } catch (CasillaOcupadaError e){
            System.out.println("Construcción invalida por casilla ocupada.");
            return "Construcción invalida por casilla ocupada.";

        } catch (ConstruccionNoPermitidaRecursoError e){
            System.out.println("No se puede construir sobre un recurso.");
            return "No se puede construir sobre un recurso.";

        } catch (ConstruccionNoPermitidaTerrenoError e){
            System.out.println("No se puede construir sobre un terreno incompatible con el edificio.");
            return "No se puede construir sobre un terreno incompatible con el edificio.";
        }
        return null;
    }

    private String construirAsimilador(Casilla casilla, Jugador jugadorActual){
        try {
            Asimilador a = new Asimilador(casilla, jugadorActual.obtenerAlmacen());
            jugadorActual.puedeSeleccionar(a.obtenerRaza());
            casilla.construir(a, jugadorActual.obtenerAlmacen());
            jugadorActual.construyo("Asimilador");
            jugadorActual.agregarEdificio(a);

        } catch (SeleccionInvalidaError e){
            System.out.println("Este edificio no te pertenece. ");
            return "Este edificio no te pertenece. ";

        } catch (CasillaOcupadaError e){
            System.out.println("Construcción invalida por casilla ocupada.");
            return "Construcción invalida por casilla ocupada.";

        } catch (ConstruccionNoPermitidaRecursoError e){
            System.out.println("No se puede construir sobre un recurso.");
            return "No se puede construir sobre un recurso.";

        } catch (ConstruccionNoPermitidaTerrenoError e){
            System.out.println("No se puede construir sobre un terreno incompatible con el edificio.");
            return "No se puede construir sobre un terreno incompatible con el edificio.";
        }
        return null;
    }

    private void crearZerling(Casilla casilla, Jugador jugadorActual){

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
            jugadorActual.verificarLarvas();
            jugadorActual.verificarSuministro(z);
            casilla.construir(z,jugadorActual.obtenerAlmacen());
            jugadorActual.consumirSuministro(z);

        } catch (ConstruccionNoPermitidaError e){
            return;

        } catch (PoblacionInsuficienteError e) {
            System.out.println("Población insuficiente para crear un Zerling (1 Pob).");

        } catch (SeleccionInvalidaError s){
            System.out.println("Esta unidad no te pertenece.");

        } catch (LarvasInsuficientesError l){
            System.out.println("No tenes suficientes larvas en tus criaderos. Al avanzar turnos se regeneran.");
        }
    }

    private void crearZangano(Casilla casilla, Jugador jugadorActual){

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
            jugadorActual.verificarLarvas();
            jugadorActual.verificarSuministro(z);
            casilla.construir(z,jugadorActual.obtenerAlmacen());
            jugadorActual.consumirSuministro(z);

        } catch (ConstruccionNoPermitidaError e){
            return;

        } catch (PoblacionInsuficienteError e) {
            System.out.println("Población insuficiente para crear un Zangano (1 Pob).");

        } catch (SeleccionInvalidaError s) {
            System.out.println("Esta unidad no te pertenece.");

        } catch (LarvasInsuficientesError l){
            System.out.println("No tenes suficientes larvas en tus criaderos. Al avanzar turnos se regeneran.");
        }
    }

    private void crearHidralisco(Casilla casilla, Jugador jugadorActual){

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
            jugadorActual.verificarLarvas();
            jugadorActual.verificarSuministro(h);
            casilla.construir(h,jugadorActual.obtenerAlmacen());
            jugadorActual.consumirSuministro(h);

        } catch (ConstruccionNoPermitidaError e){
            return ;

        } catch (PoblacionInsuficienteError e) {
            System.out.println("Población insuficiente para crear un Hidralisco (2 Pob). ");

        } catch (SeleccionInvalidaError s) {
            System.out.println("Esta unidad no te pertenece.");

        } catch (LarvasInsuficientesError l){
            System.out.println("No tenes suficientes larvas en tus criaderos. Al avanzar turnos se regeneran.");
        }
    }

    private void crearMutalisco(Casilla casilla, Jugador jugadorActual){

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
            jugadorActual.verificarLarvas();
            jugadorActual.verificarSuministro(m);
            casilla.construir(m,jugadorActual.obtenerAlmacen());
            jugadorActual.consumirSuministro(m);

        } catch (ConstruccionNoPermitidaError e){
            return ;

        } catch (PoblacionInsuficienteError e) {
            System.out.println("Población insuficiente para crear un Mutalisco (4 Pob).");

        } catch (SeleccionInvalidaError s) {
            System.out.println("Esta unidad no te pertenece.");

        } catch (LarvasInsuficientesError l){
            System.out.println("No tenes suficientes larvas en tus criaderos. Al avanzar turnos se regeneran.");
        }
    }

    private void crearZealot(Casilla casilla, Jugador jugadorActual){

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
            jugadorActual.verificarSuministro(z);
            casilla.construir(z,jugadorActual.obtenerAlmacen());
            jugadorActual.consumirSuministro(z);

        } catch (ConstruccionNoPermitidaError e){
            return ;

        } catch (PoblacionInsuficienteError e) {
            System.out.println("Población insuficiente para crear un Zealot (2 Pob).");

        } catch (SeleccionInvalidaError s) {
            System.out.println("Esta unidad no te pertenece.");
        }
    }

    private void crearDragon(Casilla casilla, Jugador jugadorActual){

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
            jugadorActual.verificarSuministro(d);
            casilla.construir(d,jugadorActual.obtenerAlmacen());
            jugadorActual.consumirSuministro(d);

        } catch (ConstruccionNoPermitidaError e){
            return ;

        } catch (PoblacionInsuficienteError e) {
            System.out.println("Población insuficiente para crear un Dragon (3 Pob).");

        }  catch (SeleccionInvalidaError s) {
            System.out.println("Esta unidad no te pertenece.");
        }
    }

    private void crearScout(Casilla casilla, Jugador jugadorActual){

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
            jugadorActual.verificarSuministro(s);
            casilla.construir(s,jugadorActual.obtenerAlmacen());
            jugadorActual.consumirSuministro(s);

        } catch (ConstruccionNoPermitidaError e){
            return ;

        } catch (PoblacionInsuficienteError e) {
            System.out.println("Población insuficiente para crear un Scout (4 Pob).");

        } catch (SeleccionInvalidaError s) {
            System.out.println("Esta unidad no te pertenece.");
        }
    }

    private void crearAmoSupremo(Casilla casilla, Jugador jugadorActual){

        try {
            AmoSupremo a = new AmoSupremo(casilla);
            jugadorActual.puedeSeleccionar(a.obtenerRaza());
            jugadorActual.verificarLarvas();
            casilla.construir(a, jugadorActual.obtenerAlmacen());
            jugadorActual.generarPoblacion();

        } catch (ConstruccionNoPermitidaError e){
            return ;

        } catch (SeleccionInvalidaError s) {
            System.out.println("Esta unidad no te pertenece.");

        } catch (LarvasInsuficientesError l){
            System.out.println("No tenes suficientes larvas en tus criaderos. Al avanzar turnos se regeneran.");
        }
    }
}
