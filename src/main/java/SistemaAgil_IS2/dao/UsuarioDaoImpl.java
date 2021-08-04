package SistemaAgil_IS2.dao;


import SistemaAgil_IS2.model.Usuario;
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

    @Override
    public Usuario validarIngreso(Usuario usuario) throws Exception {
        List<Usuario> user=jdbcTemplate.query(OBTENER_USUARIO, new UsuarioRowMapper(),usuario.getNombreUsuario(),usuario.getPasswrd());
        return user.size()>0?user.get(0):null;
    }

    private class UsuarioRowMapper implements RowMapper<Usuario>{


        @Override
        public Usuario mapRow(ResultSet rs, int i) throws SQLException {
            Usuario usuario = new Usuario();
            usuario.setIdUsuario(rs.getInt("idUsuario")); //se cambio el nombre de la columna, cambiarla de acuerdo a tu configuracion local
            usuario.setNombre(rs.getString("nombre"));
            usuario.setNombreUsuario(rs.getString("nombreUsuario"));//se cambio el nombre de la columna, cambiarla de acuerdo a tu configuracion local
            usuario.setPasswrd(rs.getString("passwrd"));
            return usuario;
        }
    }

}
