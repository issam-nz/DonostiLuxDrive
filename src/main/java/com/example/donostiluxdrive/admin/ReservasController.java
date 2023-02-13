package com.example.donostiluxdrive.admin;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class ReservasController {

    @FXML
    private Button addButton;

    @FXML
    private TableColumn<?, ?> apellidoCliente;

    @FXML
    private Button deleteButton;

    @FXML
    private Button editButton;

    @FXML
    private TableColumn<?, ?> emailColumn;

    @FXML
    private TableColumn<?, ?> fechaFinColumn;

    @FXML
    private TableColumn<?, ?> fechaInColumn;

    @FXML
    private TableColumn<?, ?> idColumn;

    @FXML
    private TableColumn<?, ?> id_cocheColumn;

    @FXML
    private TableColumn<?, ?> nombreCliente;

    @FXML
    private TableView<?> personTable;

    @FXML
    private TableColumn<?, ?> precioColumn;

    @FXML
    private TableColumn<?, ?> tlefonoColumn;

}
