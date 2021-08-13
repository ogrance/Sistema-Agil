package SistemaAgil_IS2.service;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {

    Connection con;
    String user = "root";
    String pass = "454234798";
    String url = "jdbc:mysql://localhost:3306/db_ingsofdos";

    public Conexion() {
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

//Metodo que me funciona la clase Conexi
//package SistemaAgil_IS2.service;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//import org.springframework.jdbc.datasource.DriverManagerDataSource;
//
//public class Conexion {
//    public DriverManagerDataSource Conectar(){
//        DriverManagerDataSource datasource = new DriverManagerDataSource();
//        datasource.setDriverClassName("com.mysql.jdb.Driver");
//        datasource.setUrl("jdbc:mysql://localhost:3306/db_ingsofdos");
//        datasource.setUsername("root");
//        datasource.setPassword("454234798");
//        return datasource;
//    }
//
//
//
//    public static void main(String[]args){
//        String user = "root";
//        String pass = "454234798"; /*OJO:LA CONTRASENHA DEPENDE DE LA CONTRASENHA QUE ASIGNARON AL ROOT AL INSTALAR!!*/
//        String url = "jdbc:mysql://localhost:3306/db_ingsofdos"; /*OJO:SI CREASTE CON OTRO NOMNRE COLOCAR EL NOMBRE DE TU BD,!!*/
//        Connection con;
//        Statement stmt;
//        ResultSet rs;
//        
//        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
//        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(TestConexion.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        
//        try {
//            con = DriverManager.getConnection(url,user,pass);
//            stmt = con.createStatement();
//            rs = stmt.executeQuery("select * from usuario");
//            rs.next();
//            do {
//                System.out.println(rs.getString("nombreUsuario")+" "+rs.getString("passwrd"));
//            }while (rs.next());
//        } catch (SQLException ex) {
//            Logger.getLogger(TestConexion.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
//
//}
