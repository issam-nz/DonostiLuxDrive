package com.example.donostiluxdrive.form;

import clases.Coche;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;
import java.time.LocalDate;

public class FechaFormularioController {

    @FXML
    private DatePicker fechaFinPicker;

    @FXML
    private DatePicker fechaInPicker;

    @FXML
    private Button nextButton;

    @FXML
    void goToMarcaFormulario(ActionEvent event) throws IOException {
        // assuming fechaInPicker and fechaFinPicker are instances of DatePicker
        LocalDate fechaIn = fechaInPicker.getValue();
        LocalDate fechaFin = fechaFinPicker.getValue();

        //mostrar un alert si el usuario o ha elijido nada
        if (fechaIn == null || fechaFin == null) {
            showAlertDialog("Please select both start and end dates.");
        }

        //mostrar un alert si el usuario o ha elijo un fecha invalida
        if (fechaIn.isAfter(fechaFin)) {
            showAlertDialog("End date must be on or after start date.");
        }

        // assuming conn is a Connection object representing the MySQL database connection
        String query = "SELECT * FROM coches WHERE id NOT IN " +
                "(SELECT id_coche FROM reservas " +
                "WHERE (fechaIn <= ? AND fechaFin >= ?) OR " +
                "(fechaIn <= ? AND fechaFin >= ?) OR " +
                "(fechaIn >= ? AND fechaFin <= ?))";
        ObservableList<Coche> cochesList = FXCollections.observableArrayList();

        Connection conn = null;
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setDate(1, Date.valueOf(fechaIn));
            stmt.setDate(2, Date.valueOf(fechaIn));
            stmt.setDate(3, Date.valueOf(fechaFin));
            stmt.setDate(4, Date.valueOf(fechaFin));
            stmt.setDate(5, Date.valueOf(fechaIn));
            stmt.setDate(6, Date.valueOf(fechaFin));
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String marca = rs.getString("marca");
                String modelo = rs.getString("modelo");
                String color = rs.getString("color");
                int precioBase = rs.getInt("precioBase");
                Coche coche = new Coche(id, marca, modelo, color, precioBase);
                cochesList.add(coche);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        //mostrar un alert si no hay ningun  coche disponible en la fecha elejida
        if (cochesList.isEmpty()) {
            showAlertDialog("There are no cars available in the specified date range.");
        }

        //To pass the list of available cars to the next form, you can add the following code to the section that handles the case where one or more cars are available:
        if (!cochesList.isEmpty()) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("MarcaForm-view.fxml"));
            Parent marcaFormParent = loader.load();
            MarcaFormularioController marcaFormController = loader.getController();
            marcaFormController.setAvailableCars(cochesList);
            Scene marcaFormScene = new Scene(marcaFormParent);
            Stage currentStage = (Stage) nextButton.getScene().getWindow();
            currentStage.setScene(marcaFormScene);
            currentStage.show();
        };
    }

    public void showAlertDialog(String mensaje) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    };

}
