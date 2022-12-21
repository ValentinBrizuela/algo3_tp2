package edu.fiuba.algo3.view;

import edu.fiuba.algo3.modelo.edificios.*;
import edu.fiuba.algo3.modelo.juego.AlgoStar;
import edu.fiuba.algo3.modelo.juego.Casilla;
import edu.fiuba.algo3.modelo.juego.Entidad;
import edu.fiuba.algo3.modelo.recursos.Geiser;
import edu.fiuba.algo3.modelo.recursos.Mena;
import edu.fiuba.algo3.modelo.recursos.Recurso;
import edu.fiuba.algo3.modelo.terrenos.*;
import edu.fiuba.algo3.modelo.unidades.*;
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


        public void dibujarElemento(int i, int j, Image elemento, Pane pane) {
            ImageView imagen = new ImageView(elemento);
            imagen.setX(i * 8);
            imagen.setY(j * 8);
            pane.getChildren().add(imagen);
        }

        public void dibujarTerreno() throws FileNotFoundException {
            Image tierra = new Image(new FileInputStream("assets/tierra.png"));
            Image tierraEnergizada = new Image(new FileInputStream("assets/tierra energizada.png"), 10, 10, false, false);
            Image moho = new Image(new FileInputStream("assets/moho.png"));
            Image espacio = new Image(new FileInputStream("assets/espacio.png"));
            for (int i = 0; i < algostar.mapa.tamanioMapa(); i++) {
                for (int j = 0; j < algostar.mapa.tamanioMapa(); j++) {
                    Casilla casilla = algostar.mapa.obtenerCasilla(i, j);
                    Terreno recurso = casilla.obtenerTerreno();

                    if (recurso.getClass() == Tierra.class) {
                        dibujarElemento(i, j, tierra, terrenos);
                    }
                    if (recurso.getClass() == Moho.class) {
                        dibujarElemento(i, j, moho, terrenos);
                    }
                    if (recurso.getClass() == Espacio.class) {
                        dibujarElemento(i, j, espacio, terrenos);
                    }
                    if (recurso.getClass() == TierraEnergizada.class) {
                        dibujarElemento(i, j, tierraEnergizada, terrenos);
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
                        dibujarElemento(i, j, mina, recursos);
                    }
                    if (recurso.getClass() == Geiser.class) {
                        dibujarElemento(i, j, geiser, recursos);
                    }
                }
            }
        }

    public void dibujarEntidades() throws FileNotFoundException {
        entidades.getChildren().clear();
        Image pilon = new Image(new FileInputStream("assets/pilon.png"), 15, 15, false, false);
        Image criadero = new Image(new FileInputStream("assets/criadero.png"), 20, 20, false, false);
        Image acceso = new Image(new FileInputStream("assets/acceso.png"), 20, 20, false, false);
        Image asimilador = new Image(new FileInputStream("assets/asimilador.png"), 20, 20, false, false);
        Image espiral = new Image(new FileInputStream("assets/espiral.png"), 20, 20, false, false);
        Image extractor = new Image(new FileInputStream("assets/extractor.png"), 20, 20, false, false);
        Image guarida = new Image(new FileInputStream("assets/guarida.png"), 20, 20, false, false);
        Image nexoMineral = new Image(new FileInputStream("assets/nexo mineral.png"), 20, 20, false, false);
        Image puertoEstelar = new Image(new FileInputStream("assets/puerto estelar.png"), 20, 20, false, false);
        Image reservaDeReprduccion = new Image(new FileInputStream("assets/reserva de reproduccion.png"), 20, 20, false, false);


        Image zangano = new Image(new FileInputStream("assets/zangano.png"), 20, 20, false, false);
        Image zerling = new Image(new FileInputStream("assets/zerling.png"), 20, 20, false, false);
        Image hidralisco = new Image(new FileInputStream("assets/hidralisco.png"), 20, 20, false, false);
        Image mutalisco = new Image(new FileInputStream("assets/mutalisco.png"), 20, 20, false, false);
        Image guardian = new Image(new FileInputStream("assets/guardian.png"), 20, 20, false, false);
        Image devorador = new Image(new FileInputStream("assets/devorador.png"), 20, 20, false, false);
        Image amoSupremo = new Image(new FileInputStream("assets/amoSupremo.png"), 20, 20, false, false);
        Image dragon = new Image(new FileInputStream("assets/dragon.png"), 20, 20, false, false);
        Image zealot = new Image(new FileInputStream("assets/zealot.png"), 20, 20, false, false);
        Image scout = new Image(new FileInputStream("assets/scout.png"), 20, 20, false, false);


        for (int i = 0; i < algostar.mapa.tamanioMapa(); i++) {
            for (int j = 0; j < algostar.mapa.tamanioMapa(); j++) {
                Casilla casilla = algostar.mapa.obtenerCasilla(i, j);
                try {
                    Entidad entidad = casilla.obtenerEstado().obtenerEntidad();
                    if (entidad.getClass() == Pilon.class) {
                        dibujarElemento(i-1, j-1, pilon, entidades);
                    }
                    if (entidad.getClass() == Criadero.class) {
                        dibujarElemento(i-1, j-1, criadero, entidades);
                    }
                    if (entidad.getClass() == Zangano.class) {
                        dibujarElemento(i-1, j-1, zangano, entidades);
                    }
                    if (entidad.getClass() == Zerling.class) {
                        dibujarElemento(i-1, j-1, zerling, entidades);
                    }
                    if (entidad.getClass() == Hidralisco.class) {
                        dibujarElemento(i-1, j-1, hidralisco, entidades);
                    }
                    if (entidad.getClass() == Mutalisco.class) {
                        dibujarElemento(i-1, j-1, mutalisco, entidades);
                    }
                    if (entidad.getClass() == Guardian.class) {
                        dibujarElemento(i-1, j-1, guardian, entidades);
                    }
                    if (entidad.getClass() == Devorador.class) {
                        dibujarElemento(i-1, j-1, devorador, entidades);
                    }
                    if (entidad.getClass() == AmoSupremo.class) {
                        dibujarElemento(i-1, j-1, amoSupremo, entidades);
                    }
                    if (entidad.getClass() == Acceso.class) {
                        dibujarElemento(i-1, j-1, acceso, entidades);
                    }
                    if (entidad.getClass() == Asimilador.class) {
                        dibujarElemento(i-1, j-1, asimilador, entidades);
                    }
                    if (entidad.getClass() == Espiral.class) {
                        dibujarElemento(i-1, j-1, espiral, entidades);
                    }
                    if (entidad.getClass() == Extractor.class) {
                        dibujarElemento(i-1, j-1, extractor, entidades);
                    }
                    if (entidad.getClass() == Guarida.class) {
                        dibujarElemento(i-1, j-1, guarida, entidades);
                    }
                    if (entidad.getClass() == NexoMineral.class) {
                        dibujarElemento(i-1, j-1, nexoMineral, entidades);
                    }
                    if (entidad.getClass() == PuertoEstelar.class) {
                        dibujarElemento(i-1, j-1, puertoEstelar, entidades);
                    }
                    if (entidad.getClass() == ReservaDeReproduccion.class) {
                        dibujarElemento(i-1, j-1, reservaDeReprduccion, entidades);
                    }
                    if (entidad.getClass() == Dragon.class) {
                        dibujarElemento(i-1, j-1, dragon, entidades);
                    }
                    if (entidad.getClass() == Zealot.class) {
                        dibujarElemento(i-1, j-1, zealot, entidades);
                    }
                    if (entidad.getClass() == Scout.class) {
                        dibujarElemento(i-1, j-1, scout, entidades);
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

