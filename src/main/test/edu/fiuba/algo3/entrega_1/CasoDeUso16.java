package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.edificios.Extractor;
import edu.fiuba.algo3.modelo.edificios.NexoMineral;
import edu.fiuba.algo3.modelo.errores.EdificioYaConstruidoError;
import edu.fiuba.algo3.modelo.juego.Almacen;
import edu.fiuba.algo3.modelo.juego.Casilla;
import edu.fiuba.algo3.modelo.unidades.Zangano;
import edu.fiuba.algo3.modelo.recursos.Geiser;
import edu.fiuba.algo3.modelo.recursos.Mena;
import edu.fiuba.algo3.modelo.terrenos.Moho;
import edu.fiuba.algo3.modelo.terrenos.Tierra;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class CasoDeUso16 {
    @Test
    public void test01NoPuedoConstruirSobreGeiserYaConstruidoPropio(){
        Casilla casilla = new Casilla(0,0, new Moho(),new Geiser());
        Almacen almacen = new Almacen();
        almacen.almacenarMineral(1000);
        Extractor extractor = new Extractor(casilla);

        casilla.construir(extractor, almacen);

        Extractor extractor2 = new Extractor(casilla);
        assertThrows(EdificioYaConstruidoError.class, () -> {casilla.construir(extractor2, almacen);});
    }

    @Test
    public void test02NoPuedoConstruirSobreGeiserYaConstruidoEnemigo(){
        Casilla casilla = new Casilla(0,0, new Moho(),new Geiser());
        Almacen almacen = new Almacen();
        almacen.almacenarMineral(1000);
        Extractor extractor = new Extractor(casilla);

        casilla.construir(extractor, almacen);

        Extractor extractor2 = new Extractor(casilla);
        assertThrows(EdificioYaConstruidoError.class, () -> {casilla.construir(extractor2, almacen);});
    }

    @Test
    public void test03UnZanganoNoSePuedeAsentarEnUnaMinaSiYaHayConstruidoUnNexoMineral(){
        Almacen almacen=new Almacen();
        almacen.almacenarMineral(500);
        Mena mena=new Mena();
        Casilla casilla= new Casilla(0,0, new Tierra(),mena);
        casilla.construir(new NexoMineral(casilla),almacen);
        Zangano zangano=new Zangano();
        assertThrows(EdificioYaConstruidoError.class, () -> {zangano.asentarseEnMena(casilla,almacen);});
    }
    @Test
    public void test04NoSePuedeConstruirUnNexoMineralSiHayUnZanganoEnLaMina(){
        Almacen almacen=new Almacen();
        almacen.almacenarMineral(500);
        Mena mena=new Mena();
        Casilla casilla= new Casilla(0,0, new Moho(),mena);
        Zangano zangano=new Zangano();
        zangano.asentarseEnMena(casilla,almacen);
        assertThrows(EdificioYaConstruidoError.class, () -> {casilla.construir(new NexoMineral(casilla),almacen);});
    }
}
