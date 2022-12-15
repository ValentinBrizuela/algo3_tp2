package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.edificios.NexoMineral;
import edu.fiuba.algo3.modelo.juego.Almacen;
import edu.fiuba.algo3.modelo.juego.Casilla;
import edu.fiuba.algo3.modelo.recursos.RecursoVacio;
import edu.fiuba.algo3.modelo.unidades.Zangano;
import edu.fiuba.algo3.modelo.recursos.Mena;
import edu.fiuba.algo3.modelo.terrenos.Moho;
import edu.fiuba.algo3.modelo.terrenos.TierraEnergizada;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CasoDeUso7Test {

    @Test
    public void zanganoExtrae10MineralesPorTurno() {
        Almacen a=new Almacen();
        a.almacenarMineral(25);
        Casilla casilla1 = new Casilla(20,20,new Moho(),new Mena());
        Zangano zangano = new Zangano(casilla1, a);
        casilla1.construir(zangano,a);
        //Se construye
        zangano.avanzarTurno();

        //avanza turno de extraccion +10
        zangano.avanzarTurno();

        assertEquals(10, a.cantMineral());
    }

    @Test
    public void nexoMineralExtrae20MineralesPorTurno() {
        Almacen a = new Almacen();
        Mena men = new Mena();
        Casilla casilla = new Casilla(0,0,new TierraEnergizada(),men);
        NexoMineral nexo = new NexoMineral(casilla, a);
        nexo.finalizarConstruccion();

        nexo.avanzarTurno();

        assertEquals(20, a.cantMineral());
    }
}
