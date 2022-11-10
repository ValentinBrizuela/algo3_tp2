package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.edificios.NexoMineral;
import edu.fiuba.algo3.modelo.estados.Desocupada;
import edu.fiuba.algo3.modelo.juego.Almacen;
import edu.fiuba.algo3.modelo.juego.Casilla;
import edu.fiuba.algo3.modelo.razas.Zangano;
import edu.fiuba.algo3.modelo.recursos.Mena;
import edu.fiuba.algo3.modelo.terrenos.TierraEnergizada;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CasoDeUso7 {

    @Test
    public void zanganoExtrae10MineralesPorTurno() {
        Almacen a = new Almacen();
        Zangano z = new Zangano();
        Mena men = new Mena();

        z.extraerMineral(a, men);

        assertEquals(10, a.cantMineral());
    }

    @Test
    public void nexoMineralExtrae20MineralesPorTurno() {
        Almacen a = new Almacen();
        Mena men = new Mena();
        Casilla casilla = new Casilla(0,0,new TierraEnergizada(),men, new Desocupada());
        NexoMineral nexo = new NexoMineral(casilla);

        nexo.extraerMineral(a, men);

        assertEquals(20, a.cantMineral());
    }
}
