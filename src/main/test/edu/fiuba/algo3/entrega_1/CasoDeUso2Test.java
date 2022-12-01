package edu.fiuba.algo3.entrega_1;
import edu.fiuba.algo3.modelo.edificios.Criadero;
import edu.fiuba.algo3.modelo.errores.EnConstruccionError;
import edu.fiuba.algo3.modelo.juego.Casilla;
import edu.fiuba.algo3.modelo.recursos.RecursoVacio;
import edu.fiuba.algo3.modelo.terrenos.Moho;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
public class CasoDeUso2Test {

    @Test
    public void test01EdificioNoEsOperativoAntesDeConstruirse() {
        Casilla casilla = new Casilla(25,25, new Moho(), new RecursoVacio());
        Criadero c = new Criadero(casilla);
        c.avanzarTurno();
        c.avanzarTurno();
        c.avanzarTurno();

        assertThrows(EnConstruccionError.class, c::engendrarZangano);

    }

    @Test
    public void test02EdificioTardaLoQueCorrespondeEnConstruirse() {
        Casilla casilla = new Casilla(25,25, new Moho(), new RecursoVacio());
        Criadero c = new Criadero(casilla);
        c.avanzarTurno();
        c.avanzarTurno();
        c.avanzarTurno();
        c.avanzarTurno();

       assertEquals(0, c.tiempoDeConstruccion());

    }
}
