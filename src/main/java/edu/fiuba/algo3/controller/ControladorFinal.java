package edu.fiuba.algo3.controller;

import edu.fiuba.algo3.view.VistaInicio;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

import java.io.FileNotFoundException;

public class ControladorFinal implements EventHandler<ActionEvent>  {

    @Override
    public void handle(ActionEvent actionEvent) {
        try {
            ((Button)actionEvent.getSource()).getScene().setRoot(new VistaInicio());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
