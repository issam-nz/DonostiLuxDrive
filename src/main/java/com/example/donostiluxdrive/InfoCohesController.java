package com.example.donostiluxdrive;

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

public abstract class InfoCohesController implements Initializable{


    @FXML
    private Label precioLabel;
    @FXML
    private Label ColorLabel;

    @FXML
    private Label CaballosLabel;

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

        }
        /*
        public void setCoche(MasInfoCoche coche, String img1, String img2, String img3) {

            InfoCohesController.coche = coche;

            Image image1 = new Image(img1);
            Image image2 = new Image(img2);
            Image image3 = new Image(img3);

            this.marcaLabel.setText(InfoCohesController.coche.getMarca());
            this.modeloLabel.setText(InfoCohesController.coche.getModelo());
            this.CaballosLabel.setText(InfoCohesController.coche.getCaballos());
            this.ColorLabel.setText(InfoCohesController.coche.getColor());
            this.anoLabel.setText(InfoCohesController.coche.getAno());
            this.precioLabel.setText(InfoCohesController.coche.getPrecio_base());

            this.img1.setImage(image1);
            this.img2.setImage(image2);
            this.img3.setImage(image3);

        }
        */

        public void rellenarCoche1(){
            this.marcaLabel.setText(CochesController.coche1.getMarca());
            this.modeloLabel.setText(CochesController.coche1.getModelo());
            this.CaballosLabel.setText(CochesController.coche1.getCaballos());
            this.ColorLabel.setText(CochesController.coche1.getColor());
            this.anoLabel.setText(CochesController.coche1.getAno());
            this.precioLabel.setText(CochesController.coche1.getPrecio_base());
        }
}





