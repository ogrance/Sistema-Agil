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

 private static final String OBTENER_USUARIO="SELECT * FROM USUARIOS WHERE nombre_usuario = ? AND passwrd = ?";

    @Override
    public Usuario validarIngreso(Usuario usuario) throws Exception {
        List<Usuario> user=jdbcTemplate.query(OBTENER_USUARIO, new UsuarioRowMapper(),usuario.getNombreUsuario(),usuario.getPasswrd());
        return user.size()>0?user.get(0):null;
    }

    private class UsuarioRowMapper implements RowMapper<Usuario>{


        @Override
        public Usuario mapRow(ResultSet rs, int i) throws SQLException {
            Usuario usuario = new Usuario();
            usuario.setIdUsuario(rs.getInt("usuario_id"));
            usuario.setNombre(rs.getString("nombre"));
            usuario.setNombreUsuario(rs.getString("nombre_usuario"));
            usuario.setPasswrd(rs.getString("passwrd"));
            return usuario;
        }
    }

}
