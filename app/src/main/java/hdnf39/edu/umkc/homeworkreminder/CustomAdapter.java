package hdnf39.edu.umkc.homeworkreminder;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import junit.framework.Assert;

import java.util.List;

/**
 * Created by mr_glaf43 on 2/19/2015.
 */
public class CustomAdapter extends BaseAdapter{
    Context context;
    List<Homework> listHomework;

    CustomAdapter(Context context, List<Homework> listHomework){
        this.context=context;
        this.listHomework = listHomework;
    }

    @Override
    public int getCount() {
        return listHomework.size();
    }

    @Override
    public Object getItem(int position) {
        return listHomework.get(position);
    }

    @Override
    public long getItemId(int position) {
        return listHomework.indexOf((getItem(position)));
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            Assert.assertTrue("View is null",convertView == null);
            LayoutInflater mInflater = (LayoutInflater) context
                    .getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            convertView = mInflater.inflate(R.layout.custom_item, null);
        }

        //ImageView imgIcon = (ImageView) convertView.findViewById(R.id.image);
        TextView name = (TextView) convertView.findViewById(R.id.name);
        TextView comment=(TextView) convertView.findViewById(R.id.ClassName);
        TextView date=(TextView) convertView.findViewById(R.id.date);

        Homework Homework = listHomework.get(position);
        // setting the image resource and title
        //imgIcon.setImageResource(item.getIconID());
        name.setText(Homework.getName());
        comment.setText(Homework.getComment());
        date.setText(Homework.getDate());

        return convertView;
    }
}
