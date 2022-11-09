package edu.fiuba.algo3.entrega_1;
import edu.fiuba.algo3.modelo.edificios.Criadero;
import edu.fiuba.algo3.modelo.errores.EdificioEnConstruccionError;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
public class CasoDeUso2 {

    @Test
    public void test01EdificioNoEsOperativoAntesDeConstruirse() {
        Criadero c = new Criadero();
        c.avanzarTurno();
        c.avanzarTurno();
        c.avanzarTurno();

        assertThrows(EdificioEnConstruccionError.class, c::engendrarZangano);

    }

    @Test
    public void test02EdificioTardaLoQueCorrespondeEnConstruirse() {
        Criadero c = new Criadero();
        c.avanzarTurno();
        c.avanzarTurno();
        c.avanzarTurno();
        c.avanzarTurno();

       assertEquals(0, c.tiempoDeConstruccion());

    }
}
