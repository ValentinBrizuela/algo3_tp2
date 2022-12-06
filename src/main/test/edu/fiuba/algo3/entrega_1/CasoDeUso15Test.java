package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.edificios.Extractor;
import edu.fiuba.algo3.modelo.edificios.NexoMineral;
import edu.fiuba.algo3.modelo.juego.Almacen;
import edu.fiuba.algo3.modelo.juego.Casilla;
import edu.fiuba.algo3.modelo.recursos.RecursoVacio;
import edu.fiuba.algo3.modelo.unidades.Zangano;
import edu.fiuba.algo3.modelo.recursos.Geiser;
import edu.fiuba.algo3.modelo.recursos.Mena;
import edu.fiuba.algo3.modelo.terrenos.Moho;
import edu.fiuba.algo3.modelo.terrenos.TierraEnergizada;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CasoDeUso15Test {

    @Test
    public void test01UnNexoMineralDejaDeExtraerMineralesCuandoLaMinaSeAgota(){

        Mena mena=new Mena();
        //vacio la mena
        mena.extraer(2000);
        Casilla casilla = new Casilla(0,0,new TierraEnergizada(), mena);
        Almacen almacen= new Almacen();
        almacen.almacenarMineral(0);
        NexoMineral nexoMineral= new NexoMineral(casilla);
        nexoMineral.finalizarConstruccion();

        nexoMineral.extraerMineral(almacen,mena);

        assertEquals(0,almacen.cantMineral());

    }

    @Test
    public void test02UnNexoMineralNoExtraeMasDeLoDebidoCuandoLaMinaSeAgota(){

        Mena mena=new Mena();
        //dejo 15 minerales
        mena.extraer(1985);
        Almacen almacen= new Almacen();
        almacen.almacenarMineral(0);
        Casilla casilla = new Casilla(0,0,new TierraEnergizada(), mena);

        NexoMineral nexoMineral= new NexoMineral(casilla);
        nexoMineral.finalizarConstruccion();

        nexoMineral.extraerMineral(almacen,mena);

        assertEquals(15,almacen.cantMineral());

        nexoMineral.extraerMineral(almacen,mena);

        assertEquals(15,almacen.cantMineral());

    }

    @Test
    public void test03UnExtractorNoExtraeMasGasDeUnGeiserSiEsteSeAgota(){
        Geiser geiser=new Geiser();
        geiser.extraerGas(5000);
        Almacen almacen=new Almacen();
        Casilla casilla = new Casilla(0,0,new Moho(), geiser);
        Extractor extractor=new Extractor(casilla);
        extractor.finalizarConstruccion();
        extractor.meterZangano();

        extractor.extraerGas(almacen,geiser);

        assertEquals(0,almacen.cantGas());
    }

    @Test
    public void test04UnExtractorConUnZanganoNoExtraeMasGasDeLoDebidoDeUnGeiserSiEsteSeAgota(){
        Geiser geiser=new Geiser();
        //dejo 5 unidades de gas
        geiser.extraerGas(4995);
        Almacen almacen=new Almacen();
        Casilla casilla = new Casilla(0,0,new Moho(), geiser);
        Extractor extractor=new Extractor(casilla);
        extractor.finalizarConstruccion();
        extractor.meterZangano();

        extractor.extraerGas(almacen,geiser);

        assertEquals(5,almacen.cantGas());
    }

    @Test
    public void test05UnExtractorConTresZanganosNoExtraeMasGasDeLoDebidoDeUnGeiserSiEsteSeAgota(){
        Geiser geiser=new Geiser();
        //dejo 5 unidades de gas
        geiser.extraerGas(4980);
        Almacen almacen=new Almacen();
        Casilla casilla = new Casilla(0,0,new Moho(), geiser);
        Extractor extractor=new Extractor(casilla);
        extractor.finalizarConstruccion();
        extractor.meterZangano();
        extractor.meterZangano();
        extractor.meterZangano();

        extractor.extraerGas(almacen,geiser);

        assertEquals(20,almacen.cantGas());
    }

    @Test
    public void test06UnZanganoDejaDeExtraerMineralesCuandoLaMinaSeAgota(){
        Almacen a=new Almacen();
        a.almacenarMineral(25);
        Mena mena=new Mena();
        //vacio la mena
        mena.extraer(2000);

        Casilla casilla = new Casilla(20,20,new Moho(), mena);

        Zangano zangano= new Zangano(casilla, a);
        casilla.construir(zangano,a);

        //se construye
        zangano.avanzarTurno();

        //se intenta extraer
        zangano.avanzarTurno();


        assertEquals(0,a.cantMineral());

    }
}
