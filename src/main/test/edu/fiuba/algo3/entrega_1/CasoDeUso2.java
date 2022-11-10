package edu.fiuba.algo3.entrega_1;
import edu.fiuba.algo3.modelo.edificios.Criadero;
import edu.fiuba.algo3.modelo.errores.EdificioEnConstruccionError;
import edu.fiuba.algo3.modelo.juego.Casilla;
import edu.fiuba.algo3.modelo.juego.Mapa;
import edu.fiuba.algo3.modelo.recursos.RecursoVacio;
import edu.fiuba.algo3.modelo.terrenos.Moho;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
public class CasoDeUso2 {

    @Test
    public void test01EdificioNoEsOperativoAntesDeConstruirse() {
        Casilla casilla = new Casilla(25,25, new Moho(), new RecursoVacio());
        Criadero c = new Criadero(new Mapa(), casilla);
        c.avanzarTurno();
        c.avanzarTurno();
        c.avanzarTurno();

        assertThrows(EdificioEnConstruccionError.class, c::engendrarZangano);

    }

    @Test
    public void test02EdificioTardaLoQueCorrespondeEnConstruirse() {
        Casilla casilla = new Casilla(25,25, new Moho(), new RecursoVacio());
        Criadero c = new Criadero(new Mapa(), casilla);
        c.avanzarTurno();
        c.avanzarTurno();
        c.avanzarTurno();
        c.avanzarTurno();

       assertEquals(0, c.tiempoDeConstruccion());

    }
}
