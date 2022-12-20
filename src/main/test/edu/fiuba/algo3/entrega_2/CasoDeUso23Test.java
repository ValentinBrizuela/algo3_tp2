package edu.fiuba.algo3.entrega_2;

import edu.fiuba.algo3.modelo.edificios.Acceso;
import edu.fiuba.algo3.modelo.errores.AtaquePorAireInvalidoError;
import edu.fiuba.algo3.modelo.juego.*;
import edu.fiuba.algo3.modelo.unidades.Dragon;
import edu.fiuba.algo3.modelo.unidades.Zerling;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class CasoDeUso23Test {
    @Test
    public void noPuedoAtacarUnaUnidadSiNoEstaEnElRangoDeAtaque(){
        Mapa mapa = new Mapa(2);
        Almacen a=new Almacen();
        a.almacenarMineral(10000);
        a.almacenarGas(10000);
        Casilla casilla1 = mapa.obtenerCasilla(15,15);
        Casilla casilla2 = mapa.obtenerCasilla(25,25);
        Zerling z = new Zerling(casilla1);
        Dragon d = new Dragon(casilla2);

        for (int i=0; i<25; i++){
            z.avanzarTurno();
        }

        assertThrows(AtaquePorAireInvalidoError.class, () -> {z.atacarA(d);});
    }

    @Test
    public void noPuedoAtacarUnEdificioSiNoEstaEnElRangoDeAtaque(){
        Mapa mapa = new Mapa(2);
        Almacen a=new Almacen();
        a.almacenarMineral(10000);
        a.almacenarGas(10000);
        Zerling z = new Zerling(mapa.obtenerCasilla(21,21));
        z.finalizarConstruccion();

        Casilla casillaEdificio = mapa.obtenerCasilla(25,25);

        Acceso acceso = new Acceso(casillaEdificio);
        acceso.finalizarConstruccion();

        assertThrows(AtaquePorAireInvalidoError.class, () -> {acceso.recibirAtaque(z, mapa);});
    }
}
