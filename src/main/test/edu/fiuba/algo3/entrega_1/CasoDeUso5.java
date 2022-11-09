package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CasoDeUso5 {


    @Test
    public void construyoEdificioZergEnTierraYNoSePuede() {
        Casilla casilla = new Casilla(0,0, new Tierra(), new Desocupada());
        Extractor extractor = new Extractor();

        assertThrows(ConstruccionNoPermitidaError.class, () -> {casilla.construir(extractor);});
        //Falta testear los otros edificios.
    }

    @Test
    public void construyoEdificioZergEnGeiserYNoSePuede() {
        Casilla casilla = new Casilla(0,0, new Geiser(), new Desocupada());
        Criadero criadero = new Criadero();

        assertThrows(ConstruccionNoPermitidaError.class, () -> {casilla.construir(criadero);});
    }

    @Test
    public void construyoEdificioProtossEnMohoYNoSePuede() {
        Casilla casilla = new Casilla(0,0, new Moho(), new Desocupada());
        Asimilador asimilador = new Asimilador();

        assertThrows(ConstruccionNoPermitidaError.class, () -> {casilla.construir(asimilador);});
    }

    //REFACTOREAR LA CONSTRUCCION POR RAZA.
    @Test
    public void construyoEdificioProtossEnTierraNoEnergizadaYNoSePuede() {
        Casilla casilla = new Casilla(0,0, new Tierra(), new Desocupada());
        Acceso acceso = new Acceso();
        //Casilla sin energia por defecto.
        // Funciona por ser tierra pero deberia funcionar por no tener energia.
        assertThrows(ConstruccionNoPermitidaError.class, () -> {casilla.construir(acceso);});
    }
}
