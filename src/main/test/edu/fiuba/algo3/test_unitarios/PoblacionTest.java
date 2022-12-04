package edu.fiuba.algo3.test_unitarios;

import edu.fiuba.algo3.modelo.errores.PoblacionInsuficienteError;
import edu.fiuba.algo3.modelo.juego.*;
import edu.fiuba.algo3.modelo.razas.Protoss;
import edu.fiuba.algo3.modelo.razas.Zerg;
import edu.fiuba.algo3.modelo.unidades.Hidralisco;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

public class PoblacionTest {
    @Test
    public void noSePuedeCrearUnaUnidadSiSuSuministroEsMayorALaCapacidadActual(){
        Poblacion poblacion = new Poblacion();
        Hidralisco hidraliscoMock = mock(Hidralisco.class);
        when(hidraliscoMock.tenesEspacioConEstaCapacidad(0)).thenReturn(false);

        assertThrows(PoblacionInsuficienteError.class, () -> {poblacion.verificarYDescontarCapacidad(hidraliscoMock);});
    }

    @Test
    public void sePuedeCrearUnaUnidadSiSuSuministroEsMayorALaCapacidadActual(){
        Poblacion poblacion = new Poblacion();
        Hidralisco hidraliscoMock = mock(Hidralisco.class);
        when(hidraliscoMock.tenesEspacioConEstaCapacidad(0)).thenReturn(true);

        poblacion.verificarYDescontarCapacidad(hidraliscoMock);

        verify(hidraliscoMock).comunicarDescuentoDePoblacion(poblacion);
    }

    @Test
    public void siLaCapacidadYaEsMaximaLaPoblacionNoAumenta(){
        Poblacion poblacion = new Poblacion();
        for (int i=0; i<40; i++) {
            poblacion.aumentarPoblacion();
        }

        poblacion.aumentarPoblacion();
        assertEquals(200, poblacion.cantidadUsable());
    }
}
