
package SistemaAgil_IS2.dao;

import SistemaAgil_IS2.model.Backlog;
import SistemaAgil_IS2.model.ProjectBacklog;
import SistemaAgil_IS2.model.UsBacklog;
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
                ustorie.setEstatus(rs.getString("estatus"));
            }
        } catch (Exception e) {
        }
        return ustorie;

    }

    @Override
    public Boolean add(UserStorie us) {
        String sql = "insert into user_stories(descripcion,estatus) values('" + us.getDescripcion() + "','" + us.getEstatus() + "')";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return false;
    }

    @Override
    public Boolean edit(UserStorie us) {
        String sql = "update user_stories set descripcion='" + us.getDescripcion() + "', estatus='" + us.getEstatus() + "' where id_us=" + us.getId_us();
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
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
                b.setComentario(rs.getString("comentario"));
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
                backl.setNombre(rs.getString("nombre"));
                backl.setComentario(rs.getString("comentario"));
            }
        } catch (Exception e) {
        }
        return backl;
    }

    @Override
    public Boolean addb(Backlog b) {
        String sql = "insert into backlogs(nombre,comentario) values('" + b.getNombre()+ "','" + b.getComentario() + "')";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return false;
    }

    @Override
    public Boolean editb(Backlog b) {
       String sql = "update backlogs set comentario='" + b.getComentario() + "', nombre='" + b.getNombre() + "' where id_backlog=" + b.getId_backlog();
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return false;

    }

    @Override
    public String addpb(ProjectBacklog pb) {
        String sql = "insert into project_backlogs values(" + pb.getId_project() + "," + pb.getId_backlog() + ")";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (SQLException e) {
            return "errorexp";
        }
        return "success";
    }

    @Override
    public String addub(UsBacklog ub) {
        String sql = "insert into us_backlog values(" + ub.getId_Backl() + "," + ub.getId_Us() + ")";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (SQLException e) {
            return "errorexp";
        }
        return "success";
    }

    
}
