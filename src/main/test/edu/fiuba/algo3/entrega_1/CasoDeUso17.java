package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.edificios.Espiral;
import edu.fiuba.algo3.modelo.edificios.Guarida;
import edu.fiuba.algo3.modelo.edificios.PuertoEstelar;
import edu.fiuba.algo3.modelo.errores.ConstruccionNoPermitidaError;
import edu.fiuba.algo3.modelo.estados.Desocupada;
import edu.fiuba.algo3.modelo.juego.AlgoStar;
import edu.fiuba.algo3.modelo.juego.Almacen;
import edu.fiuba.algo3.modelo.juego.Casilla;
import edu.fiuba.algo3.modelo.juego.Jugador;
import edu.fiuba.algo3.modelo.recursos.RecursoVacio;
import edu.fiuba.algo3.modelo.terrenos.Moho;
import edu.fiuba.algo3.modelo.terrenos.TierraEnergizada;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CasoDeUso17 {

    @Test
    public void test01UnaGuaridaNoSePuedeConstruirSiNoHayYaConstruidaUnaReservaDeReproduccion(){
        AlgoStar algoStar =new AlgoStar(new Jugador());


        Casilla casilla= new Casilla(0,0,new Moho(),new RecursoVacio(),new Desocupada());

        Almacen almacen=new Almacen();
        almacen.almacenarMineral(500);
        almacen.almacenarGas(500);

        assertThrows(ConstruccionNoPermitidaError.class, () -> {algoStar.construirGuarida(casilla,almacen);});

    }

    @Test
    public void test02UnaGuaridaSePuedeConstruirSiAntesSeConstruyoUnaReservaDeReproduccion(){
        AlgoStar algoStar =new AlgoStar(new Jugador());


        Casilla casilla1= new Casilla(0,0,new Moho(),new RecursoVacio(),new Desocupada());
        Casilla casilla2= new Casilla(1,0,new Moho(),new RecursoVacio(),new Desocupada());

        Almacen almacen=new Almacen();
        almacen.almacenarMineral(500);
        almacen.almacenarGas(500);

        algoStar.construirReservaDeReproduccion(casilla1,almacen);
        algoStar.construirGuarida(casilla2,almacen);

        assertSame(Guarida.class, casilla2.obtenerEdificio().getClass());

    }

    @Test
    public void test03UnEspiralNoSePuedeConstruirSiNoHayYaConstruidaUnaGuarida(){
        AlgoStar algoStar =new AlgoStar(new Jugador());


        Casilla casilla= new Casilla(0,0,new Moho(),new RecursoVacio(),new Desocupada());

        Almacen almacen=new Almacen();
        almacen.almacenarMineral(500);
        almacen.almacenarGas(500);

        assertThrows(ConstruccionNoPermitidaError.class, () -> {algoStar.construirEspiral(casilla,almacen);});

    }

    @Test
    public void test04UnEspiralSePuedeConstruirSiAntesSeConstruyoUnaGuarida(){
        AlgoStar algoStar =new AlgoStar(new Jugador());


        Casilla casilla1= new Casilla(0,0,new Moho(),new RecursoVacio(),new Desocupada());
        Casilla casilla2= new Casilla(1,0,new Moho(),new RecursoVacio(),new Desocupada());
        Casilla casilla3= new Casilla(1,0,new Moho(),new RecursoVacio(),new Desocupada());

        Almacen almacen=new Almacen();
        almacen.almacenarMineral(500);
        almacen.almacenarGas(500);

        algoStar.construirReservaDeReproduccion(casilla1,almacen);
        algoStar.construirGuarida(casilla2,almacen);
        algoStar.construirEspiral(casilla3,almacen);

        assertSame(Espiral.class, casilla3.obtenerEdificio().getClass());

    }

    @Test
    public void test05UnPuertoEstelarNoSePuedeConstruirSiNoHayYaConstruidoUnAcceso(){
        AlgoStar algoStar =new AlgoStar(new Jugador());


        Casilla casilla= new Casilla(0,0,new TierraEnergizada(),new RecursoVacio(),new Desocupada());

        Almacen almacen=new Almacen();
        almacen.almacenarMineral(500);
        almacen.almacenarGas(500);

        assertThrows(ConstruccionNoPermitidaError.class, () -> {algoStar.construirPuertoEstelar(casilla,almacen);});

    }

    @Test
    public void test06UnEspiralSePuedeConstruirSiAntesSeConstruyoUnPuertoEstelar(){
        AlgoStar algoStar =new AlgoStar(new Jugador());


        Casilla casilla1= new Casilla(0,0,new TierraEnergizada(),new RecursoVacio(),new Desocupada());
        Casilla casilla2= new Casilla(1,0,new TierraEnergizada(),new RecursoVacio(),new Desocupada());

        Almacen almacen=new Almacen();
        almacen.almacenarMineral(500);
        almacen.almacenarGas(500);

        algoStar.construirAcceso(casilla1,almacen);
        algoStar.construirPuertoEstelar(casilla2,almacen);

        assertSame(PuertoEstelar.class, casilla2.obtenerEdificio().getClass());

    }

}
