package com.example.donostiluxdrive;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class ClienteFormularioController {

    @FXML
    private TextField apellidoField;

    @FXML
    private Button confirmarButton;

    @FXML
    private TextField emailField;

    @FXML
    private TextField nombreField;

    @FXML
    private TextField telefonoField;


    public void confirmar(ActionEvent actionEvent) {
        if (nombreField == null || apellidoField == null || emailField == null || telefonoField == null)
            FechaFormularioController.showAlertDialog("fill all the fields");
    }
}
//when confirmar es clicked :
//    - check is everything is valid (all the textFields are filled)
//    - hacer un query de insert en reservas
//    - reset all the attributes (fechaIn, fechaFin, cochesLista, marcas, marcaElejida ...)

//proxima version:
//    - show an alert of fthe reserva Details
//    - controll the textField (like email )