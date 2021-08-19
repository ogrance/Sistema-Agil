package SistemaAgil_IS2.dao;


import SistemaAgil_IS2.model.Roles;
import SistemaAgil_IS2.model.RolesDetalle;
import SistemaAgil_IS2.model.Usuario;
import SistemaAgil_IS2.model.UsuarioRol;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class UsuarioDaoImpl implements UsuarioDao {
 @Autowired
 private   JdbcTemplate jdbcTemplate;
 @Autowired
 private DataSource datasource;

 private static final String OBTENER_USUARIO="SELECT * FROM usuario WHERE nombreUsuario = ? AND passwrd = ?"; //se cambiaron el nombre de la tabla y sus columnas a recuparar, de acuerdo a tu configuracion interna cambiarla acordemente
 private static  final String OBTENER_USUARIOS="SELECT * FROM usuario";
 private static final String OBTENER_USUARIO_POR_ID="SELECT * FROM usuario WHERE idUsuario=?";
 private static final String INSERTAR_USUARIO="INSERT INTO usuario (nombreUsuario,nombre,apellido,passwrd) VALUES (?,?,?,?)";
 private static final String ACTUALIZAR_USUARIO="UPDATE usuario SET nombreUsuario=?,nombre=?,apellido=?,passwrd=? WHERE idUsuario=?";
 private static final String OBTENER_ROLES="SELECT * FROM roles";
 private static final String ASIGNAR_ROLES="INSERT INTO user_role (user_id,role_id) VALUES (?,?)";
 private static final String OBTENER_USUARIO_Y_ROL="SELECT * FROM user_role";
 private static final String OBTENER_LISTA_ROLES_POR_USUARIO="SELECT u.nombreUsuario, u.nombre,u.apellido,u.idUsuario,r.id_role,r.descripcion FROM usuario u JOIN user_role ur ON u.idUsuario=ur.user_id " +
                                                             "JOIN roles r ON ur.role_id=r.id_role WHERE u.idUsuario=?";
 private static final String ELIMINAR_USUARIO_ROL="DELETE FROM user_role WHERE user_id=? and role_id=?";
 private static final String ELIMINAR_USUARIO="DELETE FROM usuario WHERE idUsuario=?";
    @Override
    public Usuario validarIngreso(Usuario usuario) throws Exception {
        List<Usuario> user=jdbcTemplate.query(OBTENER_USUARIO, new UsuarioRowMapper(),usuario.getNombreUsuario(),usuario.getPasswrd());
        return user.size()>0?user.get(0):null;
    }

    @Override
    public List<Usuario> obtenerUsuarios() throws Exception {
        List<Usuario> retUsuer=jdbcTemplate.query(OBTENER_USUARIOS, new UsuarioRowMapper());
        return retUsuer;
    }

    @Override
    public Usuario obtenerUsuarioPorId(Integer id) throws Exception {
        Usuario usuario=jdbcTemplate.queryForObject(OBTENER_USUARIO_POR_ID, new UsuarioRowMapper(),id);
        return usuario;
    }

    @Override
    public void insertarUsuarioBD(Usuario usuario) throws Exception {
        if(usuario.getIdUsuario()==null){
            jdbcTemplate.update(INSERTAR_USUARIO, new Object[]{usuario.getNombreUsuario(),usuario.getNombre(),usuario.getApellido(),usuario.getPasswrd()});
        }else{
            actualizarUsuario(usuario);
        }

    }
    @Override
    public  void actualizarUsuario(Usuario usuario) throws Exception{
        jdbcTemplate.update(ACTUALIZAR_USUARIO, new Object[]{usuario.getNombreUsuario(),usuario.getNombre(),usuario.getApellido(),usuario.getPasswrd(),usuario.getIdUsuario()});
    }

    @Override
    public void eliminarUsuario(Integer usuarioId) throws Exception {
        jdbcTemplate.update(ELIMINAR_USUARIO, new Object[]{usuarioId});
    }

    @Override
    public List<Roles> obtenerRolesDao() throws Exception {
        return jdbcTemplate.query(OBTENER_ROLES, new RolesRowMapper());
    }

    @Override
    public void insertaRolesAsignados(Integer usuarioID, Integer idRole ) throws Exception {
        jdbcTemplate.update(ASIGNAR_ROLES, new Object[]{usuarioID,idRole});
    }

    @Override
    public List<RolesDetalle> obtenerUsuarioYRol(Integer idUsuario) throws Exception {

        return jdbcTemplate.query(OBTENER_LISTA_ROLES_POR_USUARIO, new UsuarioRolRowMapper(),idUsuario);
    }

    @Override
    public void eliminarAsignacionRol(UsuarioRol usuarioRol) throws Exception {
        jdbcTemplate.update(ELIMINAR_USUARIO_ROL, new Object[]{usuarioRol.getUsuarioId(),usuarioRol.getRoleId()});
    }

    private class UsuarioRowMapper implements RowMapper<Usuario>{


        @Override
        public Usuario mapRow(ResultSet rs, int i) throws SQLException {
            Usuario usuario = new Usuario();
            usuario.setIdUsuario(rs.getInt("idUsuario")); //se cambio el nombre de la columna, cambiarla de acuerdo a tu configuracion local
            usuario.setNombre(rs.getString("nombre"));
            usuario.setNombreUsuario(rs.getString("nombreUsuario"));//se cambio el nombre de la columna, cambiarla de acuerdo a tu configuracion local
            usuario.setPasswrd(rs.getString("passwrd"));
            usuario.setApellido(rs.getString("apellido"));
            usuario.setStatus(rs.getString("status"));
            return usuario;
        }
    }
    private class RolesRowMapper implements RowMapper<Roles>{

        @Override
        public Roles mapRow(ResultSet rs, int i) throws SQLException {
            Roles rol =new Roles();
            rol.setIdRole(rs.getInt("id_role"));
            rol.setDescripcion(rs.getString("descripcion"));
            return rol;
        }
    }
    private class UsuarioRolRowMapper implements RowMapper<RolesDetalle>{

        @Override
        public RolesDetalle mapRow(ResultSet rs, int i) throws SQLException {
            RolesDetalle usuarioRol=new RolesDetalle();
            Usuario usuario=new Usuario();
            usuario.setNombreUsuario(rs.getString(1));
            usuario.setNombre(rs.getString(2));
            usuario.setApellido(rs.getString(3));
            usuario.setIdUsuario(rs.getInt(4));
            Roles roles=new Roles();
            roles.setIdRole(rs.getInt(5));
            roles.setDescripcion(rs.getString(6));
            usuarioRol.setUser(usuario);
            usuarioRol.setRoles(roles);
            return usuarioRol;
        }
    }

}
