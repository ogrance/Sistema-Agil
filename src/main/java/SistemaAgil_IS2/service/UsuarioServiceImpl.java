package SistemaAgil_IS2.service;

import SistemaAgil_IS2.dao.UsuarioDao;
import SistemaAgil_IS2.model.Roles;
import SistemaAgil_IS2.model.RolesDetalle;
import SistemaAgil_IS2.model.Usuario;
import SistemaAgil_IS2.model.UsuarioRol;
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
        System.out.println("En Servicios "+ Arrays.asList(ret));
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

}
