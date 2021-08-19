package SistemaAgil_IS2.dao;

import SistemaAgil_IS2.model.*;

import java.util.List;

public interface UsuarioDao {

    public Usuario validarIngreso(Usuario usuario) throws Exception;
    public List<Usuario> obtenerUsuarios() throws Exception;
    public Usuario obtenerUsuarioPorId(Integer id) throws Exception;
    public void insertarUsuarioBD (Usuario usuario) throws Exception;
    public  void actualizarUsuario(Usuario usuario) throws Exception;
    public void eliminarUsuario(Integer usuarioId) throws  Exception;
    public List<Roles> obtenerRolesDao() throws Exception;
    public void insertaRolesAsignados(Integer usuarioID, Integer idRole) throws Exception;
    public List<RolesDetalle> obtenerUsuarioYRol(Integer idUsuario) throws Exception;
    public void eliminarAsignacionRol(UsuarioRol usuarioRol) throws Exception;
    public Roles obtenerRolPorId(Integer idRol) throws Exception;
    public void insertarRol(Roles roles) throws Exception;
    public void eliminarRol(Integer idRol) throws Exception;
    public void actualizarRol(Roles roles) throws Exception;
    public void insertarPermiso(Permisos permiso) throws Exception;
    public void eliminarPermiso(Integer idPermiso) throws Exception;
    public void actualizarPermiso(Permisos permiso) throws Exception;
}
