package edu.fiuba.algo3.modelo.juego;

public class AlgoColores {
    private String algoColor;
    public AlgoColores(String color){
        algoColor=color;
        /*switch (color){
            case "rojo":
                algoColor = Color.RED;
                break;
            case "azul":
                algoColor = Color.BLUE;
                break;
            case "verde":
                algoColor = Color.GREEN;
                break;
            case "amarillo":
                algoColor = Color.YELLOW;
                break;
            case "rosa":
                algoColor = Color.PINK;
                break;
            case "naranja":
                algoColor = Color.ORANGE;
                break;
        }*/
    }

    public String color() {
        return algoColor;
    }

    public boolean esIgualA(AlgoColores color ){
        return color.color() == algoColor;
        //return color.color().equals(algoColor);
    }
}
