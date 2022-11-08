package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
public class CasoDeUso4 {

    @Test
    public void extractorSinZanganosNoGenraGas() {  /*falta verificar construccion*/
       Almacen a = new Almacen();
       Extractor e = new Extractor();
       e.extraerGas(a);

        assertEquals(0, a.cantGas());
    }

    @Test
    public void extractorConUnZanganoGenera10DeGasPorTurno() {
        Almacen a = new Almacen();
        Extractor e = new Extractor();
        e.meterZangano();
        e.extraerGas(a);

        assertEquals(10, a.cantGas());

        e.extraerGas(a);

        assertEquals(20, a.cantGas());
    }

    @Test
    public void extractorCon2ZanganoSGenera20DeGasPorTurno() {
        Almacen a = new Almacen();
        Extractor e = new Extractor();
        e.meterZangano();
        e.meterZangano();
        e.extraerGas(a);

        assertEquals(20, a.cantGas());

        e.extraerGas(a);

        assertEquals(40, a.cantGas());
    }

    @Test
    public void extractorCon3ZanganoSGenera30DeGasPorTurno() {
        Almacen a = new Almacen();
        Extractor e = new Extractor();
        e.meterZangano();
        e.meterZangano();
        e.meterZangano();
        e.extraerGas(a);

        assertEquals(30, a.cantGas());

        e.extraerGas(a);

        assertEquals(60, a.cantGas());
    }

    @Test
    public void extractorTieneCapacidadMaximaDe3Zanganos() {
        Extractor e = new Extractor();
        e.meterZangano();
        e.meterZangano();
        e.meterZangano();

        assertThrows(ExtractorLlenoError.class, e::meterZangano);
    }

    @Test
    public void asimilador() {    /*falta verificar construccion*/
        Almacen almacen = new Almacen();
        Asimilador a = new Asimilador();
        a.extraerGas(almacen);

        assertEquals(20, almacen.cantGas());
    }
}
