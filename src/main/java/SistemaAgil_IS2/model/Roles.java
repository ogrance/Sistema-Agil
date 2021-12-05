package SistemaAgil_IS2_war.model;

public class Roles {
    private Integer idRole;
    private String descripcion;
   // private Usuario user;
    public Roles() {
    }

    public Integer getIdRole() {
        return idRole;
    }

    public void setIdRole(Integer idRole) {
        this.idRole = idRole;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Roles{" +
                "idRole=" + idRole +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }
}
