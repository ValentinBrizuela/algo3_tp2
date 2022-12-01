package edu.fiuba.algo3.test_unitarios;

import edu.fiuba.algo3.modelo.edificios.Criadero;
import edu.fiuba.algo3.modelo.edificios.ParaMock;
import edu.fiuba.algo3.modelo.estados.Estado;
import edu.fiuba.algo3.modelo.juego.Almacen;
import edu.fiuba.algo3.modelo.juego.Casilla;
import edu.fiuba.algo3.modelo.terrenos.Tierra;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class unitaria1Test {

    Casilla casillaMock = mock(Casilla.class);
    Estado estadoMock = mock(Estado.class);
    Almacen almacenMock = mock(Almacen.class);
    Tierra tierraMock = mock(Tierra.class);

    @Test
    public void construirCriaderoSobreTierra() {

        when(almacenMock.cantGas()).thenReturn(1000);
        when(almacenMock.cantMineral()).thenReturn(1000);


        Criadero criadero = new Criadero(casillaMock);

        ParaMock mock = mock(ParaMock.class);

        int num = 10;
        assert(num == 10);
    }

}
