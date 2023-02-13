package com.example.donostiluxdrive.admin;



import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class CochesController {


    @FXML
    private TableColumn<?, ?> idColumn;

    @FXML
    private TableColumn<?, ?> colorColumn;

    @FXML
    private TableColumn<?, ?> marcaColumn;

    @FXML
    private TableColumn<?, ?> modeloColumn;

    @FXML
    private TableView<?> personTable;

    @FXML
    private TableColumn<?, ?> precioBaseColumn;

    String sql = "";

}
