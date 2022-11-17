package edu.fiuba.algo3.entrega_2;

import edu.fiuba.algo3.modelo.errores.EnConstruccionError;
import edu.fiuba.algo3.modelo.errores.UnidadEnConstruccionError;
import edu.fiuba.algo3.modelo.juego.Casilla;
import edu.fiuba.algo3.modelo.juego.Mapa;
import edu.fiuba.algo3.modelo.unidades.Dragon;
import edu.fiuba.algo3.modelo.unidades.Zerling;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CasoDeUso22 {
    @Test
    public void NoPuedoUsarUnidadSiNoSeTerminoDeConstruir(){
        Mapa mapa = new Mapa(2);
        Casilla casilla1 = mapa.obtenerCasilla(5,5);
        Casilla casilla2 = mapa.obtenerCasilla(5,6);
        Zerling z = new Zerling(casilla1);
        Dragon d = new Dragon(casilla2);

        assertThrows(EnConstruccionError.class, () -> {z.atacarA(d);});
    }

    @Test
    public void NoPuedoConstruirUnZerlingSinReservaDeReproduccion(){

    }
}
