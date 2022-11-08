package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CasoDeUso3 {
    @Test
    public void test01AsimiladorSePuedeConstruirSobreGeiser(){
        Casilla casilla = new Casilla(0,0, new Geiser(), new Desocupada());
        Asimilador asimilador = new Asimilador();

        casilla.construir(asimilador);

        assertEquals(asimilador, casilla.obtenerEdificio());
    }

    @Test
    public void test02ExtractorSePuedeConstruirSobreGeiser(){
        Casilla casilla = new Casilla(0,0, new Geiser(), new Desocupada());
        Extractor extractor = new Extractor();

        casilla.construir(extractor);

        assertEquals(extractor, casilla.obtenerEdificio());
    }

    @Test
    public void test03NoSePuedeConstruirUnEdificioQueNoSeaExtractorOAsimiladorSobreGeiser(){
        Casilla casilla = new Casilla(0,0, new Geiser(), new Desocupada());
        Criadero criadero = new Criadero();

        assertThrows(ConstruccionNoPermitidaError.class, () -> {casilla.construir(criadero);});
    }
}
