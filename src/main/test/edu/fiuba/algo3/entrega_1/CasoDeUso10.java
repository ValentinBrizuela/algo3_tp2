package edu.fiuba.algo3.entrega_1;
import edu.fiuba.algo3.modelo.edificios.Criadero;
import edu.fiuba.algo3.modelo.juego.Mapa;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CasoDeUso10 {
    @Test
    public void construccionZergRecuperaVidaPorTurnoHastaElMaximo() { /*Supuesto: Recupera 10% por turno*/
        Criadero criadero = new Criadero(new Mapa(), 25, 25);
        criadero.atacar(100);

        assertEquals(400, criadero.vida());

        criadero.avanzarTurno();

        assertEquals(450, criadero.vida());

        criadero.avanzarTurno();

        assertEquals(500, criadero.vida());

        criadero.avanzarTurno();

        assertEquals(500, criadero.vida());
    }
}
