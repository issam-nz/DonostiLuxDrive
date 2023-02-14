package com.example.donostiluxdrive.form;

import clases.Coche;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;


//when the user select the marca and he modelo required -> {
//        precioLabel.setText(precioTotal + "€");
//        precioTitleLabel.setVisible(true);
//        precioLabel.setVisible(true);
// }
public class MarcaFormularioController {

    @FXML
    private ComboBox<?> colorCombo;

    @FXML
    private ComboBox<?> marcaCombo;

    @FXML
    private ComboBox<?> modeloCombo;

    @FXML
    private Button nextButton;

    @FXML
    private Label precioLabel;

    @FXML
    private Label precioTitleLabel;

    @FXML
    void goToClienteFormulario(ActionEvent event) {

    }

    public void setAvailableCars(ObservableList<Coche> cochesList) {
    }
}
