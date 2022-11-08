package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.Asimilador;
import edu.fiuba.algo3.modelo.Gas;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CasoDeUso3 {
    @Test
    public void test01AsimiladorSePuedeConstruirSobreGas(){
        CasillaDesocupada casillaD = new CasillaDesocupada(0, 0, new Gas());
        Asimilador asimilador = new Asimilador();

        CasillaOcupada casillaO = casillaD.construir(asimilador);

        assertEquals(asimilador, casillaO.edificioActual());
    }

    @Test
    public void test02ExtractorSePuedeConstruirSobreGas(){
        CasillaDesocupada casillaD = new CasillaDesocupada(0, 0, new Gas());
        Asimilador asimilador = new Asimilador();

        CasillaOcupada casillaO = casillaD.construir(asimilador);

        assertEquals(asimilador, casillaO.edificioActual());
    }

    @Test
    public void test03NoSePuedeConstruirUnEdificioQueNoSeaExtractorOAsimiladorSobreGas(){

    }
}
