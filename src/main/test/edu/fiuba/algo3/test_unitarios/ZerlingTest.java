package edu.fiuba.algo3.test_unitarios;

import edu.fiuba.algo3.modelo.juego.Casilla;
import edu.fiuba.algo3.modelo.juego.Mapa;
import edu.fiuba.algo3.modelo.recursos.RecursoVacio;
import edu.fiuba.algo3.modelo.terrenos.Moho;
import edu.fiuba.algo3.modelo.unidades.Dragon;
import edu.fiuba.algo3.modelo.unidades.Scout;
import edu.fiuba.algo3.modelo.unidades.Zerling;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ZerlingTest {
    @Test
    public void unZerlingSeRegeneraLuegoDeRecibirDanio(){
        Mapa mapa = mock(Mapa.class);
        when(mapa.obtenerCasilla(anyInt(), anyInt())).thenReturn(new Casilla(5,5,new Moho(), new RecursoVacio()));

        Zerling z = new Zerling(mapa.obtenerCasilla(5,5));
        Dragon dragon = new Dragon(mapa.obtenerCasilla(5,6));

        for (int i=0; i<6; i++){
            dragon.avanzarTurno();
        }

        dragon.atacarA(z);

        z.avanzarTurno();

        assertEquals(18, z.vida());
    }
}
