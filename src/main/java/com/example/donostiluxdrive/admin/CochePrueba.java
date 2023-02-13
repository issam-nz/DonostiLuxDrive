package com.example.donostiluxdrive.admin;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.ObservableList;

import java.sql.*;

public class CochePrueba {
    private IntegerProperty id_coche;
    private StringProperty marca;
    private StringProperty modelo;
    private StringProperty color;
    private IntegerProperty precio_base;

    public CochePrueba(int id_coche, String marca, String modelo, String color, int precio_base) {
        this.id_coche = new SimpleIntegerProperty(id_coche);
        this.marca = new SimpleStringProperty(marca);
        this.modelo = new SimpleStringProperty(modelo);
        this.color = new SimpleStringProperty(color);
        this.precio_base = new SimpleIntegerProperty(precio_base);
    }

    //Metodos getter and setter
    //id
    public Integer getId_coche(){
        return id_coche.get();
    }

    public void setId_coche(Integer id_coche){
        this.id_coche = new SimpleIntegerProperty(id_coche);
    }
    //Marca
    public String getMarca(){
        return marca.get();
    }

    public void setMarca(String marca){
        this.marca = new SimpleStringProperty(marca);
    }
    //Modelo
    public String getModelo(){
        return modelo.get();
    }

    public void setModelo(String modelo){
        this.modelo = new SimpleStringProperty(modelo);
    }
    //Color
    public String getColor(){
        return color.get();
    }

    public void setColor(String color){
        this.color = new SimpleStringProperty(color);
    }
    //Precio Base
    public Integer getPrecio_base(){
        return precio_base.get();
    }

    public void setPrecio_base(Integer precio_base){
        this.precio_base = new SimpleIntegerProperty(precio_base);
    }

    public IntegerProperty idCoche(){
        return id_coche;
    }

    public StringProperty marca(){
        return marca;
    }

    public StringProperty modeloProperty(){
        return modelo;
    }

    public StringProperty colorProperty(){
        return color;
    }

    public IntegerProperty generoProperty(){
        return precio_base;
    }

    public int guardarRegistro(Connection connection){
        try {
            //Evitar inyeccion SQL.
            PreparedStatement instruccion =
                    connection.prepareStatement("INSERT INTO coches (marca, modelo, color, precio_base) "+
                            "VALUES (?, ?, ?, ?, ?, ?, ?)");
            instruccion.setString(1, modelo.get());
            instruccion.setString(2, marca.get());
            instruccion.setString(3, color.get());
            instruccion.setInt(4, precio_base.get());
            return instruccion.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int actualizarRegistro(Connection connection){
        try {
            PreparedStatement instruccion =
                    connection.prepareStatement(
                            "UPDATE coches "+
                                    " SET 	id = ?,  "+
                                    " marca = ?,  "+
                                    " modelo = ?, "+
                                    " color = ?,  "+
                                    " precio_base = ?, "+

                    );
            instruccion.setString(1, modelo.get());
            instruccion.setString(2, marca.get());
            instruccion.setString(3, color.get());
            instruccion.setInt(4, precio_base.get());
            return instruccion.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int eliminarRegistro(Connection connection){
        try {
            PreparedStatement instruccion = connection.prepareStatement(
                    "DELETE FROM coches "+
                            "WHERE id = ?"
            );
            instruccion.setInt(1, id_coche.get());
            return instruccion.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static void llenarInformacionCoches(Connection connection,
                                                ObservableList<CochePrueba> lista){
        try {
            Statement instruccion = connection.createStatement();
            ResultSet resultado = instruccion.executeQuery(
                    "SELECT A.codigo_alumno, " +
                            "A.nombre, " +
                            "A.apellido, " +
                            "A.edad, " +
                            "A.genero, " +
                            "A.fecha_ingreso, " +
                            "A.codigo_centro, " +
                            "A.codigo_carrera, " +
                            "B.nombre_carrera, " +
                            "B.cantidad_asignaturas, " +
                            "C.nombre_centro_estudio " +
                            "FROM coches A "

            );
            while(resultado.next()){
                lista.add(
                        new CochePrueba(
                                resultado.getInt("id"),
                                resultado.getString("marca"),
                                resultado.getString("modelo"),
                                resultado.getString("color"),
                                resultado.getInt("precio_base")


                        )
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



}
