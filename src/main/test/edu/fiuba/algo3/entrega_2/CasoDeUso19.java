package edu.fiuba.algo3.entrega_2;

import edu.fiuba.algo3.modelo.errores.AtaqueInvalidoError;
import edu.fiuba.algo3.modelo.juego.Casilla;
import edu.fiuba.algo3.modelo.juego.Mapa;
import edu.fiuba.algo3.modelo.unidades.Scout;
import edu.fiuba.algo3.modelo.unidades.Zerling;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class CasoDeUso19 {

    @Test
    public void unZerlingNoPuedeAtacarAUnaUnidadVoladora(){
        Mapa mapa = new Mapa();
        Casilla casilla1 = mapa.obtenerCasilla(5,5);
        Casilla casilla2 = mapa.obtenerCasilla(6,6);
        Zerling z = new Zerling(casilla1);
        Scout s = new Scout(casilla2);

        for (int i=0; i<25; i++){
            z.avanzarTurno();
        }

        assertThrows(AtaqueInvalidoError.class, () -> {z.atacarA(s);});
    }
}
