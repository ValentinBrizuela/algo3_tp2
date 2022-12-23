package edu.fiuba.algo3.test_unitarios;

import edu.fiuba.algo3.modelo.errores.ConstruccionNoPermitidaError;
import edu.fiuba.algo3.modelo.errores.ConstruccionNoPermitidaRecursoError;
import edu.fiuba.algo3.modelo.errores.ConstruccionNoPermitidaTerrenoError;
import edu.fiuba.algo3.modelo.juego.Almacen;
import edu.fiuba.algo3.modelo.juego.Casilla;
import edu.fiuba.algo3.modelo.recursos.Geiser;
import edu.fiuba.algo3.modelo.recursos.Mena;
import edu.fiuba.algo3.modelo.recursos.RecursoVacio;
import edu.fiuba.algo3.modelo.terrenos.Espacio;
import edu.fiuba.algo3.modelo.terrenos.Moho;
import edu.fiuba.algo3.modelo.terrenos.Tierra;
import edu.fiuba.algo3.modelo.terrenos.TierraEnergizada;
import edu.fiuba.algo3.modelo.unidades.Zerling;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ZerlingTest {

    @Test
    public void test01SePuedeCrearUnZerlingEnUnTerrenoDeTierra(){
        Casilla casilla=new Casilla(20,20,new Tierra(),new RecursoVacio());
        Almacen almacen= new Almacen();
        almacen.almacenarMineral(10000);
        Zerling z=new Zerling(casilla);
        casilla.construir(z,almacen);

        assertEquals(z, casilla.obtenerEstado().obtenerEntidad());
    }
    @Test
    public void test02SePuedeCrearUnZerlingEnUnTerrenoDeTierraEnergizada(){
        Casilla casilla=new Casilla(20,20,new TierraEnergizada(),new RecursoVacio());
        Almacen almacen= new Almacen();
        almacen.almacenarMineral(10000);
        Zerling z=new Zerling(casilla);
        casilla.construir(z,almacen);

        assertEquals(z, casilla.obtenerEstado().obtenerEntidad());
    }

    @Test
    public void test03SePuedeCrearUnZerlingEnUnTerrenoDeMoho(){
        Casilla casilla=new Casilla(20,20,new Moho(),new RecursoVacio());
        Almacen almacen= new Almacen();
        almacen.almacenarMineral(10000);
        Zerling z=new Zerling(casilla);
        casilla.construir(z,almacen);

        assertEquals(z, casilla.obtenerEstado().obtenerEntidad());
    }

    @Test
    public void test04NoSePuedeCrearUnZerlingEnUnTerrenoDeEspacio(){
        Casilla casilla=new Casilla(20,20,new Espacio(),new RecursoVacio());
        Almacen almacen= new Almacen();
        almacen.almacenarMineral(10000);
        Zerling z=new Zerling(casilla);

        assertThrows(ConstruccionNoPermitidaTerrenoError.class, () -> {casilla.construir(z,almacen);});
    }

    @Test
    public void test05NoSePuedeCrearUnZerlingEnUnTerrenoDeTierraYRecursoDeGeiser(){
        Casilla casilla=new Casilla(20,20,new Tierra(),new Geiser());
        Almacen almacen= new Almacen();
        almacen.almacenarMineral(10000);
        Zerling z=new Zerling(casilla);

        assertThrows(ConstruccionNoPermitidaRecursoError.class, () -> {casilla.construir(z,almacen);});
    }

    @Test
    public void test06NoSePuedeCrearUnZerlingEnUnTerrenoDeTierraYRecursoDeMena(){
        Casilla casilla=new Casilla(20,20,new Tierra(),new Mena());
        Almacen almacen= new Almacen();
        almacen.almacenarMineral(10000);
        Zerling z=new Zerling(casilla);

        assertThrows(ConstruccionNoPermitidaRecursoError.class, () -> {casilla.construir(z,almacen);});
    }
}