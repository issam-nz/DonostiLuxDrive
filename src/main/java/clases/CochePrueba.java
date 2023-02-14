package clases;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.ObservableList;

import java.sql.*;

public class CochePrueba {
    private IntegerProperty id;
    private StringProperty marca;
    private StringProperty modelo;
    private StringProperty color;
    private IntegerProperty precioBase;

    public CochePrueba( String marca, String modelo, String color, int precioBase) {

        this.marca = new SimpleStringProperty(marca);
        this.modelo = new SimpleStringProperty(modelo);
        this.color = new SimpleStringProperty(color);
        this.precioBase = new SimpleIntegerProperty(precioBase);
    }

    //Metodos getter and setter
    //id
    public Integer getId_coche(){
        return id.get();
    }

    public void setId_coche(Integer id_coche){
        this.id = new SimpleIntegerProperty(id_coche);
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
        return precioBase.get();
    }

    public void setPrecio_base(Integer precio_base){
        this.precioBase = new SimpleIntegerProperty(precio_base);
    }

    public IntegerProperty idCoche(){
        return id;
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
        return precioBase;
    }

    public int guardarRegistro(Connection connection){
        try {
            //Evitar inyeccion SQL.
            PreparedStatement instruccion =
                    connection.prepareStatement("INSERT INTO coches (marca, modelo, color, precioBase) "+
                            "VALUES (?, ?, ?, ?, ?, ?, ?)");
            instruccion.setString(1, modelo.get());
            instruccion.setString(2, marca.get());
            instruccion.setString(3, color.get());
            instruccion.setInt(4, precioBase.get());
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
                                    " precioBase = ?"

                    );
            instruccion.setString(1, modelo.get());
            instruccion.setString(2, marca.get());
            instruccion.setString(3, color.get());
            instruccion.setInt(4, precioBase.get());
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
            instruccion.setInt(1, id.get());
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
                    "SELECT A.marca, " +
                            "A.modelo, " +
                            "A.color, " +
                            "A.precioBase " +
                            "FROM coches A "

            );
            while(resultado.next()){
                lista.add(
                        new CochePrueba(
                                resultado.getString("marca"),
                                resultado.getString("modelo"),
                                resultado.getString("color"),
                                resultado.getInt("precioBase")


                        )
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



}
