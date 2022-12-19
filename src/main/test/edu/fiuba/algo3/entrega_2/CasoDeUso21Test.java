package edu.fiuba.algo3.entrega_2;

import edu.fiuba.algo3.modelo.errores.RecursosInsuficientesError;
import edu.fiuba.algo3.modelo.juego.Almacen;
import edu.fiuba.algo3.modelo.juego.Casilla;
import edu.fiuba.algo3.modelo.juego.FakeMapa;
import edu.fiuba.algo3.modelo.juego.Mapa;
import edu.fiuba.algo3.modelo.unidades.Guardian;
import edu.fiuba.algo3.modelo.unidades.Mutalisco;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CasoDeUso21Test {

    @Test
    public void unMutaliscoNoPuedeEvolucionarAGuardianSiNoHayRecursosSuficientes(){
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

        assertThrows(RecursosInsuficientesError.class, () -> {mutalisco.evolucionarAGuardian(a);});


    }

    @Test
    public void unMutaliscoSePuedeEvolucionarAGuardianSiHayRecursosSuficientes(){
        FakeMapa mapa= new FakeMapa(2);
        Almacen a=new Almacen();
        a.almacenarMineral(10000);
        a.almacenarGas(10000);

        Casilla casilla = mapa.obtenerCasilla(5,5);
        Mutalisco mutalisco = new Mutalisco(casilla);
        Almacen almacen = new Almacen();
        almacen.almacenarMineral(500);
        almacen.almacenarGas(500);

        for (int i=0; i<25; i++){
            mutalisco.avanzarTurno();
        }

        assertSame(Guardian.class , mutalisco.evolucionarAGuardian(almacen).getClass());
    }
}
