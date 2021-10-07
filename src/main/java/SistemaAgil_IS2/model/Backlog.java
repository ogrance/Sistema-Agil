
package SistemaAgil_IS2.model;


public class Backlog {
    private Integer id_backlog;
    private String nombre;
    private String comentario;

    public Backlog() {
    }

    public Backlog(Integer id_backlog, String nombre, String comentario) {
        this.id_backlog = id_backlog;
        this.nombre = nombre;
        this.comentario = comentario;
    }

    public Integer getId_backlog() {
        return id_backlog;
    }

    public void setId_backlog(Integer id_backlog) {
        this.id_backlog = id_backlog;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }
    
    
}
