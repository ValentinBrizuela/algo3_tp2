package edu.fiuba.algo3.view;

import edu.fiuba.algo3.modelo.edificios.Criadero;
import edu.fiuba.algo3.modelo.edificios.Pilon;
import edu.fiuba.algo3.modelo.juego.AlgoStar;
import edu.fiuba.algo3.modelo.juego.Casilla;
import edu.fiuba.algo3.modelo.juego.Entidad;
import edu.fiuba.algo3.modelo.recursos.Geiser;
import edu.fiuba.algo3.modelo.recursos.Mena;
import edu.fiuba.algo3.modelo.recursos.Recurso;
import edu.fiuba.algo3.modelo.terrenos.Espacio;
import edu.fiuba.algo3.modelo.terrenos.Moho;
import edu.fiuba.algo3.modelo.terrenos.Terreno;
import edu.fiuba.algo3.modelo.terrenos.Tierra;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;


public class VistaMapa extends StackPane {
    private AlgoStar algostar;
    private Pane recursos = new Pane();
    private Pane terrenos = new Pane();
    private Pane entidades = new Pane();

    private Pane casillaPrimaria = new Pane();

    private Pane casillaSecundaria = new Pane();

    public VistaMapa(AlgoStar algoStar, Stage stage) {

            this.algostar = algoStar;
            this.getChildren().addAll(terrenos, recursos, entidades, casillaPrimaria, casillaSecundaria);
            try {
                dibujarTerreno();
                dibujarRecurso();
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
                        terrenos.getChildren().add(imagen);
                    }
                    if (recurso.getClass() == Moho.class) {
                        ImageView imagen = new ImageView(moho);
                        imagen.setX(i * 8);
                        imagen.setY(j * 8);
                        terrenos.getChildren().add(imagen);
                    }
                    if (recurso.getClass() == Espacio.class) {
                        ImageView imagen = new ImageView(espacio);
                        imagen.setX(i * 8);
                        imagen.setY(j * 8);
                        terrenos.getChildren().add(imagen);
                    }
                }
            }
        }

        public void dibujarRecurso() throws FileNotFoundException {
            Image mina = new Image(new FileInputStream("assets/mina.png"));
            Image geiser = new Image(new FileInputStream("assets/geiser.png"));

            for (int i = 0; i < algostar.mapa.tamanioMapa(); i++) {
                for (int j = 0; j < algostar.mapa.tamanioMapa(); j++) {
                    Casilla casilla = algostar.mapa.obtenerCasilla(i, j);
                    Recurso recurso = casilla.obtenerRecurso();

                    if (recurso.getClass() == Mena.class) {
                        ImageView imagen = new ImageView(mina);
                        imagen.setX(i * 8);
                        imagen.setY(j * 8);
                        recursos.getChildren().add(imagen);
                    }
                    if (recurso.getClass() == Geiser.class) {
                        ImageView imagen = new ImageView(geiser);
                        imagen.setX(i * 8);
                        imagen.setY(j * 8);
                        recursos.getChildren().add(imagen);
                    }
                }
            }
        }

    public void dibujarEntidades() throws FileNotFoundException {
        Image pilon = new Image(new FileInputStream("assets/pilon.png"), 15, 15, false, false);
        Image criadero = new Image(new FileInputStream("assets/criadero.png"), 20, 20, false, false);

        for (int i = 0; i < algostar.mapa.tamanioMapa(); i++) {
            for (int j = 0; j < algostar.mapa.tamanioMapa(); j++) {
                Casilla casilla = algostar.mapa.obtenerCasilla(i, j);
                try {
                    Entidad entidad = casilla.obtenerEstado().obtenerEntidad();
                    if (entidad.getClass() == Pilon.class) {
                        ImageView imagen = new ImageView(pilon);
                        imagen.resize(10,10);
                        imagen.setX(i * 8);
                        imagen.setY(j * 8);
                        entidades.getChildren().add(imagen);
                    }
                    if (entidad.getClass() == Criadero.class) {
                        ImageView imagen = new ImageView(criadero);
                        imagen.resize(10,10);
                        imagen.setX(i * 8);
                        imagen.setY(j * 8);
                        entidades.getChildren().add(imagen);
                    }
                } catch(Exception ignored) {
                }
            }
        }
    }

    public void dibujarBordeCasillaPrimaria(int x, int y) {
        if ( x < algostar.mapa.tamanioMapa() && y < algostar.mapa.tamanioMapa()) {
            casillaPrimaria.getChildren().clear();
            Line linea1 = new Line(x*8, y*8, x*8, y*8+8);
            linea1.setStyle("-fx-stroke: red;");
            Line linea2 = new Line(x*8+8, y*8,x*8+8 , y*8+8);
            linea2.setStyle("-fx-stroke: red;");
            Line linea3 = new Line(x*8,y*8, x*8+8, y*8);
            linea3.setStyle("-fx-stroke: red;");
            Line linea4 = new Line(x*8, y*8+8, x*8+8, y*8+8);
            linea4.setStyle("-fx-stroke: red;");
            casillaPrimaria.getChildren().addAll(linea1, linea2, linea3, linea4);
        }
    }

    public void dibujarBordeCasillaSecundaria(int x, int y) {
        if ( x < algostar.mapa.tamanioMapa() && y < algostar.mapa.tamanioMapa()) {
            casillaSecundaria.getChildren().clear();
            Line linea1 = new Line(x*8, y*8, x*8, y*8+8);
            linea1.setStyle("-fx-stroke: blue;");
            Line linea2 = new Line(x*8+8, y*8,x*8+8 , y*8+8);
            linea2.setStyle("-fx-stroke: blue;");
            Line linea3 = new Line(x*8,y*8, x*8+8, y*8);
            linea3.setStyle("-fx-stroke: blue;");
            Line linea4 = new Line(x*8, y*8+8, x*8+8, y*8+8);
            linea4.setStyle("-fx-stroke: blue;");
            casillaSecundaria.getChildren().addAll(linea1, linea2, linea3, linea4);
        }
    }

    public void actualizar() throws FileNotFoundException {
        dibujarEntidades();
        dibujarTerreno();
        dibujarRecurso();
    }
}

