package SistemaAgil_IS2.model;


public class Usuario {
    private int idUsuario;
    private String NombreUsuario;
    private String Nombre;
    private String Apellido;
    private String Passwrd;
    private String Status;

    public Usuario() {
    }

    
    public Usuario(int idUsuario, String NombreUsuario, String Nombre, String Apellido, String Passwrd, String Status) {
        this.idUsuario = idUsuario;
        this.NombreUsuario = NombreUsuario;
        this.Nombre = Nombre;
        this.Apellido = Apellido;
        this.Passwrd = Passwrd;
        this.Status = Status;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    

    public String getNombreUsuario() {
        return NombreUsuario;
    }

    public void setNombreUsuario(String NombreUsuario) {
        this.NombreUsuario = NombreUsuario;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }

    public String getPasswrd() {
        return Passwrd;
    }

    public void setPasswrd(String Passwrd) {
        this.Passwrd = Passwrd;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }
    
}
