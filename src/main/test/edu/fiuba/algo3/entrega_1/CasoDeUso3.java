package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CasoDeUso3 {
    @Test
    public void test01AsimiladorSePuedeConstruirSobreGeiser(){
        Almacen almacen = new Almacen();
        almacen.almacenarMineral(1000);
        Casilla casilla = new Casilla(0,0, new TierraEnergizada(),new Geiser(), new Desocupada());
        Asimilador asimilador = new Asimilador();

        casilla.construir(asimilador, almacen);

        assertEquals(asimilador, casilla.obtenerEdificio());
    }

    @Test
    public void test02ExtractorSePuedeConstruirSobreGeiser(){
        Casilla casilla = new Casilla(0,0, new Moho(),new Geiser(), new Desocupada());
        Almacen almacen = new Almacen();
        almacen.almacenarMineral(1000);
        Extractor extractor = new Extractor();

        casilla.construir(extractor, almacen);

        assertEquals(extractor, casilla.obtenerEdificio());
    }

    @Test
    public void test03NoSePuedeConstruirUnEdificioQueNoSeaExtractorOAsimiladorSobreGeiser(){
        Casilla casilla = new Casilla(0,0, new TierraEnergizada(),new Geiser(), new Desocupada());
        Criadero criadero = new Criadero();
        Almacen almacen = new Almacen();
        almacen.almacenarMineral(1000);

        assertThrows(ConstruccionNoPermitidaError.class, () -> {casilla.construir(criadero, almacen);});
    }
}
