
package SistemaAgil_IS2.model;


public class ProjectBacklog {
    private Integer id_project;
    private Integer id_backlog;

    public ProjectBacklog() {
    }

    public ProjectBacklog(Integer id_project, Integer id_backlog) {
        this.id_project = id_project;
        this.id_backlog = id_backlog;
    }

    public Integer getId_project() {
        return id_project;
    }

    public void setId_project(Integer id_project) {
        this.id_project = id_project;
    }

    public Integer getId_backlog() {
        return id_backlog;
    }

    public void setId_backlog(Integer id_backlog) {
        this.id_backlog = id_backlog;
    }
    
    
}
