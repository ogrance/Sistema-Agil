package SistemaAgil_IS2.service;


import SistemaAgil_IS2.model.*;

import java.util.List;

public interface UsuarioService {

    public List <RolesDetalle> validarUsuario(Usuario usuario) throws Exception;
    public List<Usuario> obtenerListaUsuarios() throws Exception;
    public Usuario obtenerUsuarioPorId(Integer id) throws Exception;
    public void insertarUsuario(Usuario usuario) throws Exception;
    public void eliminarUsuario(Integer idUsuario) throws Exception;
    public List<Roles> obtenerRoles() throws Exception;
    public void asignarRol(Integer usuarioID, Integer idRole) throws Exception;
    public List<RolesDetalle> obtenerUsuarioYRol(Integer idUsuario) throws Exception;
    public void eliminarUsuarioRol(UsuarioRol usuarioRol) throws Exception;
    public void insertarRol(Roles roles) throws Exception;
    public void eliminarRol(Integer idRol) throws Exception;
    public void actualizarRol(Roles roles) throws Exception;
    public void insertarPermiso(Permisos permiso) throws Exception;
    public void eliminarPermiso(Integer idPermiso) throws Exception;
    public void actualizarPermiso(Permisos permiso) throws Exception;
    public Roles obtenerRolPorId(Integer idRol) throws Exception;
    public List<Permisos> obtenerPermisos()throws Exception;
    public Permisos obtenerPermisoPorId(Integer idPermiso) throws Exception;
    public void insertaPermisosAsignados(Integer idRole, Integer idPermiso ) throws Exception;
    public List<PermisosDetalle> obtenerListaPermisosAsignados(Integer idPermiso) throws Exception;
    public void eliminarAsignacionPermiso(Integer idRole, Integer idPermiso) throws Exception;
}
