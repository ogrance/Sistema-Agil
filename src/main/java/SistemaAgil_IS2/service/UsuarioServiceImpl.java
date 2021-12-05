package SistemaAgil_IS2_war.service;

import SistemaAgil_IS2_war.dao.UsuarioDao;
import SistemaAgil_IS2_war.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService {
@Autowired
private UsuarioDao usuarioDao;
    @Override
    public Usuario validarUsuario(Usuario usuario) throws Exception {
        Usuario user= usuarioDao.validarIngreso(usuario);
      return user;

    }

    @Override
    public List<Usuario> obtenerListaUsuarios() throws Exception {
        List<Usuario> retorno=usuarioDao.obtenerUsuarios();

        return retorno;
    }

    @Override
    public Usuario obtenerUsuarioPorId(Integer id) throws Exception {
        return usuarioDao.obtenerUsuarioPorId(id);
    }

    @Override
    public void insertarUsuario(Usuario usuario) throws Exception {
        usuarioDao.insertarUsuarioBD(usuario);
    }

    @Override
    public void eliminarUsuario(Integer idUsuario) throws Exception {
        usuarioDao.eliminarUsuario(idUsuario);
    }

    @Override
    public List<Roles> obtenerRoles() throws Exception {
       List<Roles> ret=usuarioDao.obtenerRolesDao();
        return ret;
    }

    @Override
    public void asignarRol(Integer usuarioID, Integer idRole) throws Exception {
        usuarioDao.insertaRolesAsignados(usuarioID,idRole);
    }

    @Override
    public List<RolesDetalle> obtenerUsuarioYRol(Integer idUsuario) throws Exception {
        return usuarioDao.obtenerUsuarioYRol(idUsuario);
    }

    @Override
    public void eliminarUsuarioRol(UsuarioRol usuarioRol) throws Exception {
        usuarioDao.eliminarAsignacionRol(usuarioRol);
    }

    @Override
    public void insertarRol(Roles roles) throws Exception {
        usuarioDao.insertarRol(roles);
    }

    @Override
    public void eliminarRol(Integer idRol) throws Exception {
        usuarioDao.eliminarRol(idRol);
    }

    @Override
    public void actualizarRol(Roles roles) throws Exception {
        usuarioDao.actualizarRol(roles);
    }

    @Override
    public void insertarPermiso(Permisos permiso) throws Exception {
        usuarioDao.insertarPermiso(permiso);
    }

    @Override
    public void eliminarPermiso(Integer idPermiso) throws Exception {
        usuarioDao.eliminarPermiso(idPermiso);
    }

    @Override
    public void actualizarPermiso(Permisos permiso) throws Exception {
        usuarioDao.actualizarPermiso(permiso);
    }

    @Override
    public Roles obtenerRolPorId(Integer idRol) throws Exception {
       return usuarioDao.obtenerRolPorId(idRol);
    }

    @Override
    public List<Permisos> obtenerPermisos() throws Exception {
        return usuarioDao.obtenerPermisos();
    }

    @Override
    public Permisos obtenerPermisoPorId(Integer idPermiso) throws Exception {
        return usuarioDao.obtenerPermisoPorId(idPermiso);
    }

    @Override
    public void insertaPermisosAsignados(Integer idRole, Integer idPermiso) throws Exception {
        usuarioDao.insertaPermisosAsignados(idRole, idPermiso);
    }

    @Override
    public List<PermisosDetalle> obtenerListaPermisosAsignados(Integer idPermiso) throws Exception {
        return usuarioDao.obtenerListaPermisosAsignados(idPermiso);
    }

    @Override
    public void eliminarAsignacionPermiso(Integer idRole, Integer idPermiso) throws Exception {
        usuarioDao.eliminarAsignacionPermiso(idRole,idPermiso);
    }

}
