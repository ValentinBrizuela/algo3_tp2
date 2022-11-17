package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.edificios.Asimilador;
import edu.fiuba.algo3.modelo.edificios.Extractor;
import edu.fiuba.algo3.modelo.errores.ConstruccionNoPermitidaError;
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
        Extractor extractor = new Extractor(casilla);
        Almacen almacen = new Almacen();
        almacen.almacenarMineral(1000);

        assertThrows(ConstruccionNoPermitidaError.class, () -> {casilla.construir(extractor, almacen);});
        //Falta testear los otros edificios.
    }

   /* @Test
    public void construyoEdificioZergEnGeiserYNoSePuede() {
        Casilla casilla = new Casilla(0,0, new Moho(),new Geiser(), new Desocupada());
        Criadero criadero = new Criadero();
        Almacen almacen = new Almacen();
        almacen.almacenarMineral(1000);

        assertThrows(ConstruccionNoPermitidaError.class, () -> {casilla.construir(criadero, almacen);});
    }*/

    @Test
    public void construyoEdificioProtossEnMohoYNoSePuede() {
        Casilla casilla = new Casilla(0,0, new Moho(), new Geiser());
        Asimilador asimilador = new Asimilador(casilla);
        Almacen almacen = new Almacen();
        almacen.almacenarMineral(1000);

        assertThrows(ConstruccionNoPermitidaError.class, () -> {casilla.construir(asimilador, almacen);});
    }

    //REFACTOREAR LA CONSTRUCCION POR RAZA.
    @Test
    public void construyoEdificioProtossEnTierraNoEnergizadaYNoSePuede() {
        Casilla casilla = new Casilla(0,0, new Tierra(), new Geiser());
        Asimilador asimilador = new Asimilador(casilla);
        Almacen almacen = new Almacen();
        almacen.almacenarMineral(1000);
        //Casilla sin energia por defecto.
        // Funciona por ser tierra pero deberia funcionar por no tener energia.
        assertThrows(ConstruccionNoPermitidaError.class, () -> {casilla.construir(asimilador, almacen);});
    }
}
