package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.edificios.*;
import edu.fiuba.algo3.modelo.errores.RecursosInsuficientesError;
import edu.fiuba.algo3.modelo.juego.Almacen;
import edu.fiuba.algo3.modelo.juego.Casilla;
import edu.fiuba.algo3.modelo.juego.Mapa;
import edu.fiuba.algo3.modelo.recursos.Geiser;
import edu.fiuba.algo3.modelo.recursos.Mena;
import edu.fiuba.algo3.modelo.recursos.RecursoVacio;
import edu.fiuba.algo3.modelo.terrenos.Moho;
import edu.fiuba.algo3.modelo.terrenos.TierraEnergizada;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class CasoDeUso8 {
    @Test
    public void test01NoPuedoConstruirUnCriaderoSiNoTengoLosRecursosNecesarios(){
        Almacen almacen = new Almacen();
        Casilla casilla = new Casilla(25,25, new Moho(), new RecursoVacio());
        Criadero criadero = new Criadero(new Mapa(2), casilla);

        assertThrows(RecursosInsuficientesError.class, () -> {casilla.construir(criadero, almacen);});
    }
    @Test
    public void test02NoPuedoConstruirUnExtractorSiNoTengoLosRecursosNecesarios(){
        Almacen almacen = new Almacen();
        Casilla casilla = new Casilla(0,0, new Moho(), new Geiser());
        Extractor extractor = new Extractor(casilla);

        assertThrows(RecursosInsuficientesError.class, () -> {casilla.construir(extractor, almacen);});
    }
    @Test
    public void test03NoPuedoConstruirReservaDeReproduccionSiNoTengoLosRecursosNecesarios(){
        Almacen almacen = new Almacen();
        Casilla casilla = new Casilla(0,0, new Moho(), new RecursoVacio());
        ReservaDeReproduccion reserva = new ReservaDeReproduccion(casilla);

        assertThrows(RecursosInsuficientesError.class, () -> {casilla.construir(reserva, almacen);});
    }
    @Test
    public void test04NoPuedoConstruirUnaGuaridaSiNoTengoLosRecursosNecesarios(){
        Almacen almacen = new Almacen();
        Casilla casilla = new Casilla(0,0, new Moho(), new RecursoVacio());
        Guarida guarida = new Guarida(casilla);

        assertThrows(RecursosInsuficientesError.class, () -> {casilla.construir(guarida, almacen);});
    }
    @Test
    public void test05NoPuedoConstruirUnaEspiralSiNoTengoLosRecursosNecesarios(){
        Almacen almacen = new Almacen();
        Casilla casilla = new Casilla(0,0, new Moho(), new RecursoVacio());
        Espiral espiral = new Espiral(casilla);

        assertThrows(RecursosInsuficientesError.class, () -> {casilla.construir(espiral, almacen);});
    }
    @Test
    public void test06NoPuedoConstruirUnNexoMineralSiNoTengoLosRecursosNecesarios(){
        Almacen almacen = new Almacen();
        Casilla casilla = new Casilla(0,0, new TierraEnergizada(), new Mena());
        NexoMineral nexo = new NexoMineral(casilla);

        assertThrows(RecursosInsuficientesError.class, () -> {casilla.construir(nexo, almacen);});
    }
    @Test
    public void test07NoPuedoConstruirUnPilonSiNoTengoLosRecursosNecesarios(){
        Mapa mapa = new Mapa(2);
        Almacen almacen = new Almacen();
        Casilla casilla = new Casilla(25,25, new TierraEnergizada(), new RecursoVacio());
        Pilon pilon = new Pilon(mapa, casilla);

        assertThrows(RecursosInsuficientesError.class, () -> {casilla.construir(pilon, almacen);});
    }
    @Test
    public void test08NoPuedoConstruirUnAsimilidaorSiNoTengoLosRecursosNecesarios(){
        Almacen almacen = new Almacen();
        Casilla casilla = new Casilla(0,0, new TierraEnergizada(), new Geiser());
        Asimilador asimilador = new Asimilador(casilla);

        assertThrows(RecursosInsuficientesError.class, () -> {casilla.construir(asimilador, almacen);});
    }
    @Test
    public void test09NoPuedoConstruirUnAccesoSiNoTengoLosRecursosNecesarios(){
        Almacen almacen = new Almacen();
        Casilla casilla = new Casilla(0,0, new TierraEnergizada(), new RecursoVacio());
        Acceso acceso = new Acceso(casilla);

        assertThrows(RecursosInsuficientesError.class, () -> {casilla.construir(acceso, almacen);});
    }
    @Test
    public void test10NoPuedoConstruirUnPuertoEstelarSiNoTengoLosRecursosNecesarios(){
        Almacen almacen = new Almacen();
        Casilla casilla = new Casilla(0,0, new TierraEnergizada(), new RecursoVacio());
        PuertoEstelar puerto = new PuertoEstelar(casilla);

        assertThrows(RecursosInsuficientesError.class, () -> {casilla.construir(puerto, almacen);});
    }
}
