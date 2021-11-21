package SistemaAgil_IS2.service;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestConexion {

    Connection con;
    String user = "root";
    String pass = "root";
    String url = "jdbc:mysql://node6140-env-9249604.dal.togglebox.site:3306/db_ingsofdos?serverTimezone=UTC";

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