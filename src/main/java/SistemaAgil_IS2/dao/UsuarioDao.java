package SistemaAgil_IS2.dao;

import SistemaAgil_IS2.model.Usuario;
import java.util.List;

public interface UsuarioDao {

    public Usuario validarIngreso(Usuario usuario) throws Exception;
    
    //metodos de prueba CRUD
    public List listar();
    public Usuario list(int id);
    public Boolean add(Usuario user);
    public Boolean edit(Usuario user);
    public Boolean eliminar(int id);

}
