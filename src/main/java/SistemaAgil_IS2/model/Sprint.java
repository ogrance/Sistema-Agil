
package SistemaAgil_IS2_war.model;

public class Sprint {
    private Integer id_sprint;
    private Integer project_id;
    private String name;
    private String duration;
    private String estatus;
    private String nombreProyecto;

    public Sprint() {
    }

    public Sprint(Integer id_sprint, Integer project_id, String name, String duration, String estatus) {
        this.id_sprint = id_sprint;
        this.project_id = project_id;
        this.name = name;
        this.duration = duration;
        this.estatus = estatus;
    }

    public Integer getId_sprint() {
        return id_sprint;
    }

    public void setId_sprint(Integer id_sprint) {
        this.id_sprint = id_sprint;
    }

    public Integer getProject_id() {
        return project_id;
    }

    public void setProject_id(Integer project_id) {
        this.project_id = project_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    public String getNombreProyecto() {
        return nombreProyecto;
    }

    public void setNombreProyecto(String nombreProyecto) {
        this.nombreProyecto = nombreProyecto;
    }
}
