package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CasoDeUso7 {

    @Test
    public void zanganoExtrae10MineralesPorTurno() {
        Almacen a = new Almacen();
        Zangano z = new Zangano();
        Mena men = new Mena();
        z.trabajarSobreMena(men);

        z.extraerMineral(a);

        assertEquals(10, a.cantMineral());
    }

    @Test
    public void nexoMineralExtrae20MineralesPorTurno() {
        Almacen a = new Almacen();
        Mena men = new Mena();
        NexoMineral nexo = new NexoMineral(men);

        nexo.extraerMineral(a);

        assertEquals(20, a.cantMineral());
    }
}
