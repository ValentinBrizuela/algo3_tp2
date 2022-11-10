package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.edificios.NexoMineral;
import edu.fiuba.algo3.modelo.juego.Almacen;
import edu.fiuba.algo3.modelo.juego.Casilla;
import edu.fiuba.algo3.modelo.razas.Zangano;
import edu.fiuba.algo3.modelo.recursos.Mena;
import edu.fiuba.algo3.modelo.terrenos.Moho;
import edu.fiuba.algo3.modelo.terrenos.TierraEnergizada;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CasoDeUso7 {

    @Test
    public void zanganoExtrae10MineralesPorTurno() {
        Almacen almacen = new Almacen();
        Zangano zangano = new Zangano();
        Mena mena = new Mena();
        Casilla casilla = new Casilla(0,0,new Moho(),mena);

        zangano.asentarseEnMena(casilla,almacen);
        zangano.extraerMineral(almacen,mena);

        assertEquals(10, almacen.cantMineral());
    }

    @Test
    public void nexoMineralExtrae20MineralesPorTurno() {
        Almacen a = new Almacen();
        Mena men = new Mena();
        Casilla casilla = new Casilla(0,0,new TierraEnergizada(),men);
        NexoMineral nexo = new NexoMineral(casilla);

        nexo.extraerMineral(a, men);

        assertEquals(20, a.cantMineral());
    }
}
