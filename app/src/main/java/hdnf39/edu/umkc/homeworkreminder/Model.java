package hdnf39.edu.umkc.homeworkreminder;

import android.content.Context;

import java.util.ArrayList;

/**
 * Created by mr_glaf43 on 2/19/2015.
 */
public class Model {
    // Singleton design pattern
    private static Model instance = null;
    private Context context;

    private ArrayList<Homework> homeworkList =new ArrayList<Homework>();

    private Model(Context context) {
        this.context=context;
    }

    public synchronized static Model instance(Context context) {
        if( instance == null ) {
            instance = new Model(context);
        }
        return instance;
    }

    public void insert(Homework Homework) {
        homeworkList.add(Homework);
    }

    public int countItem(){return homeworkList.size();}

    public ArrayList<Homework> findAll(){
        return homeworkList;
    }
}
