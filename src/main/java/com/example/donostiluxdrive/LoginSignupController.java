package com.example.donostiluxdrive;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Objects;

public class LoginSignupController {

    @FXML
    private TextField logContraTf;

    @FXML
    private TextField logEmailTf;

    @FXML
    private Button loginButton;

    @FXML
    private Button salirVentanaButton;

    @FXML
    private Button signUpButton;

    @FXML
    private TextField singApellidoTf;

    @FXML
    private TextField singContraTf;

    @FXML
    private TextField singEmailTf;

    @FXML
    private TextField singNombreTf;

    @FXML
    private TextField singTelfTF;

    @FXML
    void Login(ActionEvent event) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/donostiluxdrive", "root", "");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM usuarios WHERE usuario='"+logEmailTf.getText()+"' AND contrasena='"+logContraTf.getText()+"'");
            if(resultSet.next()){
                System.out.println("Usuario validado");
                goToCrud();
            }
            else {
                System.out.println("No correcto");
            }
            connection.close();
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    @FXML
    void Singup(ActionEvent event) {


    }

    @FXML
    void gotToInicio(ActionEvent event) {
        Stage stage;
        try {
            Parent root = FXMLLoader.load(getClass().getResource("Inicio-view.fxml"));
            Scene scene = new Scene(root);
            stage = (Stage) salirVentanaButton.getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    void goToCrud() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("Crudportada-view.fxml"));
            //root=FXMLLoader.load(getClass().getClassloader().getResource("application/Models/Views/ProductView.fxml")
            Scene scene = new Scene(root);
            Stage stage = (Stage) loginButton.getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }




}

