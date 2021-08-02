package SistemaAgil_IS2.dao;

import SistemaAgil_IS2.model.Usuario;

public interface UsuarioDao {

    public Usuario validarIngreso(Usuario usuario) throws Exception;

}
