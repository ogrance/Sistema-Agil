package SistemaAgil_IS2_war.dao;


import SistemaAgil_IS2_war.model.*;
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
 private static final String OBTENER_ROL_POR_ID="SELECT * FROM roles where id_role=?";
 private static final String INSERTAR_ROL="INSERT INTO roles (descripcion) VALUES (?)";
 private static final String ELIMINAR_ROL="DELETE FROM roles WHERE id_role=?";
 private static final String ACTUALIZAR_ROL="UPDATE roles SET descripcion=? WHERE id_role=?";
 private static final String INSERTAR_PERMISO="INSERT INTO permissions (perm_name,scope) VALUES (?,?)";
 private static final String ELIMINAR_PERMISO="DELETE FROM permissions WHERE id_perm=?";
 private static final String ACTUALIZAR_PERMISO="UPDATE permissions SET perm_name=?,scope=? WHERE id_perm=?";
 private static final String OBTENER_PERMISOS="SELECT * FROM permissions";
 private static final String OBTENER_PERMISOS_POR_ID="SELECT * FROM permissions WHERE id_perm=?";
 private static final String ASIGNAR_PERMISOS="INSERT INTO roles_permission (id_role,perm_id) VALUES (?,?)";
 private static final String OBTENER_LISTA_PERMISOS_ROLES="SELECT p.perm_name,p.scope,p.id_perm,r.id_role,r.descripcion FROM permissions p " +
                            "JOIN roles_permission rp ON p.id_perm=rp.perm_id JOIN roles r ON r.id_role=rp.id_role WHERE p.id_perm=?";
    private static final String ELIMINAR_PERMISO_ROL="DELETE FROM roles_permission WHERE id_role=? and perm_id=?";
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

    @Override
    public Roles obtenerRolPorId(Integer idRol) throws Exception {
        return jdbcTemplate.queryForObject(OBTENER_ROL_POR_ID, new RolesRowMapper(),idRol);
    }

    @Override
    public void insertarRol(Roles roles) throws Exception {

        if(roles.getIdRole()==null){
            jdbcTemplate.update(INSERTAR_ROL, new Object[]{roles.getDescripcion()});
        }else{
            actualizarRol(roles);
        }
    }

    @Override
    public void eliminarRol(Integer idRol) throws Exception {
        jdbcTemplate.update(ELIMINAR_ROL, new Object[]{idRol});
    }

    @Override
    public void actualizarRol(Roles roles) throws Exception {
        jdbcTemplate.update(ACTUALIZAR_ROL, new Object[]{roles.getDescripcion(),roles.getIdRole()});
    }

    @Override
    public void insertarPermiso(Permisos permiso) throws Exception {
        if(permiso.getIdPermiso()==null){
            jdbcTemplate.update(INSERTAR_PERMISO, new Object[]{permiso.getNombrePermiso(),permiso.getAlcance()});
        }else{
            actualizarPermiso(permiso);
        }

    }

    @Override
    public void eliminarPermiso(Integer idPermiso) throws Exception {
        jdbcTemplate.update(ELIMINAR_PERMISO, new Object[]{idPermiso});
    }

    @Override
    public void actualizarPermiso(Permisos permiso) throws Exception {
        jdbcTemplate.update(ACTUALIZAR_PERMISO, new Object[]{permiso.getNombrePermiso(),permiso.getAlcance(),permiso.getIdPermiso()});
    }

    @Override
    public List<Permisos> obtenerPermisos() throws Exception {
        return jdbcTemplate.query(OBTENER_PERMISOS, new PermisosRowMapper());
    }

    @Override
    public Permisos obtenerPermisoPorId(Integer idPermiso) throws Exception {
        return jdbcTemplate.queryForObject(OBTENER_PERMISOS_POR_ID, new PermisosRowMapper(),idPermiso);
    }
    @Override
    public void insertaPermisosAsignados(Integer idRole, Integer idPermiso ) throws Exception {
        jdbcTemplate.update(ASIGNAR_PERMISOS, new Object[]{idRole,idPermiso});
    }

    @Override
    public List<PermisosDetalle> obtenerListaPermisosAsignados(Integer idPermiso) throws Exception {
        return jdbcTemplate.query(OBTENER_LISTA_PERMISOS_ROLES,new PermisosAsignadosRowMapper(),idPermiso);
    }

    @Override
    public void eliminarAsignacionPermiso(Integer idRole, Integer idPermiso) throws Exception {
        jdbcTemplate.update(ELIMINAR_PERMISO_ROL, new Object[]{idRole,idPermiso});
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
    private class PermisosRowMapper implements RowMapper<Permisos>{

        @Override
        public Permisos mapRow(ResultSet rs, int i) throws SQLException {
            Permisos permiso=new Permisos();
            permiso.setIdPermiso(rs.getInt("id_perm"));
            permiso.setNombrePermiso(rs.getString("perm_name"));
            permiso.setAlcance(rs.getString("scope"));
            return permiso;
        }
    }
    private class PermisosAsignadosRowMapper implements RowMapper<PermisosDetalle>{

        @Override
        public PermisosDetalle mapRow(ResultSet rs, int i) throws SQLException {
            PermisosDetalle pd=new PermisosDetalle();
            Roles r=new Roles();
            Permisos p=new Permisos();
            p.setNombrePermiso(rs.getString(1));
            p.setAlcance(rs.getString(2));
            p.setIdPermiso(rs.getInt(3));
            r.setIdRole(rs.getInt(4));
            r.setDescripcion(rs.getString(5));
            pd.setPermiso(p);
            pd.setRoles(r);
            return pd;
        }
    }

}
