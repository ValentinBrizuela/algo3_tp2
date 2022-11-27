package edu.fiuba.algo3.entrega_3;

import edu.fiuba.algo3.modelo.errores.AtaqueInvalidoError;
import edu.fiuba.algo3.modelo.errores.CasillaOcupadaError;
import edu.fiuba.algo3.modelo.errores.RecursosInsuficientesError;
import edu.fiuba.algo3.modelo.juego.Almacen;
import edu.fiuba.algo3.modelo.juego.Casilla;
import edu.fiuba.algo3.modelo.juego.Mapa;
import edu.fiuba.algo3.modelo.terrenos.Espacio;
import edu.fiuba.algo3.modelo.unidades.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CasoDeUso27Test {
    @Test
    public void unMutaliscoNoPuedeEvolucionarADevoradorSiNoHayRecursosSuficientes(){
        Mapa mapa= new Mapa(2);
        Casilla casilla = mapa.obtenerCasilla(5,5);
        Mutalisco mutalisco = new Mutalisco(casilla);
        Almacen almacen = new Almacen();

        for (int i=0; i<25; i++){
            mutalisco.avanzarTurno();
        }

        assertThrows(RecursosInsuficientesError.class, () -> {mutalisco.evolucionarADevorador(almacen);});


    }

    @Test
    public void unMutaliscoSePuedeEvolucionarADevoradorSiHayRecursosSuficientes(){
        Mapa mapa= new Mapa(2);
        Casilla casilla = mapa.obtenerCasilla(5,5);
        Mutalisco mutalisco = new Mutalisco(casilla);
        Almacen almacen = new Almacen();
        almacen.almacenarMineral(500);
        almacen.almacenarGas(500);

        for (int i=0; i<25; i++){
            mutalisco.avanzarTurno();
        }

        assertSame(Devorador.class , mutalisco.evolucionarADevorador(almacen).getClass());
    }

    @Test
    public void unDevoradorSePuedeMoverPorUnAreaEspacial(){
        Mapa mapa = new Mapa(2);
        Casilla casillaDestino = mapa.obtenerCasilla(5,5);
        casillaDestino.cambiarTerreno(new Espacio());
        Casilla casillaOrigen = mapa.obtenerCasilla(3,3);
        Devorador d = new Devorador(casillaOrigen);

        for (int i=0; i<25; i++){
            d.avanzarTurno();
        }

        d.moverA(casillaDestino);
        assertThrows(CasillaOcupadaError.class, () -> {casillaDestino.estaLibre();});
    }

    @Test
    public void unDevoradorNoPuedeAtacarAUnidadesTerrestres(){
        Mapa mapa = new Mapa(2);
        Casilla casilla1 = mapa.obtenerCasilla(5,5);
        Casilla casilla2 = mapa.obtenerCasilla(6,6);
        Devorador d = new Devorador(casilla1);
        Zealot z = new Zealot(casilla2);

        for (int i=0; i<25; i++){
            d.avanzarTurno();
        }

        assertThrows(AtaqueInvalidoError.class, () -> {z.recibirAtaque(d);});
    }
}
