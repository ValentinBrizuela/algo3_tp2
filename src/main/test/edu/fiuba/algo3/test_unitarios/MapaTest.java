package edu.fiuba.algo3.test_unitarios;

import edu.fiuba.algo3.modelo.juego.Mapa;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class MapaTest {
    @Test
    public void lasPosicionesBordeEstanDentroDelMapa(){
        Mapa mapa = new Mapa(2);
        int tamMapa = mapa.tamanioMapa();

        assertTrue(mapa.estaDentroDelMapa(0,0));
        assertTrue(mapa.estaDentroDelMapa(tamMapa-1,tamMapa-1));
        assertTrue(mapa.estaDentroDelMapa(0,tamMapa-1));
        assertTrue(mapa.estaDentroDelMapa(tamMapa-1,0));
    }
}
