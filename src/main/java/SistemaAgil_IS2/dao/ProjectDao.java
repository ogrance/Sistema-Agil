
package SistemaAgil_IS2.dao;

import SistemaAgil_IS2.model.Project;
import SistemaAgil_IS2.model.ProjectMember;
import java.util.List;


public interface ProjectDao {
    public List listar();
    public Project list(int id);
    public Boolean add(Project rol);
    public String add(ProjectMember miembro);
    public Boolean edit(Project rol);
    public Boolean eliminar(int id);
}
