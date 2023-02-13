package com.example.donostiluxdrive;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class CochesController {

    @FXML
    private Button alquilarCoche0_0Button;

    @FXML
    private Button alquilarCoche0_1Button;

    @FXML
    private Button alquilarCoche1_0Button;

    @FXML
    private Button alquilarCoche1_1Button;

    @FXML
    private Button alquilarCoche2_0Button;

    @FXML
    private Button alquilarCoche2_1Button;

    @FXML
    private Button cochesButtonNav;

    @FXML
    private Button infoCoche0_0Button;

    @FXML
    private Button infoCoche0_1Button;

    @FXML
    private Button infoCoche1_0Button;

    @FXML
    private Button infoCoche1_1Button;

    @FXML
    private Button infoCoche2_0Button;

    @FXML
    private Button infoCoche2_1Button;

    @FXML
    private Button inicioButtonNav;

    @FXML
    private Button segurosButtonNav;

    @FXML
    private Button signInButton;

    @FXML
    void goToCoches(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("Coches-view.fxml"));
            Scene scene = new Scene(root);
            Stage stage = (Stage) cochesButtonNav.getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    void goToInfoCoche0_0(ActionEvent event) {

    }

    @FXML
    void goToInfoCoche0_1(ActionEvent event) {

    }

    @FXML
    void goToInfoCoche1_0(ActionEvent event) {

    }

    @FXML
    void goToInfoCoche1_1(ActionEvent event) {

    }

    @FXML
    void goToInfoCoche2_0(ActionEvent event) {

    }

    @FXML
    void goToInfoCoche2_1(ActionEvent event) {

    }

    @FXML
    void goToInicio(ActionEvent event) {
        Stage stage;
        try {
            Parent root = FXMLLoader.load(getClass().getResource("Inicio-view.fxml"));
            Scene scene = new Scene(root);
            stage = (Stage) inicioButtonNav.getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    void goToReserva(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("ReservaFormulario-view.fxml"));
            Scene scene = new Scene(root);
            Stage stage = (Stage) alquilarCoche0_0Button.getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    void goToSeguros(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("Seguros-view.fxml"));
            Scene scene = new Scene(root);
            Stage stage = (Stage) segurosButtonNav.getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    void goToSignIn(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("LoginSignup-view.fxml"));
            Scene scene = new Scene(root);
            Stage stage = (Stage) signInButton.getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
