package SistemaAgil_IS2.dao;

import SistemaAgil_IS2.model.Project;
import SistemaAgil_IS2.model.ProjectMember;
import SistemaAgil_IS2.service.TestConexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProjectDaoImpl implements ProjectDao {

    TestConexion cn = new TestConexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Project proyecto = new Project();

    @Override
    public List listar() {
        List<Project> list = new ArrayList<>();
        String sql = "select * from projects";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Project p = new Project();
                p.setId(rs.getInt("id"));
                p.setProjectName(rs.getString("project_name"));
                p.setDescription(rs.getString("descripcion"));
                p.setStatus(rs.getString("estatus"));
                list.add(p);
            }
        } catch (Exception e) {
        }
        return list;
    }

    @Override
    public Project list(int id) {
        String sql = "select * from projects where id=" + id;
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                proyecto.setId(rs.getInt("id"));
                proyecto.setProjectName(rs.getString("project_name"));
                proyecto.setDescription(rs.getString("descripcion"));
                proyecto.setStatus(rs.getString("estatus"));
            }
        } catch (Exception e) {
        }
        return proyecto;
    }

    @Override
    public Boolean add(Project proyecto) {
        String sql = "insert into projects(project_name,descripcion,estatus) values('" + proyecto.getProjectName() + "','" + proyecto.getDescription() + "','" + proyecto.getStatus() + "')";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public String add(ProjectMember miembro) {
        String sql = "insert into project_members values(" + miembro.getId_proyecto() + "," + miembro.getId_user() + ")";
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
    public Boolean edit(Project proyecto) {
        String sql = "update projects set project_name='" + proyecto.getProjectName() + "', descripcion='" + proyecto.getDescription() + "', estatus='" + proyecto.getStatus() + "' where id=" + proyecto.getId();
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
        String sql = "delete from projects where id=" + id;
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return false;
    }

}
