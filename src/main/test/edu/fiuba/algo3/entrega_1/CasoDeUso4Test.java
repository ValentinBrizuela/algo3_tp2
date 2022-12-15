package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.edificios.Asimilador;
import edu.fiuba.algo3.modelo.edificios.Extractor;
import edu.fiuba.algo3.modelo.errores.ExtractorLlenoError;
import edu.fiuba.algo3.modelo.juego.Almacen;
import edu.fiuba.algo3.modelo.juego.Casilla;
import edu.fiuba.algo3.modelo.recursos.Geiser;
import edu.fiuba.algo3.modelo.terrenos.Moho;
import edu.fiuba.algo3.modelo.terrenos.TierraEnergizada;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
public class CasoDeUso4Test {

    @Test
    public void extractorSinZanganosNoGeneraGas() {  /*falta verificar construccion*/
        Geiser geiser = new Geiser();
       Almacen a = new Almacen();
       Casilla casilla = new Casilla(0,0,new Moho(), geiser);
       Extractor e = new Extractor(casilla, a);
       e.finalizarConstruccion();
       e.avanzarTurno();

        assertEquals(0, a.cantGas());
    }

    @Test
    public void extractorConUnZanganoGenera10DeGasPorTurno() {
        Geiser geiser = new Geiser();
        Almacen a = new Almacen();
        Casilla casilla = new Casilla(0,0,new Moho(), geiser);
        Extractor e = new Extractor(casilla, a);
        e.finalizarConstruccion();

        e.meterZangano();
        e.avanzarTurno();

        assertEquals(10, a.cantGas());

        e.avanzarTurno();

        assertEquals(20, a.cantGas());
    }

    @Test
    public void extractorCon2ZanganoSGenera20DeGasPorTurno() {
        Geiser geiser = new Geiser();
        Almacen a = new Almacen();
        Casilla casilla = new Casilla(0,0,new Moho(), geiser);
        Extractor e = new Extractor(casilla, a);
        e.finalizarConstruccion();

        e.meterZangano();
        e.meterZangano();
        e.avanzarTurno();

        assertEquals(20, a.cantGas());

        e.avanzarTurno();

        assertEquals(40, a.cantGas());
    }

    @Test
    public void extractorCon3ZanganoSGenera30DeGasPorTurno() {
        Geiser geiser = new Geiser();
        Almacen a = new Almacen();
        Casilla casilla = new Casilla(0,0,new Moho(), geiser);
        Extractor e = new Extractor(casilla, a);
        e.finalizarConstruccion();

        e.meterZangano();
        e.meterZangano();
        e.meterZangano();
        e.avanzarTurno();

        assertEquals(30, a.cantGas());

        e.avanzarTurno();

        assertEquals(60, a.cantGas());
    }

    @Test
    public void extractorTieneCapacidadMaximaDe3Zanganos() {
        Geiser geiser = new Geiser();
        Casilla casilla = new Casilla(0,0,new Moho(), geiser);
        Extractor e = new Extractor(casilla, new Almacen());
        e.finalizarConstruccion();

        e.meterZangano();
        e.meterZangano();
        e.meterZangano();

        assertThrows(ExtractorLlenoError.class, e::meterZangano);
    }

    @Test
    public void asimiladorExtrae20DeGasPorTurno() {/*falta verificar construccion*/
        Geiser geiser = new Geiser();
        Casilla casilla = new Casilla(0,0,new TierraEnergizada(),geiser);
        Almacen almacen = new Almacen();
        Asimilador a = new Asimilador(casilla, almacen);
        a.finalizarConstruccion();

        a.avanzarTurno();

        assertEquals(20, almacen.cantGas());
    }
}
