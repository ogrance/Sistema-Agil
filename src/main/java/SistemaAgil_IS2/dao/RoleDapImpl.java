
package SistemaAgil_IS2.dao;

import SistemaAgil_IS2.model.Role;
import SistemaAgil_IS2.service.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class RoleDapImpl implements RoleDao{
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Role rol=new Role();
    
    @Override
    public List listar() {
        List<Role> list = new ArrayList<>();
        String sql = "select * from roles";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Role r = new Role();
                r.setIdRole(rs.getInt("id_role"));
                r.setDescripcion(rs.getString("descripcion"));
                list.add(r);
            }
        } catch (Exception e) {
        }
        return list;
    }

    @Override
    public Role list(int id) {
        String sql = "select * from roles where id_role="+id;
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                rol.setIdRole(rs.getInt("id_role"));
                rol.setDescripcion(rs.getString("descripcion"));
            }
        } catch (Exception e) {
        }
        return rol;
    }

    @Override
    public Boolean add(Role rol) {
        String sql="insert into roles(descripcion) values ('"+ rol.getDescripcion() +"')";
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return false;
    }

    @Override
    public Boolean edit(Role rol) {
        String sql="update roles set descripcion='"+ rol.getDescripcion()+"' where id_role="+rol.getIdRole();
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return false;
    }

    @Override
    public Boolean eliminar(int id) {
        String sql="delete from roles where id_role="+id;
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return false;
    }
    }

