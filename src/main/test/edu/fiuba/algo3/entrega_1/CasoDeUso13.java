package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.edificios.Asimilador;
import edu.fiuba.algo3.modelo.edificios.Criadero;
import edu.fiuba.algo3.modelo.edificios.EdificioVacio;
import edu.fiuba.algo3.modelo.edificios.Pilon;
import edu.fiuba.algo3.modelo.juego.Almacen;
import edu.fiuba.algo3.modelo.juego.Mapa;
import edu.fiuba.algo3.modelo.terrenos.Moho;
import edu.fiuba.algo3.modelo.terrenos.Tierra;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CasoDeUso13 {
    @Test
    public void criaderoSeDestruyeYElMohoSigueEstando() {
        Mapa mapa = new Mapa();
        Almacen almacen = new Almacen();
        almacen.almacenarMineral(100);
        assertEquals(mapa.obtenerCasilla(25, 25).obtenerTerreno().getClass(), Tierra.class);

        Criadero criadero = new Criadero(mapa, 25, 25);
        mapa.obtenerCasilla(25, 25).construir(criadero, almacen);

        criadero.avanzarTurno();

        assertEquals(mapa.obtenerCasilla(25, 25).obtenerTerreno().getClass(), Moho.class);

        criadero.atacar(1000);
        mapa.obtenerCasilla(25, 25).avanzarTurno();

        assertEquals(mapa.obtenerCasilla(25, 25).obtenerEdificio().getClass(), EdificioVacio.class);
        assertEquals(mapa.obtenerCasilla(25, 25).obtenerTerreno().getClass(), Moho.class);
        assertEquals(mapa.obtenerCasilla(26, 26).obtenerTerreno().getClass(), Moho.class);
    }
}
