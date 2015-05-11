package hdnf39.edu.umkc.homeworkreminder;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

/**
 * Created by mr_glaf43 on 2/19/2015.
 */
public class ListFragment extends android.app.ListFragment implements AdapterView.OnItemClickListener {
    public Model model;
    CustomAdapter adapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //populateFemaleList();
        //populateListView();
        return inflater.inflate(R.layout.custom_list, null, false);

        //return super.onCreateView(inflater,container,savedInstanceState);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        model=Model.instance(getActivity().getApplicationContext());
        if(model.findAll().isEmpty())
            populateList(model);
        adapter = new CustomAdapter(getActivity(), model.findAll());
        setListAdapter(adapter);
        getListView().setOnItemClickListener(this);
    }

    public void populateList(Model model){
       // model=new Model(getContext());
//        Assert.assertTrue("There is no item in the model",model.findAll().isEmpty());
        //model.insert(new Item("CS441", "homework", "2015/03/15",null));
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
/*
        Intent intent = new Intent(getActivity().getApplicationContext(), DetailMenu.class);
        intent.putExtra("name",femaleList.get(position).getName());
        intent.putExtra("gender", "female");
        startActivity( intent);*/
    }
    public void addAssignment(Homework Homework){
        model.insert(Homework);
    }
}
