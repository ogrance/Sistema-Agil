package SistemaAgil_IS2.dao;

import SistemaAgil_IS2.model.Usuario;

import java.util.List;

public interface UsuarioDao {

    public Usuario validarIngreso(Usuario usuario) throws Exception;
    public List<Usuario> obtenerUsuarios() throws Exception;

}
