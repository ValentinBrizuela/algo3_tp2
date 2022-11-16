package edu.fiuba.algo3.entrega_2;

import edu.fiuba.algo3.modelo.juego.Casilla;
import edu.fiuba.algo3.modelo.juego.Mapa;
import edu.fiuba.algo3.modelo.unidades.Dragon;
import edu.fiuba.algo3.modelo.unidades.Zerling;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CasoDeUso18 {

    @Test
    public void UnZerlingHace4DeDanioAUnidadTerrestre(){ /* falta chequear rangoDeAtaque */
        Mapa mapa = new Mapa();
        Casilla casilla1 = mapa.obtenerCasilla(5,5);
        Casilla casilla2 = mapa.obtenerCasilla(6,6);
        Zerling z = new Zerling(casilla1);  /*Cambie el constructor de Terrestre para que no haga super y lo cambie ahí al daño*/
        Dragon d = new Dragon(casilla2);

        for (int i=0; i<25; i++){
            z.avanzarTurno();
        }

        z.atacarA(d);

        assertEquals(76, d.escudo());

    }
}
