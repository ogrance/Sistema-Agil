
package SistemaAgil_IS2_war.model;


public class Backlog {
    private Integer id_backlog;
    private Integer project_id;
    private String nombre;

    public Backlog() {
    }

    public Backlog(Integer id_backlog, Integer project_id, String nombre) {
        this.id_backlog = id_backlog;
        this.project_id = project_id;
        this.nombre = nombre;
    }

    public Integer getId_backlog() {
        return id_backlog;
    }

    public void setId_backlog(Integer id_backlog) {
        this.id_backlog = id_backlog;
    }

    public Integer getProject_id() {
        return project_id;
    }

    public void setProject_id(Integer project_id) {
        this.project_id = project_id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    
 
    
    
}
