package edu.fiuba.algo3.modelo.edificios;

import edu.fiuba.algo3.modelo.errores.ConstruccionNoPermitidaError;
import edu.fiuba.algo3.modelo.juego.Casilla;
import edu.fiuba.algo3.modelo.juego.IMapa;
import edu.fiuba.algo3.modelo.juego.Jugador;
import edu.fiuba.algo3.modelo.juego.Mapa;

public class EdificiosFactory {

    public void crearEdificio(String edificio, Casilla casilla, Jugador jugadorActual, IMapa mapa){
        switch (edificio) {
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
        }
    }

    public void construirCriadero(Casilla casilla, Jugador jugadorActual, IMapa mapa){
        try {
            Criadero c = new Criadero(casilla);
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
            casilla.construir(a, jugadorActual.obtenerAlmacen());
            jugadorActual.construyo("Acceso");
            jugadorActual.agregarEdificio(a);

        } catch (Exception e){
            System.out.println("No se pudo construir el Acceso. ");
        }
    }

    public void construirExtractor(Casilla casilla, Jugador jugadorActual){
        try{
            Extractor e = new Extractor(casilla);
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
            casilla.construir(g, jugadorActual.obtenerAlmacen());
            jugadorActual.construyo("Guarida");
            jugadorActual.agregarEdificio(g);

        } catch (Exception e) {
            System.out.println("No se pudo construir la Guarida. ");
        }
    }

    public void construirNexoMineral(Casilla casilla, Jugador jugadorActual){
        try {
            NexoMineral n = new NexoMineral(casilla);
            casilla.construir(n, jugadorActual.obtenerAlmacen());
            jugadorActual.construyo("NexoMineral");
            jugadorActual.agregarEdificio(n);

        } catch (Exception e){
            System.out.println("No se pudo construir el Nexo Mineral. ");
        }
    }

    public void construirAsimilador(Casilla casilla, Jugador jugadorActual){
        try {
            Asimilador a = new Asimilador(casilla);
            casilla.construir(a, jugadorActual.obtenerAlmacen());
            jugadorActual.construyo("Asimilador");
            jugadorActual.agregarEdificio(a);

        } catch (Exception e) {
            System.out.println("No se pudo construir el Asimilador. ");
        }
    }
}
