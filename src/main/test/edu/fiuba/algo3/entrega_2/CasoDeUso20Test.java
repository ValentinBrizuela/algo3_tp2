package edu.fiuba.algo3.entrega_2;

import edu.fiuba.algo3.modelo.errores.CasillaOcupadaError;
import edu.fiuba.algo3.modelo.errores.MovimientoInvalidoError;
import edu.fiuba.algo3.modelo.juego.Almacen;
import edu.fiuba.algo3.modelo.juego.Casilla;
import edu.fiuba.algo3.modelo.juego.Mapa;
import edu.fiuba.algo3.modelo.terrenos.Espacio;
import edu.fiuba.algo3.modelo.unidades.Scout;
import edu.fiuba.algo3.modelo.unidades.Zerling;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CasoDeUso20Test {
    @Test
    public void UnaUnidadTerrestreNoPuedeMoversePorUnAreaEspacial(){
        Mapa mapa = new Mapa(2);
        Almacen a=new Almacen();
        a.almacenarMineral(10000);
        Casilla casillaDestino = mapa.obtenerCasilla(25,25);
        casillaDestino.cambiarTerreno(new Espacio());
        Casilla casillaOrigen = mapa.obtenerCasilla(23,23);
        Zerling z = new Zerling(casillaOrigen);

        for (int i=0; i<25; i++){
            z.avanzarTurno();
        }

        assertThrows(MovimientoInvalidoError.class, () -> {z.moverA(casillaDestino);});
    }

    @Test
    public void UnaUnidadAereaPuedeMoversePorUnAreaEspacial(){
        Mapa mapa = new Mapa(2);
        Almacen a=new Almacen();
        a.almacenarGas(10000);
        a.almacenarMineral(10000);
        Casilla casillaDestino = mapa.obtenerCasilla(25,25);
        casillaDestino.cambiarTerreno(new Espacio());
        Casilla casillaOrigen = mapa.obtenerCasilla(24,24);
        Scout s = new Scout(casillaOrigen);

        for (int i=0; i<25; i++){
            s.avanzarTurno();
        }

        s.moverA(casillaDestino);
        assertThrows(CasillaOcupadaError.class, () -> {casillaDestino.estaLibre();});
    }
}
