package edu.fiuba.algo3.entrega_3;

import edu.fiuba.algo3.modelo.errores.AtaqueInvalidoError;
import edu.fiuba.algo3.modelo.errores.ZealotInvisibleError;
import edu.fiuba.algo3.modelo.estados.Estado;
import edu.fiuba.algo3.modelo.estados.EstadoMock;
import edu.fiuba.algo3.modelo.estados.Ocupada;
import edu.fiuba.algo3.modelo.juego.Casilla;
import edu.fiuba.algo3.modelo.juego.Mapa;
import edu.fiuba.algo3.modelo.unidades.AmoSupremo;
import edu.fiuba.algo3.modelo.unidades.Zangano;
import edu.fiuba.algo3.modelo.unidades.Zealot;
import edu.fiuba.algo3.modelo.unidades.Zerling;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

public class CasoDeUso28Test {

    @Test
    public void noSePuedeAtacarZealotEstandoInvisible() {
        Mapa mapa = new Mapa(2);

        Casilla casilla1 = mapa.obtenerCasilla(50, 50);
        Casilla casilla2 = mapa.obtenerCasilla(51, 50);
        Casilla casilla3 = mapa.obtenerCasilla(50, 51);
        Casilla casilla4 = mapa.obtenerCasilla(49, 50);
        Casilla casilla5 = mapa.obtenerCasilla(50, 49);

        Zealot zealot = new Zealot(casilla1);
        zealot.finalizarConstruccion();
        Zangano z1 = new Zangano(casilla2);
        Zangano z2 = new Zangano(casilla3);
        Zangano z3 = new Zangano(casilla4);
        Zerling zerling = new Zerling(casilla5);
        zerling.finalizarConstruccion();

        ArrayList<Zangano> zanganos = new ArrayList<>();
        zanganos.add(z1);
        zanganos.add(z2);
        zanganos.add(z3);

       for (int i = 0; i < 4; i++) {
            for (Zangano z: zanganos) {
                z.recibirAtaque(zealot, mapa);
            }
        }

        assertThrows(ZealotInvisibleError.class, () -> {zealot.recibirAtaque(zerling, mapa);});
    }

    @Test
    public void SePuedeAtacarZealotEstandoInvisibleCuandoHayAmoSupremoEnRango() {
        Mapa mapa = new Mapa(2);
        Casilla casilla1 = mapa.obtenerCasilla(50, 50);
        Casilla casilla2 = mapa.obtenerCasilla(51, 50);
        Casilla casilla3 = mapa.obtenerCasilla(50, 51);
        Casilla casilla4 = mapa.obtenerCasilla(49, 50);
        Casilla casilla5 = mapa.obtenerCasilla(50, 49);
        Casilla casilla6 = mapa.obtenerCasilla(51, 51);
        EstadoMock estadoMock = new EstadoMock();
        casilla6.cambiarEstado(estadoMock);

        Zealot zealot = new Zealot(casilla1);
        zealot.finalizarConstruccion();
        Zangano z1 = new Zangano(casilla2);
        Zangano z2 = new Zangano(casilla3);
        Zangano z3 = new Zangano(casilla4);
        Zerling zerling = new Zerling(casilla5);
        zerling.finalizarConstruccion();
        AmoSupremo amo = new AmoSupremo(casilla6);

        ArrayList<Zangano> zanganos = new ArrayList<>();
        zanganos.add(z1);
        zanganos.add(z2);
        zanganos.add(z3);

        for (int i = 0; i < 4; i++) {
            for (Zangano z: zanganos) {
                z.recibirAtaque(zealot, mapa);
            }
        }

        assertDoesNotThrow(() -> {zealot.recibirAtaque(zerling, mapa);});
    }
}
