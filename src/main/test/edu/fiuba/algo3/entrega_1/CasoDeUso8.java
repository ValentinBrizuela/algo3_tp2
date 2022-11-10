package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.edificios.*;
import edu.fiuba.algo3.modelo.errores.RecursosInsuficientes;
import edu.fiuba.algo3.modelo.estados.Desocupada;
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
        Casilla casilla = new Casilla(0,0, new Moho(), new RecursoVacio(), new Desocupada());
        Criadero criadero = new Criadero(new Mapa(), 25, 25);

        assertThrows(RecursosInsuficientes.class, () -> {casilla.construir(criadero, almacen);});
    }
    @Test
    public void test02NoPuedoConstruirUnExtractorSiNoTengoLosRecursosNecesarios(){
        Almacen almacen = new Almacen();
        Casilla casilla = new Casilla(0,0, new Moho(), new Geiser(), new Desocupada());
        Extractor extractor = new Extractor();

        assertThrows(RecursosInsuficientes.class, () -> {casilla.construir(extractor, almacen);});
    }
    @Test
    public void test03NoPuedoConstruirReservaDeReproduccionSiNoTengoLosRecursosNecesarios(){
        Almacen almacen = new Almacen();
        Casilla casilla = new Casilla(0,0, new Moho(), new RecursoVacio(), new Desocupada());
        ReservaDeReproduccion reserva = new ReservaDeReproduccion();

        assertThrows(RecursosInsuficientes.class, () -> {casilla.construir(reserva, almacen);});
    }
    @Test
    public void test04NoPuedoConstruirUnaGuaridaSiNoTengoLosRecursosNecesarios(){
        Almacen almacen = new Almacen();
        Casilla casilla = new Casilla(0,0, new Moho(), new RecursoVacio(), new Desocupada());
        Guarida guarida = new Guarida();

        assertThrows(RecursosInsuficientes.class, () -> {casilla.construir(guarida, almacen);});
    }
    @Test
    public void test05NoPuedoConstruirUnaEspiralSiNoTengoLosRecursosNecesarios(){
        Almacen almacen = new Almacen();
        Casilla casilla = new Casilla(0,0, new Moho(), new RecursoVacio(), new Desocupada());
        Espiral espiral = new Espiral();

        assertThrows(RecursosInsuficientes.class, () -> {casilla.construir(espiral, almacen);});
    }
    @Test
    public void test06NoPuedoConstruirUnNexoMineralSiNoTengoLosRecursosNecesarios(){
        Almacen almacen = new Almacen();
        Casilla casilla = new Casilla(0,0, new TierraEnergizada(), new Mena(), new Desocupada());
        NexoMineral nexo = new NexoMineral();

        assertThrows(RecursosInsuficientes.class, () -> {casilla.construir(nexo, almacen);});
    }
    @Test
    public void test07NoPuedoConstruirUnPilonSiNoTengoLosRecursosNecesarios(){
        Almacen almacen = new Almacen();
        Casilla casilla = new Casilla(0,0, new TierraEnergizada(), new RecursoVacio(), new Desocupada());
        Pilon pilon = new Pilon();

        assertThrows(RecursosInsuficientes.class, () -> {casilla.construir(pilon, almacen);});
    }
    @Test
    public void test08NoPuedoConstruirUnAsimilidaorSiNoTengoLosRecursosNecesarios(){
        Almacen almacen = new Almacen();
        Casilla casilla = new Casilla(0,0, new TierraEnergizada(), new Geiser(), new Desocupada());
        Asimilador asimilador = new Asimilador();

        assertThrows(RecursosInsuficientes.class, () -> {casilla.construir(asimilador, almacen);});
    }
    @Test
    public void test09NoPuedoConstruirUnAccesoSiNoTengoLosRecursosNecesarios(){
        Almacen almacen = new Almacen();
        Casilla casilla = new Casilla(0,0, new TierraEnergizada(), new RecursoVacio(), new Desocupada());
        Acceso acceso = new Acceso();

        assertThrows(RecursosInsuficientes.class, () -> {casilla.construir(acceso, almacen);});
    }
    @Test
    public void test10NoPuedoConstruirUnPuertoEstelarSiNoTengoLosRecursosNecesarios(){
        Almacen almacen = new Almacen();
        Casilla casilla = new Casilla(0,0, new TierraEnergizada(), new RecursoVacio(), new Desocupada());
        PuertoEstelar puerto = new PuertoEstelar();

        assertThrows(RecursosInsuficientes.class, () -> {casilla.construir(puerto, almacen);});
    }
}
