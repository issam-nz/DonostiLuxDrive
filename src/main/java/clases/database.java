package clases;

import java.sql.Connection;
import java.sql.DriverManager;

public class database {
    public static Connection connectDb(){
        try{
            Connection connect = DriverManager.getConnection("jdbc:mysql://localhost/donostiluxdrive", "root", ""); // root is the default username while "" or empty is for the password
            return connect;
        }catch(Exception e){
            System.out.println("Database connection failed: " + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }
}
