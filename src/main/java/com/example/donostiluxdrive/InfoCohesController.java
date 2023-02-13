package com.example.donostiluxdrive;

import clases.Coche;
import clases.MasInfoCoche;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class InfoCohesController implements Initializable{


    @FXML
    private Button alquilarButton;

    @FXML
    private static Label anoLabel;

    @FXML
    private Button cochesButtonNav;

    @FXML
    private static Label colorLabel;

    @FXML
    private static Label cvLabel;

    @FXML
    private ImageView img1;

    @FXML
    private ImageView img2;

    @FXML
    private ImageView img3;

    @FXML
    private Button inicioButtonNav;

    @FXML
    public Label marcaLabel;

    @FXML
    private Button mayusButton;

    @FXML
    private Button minusButton;

    @FXML
    private static Label modeloLabel;

    @FXML
    private static Label prclabel;

    @FXML
    private Button segurosButtonNav;

    @FXML
    private Button signInButton;

    private static MasInfoCoche coche;

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


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
            modeloLabel.setText(coche.getModelo());
            anoLabel.setText(coche.getAno());
            colorLabel.setText(coche.getColor());
            prclabel.setText(coche.getPrecio_base());
            cvLabel.setText(coche.getCaballos());
        }
        public static void setCoche(MasInfoCoche coche) {
            InfoCohesController.coche = coche;
        }
}





