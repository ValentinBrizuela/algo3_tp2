package edu.fiuba.algo3.test_unitarios;

import edu.fiuba.algo3.modelo.juego.Almacen;
import edu.fiuba.algo3.modelo.juego.Casilla;
import edu.fiuba.algo3.modelo.recursos.Mena;
import edu.fiuba.algo3.modelo.recursos.RecursoVacio;
import edu.fiuba.algo3.modelo.terrenos.Tierra;
import edu.fiuba.algo3.modelo.unidades.Zangano;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ZanganoTest {

    @Test
    public void test01SeCreaUnZanganoYSeMueveAUnaCasillaConMenaYSeChequeaQueLuegoDeCincoTurnosHayaExtraido5Veces(){
        Almacen a =new Almacen();
        a.almacenarMineral(25);
        Casilla casilla1=new Casilla(50,50,new Tierra(),new Mena());
        Casilla casilla2=new Casilla(49,50,new Tierra(),new RecursoVacio());
        Zangano z= new Zangano(casilla2,a);
        casilla2.construir(z,a);

        //seConstruye
        z.avanzarTurno();
        //No extrae nada porq no esta arriba de una mena
        z.avanzarTurno();

        z.moverA(casilla1);

        //avanzo 5 turnos para extraer 5 veces.
        for(int i=0;i<5;i++){
            z.avanzarTurno();
        }
        assertEquals(50, a.cantMineral());


    }

    @Test
    public void test02SeCreaUnZanganoSobreUnaMenaYEn6TurnosDeberiaExtraer5Veces(){
        Almacen a =new Almacen();
        a.almacenarMineral(25);
        Casilla casilla1=new Casilla(50,50,new Tierra(),new Mena());
        Zangano z= new Zangano(casilla1,a);
        casilla1.construir(z,a);

        //seConstruye
        z.avanzarTurno();

        //avanzo 5 turnos para extraer 5 veces.
        for(int i=0;i<5;i++){
            z.avanzarTurno();
        }
        assertEquals(50, a.cantMineral());


    }
}
