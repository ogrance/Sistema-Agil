package SistemaAgil_IS2.service;

import SistemaAgil_IS2.dao.UsuarioDao;
import SistemaAgil_IS2.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
