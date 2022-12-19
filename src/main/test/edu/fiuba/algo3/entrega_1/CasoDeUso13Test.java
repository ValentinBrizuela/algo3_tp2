package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.edificios.Criadero;
import edu.fiuba.algo3.modelo.juego.Almacen;
import edu.fiuba.algo3.modelo.juego.Casilla;
import edu.fiuba.algo3.modelo.juego.FakeMapa;
import edu.fiuba.algo3.modelo.juego.Mapa;
import edu.fiuba.algo3.modelo.terrenos.Moho;
import edu.fiuba.algo3.modelo.terrenos.Tierra;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CasoDeUso13Test {
    @Test
    public void criaderoSeDestruyeYElMohoSigueEstando() {
        FakeMapa mapa = new FakeMapa(2);
        Almacen almacen = new Almacen();
        almacen.almacenarMineral(500);

        Casilla casilla = mapa.obtenerCasilla(5,5);
        assertEquals(casilla.obtenerEstado().obtenerTerreno().getClass(), Tierra.class);

        Criadero criadero = new Criadero(casilla);
        casilla.construir(criadero, almacen);

        criadero.avanzarTurno();

        assertEquals(casilla.obtenerEstado().obtenerTerreno().getClass(), Moho.class);

        criadero.aplicarDanio(1000);

        casilla.avanzarTurno();

        assertEquals(true, criadero.estaDestruido());
        assertEquals(casilla.obtenerEstado().obtenerTerreno().getClass(), Moho.class);
        assertEquals(casilla.obtenerEstado().obtenerTerreno().getClass(), Moho.class);
    }
}
