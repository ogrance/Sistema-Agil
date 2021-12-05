package SistemaAgil_IS2_war.service;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestConexion {

    Connection con;
    String user = "root";

    String pass = "";
    String url = "jdbc:mysql://localhost:3306/db_ingsofdos?serverTimezone=UTC";


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