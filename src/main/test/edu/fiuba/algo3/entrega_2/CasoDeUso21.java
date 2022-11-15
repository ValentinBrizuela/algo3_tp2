package edu.fiuba.algo3.entrega_2;

import edu.fiuba.algo3.modelo.errores.RecursosInsuficientes;
import edu.fiuba.algo3.modelo.juego.Almacen;
import edu.fiuba.algo3.modelo.juego.Casilla;
import edu.fiuba.algo3.modelo.juego.Mapa;
import edu.fiuba.algo3.modelo.unidades.Guardian;
import edu.fiuba.algo3.modelo.unidades.Mutalisco;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CasoDeUso21 {

    @Test
    public void unMutaliscoNoPuedeEvolucionarAGuardianSiNoHayRecursosSuficientes(){
        Mapa mapa= new Mapa();
        Casilla casilla = mapa.obtenerCasilla(5,5);
        Mutalisco mutalisco = new Mutalisco(casilla);
        Almacen almacen = new Almacen();

        assertThrows(RecursosInsuficientes.class, () -> {mutalisco.evolucionar(almacen);});


    }

    //Hay una creacion de costo rara dentro de evolucionar.

    @Test
    public void unMutaliscoSePuedeEvolucionarAGuardianSiHayRecursosSuficientes(){
        Mapa mapa= new Mapa();
        Casilla casilla = mapa.obtenerCasilla(5,5);
        Mutalisco mutalisco = new Mutalisco(casilla);
        Almacen almacen = new Almacen();
        almacen.almacenarMineral(500);
        almacen.almacenarGas(500);

        assertSame(Guardian.class , mutalisco.evolucionar(almacen).getClass());
    }
}
