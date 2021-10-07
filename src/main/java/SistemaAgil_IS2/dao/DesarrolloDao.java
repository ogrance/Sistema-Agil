
package SistemaAgil_IS2.dao;


import SistemaAgil_IS2.model.Backlog;
import SistemaAgil_IS2.model.ProjectBacklog;
import SistemaAgil_IS2.model.UsBacklog;
import SistemaAgil_IS2.model.UserStorie;
import java.util.List;


public interface DesarrolloDao {
    public List listar();
    public List listarb();
    
    public UserStorie list(int id);
    public Backlog listb(int id);
    
    public Boolean add(UserStorie us);
    public Boolean addb(Backlog b);
    public String addpb(ProjectBacklog pb);
    public String addub(UsBacklog ub);
    
    public Boolean edit(UserStorie us);
    public Boolean editb(Backlog b);
    
    public Boolean eliminar(int id);
}
