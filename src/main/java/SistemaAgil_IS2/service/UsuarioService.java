package SistemaAgil_IS2.service;


import SistemaAgil_IS2.model.Usuario;

import java.util.List;

public interface UsuarioService {

    public Usuario validarUsuario(Usuario usuario) throws Exception;
    public List<Usuario> obtenerListaUsuarios() throws Exception;
    public Usuario obtenerUsuarioPorId(Integer id) throws Exception;
    public void insertarUsuario(Usuario usuario) throws Exception;
}
