package edu.fiuba.algo3.entrega_2;

import edu.fiuba.algo3.modelo.edificios.Acceso;
import edu.fiuba.algo3.modelo.errores.AtaqueInvalidoError;
import edu.fiuba.algo3.modelo.juego.*;
import edu.fiuba.algo3.modelo.unidades.Dragon;
import edu.fiuba.algo3.modelo.unidades.Zerling;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class CasoDeUso23Test {
    @Test
    public void noPuedoAtacarUnaUnidadSiNoEstaEnElRangoDeAtaque(){
        Mapa mapa = new Mapa(2);
        Casilla casilla1 = mapa.obtenerCasilla(5,5);
        Casilla casilla2 = mapa.obtenerCasilla(15,15);
        Zerling z = new Zerling(casilla1);
        Dragon d = new Dragon(casilla2);

        for (int i=0; i<25; i++){
            z.avanzarTurno();
        }

        assertThrows(AtaqueInvalidoError.class, () -> {z.atacarA(d);});
    }

    @Test
    public void noPuedoAtacarUnEdificioSiNoEstaEnElRangoDeAtaque(){
        Mapa mapa = new Mapa(2);
        Zerling z = new Zerling(mapa.obtenerCasilla(1,1));
        z.finalizarConstruccion();

        Casilla casillaEdificio = mapa.obtenerCasilla(5,5);

        Acceso acceso = new Acceso(casillaEdificio);
        acceso.finalizarConstruccion();

        assertThrows(AtaqueInvalidoError.class, () -> {acceso.recibirAtaque(z);});
    }
}
