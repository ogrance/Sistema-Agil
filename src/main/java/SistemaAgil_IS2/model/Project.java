
package SistemaAgil_IS2.model;


public class Project {
    private int id;
    private String ProjectName;
    private String Description;
    private String Status;

    public Project() {
    }

    public Project(int id, String ProjectName, String Description, String Status) {
        this.id = id;
        this.ProjectName = ProjectName;
        this.Description = Description;
        this.Status = Status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProjectName() {
        return ProjectName;
    }

    public void setProjectName(String ProjectName) {
        this.ProjectName = ProjectName;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }
    
    
}
