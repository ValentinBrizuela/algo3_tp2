package edu.fiuba.algo3.modelo.unidades;

import edu.fiuba.algo3.modelo.edificios.VidaZerg;
import edu.fiuba.algo3.modelo.interfaces.AtacableAereo;
import edu.fiuba.algo3.modelo.interfaces.Atacante;
import edu.fiuba.algo3.modelo.juego.Casilla;
import edu.fiuba.algo3.modelo.juego.Entidad;
import edu.fiuba.algo3.modelo.juego.Mapa;
import edu.fiuba.algo3.modelo.razas.Zerg;

public class AmoSupremo extends Unidad implements AtacableAereo {

    public AmoSupremo(Casilla casilla) {
        super(new VidaZerg(200), 50, 0, 5, new Zerg(), casilla, new UnidadAerea());
    }

    @Override
    public void avanzarTurno() {

    }

    @Override
    public void recibirAtaque(Atacante atacante, Mapa mapa) {
        atacante.atacarA(this);
    }
}
