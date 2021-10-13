
package SistemaAgil_IS2.dao;

import SistemaAgil_IS2.model.Backlog;
import SistemaAgil_IS2.model.UserStorie;
import SistemaAgil_IS2.service.TestConexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class DesarrolloDaoImpl implements DesarrolloDao{
    
    TestConexion cn = new TestConexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    UserStorie ustorie = new UserStorie();
    Backlog backl = new Backlog();

    @Override
    public List listar() {
        List<UserStorie> list = new ArrayList<>();
        String sql = "select * from user_stories";
        try {
           con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                UserStorie u = new UserStorie();
                u.setId_us(rs.getInt("id_us"));
                u.setBacklog_id(rs.getInt("backlog_id"));
                u.setProject_id(rs.getInt("project_id"));
                u.setDescripcion(rs.getString("descripcion"));
                u.setEstatus(rs.getString("estatus"));
                list.add(u);
            }
        } catch (Exception e) {
        }
        return list;
    }

    @Override
    public UserStorie list(int id) {
        String sql = "select * from user_stories where id_us=" + id;
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                ustorie.setId_us(rs.getInt("id_us"));
                ustorie.setDescripcion(rs.getString("descripcion"));
            }
        } catch (Exception e) {
        }
        return ustorie;

    }

    @Override
    public Boolean add(UserStorie us) {
        String sql = "insert into user_stories(descripcion,project_id,backlog_id) values('" + us.getDescripcion() + "'," + us.getProject_id()+ ", (select id_backlog from backlogs where project_id="+ us.getProject_id() +"))";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
            return true;
        }
        return false;
    }

    @Override
    public Boolean edit(UserStorie us) {
        String sql = "update user_stories set descripcion='" + us.getDescripcion()  + "', project_id="  + us.getProject_id() + ", backlog_id=(select id_backlog from backlogs where project_id=" + us.getProject_id() + ") where id_us=" + us.getId_us();
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
            return true;
        }
        return false;
    }

    @Override
    public Boolean eliminar(int id) {
         String sql = "delete from user_stories where id_us=" + id;
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return false;
    }

    
    
    
    
    
//DIVISION DIVISION DIVISION DIVISION DIVISION DIVISION DIVISION DIVISION DIVISION DIVISION DIVISION DIVISION DIVISION DIVISION
    
    
    
    
    
    @Override
    public List listarb() {
        List<Backlog> list = new ArrayList<>();
        String sql = "select * from backlogs";
        try {
           con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Backlog b = new Backlog();
                b.setId_backlog(rs.getInt("id_backlog"));
                b.setProject_id(rs.getInt("project_id"));
                b.setNombre(rs.getString("nombre"));
                list.add(b);
            }
        } catch (Exception e) {
        }
        return list;
    }

    @Override
    public Backlog listb(int id) {
        String sql = "select * from backlogs where id_backlog=" + id;
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                backl.setId_backlog(rs.getInt("id_backlog"));
                backl.setProject_id(rs.getInt("project_id"));
                backl.setNombre(rs.getString("nombre"));
            }
        } catch (Exception e) {
        }
        return backl;
    }

    @Override
   public Boolean addb(Backlog b) {
        String sql = "insert into backlogs(nombre,project_id) values('" + b.getNombre()+ "','" + b.getProject_id()+ "')";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
            return true;
        }
        return false;
    }

    @Override
    public Boolean editb(Backlog b) {
       String sql = "update backlogs set nombre='" + b.getNombre()+ "' , project_id="+ b.getProject_id()  +" where id_backlog=" + b.getId_backlog();
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
            return true;
        }
        return false;

    }

    
}
