package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.edificios.Criadero;
import edu.fiuba.algo3.modelo.edificios.EdificioVacio;
import edu.fiuba.algo3.modelo.juego.Almacen;
import edu.fiuba.algo3.modelo.juego.Casilla;
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
        Casilla casilla = mapa.obtenerCasilla(25,25);
        assertEquals(casilla.obtenerEstado().terreno.getClass(), Tierra.class);

        Criadero criadero = new Criadero(mapa, casilla);
        casilla.construir(criadero, almacen);

        criadero.avanzarTurno();

        assertEquals(casilla.obtenerEstado().terreno.getClass(), Moho.class);

        criadero.recibirDanio(1000);
        casilla.avanzarTurno();

        assertEquals(casilla.obtenerEstado().edificio, null);
        assertEquals(casilla.obtenerEstado().terreno.getClass(), Moho.class);
        assertEquals(casilla.obtenerEstado().terreno.getClass(), Moho.class);
    }
}
