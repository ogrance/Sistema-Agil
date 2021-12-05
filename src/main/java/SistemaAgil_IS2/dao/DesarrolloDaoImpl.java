package SistemaAgil_IS2.dao;

import SistemaAgil_IS2.model.Backlog;
import SistemaAgil_IS2.model.Sprint;
import SistemaAgil_IS2.model.UserStorie;
import SistemaAgil_IS2.service.TestConexion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Repository
public class DesarrolloDaoImpl implements DesarrolloDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private DataSource datasource;

    TestConexion cn = new TestConexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    UserStorie ustorie = new UserStorie();
    Backlog backl = new Backlog();
    Sprint sprt = new Sprint();

    private static final String OBTENER_SPRINTS_DISPONIBLES = "select s.id_sprint, s.project_id,p.project_name ,s.name,s.duration,s.estatus from db_ingsofdos.sprints s "
            + "join db_ingsofdos.projects p on s.project_id =p.id where s.estatus = 'TO-DO'";
    private static final String ACTUALIZAR_ESTADO_SPRINT_INICIO = "update db_ingsofdos.sprints set estatus='DOING' where id_sprint=?";
    private static final String OBTENER_USER_STORIES_POR_ESTADOS = "select t1.id_us,t1.descripcion,t1.estatus,t1.project_id,t2.project_name from user_stories t1 join projects t2 on t1.project_id=t2.id \n"
            + "join sprints t3 on t2.id=t3.project_id where t3.project_id =? and t3.id_sprint=?";
    private static final String ACTUALIZAR_ESTADO_US = "UPDATE user_stories set estatus=? where id_us =?";

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
        String sql = "insert into user_stories(descripcion,backlog_id,project_id) values('" + us.getDescripcion() + "'," + us.getProject_id() + ", (select project_id from backlogs where id_backlog=" + us.getProject_id() + "))";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return true;
        }
        return false;
    }

    @Override
    public Boolean edit(UserStorie us) {
        String sql = "update user_stories set descripcion='" + us.getDescripcion() + "',  backlog_id=" + us.getProject_id() + ",project_id=(select project_id from backlogs where id_backlog=" + us.getProject_id() + ") where id_us=" + us.getId_us();
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

    @Override
    public List<Sprint> mostrarSprintsDisponibles() throws Exception {
        return jdbcTemplate.query(OBTENER_SPRINTS_DISPONIBLES, new SprintRowMapper());
    }

    @Override
    public void actualizarSprintInicio(Integer sprintId) throws Exception {
        jdbcTemplate.update(ACTUALIZAR_ESTADO_SPRINT_INICIO, sprintId);
    }

    @Override
    public List<UserStorie> obtenerUserStoriesPorProyecto(Integer idProyecto, Integer idSprint) throws Exception {
        return jdbcTemplate.query(OBTENER_USER_STORIES_POR_ESTADOS, new Object[]{idProyecto, idSprint}, new UserStorieRowMapper());
    }

    @Override
    public void actualizarEstadoUS(String estado, Integer idUs) throws Exception {
        jdbcTemplate.update(ACTUALIZAR_ESTADO_US, estado, idUs);
    }

    private class UserStorieRowMapper implements RowMapper<UserStorie> {

        @Override
        public UserStorie mapRow(ResultSet rs, int i) throws SQLException {

            try {
                UserStorie us = new UserStorie();
                us.setId_us(rs.getInt(1));
                us.setDescripcion(rs.getString(2));
                us.setEstatus(rs.getString(3));
                us.setProject_id(rs.getInt(4));
                us.setNombreProyecto(rs.getString(5));
                return us;
            } catch (SQLException s) {
                s.printStackTrace();
                return null;
            }

        }
    }

    private class SprintRowMapper implements RowMapper<Sprint> {

        @Override
        public Sprint mapRow(ResultSet rs, int i) throws SQLException {
            Sprint sprint = new Sprint();
            sprint.setId_sprint(rs.getInt(1));
            sprint.setProject_id(rs.getInt(2));
            sprint.setNombreProyecto(rs.getString(3));
            sprint.setName(rs.getString(4));
            sprint.setDuration(rs.getString(5));
            sprint.setEstatus(rs.getString(6));
            return sprint;
        }
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
        String sql = "insert into backlogs(nombre,project_id) values('" + b.getNombre() + "','" + b.getProject_id() + "')";
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
        String sql = "update backlogs set nombre='" + b.getNombre() + "' , project_id=" + b.getProject_id() + " where id_backlog=" + b.getId_backlog();
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
    public List listars(int val) {
        List<Sprint> list = new ArrayList<>();
        String sql;
        if (val == 1) {
            sql = "select * from sprints where estatus <> 'DONE'";
        }else if (val == 2){
            sql = "select * from sprints where estatus = 'DONE'";
        } 
        else {
            sql = "select * from sprints";
        }
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
        String sql = "insert into sprints(name,project_id, duration, estatus) values('" + s.getName() + "', " + s.getProject_id() + ", '" + s.getDuration() + "', '" + s.getEstatus() + "')";
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
        String sql = "update sprints set name='" + s.getName() + "' , project_id=" + s.getProject_id() + ", estatus = '" + s.getEstatus() + "', duration= '" + s.getDuration() + "' where id_sprint=" + s.getId_sprint();
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
        String sql = "select * from user_stories where sprint_id =" + id;
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
        String sql = "update user_stories set sprint_id=" + us.getSprint_id() + " where id_us=" + us.getId_us();
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
            return true;
        }
        return false;
    }

//SECCION LISTAR EN KANBAN
    @Override
    public List listarToDo(int id) {
        List<UserStorie> list = new ArrayList<>();
        String sql = "select * from user_stories where estatus = 'TO-DO' and sprint_id = " + id;
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
                u.setSprint_id(rs.getInt("sprint_id"));
                list.add(u);
            }
        } catch (Exception e) {
        }
        return list;
    }

    @Override
    public List listarDoing(int id) {
        List<UserStorie> list = new ArrayList<>();
        String sql = "select * from user_stories where estatus = 'DOING' and sprint_id = " + id;
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
                u.setSprint_id(rs.getInt("sprint_id"));
                list.add(u);
            }
        } catch (Exception e) {
        }
        return list;
    }

    @Override
    public List listarDone(int id) {
        List<UserStorie> list = new ArrayList<>();
        String sql = "select * from user_stories where estatus = 'DONE'and sprint_id = " + id;
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
                u.setSprint_id(rs.getInt("sprint_id"));
                list.add(u);
            }
        } catch (Exception e) {
        }
        return list;
    }

    @Override
    public Boolean editstatus(UserStorie us) {
        String sql = "update user_stories set estatus='" + us.getEstatus() + "' where id_us=" + us.getId_us();
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
    public Boolean finalizarSprint(Sprint s) {
        String sql = "update sprints set estatus='DONE' where id_sprint=" + s.getId_sprint();
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
