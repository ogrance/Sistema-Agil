package SistemaAgil_IS2.service;


import SistemaAgil_IS2.model.Roles;
import SistemaAgil_IS2.model.RolesDetalle;
import SistemaAgil_IS2.model.Usuario;
import SistemaAgil_IS2.model.UsuarioRol;

import java.util.List;

public interface UsuarioService {

    public Usuario validarUsuario(Usuario usuario) throws Exception;
    public List<Usuario> obtenerListaUsuarios() throws Exception;
    public Usuario obtenerUsuarioPorId(Integer id) throws Exception;
    public void insertarUsuario(Usuario usuario) throws Exception;
    public List<Roles> obtenerRoles() throws Exception;
    public void asignarRol(Integer usuarioID, Integer idRole) throws Exception;
    public List<RolesDetalle> obtenerUsuarioYRol(Integer idUsuario) throws Exception;
}
