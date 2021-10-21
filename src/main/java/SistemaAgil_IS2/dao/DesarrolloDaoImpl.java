
package SistemaAgil_IS2.dao;

import SistemaAgil_IS2.model.Backlog;
import SistemaAgil_IS2.model.Sprint;
import SistemaAgil_IS2.model.UserStorie;
import SistemaAgil_IS2.service.TestConexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;


public class DesarrolloDaoImpl implements DesarrolloDao{
    
    TestConexion cn = new TestConexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    UserStorie ustorie = new UserStorie();
    Backlog backl = new Backlog();
    Sprint sprt = new Sprint();

//SECCION USER STORIES *SECCION USER STORIES *SECCION USER STORIES *SECCION USER STORIES *SECCION USER STORIES *    
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
                ustorie.setProject_id(rs.getInt("project_id"));
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

    
    
    
    
    
//SECCION BACKLOGS * SECCION BACKLOGS *SECCION BACKLOGS *SECCION BACKLOGS *SECCION BACKLOGS *SECCION BACKLOGS *
    
    
    
    
    
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

//SECCION SPRINTS *SECCION SPRINTS *SECCION SPRINTS *SECCION SPRINTS *SECCION SPRINTS *SECCION SPRINTS *SECCION SPRINTS *

    @Override
    public List listars() {
        List<Sprint> list = new ArrayList<>();
        String sql = "select * from sprints";
        try {
           con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Sprint s = new Sprint();
                s.setId_sprint(rs.getInt("id_sprint"));
                s.setProject_id(rs.getInt("project_id"));
                s.setName(rs.getString("name"));
                s.setDuration(rs.getString("duration"));
                s.setEstatus(rs.getString("estatus"));
                list.add(s);
            }
        } catch (Exception e) {
        }
        return list;
    }

    @Override
    public Sprint lists(int id) {
        String sql = "select * from sprints where id_sprint=" + id;
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                sprt.setId_sprint(rs.getInt("id_sprint"));
                sprt.setProject_id(rs.getInt("project_id"));
                sprt.setName(rs.getString("name"));
                sprt.setDuration(rs.getString("duration"));
                sprt.setEstatus(rs.getString("estatus"));
                
            }
        } catch (Exception e) {
        }
        return sprt;
    }

    @Override
    public Boolean adds(Sprint s) {
        String sql = "insert into sprints(name,project_id, duration, estatus) values('" + s.getName()+ "', " + s.getProject_id()+ ", '" + s.getDuration() + "', '"+ s.getEstatus()+ "')";
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
    public Boolean edits(Sprint s) {
        String sql = "update sprints set name='" + s.getName()+ "' , project_id="+ s.getProject_id()+ ", estatus = '" + s.getEstatus() + "', duration= '"+ s.getDuration() +"' where id_sprint=" + s.getId_sprint();
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
    public List listarsus(int id) {
        List<UserStorie> list = new ArrayList<>();
        String sql = "select * from user_stories where sprint_id ="+ id ;
        try {
           con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                UserStorie us = new UserStorie();
                us.setId_us(rs.getInt("id_us"));
                us.setProject_id(rs.getInt("project_id"));
                us.setDescripcion(rs.getString("descripcion"));
                us.setBacklog_id(rs.getInt("backlog_id"));
                us.setEstatus(rs.getString("estatus"));
                list.add(us);
            }
        } catch (Exception e) {
        }
        return list;
    }

    @Override
    public Boolean updateSprintUS(UserStorie us) {
        String sql = "update user_stories set sprint_id=" + us.getSprint_id()+ " where id_us=" + us.getId_us();
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
