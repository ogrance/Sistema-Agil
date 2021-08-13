
package SistemaAgil_IS2.dao;

import SistemaAgil_IS2.model.Role;
import java.util.List;


public interface RoleDao {
    public List listar();
    public Role list(int id);
    public Boolean add(Role rol);
    public Boolean edit(Role rol);
    public Boolean eliminar(int id);
}
