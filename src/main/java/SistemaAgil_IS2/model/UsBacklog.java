package SistemaAgil_IS2.model;


public class UsBacklog {
    private Integer id_Us;
    private Integer id_Backl;

    public UsBacklog() {
    }

    public UsBacklog(Integer id_Us, Integer id_Backl) {
        this.id_Us = id_Us;
        this.id_Backl = id_Backl;
    }

    public Integer getId_Us() {
        return id_Us;
    }

    public void setId_Us(Integer id_Us) {
        this.id_Us = id_Us;
    }

    public Integer getId_Backl() {
        return id_Backl;
    }

    public void setId_Backl(Integer id_Backl) {
        this.id_Backl = id_Backl;
    }
    
    
}
