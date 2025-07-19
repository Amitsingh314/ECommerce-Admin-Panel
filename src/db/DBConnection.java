package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    static String URL = "jdbc:mysql://localhost:3306/ Ecommerce_admin_panel";
    static String USER = "root";
    static String PASS = "Amit@123";

    public static Connection getConnection(){
        Connection con=null;
        try{
            con =DriverManager.getConnection(URL,USER,PASS);
            System.out.println("Connected to database!");
        }catch (SQLException e){
            System.out.println("Connection failed: " + e.getMessage());
        }
        return con;
    }

}