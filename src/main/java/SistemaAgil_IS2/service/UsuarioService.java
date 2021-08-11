package SistemaAgil_IS2.service;


import SistemaAgil_IS2.model.Usuario;

import java.util.List;

public interface UsuarioService {

    public Usuario validarUsuario(Usuario usuario) throws Exception;
    public List<Usuario> obtenerListaUsuarios() throws Exception;
}
