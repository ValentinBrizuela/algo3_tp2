package edu.fiuba.algo3.entrega_2;

import edu.fiuba.algo3.modelo.errores.AtaquePorAireInvalidoError;
import edu.fiuba.algo3.modelo.juego.Almacen;
import edu.fiuba.algo3.modelo.juego.Casilla;
import edu.fiuba.algo3.modelo.juego.FakeMapa;
import edu.fiuba.algo3.modelo.juego.Mapa;
import edu.fiuba.algo3.modelo.unidades.Guardian;
import edu.fiuba.algo3.modelo.unidades.Scout;
import edu.fiuba.algo3.modelo.unidades.Zealot;
import edu.fiuba.algo3.modelo.unidades.Zerling;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class CasoDeUso19Test {

    @Test
    public void unZerlingNoPuedeAtacarAUnaUnidadVoladora(){
        FakeMapa mapa = new FakeMapa(2);
        Almacen a=new Almacen();
        a.almacenarMineral(10000);
        a.almacenarGas(10000);

        Casilla casilla1 = mapa.obtenerCasilla(5,5);
        Casilla casilla2 = mapa.obtenerCasilla(6,6);

        Zerling z = new Zerling(casilla1);
        Scout s = new Scout(casilla2);

        for (int i=0; i<25; i++){
            z.avanzarTurno();
        }

        assertThrows(AtaquePorAireInvalidoError.class, () -> {s.recibirAtaque(z, mapa);});
    }

    @Test
    public void unguardianNoPuedeAtacarAUnaUnidadVoladora(){
        FakeMapa mapa = new FakeMapa(2);
        Almacen a=new Almacen();
        a.almacenarMineral(10000);
        a.almacenarGas(10000);

        Casilla casilla1 = mapa.obtenerCasilla(5,5);
        Casilla casilla2 = mapa.obtenerCasilla(6,6);

        Guardian g = new Guardian(casilla1,a );
        Scout s = new Scout(casilla2);

        for (int i=0; i<25; i++){
            g.avanzarTurno();
        }

        assertThrows(AtaquePorAireInvalidoError.class, () -> {s.recibirAtaque(g, mapa);});
    }

    @Test
    public void unZealotNoPuedeAtacarAUnaUnidadVoladora(){
        FakeMapa mapa = new FakeMapa(2);
        Almacen a=new Almacen();
        a.almacenarMineral(10000);
        a.almacenarGas(10000);

        Casilla casilla1 = mapa.obtenerCasilla(5,5);
        Casilla casilla2 = mapa.obtenerCasilla(6,6);
        Zealot z = new Zealot(casilla1);
        Scout s = new Scout(casilla2);

        for (int i=0; i<25; i++){
            z.avanzarTurno();
        }

        assertThrows(AtaquePorAireInvalidoError.class, () -> {s.recibirAtaque(z, mapa);});
    }

}
