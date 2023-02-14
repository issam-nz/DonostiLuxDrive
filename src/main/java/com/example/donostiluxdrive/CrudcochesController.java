package com.example.donostiluxdrive;



import clases.CochePrueba;
import com.example.donostiluxdrive.admin.Conexion;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.Connection;
import java.util.ResourceBundle;

public class CrudcochesController implements Initializable {

    @FXML
    private Button btnActualizar;

    @FXML
    private Button btnEliminar;

    @FXML
    private Button btnGuardar;

    @FXML
    private TableColumn<CochePrueba, String> clmnColor;

    @FXML
    private TableColumn<CochePrueba, Number> clmnId;

    @FXML
    private TableColumn<CochePrueba, String> clmnMarca;

    @FXML
    private TableColumn<CochePrueba, String> clmnModelo;

    @FXML
    private TableColumn<CochePrueba, Number> clmnPrecio;

    @FXML
    private TextField colorLabel;


    @FXML
    private TextField idLabel;

    @FXML
    private TextField marcaLabel;

    @FXML
    private TextField modeloLabel;

    @FXML
    private TextField precioLabel;

    @FXML
    private TableView<CochePrueba> tblCoches;

    private Connection conexion;

    private ObservableList<CochePrueba> listaCoChe;




    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Conexion conexion = new Conexion();
        conexion.establecerConexion();

        //Inicializar listas
        listaCoChe = FXCollections.observableArrayList();
        //Llenar listas
        CochePrueba.llenarInformacionCoches(conexion.getConexion(), listaCoChe);
        //Enlazar listas con tablaView
        tblCoches.setItems(listaCoChe);
        //Enlazar columnas con atributos
        clmnId.setCellValueFactory(new PropertyValueFactory<CochePrueba,Number>("id"));
        clmnMarca.setCellValueFactory(new PropertyValueFactory<CochePrueba,String>("marca"));
        clmnModelo.setCellValueFactory(new PropertyValueFactory<CochePrueba,String>("modelo"));
        clmnColor.setCellValueFactory(new PropertyValueFactory<CochePrueba,String>("color"));
        clmnPrecio.setCellValueFactory(new PropertyValueFactory<CochePrueba,Number>("precioBase"));

        gestionarEventos();
        conexion.cerrarConexion();
    }
    public void gestionarEventos(){
        tblCoches.getSelectionModel().selectedItemProperty().addListener(
                new ChangeListener<CochePrueba>() {
                    @Override
                    public void changed(ObservableValue<? extends CochePrueba> arg0,
                                        CochePrueba valorAnterior, CochePrueba valorSeleccionado) {
                        if (valorSeleccionado!=null){
                            idLabel.setText(String.valueOf(valorSeleccionado.getMarca()));
                            marcaLabel.setText(String.valueOf(valorSeleccionado.getMarca()));
                            modeloLabel.setText(valorSeleccionado.getModelo());
                            colorLabel.setText(valorSeleccionado.getColor());
                            precioLabel.setText(String.valueOf(valorSeleccionado.getPrecio_base()));

                            btnGuardar.setDisable(true);
                            btnEliminar.setDisable(false);
                            btnActualizar.setDisable(false);
                        }
                    }

                }
        );
    }

    @FXML
    public void guardarRegistro(){
        Conexion conexion = new Conexion();

        conexion.establecerConexion();

        //Crear una nueva instancia del tipo Alumno
        CochePrueba a = new CochePrueba(
                Integer.valueOf(idLabel.getText()),
                marcaLabel.getText(),
                modeloLabel.getText(),
                colorLabel.getText(),
                Integer.valueOf(precioLabel.getText()));


        //Llamar al metodo guardarRegistro de la clase Alumno
        conexion.establecerConexion();
        int resultant = a.guardarRegistro(conexion.getConexion());
        conexion.cerrarConexion();

        if (resultant == 1){
            listaCoChe.add(a);
            //JDK 8u>40
            Alert mensaje = new Alert(Alert.AlertType.INFORMATION);
            mensaje.setTitle("Registro agregado");
            mensaje.setContentText("El registro ha sido agregado exitosamente");
            mensaje.setHeaderText("Resultado:");
            mensaje.show();
        }
    }

    @FXML
    public void actualizarRegistro(){
        Conexion conexion = new Conexion();
        CochePrueba a = new CochePrueba(
                Integer.valueOf(idLabel.getText()),
                marcaLabel.getText(),
                modeloLabel.getText(),
                colorLabel.getText(),
                Integer.valueOf(precioLabel.getText()));

        conexion.establecerConexion();
        int resultado = a.actualizarRegistro(conexion.getConexion());
        conexion.cerrarConexion();

        if (resultado == 1){
            listaCoChe.set(tblCoches.getSelectionModel().getSelectedIndex(),a);
            //JDK 8u>40
            Alert mensaje = new Alert(Alert.AlertType.INFORMATION);
            mensaje.setTitle("Registro actualizado");
            mensaje.setContentText("El registro ha sido actualizado exitosamente");
            mensaje.setHeaderText("Resultado:");
            mensaje.show();
        }
    }

    @FXML
    public void eliminarRegistro(){
        Conexion conexion = new Conexion();
        conexion.establecerConexion();
        int resultado = tblCoches.getSelectionModel().getSelectedItem().eliminarRegistro(conexion.getConexion());
        conexion.cerrarConexion();

        if (resultado == 1){
            listaCoChe.remove(tblCoches.getSelectionModel().getSelectedIndex());
            //JDK 8u>40
            Alert mensaje = new Alert(Alert.AlertType.INFORMATION);
            mensaje.setTitle("Registro eliminado");
            mensaje.setContentText("El registro ha sido eliminado exitosamente");
            mensaje.setHeaderText("Resultado:");
            mensaje.show();
        }
    }

    @FXML
    public void limpiarComponentes(){
        idLabel.setText(null);
        marcaLabel.setText(null);
        modeloLabel.setText(null);
        colorLabel.setText(null);
        precioLabel.setText(null);

        btnGuardar.setDisable(false);
        btnEliminar.setDisable(true);
        btnActualizar.setDisable(true);
    }
}


