package com.example.donostiluxdrive;

import clases.Reserva;
import clases.database;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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

    Reserva reserva;


    public void confirmar(ActionEvent actionEvent) {
        if (nombreField == null || apellidoField == null || emailField == null || telefonoField == null)
            showAlertDialog("fill all the fields");
        reserva = new Reserva(MarcaFormularioController.cocheElejido.getId_coche(),
                FechaFormularioController.fechaIn,
                FechaFormularioController.fechaFin,
                nombreField.getText(),
                apellidoField.getText(),
                emailField.getText(),
                telefonoField.getText(),
                MarcaFormularioController.precioTotal
        );
        String query = "INSERT INTO reservas (id_coche, fechaIn, fechaFin, nombreCliente, apellidoCliente, emailCliente, telefonoCliente, precioTotal) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = database.connectDb();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, reserva.getId_coche());
            stmt.setDate(2, Date.valueOf(reserva.getFechaIn()));
            stmt.setDate(3, Date.valueOf(reserva.getFechaFin()));
            stmt.setString(4, reserva.getNombreCliente());
            stmt.setString(5, reserva.getApellidoCliente());
            stmt.setString(6, reserva.getEmailCliente());
            stmt.setString(7, reserva.getTelefonoCliente());
            stmt.setDouble(8, reserva.getPrecioTotal());
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected == 1) {
                System.out.println("added successfully.");
            } else {
                System.out.println("Error: no rows were affected by the insert operation.");
            }
        } catch (SQLException e) {
            System.out.println("Error inserting new reserva: " + e.getMessage());
        }

    }

    public static void showAlertDialog(String mensaje) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}
//when confirmar es clicked :
//    - check is everything is valid (all the textFields are filled)
//    - hacer un query de insert en reservas
//    - reset all the attributes (fechaIn, fechaFin, cochesLista, marcas, marcaElejida ...)

//proxima version:
//    - show an alert of fthe reserva Details
//    - controll the textField (like email )