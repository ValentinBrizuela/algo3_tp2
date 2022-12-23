package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.edificios.Asimilador;
import edu.fiuba.algo3.modelo.edificios.Extractor;
import edu.fiuba.algo3.modelo.errores.ConstruccionNoPermitidaError;
import edu.fiuba.algo3.modelo.errores.ConstruccionNoPermitidaTerrenoError;
import edu.fiuba.algo3.modelo.juego.Almacen;
import edu.fiuba.algo3.modelo.juego.Casilla;
import edu.fiuba.algo3.modelo.recursos.Geiser;
import edu.fiuba.algo3.modelo.terrenos.Moho;
import edu.fiuba.algo3.modelo.terrenos.Tierra;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CasoDeUso5Test {
    
    @Test
    public void construyoEdificioZergEnTierraYNoSePuede() {
        Casilla casilla = new Casilla(0,0, new Tierra(), new Geiser());
        Almacen almacen = new Almacen();
        Extractor extractor = new Extractor(casilla, almacen);
        almacen.almacenarMineral(1000);

        assertThrows(ConstruccionNoPermitidaTerrenoError.class, () -> {casilla.construir(extractor, almacen);});
    }

    @Test
    public void construyoEdificioProtossEnMohoYNoSePuede() {
        Casilla casilla = new Casilla(0,0, new Moho(), new Geiser());
        Almacen almacen = new Almacen();
        Asimilador asimilador = new Asimilador(casilla, almacen);
        almacen.almacenarMineral(1000);

        assertThrows(ConstruccionNoPermitidaTerrenoError.class, () -> {casilla.construir(asimilador, almacen);});
    }

    //REFACTOREAR LA CONSTRUCCION POR RAZA.
    @Test
    public void construyoEdificioProtossEnTierraNoEnergizadaYNoSePuede() {
        Casilla casilla = new Casilla(0,0, new Tierra(), new Geiser());
        Almacen almacen = new Almacen();
        Asimilador asimilador = new Asimilador(casilla, almacen);
        almacen.almacenarMineral(1000);
        //Casilla sin energia por defecto.
        // Funciona por ser tierra pero deberia funcionar por no tener energia.
        assertThrows(ConstruccionNoPermitidaTerrenoError.class, () -> {casilla.construir(asimilador, almacen);});
    }
}
