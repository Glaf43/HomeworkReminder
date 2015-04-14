package hdnf39.edu.umkc.homeworkreminder;

import java.util.Calendar;

/**
 * Created by mr_glaf43 on 2/19/2015.
 */
public class Item {
    private String name;
    private String comment;
    private String date;
    private Calendar c;

    public Item(String name, String comment, String date, Calendar c){
        super();
        this.name=name;
        this.comment=comment;
        this.date=date;
        this.c=c;
    }
    public Item(String name, String comment){
        super();
        this.name=name;
        this.comment=comment;
        this.date="";

    }

    public String getName(){
        return name;
    }
    public String getComment(){
        return comment;
    }
    public String getDate(){ return date;};
    public Calendar getCalendar() {return c;};

    public void setName(String Name){
       name=Name;
    }
    public void setComment(String Comment){
        comment=Comment;
    }
    public void setDate(String Date){
        date=Date;
    }
    public void setCalendar(Calendar C) {c=C;};
}
