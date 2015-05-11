package hdnf39.edu.umkc.homeworkreminder;

/**
 * Created by mr_glaf43 on 5/10/2015.
 */

public class Class {
    private String name;
    private String professor;

    public Class(String Name, String Professor){
        super();
        this.name=Name;
        this.professor=Professor;
    }

    public String getName(){
        return name;
    }
    public String getProfessor(){
        return professor;
    }

    public void setName(String Name){name=Name;}
    public void setProfessor(String Professor){
        professor=Professor;
    }
}
