
package SistemaAgil_IS2_war.model;


import java.util.ArrayList;

public class UserStorie {
    private Integer id_us;
    private Integer backlog_id;
    private Integer project_id;
    private String descripcion;
    private String estatus;
    private Integer sprint_id;
    private String nombreProyecto;

    public UserStorie() {
    }

    public UserStorie(Integer id_us, Integer backlog_id, Integer project_id, String descripcion, String estatus, Integer sprint_id) {
        this.id_us = id_us;
        this.backlog_id = backlog_id;
        this.project_id = project_id;
        this.descripcion = descripcion;
        this.estatus = estatus;
        this.sprint_id = sprint_id;
    }

    public Integer getSprint_id() {
        return sprint_id;
    }

    public void setSprint_id(Integer sprint_id) {
        this.sprint_id = sprint_id;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    public Integer getId_us() {
        return id_us;
    }

    public void setId_us(Integer id_us) {
        this.id_us = id_us;
    }

    public Integer getBacklog_id() {
        return backlog_id;
    }

    public void setBacklog_id(Integer backlog_id) {
        this.backlog_id = backlog_id;
    }

    public Integer getProject_id() {
        return project_id;
    }

    public void setProject_id(Integer project_id) {
        this.project_id = project_id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getNombreProyecto() {
        return nombreProyecto;
    }

    public void setNombreProyecto(String nombreProyecto) {
        this.nombreProyecto = nombreProyecto;
    }
}
