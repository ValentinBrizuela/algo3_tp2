package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
public class CasoDeUso4 {

    @Test
    public void extractorSinZanganosNoGeneraGas() {  /*falta verificar construccion*/
        Geiser geiser = new Geiser();
       Almacen a = new Almacen();
       Extractor e = new Extractor();
       e.extraerGas(a, geiser);

        assertEquals(0, a.cantGas());
    }

    @Test
    public void extractorConUnZanganoGenera10DeGasPorTurno() {
        Geiser geiser = new Geiser();
        Almacen a = new Almacen();
        Extractor e = new Extractor();
        e.meterZangano();
        e.extraerGas(a, geiser);

        assertEquals(10, a.cantGas());

        e.extraerGas(a, geiser);

        assertEquals(20, a.cantGas());
    }

    @Test
    public void extractorCon2ZanganoSGenera20DeGasPorTurno() {
        Geiser geiser = new Geiser();
        Almacen a = new Almacen();
        Extractor e = new Extractor();
        e.meterZangano();
        e.meterZangano();
        e.extraerGas(a, geiser);

        assertEquals(20, a.cantGas());

        e.extraerGas(a, geiser);

        assertEquals(40, a.cantGas());
    }

    @Test
    public void extractorCon3ZanganoSGenera30DeGasPorTurno() {
        Geiser geiser = new Geiser();
        Almacen a = new Almacen();
        Extractor e = new Extractor();
        e.meterZangano();
        e.meterZangano();
        e.meterZangano();
        e.extraerGas(a, geiser);

        assertEquals(30, a.cantGas());

        e.extraerGas(a, geiser);

        assertEquals(60, a.cantGas());
    }

    @Test
    public void extractorTieneCapacidadMaximaDe3Zanganos() {
        Geiser geiser = new Geiser();
        Extractor e = new Extractor();
        e.meterZangano();
        e.meterZangano();
        e.meterZangano();

        assertThrows(ExtractorLlenoError.class, e::meterZangano);
    }

    @Test
    public void asimiladorExtrae20DeGasPorTurno() {/*falta verificar construccion*/
        Geiser geiser = new Geiser();
        Almacen almacen = new Almacen();
        Asimilador a = new Asimilador();
        a.extraerGas(almacen, geiser);

        assertEquals(20, almacen.cantGas());
    }
}
