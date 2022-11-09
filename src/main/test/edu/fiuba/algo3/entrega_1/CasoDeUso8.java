package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class CasoDeUso8 {
    @Test
    public void test01NoPuedoConstruirUnCriaderoSiNoTengoLosRecursosNecesarios(){
        Almacen almacen = new Almacen();
        Casilla casilla = new Casilla(0,0, new Moho(), new Desocupada());
        Criadero criadero = new Criadero();

        assertThrows(RecursosInsuficientes.class, () -> {casilla.construir(criadero, almacen);});
    }

}
