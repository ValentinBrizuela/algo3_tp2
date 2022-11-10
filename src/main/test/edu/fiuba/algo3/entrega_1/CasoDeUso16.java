package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.edificios.Extractor;
import edu.fiuba.algo3.modelo.errores.ConstruccionNoPermitidaError;
import edu.fiuba.algo3.modelo.errores.EdificioYaConstruidoError;
import edu.fiuba.algo3.modelo.estados.Desocupada;
import edu.fiuba.algo3.modelo.juego.Almacen;
import edu.fiuba.algo3.modelo.juego.Casilla;
import edu.fiuba.algo3.modelo.recursos.Geiser;
import edu.fiuba.algo3.modelo.terrenos.Moho;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class CasoDeUso16 {
    @Test
    public void NoPuedoConstruirSobreGeiserYaConstruidoPropio(){
        Casilla casilla = new Casilla(0,0, new Moho(),new Geiser(), new Desocupada());
        Almacen almacen = new Almacen();
        almacen.almacenarMineral(1000);
        Extractor extractor = new Extractor(casilla);

        casilla.construir(extractor, almacen);

        Extractor extractor2 = new Extractor(casilla);
        assertThrows(EdificioYaConstruidoError.class, () -> {casilla.construir(extractor2, almacen);});
    }

    @Test
    public void NoPuedoConstruirSobreGeiserYaConstruidoEnemigo(){
        Casilla casilla = new Casilla(0,0, new Moho(),new Geiser(), new Desocupada());
        Almacen almacen = new Almacen();
        almacen.almacenarMineral(1000);
        Extractor extractor = new Extractor(casilla);

        casilla.construir(extractor, almacen);

        Extractor extractor2 = new Extractor(casilla);
        assertThrows(EdificioYaConstruidoError.class, () -> {casilla.construir(extractor2, almacen);});
    }

    /* Faltan demas casos */
}
