
package SistemaAgil_IS2.model;


public class UserStorie {
    private Integer id_us;
    private String descripcion;
    private String estatus;

    public UserStorie() {
    }

    public UserStorie(Integer id_us, String descripcion, String estatus) {
        this.id_us = id_us;
        this.descripcion = descripcion;
        this.estatus = estatus;
    }

    public Integer getId_us() {
        return id_us;
    }

    public void setId_us(Integer id_us) {
        this.id_us = id_us;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }
    
    
}
