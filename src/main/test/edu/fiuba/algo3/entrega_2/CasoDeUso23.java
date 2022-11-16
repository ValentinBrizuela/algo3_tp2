package edu.fiuba.algo3.entrega_2;

import edu.fiuba.algo3.modelo.errores.AtaqueInvalido;
import edu.fiuba.algo3.modelo.juego.*;
import edu.fiuba.algo3.modelo.terrenos.Moho;
import edu.fiuba.algo3.modelo.terrenos.TierraEnergizada;
import edu.fiuba.algo3.modelo.unidades.Dragon;
import edu.fiuba.algo3.modelo.unidades.Zerling;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class CasoDeUso23 {
    @Test
    public void noPuedoAtacarUnaUnidadSiNoEstaEnElRangoDeAtaque(){
        Mapa mapa = new Mapa();
        Casilla casilla1 = mapa.obtenerCasilla(5,5);
        Casilla casilla2 = mapa.obtenerCasilla(15,15);
        Zerling z = new Zerling(casilla1);
        Dragon d = new Dragon(casilla2);

        for (int i=0; i<25; i++){
            z.avanzarTurno();
        }

        assertThrows(AtaqueInvalido.class, () -> {z.atacarA(d);});
    }

    /*@Test
    public void noPuedoAtacarUnEdificioSiNoEstaEnElRangoDeAtaque(){
        Mapa mapa = new Mapa();
        Almacen almacen = new Almacen();
        AlgoStar algoStar =new AlgoStar(new Jugador(almacen), mapa);
        Zerling z = new Zerling(mapa.obtenerCasilla(1,1));

        almacen.almacenarMineral(500);
        almacen.almacenarGas(500);
        Casilla casillaEdificio = mapa.obtenerCasilla(5,5);
        casillaEdificio.cambiarTerreno(new TierraEnergizada());

        algoStar.construirAcceso(5,5);

        assertThrows(AtaqueInvalido.class, () -> {z.atacarA(casillaEdificio.obtenerEdificio());});
    }*/
}
