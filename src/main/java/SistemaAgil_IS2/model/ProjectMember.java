package SistemaAgil_IS2_war.model;

public class ProjectMember {

    private int id_proyecto;
    private int id_user;

    public ProjectMember() {
    }

    public ProjectMember(int id_proyecto, int id_user) {
        this.id_proyecto = id_proyecto;
        this.id_user = id_user;
    }

    public int getId_proyecto() {
        return id_proyecto;
    }

    public void setId_proyecto(int id_proyecto) {
        this.id_proyecto = id_proyecto;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

}
