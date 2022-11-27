package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.edificios.Acceso;
import edu.fiuba.algo3.modelo.edificios.Pilon;
import edu.fiuba.algo3.modelo.juego.Almacen;
import edu.fiuba.algo3.modelo.juego.Casilla;
import edu.fiuba.algo3.modelo.juego.Mapa;
import edu.fiuba.algo3.modelo.terrenos.TierraEnergizada;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CasoDeUso9Test {
    @Test
    public void EdificioProtossSigueEnergizadoSiLeDestruyenElPilonQueLoEnergizaPeroTieneOtroEnRango(){
        Mapa mapa = new Mapa(2);
        Almacen almacen = new Almacen();
        Casilla casilla = mapa.obtenerCasilla(49, 49);
        Pilon pilon1 = new Pilon(mapa, mapa.obtenerCasilla(50, 50));
        Pilon pilon2 = new Pilon(mapa, mapa.obtenerCasilla(50, 51));
        Acceso acceso = new Acceso(casilla);


        almacen.almacenarMineral(5000);

        mapa.obtenerCasilla(50, 50).construir(pilon1, almacen);
        mapa.obtenerCasilla(50, 51).construir(pilon2, almacen);
        casilla.construir(acceso, almacen);


        assertEquals(casilla.obtenerEstado().obtenerTerreno().getClass(), TierraEnergizada.class);

        pilon2.aplicarDanio(2000);

        mapa.obtenerCasilla(50, 50).avanzarTurno();

        assertEquals(casilla.obtenerEstado().obtenerTerreno().getClass(), TierraEnergizada.class);
        /*assertTrue(acceso.estaEnergizado());*/
    }
}
