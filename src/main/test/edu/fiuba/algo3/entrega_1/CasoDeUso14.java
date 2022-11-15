package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.edificios.Criadero;
import edu.fiuba.algo3.modelo.edificios.Pilon;
import edu.fiuba.algo3.modelo.juego.Almacen;
import edu.fiuba.algo3.modelo.juego.Mapa;
import edu.fiuba.algo3.modelo.terrenos.Moho;
import edu.fiuba.algo3.modelo.terrenos.TierraEnergizada;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CasoDeUso14 {
    @Test
    public void unPilonNoPuedeEnergizarUnAreaCubiertaPorMoho() {
        Mapa mapa = new Mapa();

        Criadero criadero = new Criadero(mapa, mapa.obtenerCasilla(24, 24));
        Pilon pilon = new Pilon(mapa, mapa.obtenerCasilla(25, 25));


        assertEquals(mapa.obtenerCasilla(26, 25).obtenerEstado().terreno.getClass(), Moho.class);
    }

    @Test
    public void mohoNoSePuedeExpandirPorUnaCasillaOcupada() {
        Mapa mapa = new Mapa();
        Almacen almacen = new Almacen();
        almacen.almacenarMineral(1000);
        Pilon pilon = new Pilon(mapa, mapa.obtenerCasilla(25, 25));
        mapa.obtenerCasilla(25, 25).construir(pilon, almacen);

        Criadero criadero = new Criadero(mapa, mapa.obtenerCasilla(24, 24));

        assertEquals(mapa.obtenerCasilla(25, 25).obtenerEstado().terreno.getClass(), TierraEnergizada.class);
    }
}
