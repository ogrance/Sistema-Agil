package SistemaAgil_IS2.service;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestConexion {

    Connection con;
    String user = "root";
    String pass = "454234798";
    String url = "jdbc:mysql://localhost:3306/db_ingsofdos";

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