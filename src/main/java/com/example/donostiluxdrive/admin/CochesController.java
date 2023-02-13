package com.example.donostiluxdrive.admin;



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

public class CochesController implements Initializable {

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
    private TextField marcaLabel;

    @FXML
    private TextField modeloLabel;

    @FXML
    private TextField precioLabel;

    @FXML
    private TableView<CochePrueba> tblViewAlumnos;

    private Connection conexion;

    private ObservableList<CochePrueba> listaCoChe;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        conexion = new Conexion();
        conexion.establecerConexion();
        //Inicializar listas
        listaCoChe = FXCollections.observableArrayList();
        //Llenar listas
        CochePrueba.llenarInformacionCoches(conexion.getConnection(), listaCoChe);
        //Enlazar listas con tablaView
        tblViewAlumnos.setItems(listaCoChe);
        //Enlazar columnas con atributos
        clmnId.setCellValueFactory(new PropertyValueFactory<CochePrueba,Number>("id"));
        clmnMarca.setCellValueFactory(new PropertyValueFactory<CochePrueba,String>("marca"));
        clmnModelo.setCellValueFactory(new PropertyValueFactory<CochePrueba,String>("modelo"));
        clmnColor.setCellValueFactory(new PropertyValueFactory<CochePrueba,String>("color"));
        clmnPrecio.setCellValueFactory(new PropertyValueFactory<CochePrueba,Number>("precio"));

        gestionarEventos();
        conexion.cerrarConexion();
    }
    public void gestionarEventos(){
        tblViewAlumnos.getSelectionModel().selectedItemProperty().addListener(
                new ChangeListener<CochePrueba>() {
                    @Override
                    public void changed(ObservableValue<? extends CochePrueba> arg0,
                                        CochePrueba valorAnterior, CochePrueba valorSeleccionado) {
                        if (valorSeleccionado!=null){
                            marcaLabel.setText(String.valueOf(valorSeleccionado.getMarca());
                            modeloLabel.setText(valorSeleccionado.getModelo());
                            colorLabel.setText(valorSeleccionado.getColor();
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
        //Crear una nueva instancia del tipo Alumno
        CochePrueba a = new CochePrueba(0,
                marcaLabel.getText(),
                modeloLabel.getText(),
                colorLabel.getText(),
                Integer.valueOf(precioLabel.getText()),


        //Llamar al metodo guardarRegistro de la clase Alumno
        conexion.establecerConexion();
        int resultado = a.guardarRegistro(conexion.getConnection());
        conexion.cerrarConexion();

        if (resultado == 1){
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
        CochePrueba a = new CochePrueba(
                Integer.valueOf(clmnId.getText()),
                marcaLabel.getText(),
                modeloLabel.getText(),
                colorLabel.getText(),
                Integer.valueOf(precioLabel.getText()));
                //rbtFemenino.isSelected()?"F":"M",//Condicion?ValorVerdadero:ValorFalso
                //Date.valueOf(dtpkrFecha.getValue()),
                //cmbCentroEstudio.getSelectionModel().getSelectedItem(),
                //cmbCarrera.getSelectionModel().getSelectedItem());
        conexion.establecerConexion();
        int resultado = a.actualizarRegistro(conexion.getConnection());
        conexion.cerrarConexion();

        if (resultado == 1){
            listaCoChe.set(tblViewAlumnos.getSelectionModel().getSelectedIndex(),a);
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
        conexion.establecerConexion();
        int resultado = tblViewAlumnos.getSelectionModel().getSelectedItem().eliminarRegistro(conexion.getConnection());
        conexion.cerrarConexion();

        if (resultado == 1){
            listaCoChe.remove(tblViewAlumnos.getSelectionModel().getSelectedIndex());
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
        marcaLabel.setText(null);
        modeloLabel.setText(null);
        colorLabel.setText(null);
        precioLabel.setText(null);

        btnGuardar.setDisable(false);
        btnEliminar.setDisable(true);
        btnActualizar.setDisable(true);
    }
}


