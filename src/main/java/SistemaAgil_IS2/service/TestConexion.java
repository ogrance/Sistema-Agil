package SistemaAgil_IS2.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexion {


    public static void main(String[]args){
        String user = "root";
        String pass = "454234798"; /*OJO:LA CONTRASENHA DEPENDE DE LA CONTRASENHA QUE ASIGNARON AL ROOT AL INSTALAR!!*/
        String url = "jdbc:mysql://localhost:3306/db_ingsofdos"; /*OJO:SI CREASTE CON OTRO NOMNRE COLOCAR EL NOMBRE DE TU BD,!!*/
        Connection con;
        Statement stmt;
        ResultSet rs;
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            con = DriverManager.getConnection(url,user,pass);
            stmt = con.createStatement();
            rs = stmt.executeQuery("select * from usuario");
            rs.next();
            do {
                System.out.println(rs.getString("nombreUsuario")+" "+rs.getString("passwrd"));
            }while (rs.next());
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}