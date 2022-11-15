package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.edificios.Acceso;
import edu.fiuba.algo3.modelo.edificios.Pilon;
import edu.fiuba.algo3.modelo.juego.Almacen;
import edu.fiuba.algo3.modelo.juego.Casilla;
import edu.fiuba.algo3.modelo.juego.Mapa;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CasoDeUso9 {
    @Test
    public void EdificioProtossSigueEnergizadoSiLeDestruyenElPilonQueLoEnergizaPeroTieneOtroEnRango(){
        Mapa mapa = new Mapa();
        Almacen almacen = new Almacen();
        Casilla casilla = mapa.obtenerCasilla(10, 12);
        Acceso acceso = new Acceso(casilla);
        Pilon pilon1 = new Pilon(mapa, mapa.obtenerCasilla(10, 10));
        Pilon pilon2 = new Pilon(mapa, mapa.obtenerCasilla(10, 11));


        almacen.almacenarMineral(5000);

        casilla.construir(acceso, almacen);
        mapa.obtenerCasilla(10, 10).construir(pilon1, almacen);
        mapa.obtenerCasilla(10, 11).construir(pilon2, almacen);

        assertTrue(acceso.estaEnergizado());

        pilon2.recibirDanio(2000);

        mapa.obtenerCasilla(10, 10).avanzarTurno();

        assertTrue(acceso.estaEnergizado());
    }
}
