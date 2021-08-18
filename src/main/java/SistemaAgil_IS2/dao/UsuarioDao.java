package SistemaAgil_IS2.dao;

import SistemaAgil_IS2.model.Roles;
import SistemaAgil_IS2.model.RolesDetalle;
import SistemaAgil_IS2.model.Usuario;
import SistemaAgil_IS2.model.UsuarioRol;

import java.util.List;

public interface UsuarioDao {

    public Usuario validarIngreso(Usuario usuario) throws Exception;
    public List<Usuario> obtenerUsuarios() throws Exception;
    public Usuario obtenerUsuarioPorId(Integer id) throws Exception;
    public void insertarUsuarioBD (Usuario usuario) throws Exception;
    public  void actualizarUsuario(Usuario usuario) throws Exception;
    public List<Roles> obtenerRolesDao() throws Exception;
    public void insertaRolesAsignados(Integer usuarioID, Integer idRole) throws Exception;
    public List<RolesDetalle> obtenerUsuarioYRol(Integer idUsuario) throws Exception;

}
