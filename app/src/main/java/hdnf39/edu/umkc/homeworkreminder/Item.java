package hdnf39.edu.umkc.homeworkreminder;

/**
 * Created by mr_glaf43 on 2/19/2015.
 */
public class Item {
    private String name;
    private String comment;
    private String date;

    public Item(String name, String comment, String date){
        super();
        this.name=name;
        this.comment=comment;
        this.date=date;
    }

    public String getName(){
        return name;
    }
    public String getComment(){
        return comment;
    }
    public String getDate(){ return date;};

    public void setName(String Name){
       name=Name;
    }
    public void setComment(String Comment){
        comment=Comment;
    }
    public void setDate(String Date){
        date=Date;
    }
}
