package edu.fiuba.algo3.entrega_2;

import edu.fiuba.algo3.modelo.edificios.Acceso;

import edu.fiuba.algo3.modelo.juego.Almacen;
import edu.fiuba.algo3.modelo.juego.Casilla;
import edu.fiuba.algo3.modelo.juego.FakeMapa;
import edu.fiuba.algo3.modelo.juego.Mapa;

import edu.fiuba.algo3.modelo.unidades.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CasoDeUso18Test {

    @Test
    public void UnZerlingHace4DeDanioAUnidadTerrestre(){
        FakeMapa mapa = new FakeMapa(2);
        Almacen a=new Almacen();
        a.almacenarMineral(10000);
        a.almacenarGas(10000);

        Casilla casilla1 = mapa.obtenerCasilla(5,5);
        Casilla casilla2 = mapa.obtenerCasilla(6,6);
        Zerling z = new Zerling(casilla1);
        Acceso acceso = new Acceso(casilla2);

        for (int i=0; i<25; i++){
            z.avanzarTurno();
        }

        acceso.recibirAtaque(z, mapa);

        assertEquals(496, acceso.escudo());

    }

    @Test
    public void UnHidraliscoHace10DeDanioAUnidadTerrestreY10DeDanioAUnidadAerea(){
        FakeMapa mapa = new FakeMapa(2);
        Almacen a=new Almacen();
        a.almacenarMineral(10000);
        a.almacenarGas(10000);

        Casilla casilla1 = mapa.obtenerCasilla(5,5);
        Casilla casilla2 = mapa.obtenerCasilla(6,6);
        Casilla casilla3 = mapa.obtenerCasilla(7,7);
        Hidralisco h = new Hidralisco(casilla1);
        Dragon d = new Dragon(casilla2);
        Scout s = new Scout(casilla3);

        for (int i=0; i<25; i++){
            h.avanzarTurno();
        }

        d.recibirAtaque(h, mapa);

        assertEquals(70, d.escudo());

        s.recibirAtaque(h, mapa);

        assertEquals(90, s.escudo());
    }

    @Test
    public void UnMutaliscoHace9DeDanioAUnidadTerrestreY9DeDanioAUnidadAerea(){
        FakeMapa mapa = new FakeMapa(2);
        Almacen a=new Almacen();
        a.almacenarMineral(10000);
        a.almacenarGas(10000);

        Casilla casilla1 = mapa.obtenerCasilla(5,5);
        Casilla casilla2 = mapa.obtenerCasilla(6,6);
        Casilla casilla3 = mapa.obtenerCasilla(7,7);
        Mutalisco m = new Mutalisco(casilla1);
        Dragon d = new Dragon(casilla2);
        Scout s = new Scout(casilla3);

        for (int i=0; i<25; i++){
            m.avanzarTurno();
        }

        d.recibirAtaque(m, mapa);

        assertEquals(71, d.escudo());

        s.recibirAtaque(m, mapa);

        assertEquals(91, s.escudo());
    }

    @Test
    public void UnGuardianHace25DeDanioAUnidadTerrestre(){
        FakeMapa mapa = new FakeMapa(2);
        Almacen a=new Almacen();
        a.almacenarMineral(10000);
        a.almacenarGas(10000);

        Casilla casilla1 = mapa.obtenerCasilla(5,5);
        Casilla casilla2 = mapa.obtenerCasilla(6,6);

        Guardian g = new Guardian(casilla1,a );
        Dragon d = new Dragon(casilla2);

        for (int i=0; i<25; i++){
            g.avanzarTurno();
        }

        d.recibirAtaque(g, mapa);

        assertEquals(55, d.escudo());

    }

    @Test
    public void UnZealotHace8DeDanioAUnidadTerrestre(){
        FakeMapa mapa = new FakeMapa(2);
        Almacen a=new Almacen();
        a.almacenarMineral(10000);
        a.almacenarGas(10000);

        Casilla casilla1 = mapa.obtenerCasilla(5,5);
        Casilla casilla2 = mapa.obtenerCasilla(6,6);

        Zealot z = new Zealot(casilla1);
        Hidralisco h = new Hidralisco(casilla2);

        for (int i=0; i<25; i++){
            z.avanzarTurno();
        }

        h.recibirAtaque(z, mapa);

        assertEquals(72, h.vida());
    }

    @Test
    public void UnDragonHace20DeDanioAUnidadTerrestreY20DeDanioAUnidadAerea(){
        FakeMapa mapa = new FakeMapa(2);
        Almacen a=new Almacen();
        a.almacenarMineral(10000);
        a.almacenarGas(10000);

        Casilla casilla1 = mapa.obtenerCasilla(5,5);
        Casilla casilla2 = mapa.obtenerCasilla(6,6);
        Casilla casilla3 = mapa.obtenerCasilla(7,7);

        Dragon d = new Dragon(casilla1);
        Zerling z = new Zerling(casilla2);
        Mutalisco m = new Mutalisco(casilla3);

        for (int i=0; i<25; i++){
            d.avanzarTurno();
        }

        z.recibirAtaque(d, mapa);

        assertEquals(15, z.vida());

        m.recibirAtaque(d, mapa);

        assertEquals(100, m.vida());
    }

    @Test
    public void UnScoutHace8DeDanioAUnidadTerrestreY14DeDanioAUnidadAerea(){
        FakeMapa mapa = new FakeMapa(2);
        Almacen a=new Almacen();
        a.almacenarMineral(10000);
        a.almacenarGas(10000);

        Casilla casilla1 = mapa.obtenerCasilla(5,5);
        Casilla casilla2 = mapa.obtenerCasilla(6,6);
        Casilla casilla3 = mapa.obtenerCasilla(7,7);

        Scout s = new Scout(casilla1);
        Hidralisco h = new Hidralisco(casilla2);
        Mutalisco m = new Mutalisco(casilla3);

        for (int i=0; i<25; i++){
            s.avanzarTurno();
        }

        h.recibirAtaque(s, mapa);

        assertEquals(72, h.vida());

        m.recibirAtaque(s, mapa);

        assertEquals(106, m.vida());
    }
}
