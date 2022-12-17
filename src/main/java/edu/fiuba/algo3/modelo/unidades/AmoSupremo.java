package edu.fiuba.algo3.modelo.unidades;

import edu.fiuba.algo3.modelo.costos.CostoMineral;
import edu.fiuba.algo3.modelo.edificios.Construible;
import edu.fiuba.algo3.modelo.edificios.VidaZerg;
import edu.fiuba.algo3.modelo.interfaces.AtacableAereo;
import edu.fiuba.algo3.modelo.interfaces.Atacante;
import edu.fiuba.algo3.modelo.juego.Casilla;
import edu.fiuba.algo3.modelo.juego.IMapa;
import edu.fiuba.algo3.modelo.juego.Mapa;
import edu.fiuba.algo3.modelo.razas.Zerg;

import java.util.ArrayList;
import java.util.List;

public class AmoSupremo extends Unidad implements AtacableAereo, Construible {

    public AmoSupremo(Casilla casilla) {
        super(new VidaZerg(200), new ArrayList<>(List.of(new CostoMineral(50))), 5, new Zerg(), casilla, new UnidadAerea());
    }

    @Override
    public void avanzarTurno() {
        tiempoConstruccion -= 1;
        vida.regenerar();
    }

    @Override
    public void recibirAtaque(Atacante atacante, IMapa mapa) {
        atacante.atacarA(this);
    }

    @Override
    public boolean esAtacante() {
        return false;
    }

    @Override
    public boolean esDetector() {
        return true;
    }
}
