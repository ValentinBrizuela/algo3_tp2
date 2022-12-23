package edu.fiuba.algo3.entrega_2;

import edu.fiuba.algo3.modelo.edificios.Acceso;
import edu.fiuba.algo3.modelo.errores.AtaqueInvalidoError;
import edu.fiuba.algo3.modelo.errores.AtaquePorAireInvalidoError;
import edu.fiuba.algo3.modelo.errores.FueraDeRangoError;
import edu.fiuba.algo3.modelo.juego.*;
import edu.fiuba.algo3.modelo.unidades.Dragon;
import edu.fiuba.algo3.modelo.unidades.Zerling;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class CasoDeUso23Test {
    @Test
    public void noPuedoAtacarUnaUnidadSiNoEstaEnElRangoDeAtaque(){
        FakeMapa mapa = new FakeMapa(2);
        Almacen a=new Almacen();
        a.almacenarMineral(10000);
        a.almacenarGas(10000);

        Casilla casilla1 = mapa.obtenerCasilla(5,5);
        Casilla casilla2 = mapa.obtenerCasilla(10,10);
        Zerling z = new Zerling(casilla1);
        Dragon d = new Dragon(casilla2);

        for (int i=0; i<25; i++){
            z.avanzarTurno();
        }

        assertThrows(FueraDeRangoError.class, () -> {z.atacarA(d);});
    }

    @Test
    public void noPuedoAtacarUnEdificioSiNoEstaEnElRangoDeAtaque(){
        FakeMapa mapa = new FakeMapa(2);
        Almacen a=new Almacen();
        a.almacenarMineral(10000);
        a.almacenarGas(10000);

        Zerling z = new Zerling(mapa.obtenerCasilla(5,5));
        z.finalizarConstruccion();

        Casilla casillaEdificio = mapa.obtenerCasilla(8,8);

        Acceso acceso = new Acceso(casillaEdificio);
        acceso.finalizarConstruccion();

        assertThrows(FueraDeRangoError.class, () -> {acceso.recibirAtaque(z, mapa);});
    }
}
