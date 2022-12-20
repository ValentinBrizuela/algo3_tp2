package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.edificios.Pilon;
import edu.fiuba.algo3.modelo.juego.Casilla;
import edu.fiuba.algo3.modelo.juego.Mapa;
import edu.fiuba.algo3.modelo.recursos.RecursoVacio;
import edu.fiuba.algo3.modelo.terrenos.TierraEnergizada;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CasoDeUso11Test {
    @Test
    public void construccionProtossRecuperaEscudoPorTurnoHastaElMaximo() {
        Casilla casilla = new Casilla(25,25, new TierraEnergizada(), new RecursoVacio());
        Pilon pilon = new Pilon(casilla);
        pilon.aplicarDanio(100);

        assertEquals(200, pilon.escudo());

        pilon.avanzarTurno();

        assertEquals(203, pilon.escudo());

        pilon.avanzarTurno();

        assertEquals(206, pilon.escudo());

        for (int i=0; i<32; i++){
            pilon.avanzarTurno();
        }

        assertEquals(300, pilon.escudo());
    }
}
