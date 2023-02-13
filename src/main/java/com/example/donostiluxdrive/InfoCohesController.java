package com.example.donostiluxdrive;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class InfoCohesController {
    //Declaracion de variables

    @FXML
    private Button minusButton;
    @FXML
    private Button mayusButton;
    @FXML
    private Button inicioButtonNav;

    @FXML
    private Button cochesButtonNav;

    @FXML
    private Button segurosButtonNav;

    @FXML
    private Button signInButton;

    @FXML
    private Button alquilarButton;

    //Metodos


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

    @FXML
    void goToBeforeImage(ActionEvent event) {

    }

    @FXML
    void goToNextImage(ActionEvent event) {

    }
    @FXML
    void goToReserva(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("ReservaFormulario-view.fxml"));
            Scene scene = new Scene(root);
            Stage stage = (Stage) segurosButtonNav.getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}





