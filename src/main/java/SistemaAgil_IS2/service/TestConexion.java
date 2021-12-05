package SistemaAgil_IS2.service;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestConexion {

    Connection con;
    String user = "root";

    String pass = "7neVkPepTt";
    String url = "jdbc:mysql://node6239-env-6654381.dal.togglebox.site:3306/db_ingsofdos?serverTimezone=UTC";


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