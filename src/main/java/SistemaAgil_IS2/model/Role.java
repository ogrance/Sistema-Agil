package SistemaAgil_IS2.model;


public class Role {
    private int idRole;
    private String descripcion;

    public Role() {
    }

    public Role(int idRole, String descripcion) {
        this.idRole = idRole;
        this.descripcion = descripcion;
    }

    public int getIdRole() {
        return idRole;
    }

    public void setIdRole(int idRole) {
        this.idRole = idRole;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    
}
