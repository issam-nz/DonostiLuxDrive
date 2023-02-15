package com.example.donostiluxdrive;

import clases.CrudReserva;
import clases.Crudcoche;
import clases.Reserva;
import com.example.donostiluxdrive.admin.Conexion;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;

public class CrudreservasController implements Initializable {

    @FXML
    private TextField apellidoLabel;

    @FXML
    private Button btnActualizar;

    @FXML
    private Button btnEliminar;

    @FXML
    private Button btnGuardar;

    @FXML
    private TextField emaiLabel;

    @FXML
    private TableColumn<CrudReserva, String> emailColumn;

    @FXML
    private DatePicker fechInlabel;

    @FXML
    private TableColumn<CrudReserva, Date> fechaFinColumn;

    @FXML
    private DatePicker fechaFinLabel;

    @FXML
    private TableColumn<CrudReserva, Date> fechaInColumn;

    @FXML
    private TableColumn<Crudcoche, Integer> idCocheColumn;

    @FXML
    private TextField idCocheLabel;

    @FXML
    private TableColumn<CrudReserva, Integer> idColumn;

    @FXML
    private TextField idLabel;

    @FXML
    private TextField nombreLabel;

    @FXML
    private TableColumn<CrudReserva, Integer> precioColumn;

    @FXML
    private TextField precioLabel;

    @FXML
    private TableView<CrudReserva> tblReserva;

    @FXML
    private TableColumn<CrudReserva, String> tefColumn;

    @FXML
    private TextField tefLabel;

    private ObservableList<CrudReserva> listaReserva;

    @FXML
    void actualizarRegistro(ActionEvent event) {

    }

    @FXML
    void eliminarRegistro(ActionEvent event) {

    }

    @FXML
    void guardarRegistro(ActionEvent event) {

    }

    @FXML
    void limpiarComponentes(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Conexion conexion = new Conexion();
        conexion.establecerConexion();

        //Inicializar listas
        listaReserva = FXCollections.observableArrayList();
        //Llenar listas
        CrudReserva.llenarInformacionReservas(conexion.getConexion(), listaReserva);
        //Enlazar listas con tablaView
        tblReserva.setItems(listaReserva);
        //Enlazar columnas con atributos
        idColumn.setCellValueFactory(cellData -> cellData.getValue().idProperty().asObject());
        idCocheColumn.setCellValueFactory(cellData -> cellData.getValue().idProperty().asObject());
        fechaInColumn.setCellValueFactory(new PropertyValueFactory<CrudReserva, Date>("fechaIn"));
        //fechaFinColumn.setCellValueFactory(new PropertyValueFactory<Crudcoche,String>("color"));
        //emailColumn.setCellValueFactory(new PropertyValueFactory<Crudcoche,Integer>("precioBase"));
        //tefColumn.setCellValueFactory(new PropertyValueFactory<Crudcoche,Integer>("precioBase"));
        //precioColumn.setCellValueFactory(new PropertyValueFactory<Crudcoche,Integer>("precioBase"));

        conexion.cerrarConexion();

    }
}
