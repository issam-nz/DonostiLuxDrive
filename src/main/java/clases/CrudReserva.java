package clases;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.ObservableList;

import java.sql.*;

public class CrudReserva {
    //Declaracion de variables
        IntegerProperty id;
        Crudcoche crudcoche;
        Date fechaIn;
        Date fechaFin;
        StringProperty nombreCliente;
        StringProperty apellidoCliente;
        StringProperty emailCliente;
        StringProperty telefonoCliente;
        IntegerProperty precioTotal;

    public CrudReserva(Integer id, Crudcoche crudcoche, Date fechaIn, Date fechaFin, String nombreCliente, String apellidoCliente, String emailCliente, String telefonoCliente, Integer precioTotal) {
        this.id = new SimpleIntegerProperty(id);
        this.crudcoche = crudcoche ;
        this.fechaIn = fechaIn;
        this.fechaFin = fechaFin;
        this.nombreCliente = new SimpleStringProperty(nombreCliente);
        this.apellidoCliente = new SimpleStringProperty(apellidoCliente);
        this.emailCliente = new SimpleStringProperty(emailCliente);
        this.telefonoCliente = new SimpleStringProperty(telefonoCliente);
        this.precioTotal = new SimpleIntegerProperty(id);
    }

    public static void llenarInformacionReservas(Connection connection, ObservableList<CrudReserva> listaReserva){
        try {
            Statement instruccion = connection.createStatement();
            ResultSet resultado = instruccion.executeQuery(
                    "SELECT A.id," +
                            " A.id_coche, " +
                            "A.fechaIn, " +
                            "A.fechaFin, " +
                            "A.nombreCliente, " +
                            "A.apellidoCliente, " +
                            "A.emailCliente, " +
                            "A.telefonoCliente, " +
                            "A.precioTotal " +
                            "FROM reservas A " +
                            "INNER JOIN coches B " +
                            "ON (A.id_coche = B.id) "

            );
            while(resultado.next()){
                listaReserva.add(
                        new CrudReserva(
                                resultado.getInt("id"),
                                new Crudcoche(
                                        resultado.getInt("id"),
                                        resultado.getString("marca"),
                                        resultado.getString("modelo"),
                                        resultado.getString("color"),
                                        resultado.getInt("precioBase")),
                                resultado.getDate("fechaIn"),
                                resultado.getDate("fechaFin"),
                                resultado.getString("nombre"),
                                resultado.getString("apellido"),
                                resultado.getString("email"),
                                resultado.getString("telefono"),
                                resultado.getInt("precio")

                        )
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

