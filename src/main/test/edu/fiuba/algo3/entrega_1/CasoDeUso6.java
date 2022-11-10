package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.edificios.Criadero;
import edu.fiuba.algo3.modelo.juego.Mapa;
import edu.fiuba.algo3.modelo.terrenos.Moho;
import edu.fiuba.algo3.modelo.terrenos.Tierra;
import edu.fiuba.algo3.modelo.terrenos.TierraEnergizada;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CasoDeUso6 {
    @Test
    public void mohoSeExpandeSegunLoEsperado() {
        Mapa mapa = new Mapa();
        Criadero criadero = new Criadero(mapa, 25, 25);

        criadero.avanzarTurno();
        assertEquals(Moho.class, mapa.obtenerCasilla(30, 30).obtenerTerreno().getClass());
        assertEquals(Tierra.class, mapa.obtenerCasilla(31, 31).obtenerTerreno().getClass());

        criadero.avanzarTurno();
        assertEquals(Moho.class, mapa.obtenerCasilla(30, 30).obtenerTerreno().getClass());
        assertEquals(Tierra.class, mapa.obtenerCasilla(31, 31).obtenerTerreno().getClass());

        criadero.avanzarTurno();
        assertEquals(Moho.class, mapa.obtenerCasilla(30, 30).obtenerTerreno().getClass());
        assertEquals(Moho.class, mapa.obtenerCasilla(31, 31).obtenerTerreno().getClass());
    }
}
