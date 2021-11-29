package SistemaAgil_IS2.service;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestConexion {

    Connection con;
    String user = "root";
<<<<<<< HEAD
    String pass = "454234798";
    String url = "jdbc:mysql://localhost:3306/db_ingsofdos";
=======
    String pass = "";
    String url = "jdbc:mysql://localhost:3306/db_ingsofdos?serverTimezone=UTC";
>>>>>>> af6bf83b5dfb331cfe706c16ab1584f001096163

    public TestConexion() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url, user, pass);
        } catch (Exception e) {
        }
    }

    public Connection getConnection() {
        return con;
    }

}