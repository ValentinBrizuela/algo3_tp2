package edu.fiuba.algo3.entrega_3;

import edu.fiuba.algo3.modelo.errores.ZealotInvisibleError;
import edu.fiuba.algo3.modelo.juego.Almacen;
import edu.fiuba.algo3.modelo.juego.Casilla;
import edu.fiuba.algo3.modelo.juego.Mapa;
import edu.fiuba.algo3.modelo.recursos.RecursoVacio;
import edu.fiuba.algo3.modelo.terrenos.Tierra;
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
        Almacen a=new Almacen();
        a.almacenarMineral(100000);

        Casilla casilla1 = mapa.obtenerCasilla(50, 50);
        Casilla casilla2 = mapa.obtenerCasilla(51, 50);
        Casilla casilla3 = mapa.obtenerCasilla(50, 51);
        Casilla casilla4 = mapa.obtenerCasilla(49, 50);
        Casilla casilla5 = mapa.obtenerCasilla(50, 49);

        Zealot zealot = new Zealot(casilla1);
        zealot.finalizarConstruccion();
        Zangano z1 = new Zangano(casilla2,a );
        Zangano z2 = new Zangano(casilla3, a);
        Zangano z3 = new Zangano(casilla4, a);
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
        } //Mata los zanganos

        assertThrows(ZealotInvisibleError.class, () -> {zealot.recibirAtaque(zerling, mapa);});
    }

    @Test
    public void SePuedeAtacarZealotEstandoInvisibleCuandoHayAmoSupremoEnRango() {
        Mapa mockMapa = mock(Mapa.class);
        Almacen a=new Almacen();
        a.almacenarMineral(100000);

        when(mockMapa.hayDetector(50, 50, 4)).thenReturn(true);
        when(mockMapa.obtenerCasilla(50, 50)).thenReturn(new Casilla(50, 50, new Tierra(), new RecursoVacio()));
        when(mockMapa.obtenerCasilla(51, 50)).thenReturn(new Casilla(51, 50, new Tierra(), new RecursoVacio()));
        when(mockMapa.obtenerCasilla(50, 51)).thenReturn(new Casilla(50, 51, new Tierra(), new RecursoVacio()));
        when(mockMapa.obtenerCasilla(49, 50)).thenReturn(new Casilla(49, 50, new Tierra(), new RecursoVacio()));
        when(mockMapa.obtenerCasilla(50, 49)).thenReturn(new Casilla(50, 49, new Tierra(), new RecursoVacio()));

        Casilla casilla1 = mockMapa.obtenerCasilla(50, 50);
        Casilla casilla2 = mockMapa.obtenerCasilla(51, 50);
        Casilla casilla3 = mockMapa.obtenerCasilla(50, 51);
        Casilla casilla4 = mockMapa.obtenerCasilla(49, 50);
        Casilla casilla5 = mockMapa.obtenerCasilla(50, 49);

        Zealot zealot = new Zealot(casilla1);
        zealot.finalizarConstruccion();
        Zangano z1 = new Zangano(casilla2, a);
        Zangano z2 = new Zangano(casilla3, a);
        Zangano z3 = new Zangano(casilla4, a);
        Zerling zerling = new Zerling(casilla5);
        zerling.finalizarConstruccion();

        ArrayList<Zangano> zanganos = new ArrayList<>();
        zanganos.add(z1);
        zanganos.add(z2);
        zanganos.add(z3);

        for (int i = 0; i < 4; i++) {
            for (Zangano z: zanganos) {
                z.recibirAtaque(zealot, mockMapa);
            }
        } //Mata los zanganos

        assertDoesNotThrow(() -> {zealot.recibirAtaque(zerling, mockMapa);});
    }
}
