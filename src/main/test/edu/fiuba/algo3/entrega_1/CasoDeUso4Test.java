package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.edificios.Asimilador;
import edu.fiuba.algo3.modelo.edificios.Extractor;
import edu.fiuba.algo3.modelo.errores.ExtractorLlenoError;
import edu.fiuba.algo3.modelo.juego.Almacen;
import edu.fiuba.algo3.modelo.juego.Casilla;
import edu.fiuba.algo3.modelo.recursos.Geiser;
import edu.fiuba.algo3.modelo.recursos.RecursoVacio;
import edu.fiuba.algo3.modelo.terrenos.Moho;
import edu.fiuba.algo3.modelo.terrenos.Tierra;
import edu.fiuba.algo3.modelo.terrenos.TierraEnergizada;
import edu.fiuba.algo3.modelo.unidades.Zangano;
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

        Casilla casillaZangano = new Casilla(0,1,new Tierra(), new RecursoVacio());
        Zangano z = new Zangano(casillaZangano, a);
        z.finalizarConstruccion();

        e.meterZangano(z);
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

        Casilla casillaZangano1 = new Casilla(0,1,new Tierra(), new RecursoVacio());
        Casilla casillaZangano2 = new Casilla(1,1,new Tierra(), new RecursoVacio());
        Zangano z1 = new Zangano(casillaZangano1, a);
        Zangano z2 = new Zangano(casillaZangano2, a);
        z1.finalizarConstruccion();
        z2.finalizarConstruccion();



        e.meterZangano(z1);
        e.meterZangano(z2);
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

        Casilla casillaZangano1 = new Casilla(0,1,new Tierra(), new RecursoVacio());
        Casilla casillaZangano2 = new Casilla(1,1,new Tierra(), new RecursoVacio());
        Casilla casillaZangano3 = new Casilla(2,1,new Tierra(), new RecursoVacio());

        Zangano z1 = new Zangano(casillaZangano1, a);
        Zangano z2 = new Zangano(casillaZangano2, a);
        Zangano z3 = new Zangano(casillaZangano3, a);
        z1.finalizarConstruccion();
        z2.finalizarConstruccion();
        z3.finalizarConstruccion();

        e.meterZangano(z1);
        e.meterZangano(z2);
        e.meterZangano(z3);
        e.avanzarTurno();

        assertEquals(30, a.cantGas());

        e.avanzarTurno();

        assertEquals(60, a.cantGas());
    }

    @Test
    public void extractorTieneCapacidadMaximaDe3Zanganos() {
        Geiser geiser = new Geiser();
        Almacen a = new Almacen();
        Casilla casilla = new Casilla(0,0,new Moho(), geiser);
        Extractor e = new Extractor(casilla, a);
        e.finalizarConstruccion();

        Casilla casillaZangano1 = new Casilla(0,1,new Tierra(), new RecursoVacio());
        Casilla casillaZangano2 = new Casilla(1,1,new Tierra(), new RecursoVacio());
        Casilla casillaZangano3 = new Casilla(2,1,new Tierra(), new RecursoVacio());
        Casilla casillaZangano4 = new Casilla(2,2,new Tierra(), new RecursoVacio());

        Zangano z1 = new Zangano(casillaZangano1, a);
        Zangano z2 = new Zangano(casillaZangano2, a);
        Zangano z3 = new Zangano(casillaZangano3, a);
        Zangano z4 = new Zangano(casillaZangano4, a);

        z1.finalizarConstruccion();
        z2.finalizarConstruccion();
        z3.finalizarConstruccion();
        z4.finalizarConstruccion();

        e.meterZangano(z1);
        e.meterZangano(z2);
        e.meterZangano(z3);

        assertThrows(ExtractorLlenoError.class, () -> e.meterZangano(z4));
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
