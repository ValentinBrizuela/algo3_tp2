package edu.fiuba.algo3.test_generales;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.edificios.Pilon;
import edu.fiuba.algo3.modelo.errores.ConstruccionNoPermitidaError;
import edu.fiuba.algo3.modelo.errores.RecursosInsuficientes;
import edu.fiuba.algo3.modelo.estados.*;
import edu.fiuba.algo3.modelo.juego.*;
import edu.fiuba.algo3.modelo.recursos.*;
import edu.fiuba.algo3.modelo.terrenos.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestPilon {


    @Test
    public void test01UnPilonSePuedeConstruirSobreUnTerrenoSinRecursosDeTierraSinEnergia() {

        Casilla tierraSinEnergiaYSinRecursos = new Casilla(0,0,new Tierra(), new RecursoVacio(), new Desocupada());
        Almacen almacen=new Almacen();
        almacen.almacenarMineral(1000);

        Pilon pilon=new Pilon();
        tierraSinEnergiaYSinRecursos.construir(pilon,almacen);

        assertSame(pilon,tierraSinEnergiaYSinRecursos.obtenerEdificio());


    }

    @Test
    public void test02UnPilonSePuedeConstruirSobreUnTerrenoSinRecursosDeTierraConEnergia() {

        Casilla tierraConEnergiaYSinRecursos = new Casilla(0,0,new TierraEnergizada(), new RecursoVacio(), new Desocupada());
        Almacen almacen=new Almacen();
        almacen.almacenarMineral(1000);

        Pilon pilon=new Pilon();
        tierraConEnergiaYSinRecursos.construir(pilon,almacen);

        assertSame(pilon,tierraConEnergiaYSinRecursos.obtenerEdificio());

    }

    @Test
    public void test03UnPilonNoSePuedeConstruirSobreUnTerrenoDeMohoSinRecursos() {

        Casilla mohoSinEnergiaYSinRecursos = new Casilla(0,0,new Moho(), new RecursoVacio(), new Desocupada());
        Almacen almacen=new Almacen();
        almacen.almacenarMineral(1000);

        Pilon pilon=new Pilon();

        assertThrows(ConstruccionNoPermitidaError.class, () -> {mohoSinEnergiaYSinRecursos.construir(pilon,almacen);});

    }
}
