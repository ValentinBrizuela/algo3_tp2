package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.edificios.Espiral;
import edu.fiuba.algo3.modelo.edificios.Guarida;
import edu.fiuba.algo3.modelo.edificios.PuertoEstelar;
import edu.fiuba.algo3.modelo.errores.ConstruccionNoPermitidaError;
import edu.fiuba.algo3.modelo.estados.Desocupada;
import edu.fiuba.algo3.modelo.juego.*;
import edu.fiuba.algo3.modelo.recursos.RecursoVacio;
import edu.fiuba.algo3.modelo.terrenos.Moho;
import edu.fiuba.algo3.modelo.terrenos.Tierra;
import edu.fiuba.algo3.modelo.terrenos.TierraEnergizada;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CasoDeUso17 {

    @Test
    public void test01UnaGuaridaNoSePuedeConstruirSiNoHayYaConstruidaUnaReservaDeReproduccion(){
        Mapa mapa = new Mapa();
        Almacen almacen = new Almacen();
        AlgoStar algoStar =new AlgoStar(new Jugador(almacen), mapa);


        almacen.almacenarMineral(500);
        almacen.almacenarGas(500);
        mapa.obtenerCasilla(0,0).cambiarTerreno(new Moho());

        assertThrows(ConstruccionNoPermitidaError.class, () -> {algoStar.construirGuarida(0,0);});
    }

    @Test
    public void test02UnaGuaridaSePuedeConstruirSiAntesSeConstruyoUnaReservaDeReproduccion(){
        Mapa mapa = new Mapa();
        Almacen almacen = new Almacen();
        AlgoStar algoStar =new AlgoStar(new Jugador(almacen), mapa);

        almacen.almacenarMineral(500);
        almacen.almacenarGas(500);
        mapa.obtenerCasilla(0,0).cambiarTerreno(new Moho());
        mapa.obtenerCasilla(1,0).cambiarTerreno(new Moho());

        algoStar.construirReservaDeReproduccion(0,0);
        algoStar.construirGuarida(1,0);

        assertSame(Guarida.class, mapa.obtenerCasilla(1,0).obtenerEstado().obtenerEdificio().getClass());

    }

    @Test
    public void test03UnEspiralNoSePuedeConstruirSiNoHayYaConstruidaUnaGuarida(){
        Mapa mapa = new Mapa();
        Almacen almacen=new Almacen();
        AlgoStar algoStar =new AlgoStar(new Jugador(almacen), mapa);

        almacen.almacenarMineral(500);
        almacen.almacenarGas(500);
        mapa.obtenerCasilla(0,0).cambiarTerreno(new Moho());

        assertThrows(ConstruccionNoPermitidaError.class, () -> {algoStar.construirEspiral(0,0);});
    }

    @Test
    public void test04UnEspiralSePuedeConstruirSiAntesSeConstruyoUnaGuarida(){
        Mapa mapa = new Mapa();
        Almacen almacen = new Almacen();
        AlgoStar algoStar =new AlgoStar(new Jugador(almacen), mapa);

        almacen.almacenarMineral(500);
        almacen.almacenarGas(500);
        mapa.obtenerCasilla(0,0).cambiarTerreno(new Moho());
        mapa.obtenerCasilla(1,0).cambiarTerreno(new Moho());
        mapa.obtenerCasilla(1,1).cambiarTerreno(new Moho());

        algoStar.construirReservaDeReproduccion(0,0);
        algoStar.construirGuarida(1,0);
        algoStar.construirEspiral(1,1);

        assertSame(Espiral.class, mapa.obtenerCasilla(1,1).obtenerEstado().obtenerEdificio().getClass());

    }

    @Test
    public void test05UnPuertoEstelarNoSePuedeConstruirSiNoHayYaConstruidoUnAcceso(){
        Mapa mapa = new Mapa();
        Almacen almacen = new Almacen();
        AlgoStar algoStar =new AlgoStar(new Jugador(almacen), mapa);

        almacen.almacenarMineral(500);
        almacen.almacenarGas(500);
        mapa.obtenerCasilla(0,0).cambiarTerreno(new TierraEnergizada());

        assertThrows(ConstruccionNoPermitidaError.class, () -> {algoStar.construirPuertoEstelar(0,0);});
    }

    @Test
    public void test06UnEspiralSePuedeConstruirSiAntesSeConstruyoUnPuertoEstelar(){
        Mapa mapa = new Mapa();
        Almacen almacen = new Almacen();
        AlgoStar algoStar =new AlgoStar(new Jugador(almacen), mapa);

        almacen.almacenarMineral(500);
        almacen.almacenarGas(500);
        mapa.obtenerCasilla(0,0).cambiarTerreno(new TierraEnergizada());
        mapa.obtenerCasilla(1,0).cambiarTerreno(new TierraEnergizada());

        algoStar.construirAcceso(0,0);
        algoStar.construirPuertoEstelar(1,0);

        assertSame(PuertoEstelar.class, mapa.obtenerCasilla(1,0).obtenerEstado().obtenerEdificio().getClass());
    }

}
