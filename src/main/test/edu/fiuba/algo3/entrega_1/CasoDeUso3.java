package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.edificios.Asimilador;
import edu.fiuba.algo3.modelo.edificios.Criadero;
import edu.fiuba.algo3.modelo.edificios.Extractor;
import edu.fiuba.algo3.modelo.errores.ConstruccionNoPermitidaError;
import edu.fiuba.algo3.modelo.estados.Desocupada;
import edu.fiuba.algo3.modelo.juego.Almacen;
import edu.fiuba.algo3.modelo.juego.Casilla;
import edu.fiuba.algo3.modelo.juego.Mapa;
import edu.fiuba.algo3.modelo.recursos.Geiser;
import edu.fiuba.algo3.modelo.terrenos.Moho;
import edu.fiuba.algo3.modelo.terrenos.TierraEnergizada;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CasoDeUso3 {
    @Test
    public void test01AsimiladorSePuedeConstruirSobreGeiser(){
        Almacen almacen = new Almacen();
        almacen.almacenarMineral(1000);
        Casilla casilla = new Casilla(25,25, new TierraEnergizada(),new Geiser(), new Desocupada());
        Asimilador asimilador = new Asimilador(casilla);

        casilla.construir(asimilador, almacen);

        assertEquals(asimilador, casilla.obtenerEdificio());
    }

    @Test
    public void test02ExtractorSePuedeConstruirSobreGeiser(){
        Casilla casilla = new Casilla(25,25, new Moho(),new Geiser(), new Desocupada());
        Almacen almacen = new Almacen();
        almacen.almacenarMineral(1000);
        Extractor extractor = new Extractor(casilla);

        casilla.construir(extractor, almacen);

        assertEquals(extractor, casilla.obtenerEdificio());
    }

    @Test
    public void test03NoSePuedeConstruirUnEdificioQueNoSeaExtractorOAsimiladorSobreGeiser(){
        Casilla casilla = new Casilla(25,25, new TierraEnergizada(),new Geiser(), new Desocupada());
        Criadero criadero = new Criadero(new Mapa(), casilla);
        Almacen almacen = new Almacen();
        almacen.almacenarMineral(1000);

        assertThrows(ConstruccionNoPermitidaError.class, () -> {casilla.construir(criadero, almacen);});
    }
}
