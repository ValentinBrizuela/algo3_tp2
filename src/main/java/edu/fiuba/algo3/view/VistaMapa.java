package edu.fiuba.algo3.view;

import edu.fiuba.algo3.modelo.juego.AlgoStar;
import edu.fiuba.algo3.modelo.juego.Casilla;
import edu.fiuba.algo3.modelo.recursos.Recurso;
import edu.fiuba.algo3.modelo.terrenos.Espacio;
import edu.fiuba.algo3.modelo.terrenos.Moho;
import edu.fiuba.algo3.modelo.terrenos.Terreno;
import edu.fiuba.algo3.modelo.terrenos.Tierra;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

import java.io.FileInputStream;
import java.io.FileNotFoundException;


public class VistaMapa extends StackPane {
    private AlgoStar algostar;
    private Pane recursos = new Pane();
    private Pane terrenos = new Pane();

    public VistaMapa(AlgoStar algoStar) {
        this.algostar = algoStar;
        this.getChildren().addAll(recursos, terrenos);
        try {
            dibujarTerreno();
        }
        catch (FileNotFoundException ff) {
            System.out.println("Exception " + ff.toString());
        }
    }

    public void dibujarTerreno() throws FileNotFoundException {
        Image tierra = new Image(new FileInputStream("assets/tierra.png"));
        Image moho = new Image(new FileInputStream("assets/moho.png"));
        Image espacio = new Image(new FileInputStream("assets/espacio.png"));
        for (int i = 0; i < algostar.mapa.tamanioMapa(); i++) {
            for (int j = 0; j < algostar.mapa.tamanioMapa(); j++) {
                Casilla casilla = algostar.mapa.obtenerCasilla(i, j);
                Terreno recurso = casilla.obtenerTerreno();
                if (recurso.getClass() == Tierra.class) {
                    ImageView imagen = new ImageView(tierra);
                    imagen.setX(i * 8);
                    imagen.setY(j * 8);
                    recursos.getChildren().add(imagen);
                }
                if (recurso.getClass() == Moho.class) {
                    ImageView imagen = new ImageView(moho);
                    imagen.setX(i * 8);
                    imagen.setY(j * 8);
                    recursos.getChildren().add(imagen);
                }
                if (recurso.getClass() == Espacio.class) {
                    ImageView imagen = new ImageView(espacio);
                    imagen.setX(i * 8);
                    imagen.setY(j * 8);
                    recursos.getChildren().add(imagen);
                }
            }
        }
    }
}

