package edu.fiuba.algo3.entrega_3;

import edu.fiuba.algo3.modelo.errores.AtaquePorAireInvalidoError;
import edu.fiuba.algo3.modelo.errores.AtaquePorTierraInvalidoError;
import edu.fiuba.algo3.modelo.errores.CasillaOcupadaError;
import edu.fiuba.algo3.modelo.errores.RecursosInsuficientesError;
import edu.fiuba.algo3.modelo.juego.Almacen;
import edu.fiuba.algo3.modelo.juego.Casilla;
import edu.fiuba.algo3.modelo.juego.FakeMapa;
import edu.fiuba.algo3.modelo.terrenos.Espacio;
import edu.fiuba.algo3.modelo.unidades.Devorador;
import edu.fiuba.algo3.modelo.unidades.Mutalisco;
import edu.fiuba.algo3.modelo.unidades.Zealot;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CasoDeUso27Test {
    @Test
    public void unMutaliscoNoPuedeEvolucionarADevoradorSiNoHayRecursosSuficientes(){
        FakeMapa mapa= new FakeMapa(2);
        Almacen a=new Almacen();
        a.almacenarMineral(100);
        a.almacenarGas(100);
        Casilla casilla = mapa.obtenerCasilla(5,5);
        Mutalisco mutalisco = new Mutalisco(casilla);
        casilla.construir(mutalisco,a);

        for (int i=0; i<25; i++){
            mutalisco.avanzarTurno();
        }

        assertThrows(RecursosInsuficientesError.class, () -> {mutalisco.evolucionarADevorador(a);});


    }

    @Test
    public void unMutaliscoSePuedeEvolucionarADevoradorSiHayRecursosSuficientes(){
        FakeMapa mapa= new FakeMapa(2);
        Almacen a=new Almacen();
        a.almacenarMineral(500);
        a.almacenarGas(500);
        Casilla casilla = mapa.obtenerCasilla(5,5);
        Mutalisco mutalisco = new Mutalisco(casilla);
        casilla.construir(mutalisco, a);

        for (int i=0; i<25; i++){
            mutalisco.avanzarTurno();
        }
        mutalisco.evolucionarADevorador(a);

        assertSame(Devorador.class , casilla.obtenerEntidad().getClass());
    }

    @Test
    public void unDevoradorSePuedeMoverPorUnAreaEspacial(){
        FakeMapa mapa = new FakeMapa(2);
        Almacen a=new Almacen();
        a.almacenarMineral(500);
        a.almacenarGas(500);
        Casilla casillaDestino = mapa.obtenerCasilla(8,8);
        casillaDestino.cambiarTerreno(new Espacio());
        Casilla casillaOrigen = mapa.obtenerCasilla(5,5);
        Devorador d = new Devorador(casillaOrigen, a);

        for (int i=0; i<25; i++){
            d.avanzarTurno();
        }

        d.moverA(casillaDestino);
        assertThrows(CasillaOcupadaError.class, () -> {casillaDestino.estaLibre();});
    }

    @Test
    public void unDevoradorNoPuedeAtacarAUnidadesTerrestres(){
        FakeMapa mapa = new FakeMapa(2);
        Almacen a=new Almacen();
        a.almacenarMineral(500);
        a.almacenarGas(500);
        Casilla casilla1 = mapa.obtenerCasilla(5,5);
        Casilla casilla2 = mapa.obtenerCasilla(6,6);
        Devorador d = new Devorador(casilla1, a);
        Zealot z = new Zealot(casilla2);

        for (int i=0; i<25; i++){
            d.avanzarTurno();
        }

        assertThrows(AtaquePorTierraInvalidoError.class, () -> {z.recibirAtaque(d, mapa);});
    }
}
