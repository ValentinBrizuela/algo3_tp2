package edu.fiuba.algo3.entrega_1;
import edu.fiuba.algo3.modelo.edificios.Criadero;
import edu.fiuba.algo3.modelo.juego.Casilla;
import edu.fiuba.algo3.modelo.recursos.RecursoVacio;
import edu.fiuba.algo3.modelo.terrenos.Moho;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CasoDeUso10Test {
    @Test
    public void construccionZergRecuperaVidaPorTurnoHastaElMaximo() { /*Supuesto: Recupera 1% de su vida max por turno*/
        Casilla casilla = new Casilla(25,25, new Moho(), new RecursoVacio());
        Criadero criadero = new Criadero(casilla);
        criadero.aplicarDanio(100);

        assertEquals(400, criadero.vida());

        criadero.avanzarTurno();

        assertEquals(405, criadero.vida());

        criadero.avanzarTurno();

        assertEquals(410, criadero.vida());

        for (int i=0; i<18; i++){
            criadero.avanzarTurno();
        }

        assertEquals(500, criadero.vida());

        criadero.avanzarTurno();

        assertEquals(500, criadero.vida());

    }
}
