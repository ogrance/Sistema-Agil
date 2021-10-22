
package SistemaAgil_IS2.dao;


import SistemaAgil_IS2.model.Backlog;
import SistemaAgil_IS2.model.Sprint;
import SistemaAgil_IS2.model.UserStorie;
import java.util.List;


public interface DesarrolloDao {
    public List listar();
    public List listarb();
    public List listars();
    public List listarsus(int id);
    
    public UserStorie list(int id);
    public Backlog listb(int id);
    public Sprint lists(int id);
    
    public Boolean add(UserStorie us);
    public Boolean addb(Backlog b);
    public Boolean adds(Sprint s);
    
    public Boolean edit(UserStorie us);
    public Boolean editb(Backlog b);
    public Boolean edits(Sprint s);
    public Boolean updateSprintUS(UserStorie us);
    
    public Boolean eliminar(int id);
    List<Sprint> mostrarSprintsDisponibles() throws Exception;
    void actualizarSprintInicio(Integer sprintId) throws Exception;
}
