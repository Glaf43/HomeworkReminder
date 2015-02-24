package hdnf39.edu.umkc.homeworkreminder;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by mr_glaf43 on 2/19/2015.
 */
public class CustomAdapter extends BaseAdapter{
    Context context;
    List<Item> listItem;

    CustomAdapter(Context context, List<Item> listItem){
        this.context=context;
        this.listItem=listItem;
    }

    @Override
    public int getCount() {
        return listItem.size();
    }

    @Override
    public Object getItem(int position) {
        return listItem.get(position);
    }

    @Override
    public long getItemId(int position) {
        return listItem.indexOf((getItem(position)));
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater mInflater = (LayoutInflater) context
                    .getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            convertView = mInflater.inflate(R.layout.custom_item, null);
        }

        //ImageView imgIcon = (ImageView) convertView.findViewById(R.id.image);
        TextView name = (TextView) convertView.findViewById(R.id.name);
        TextView comment=(TextView) convertView.findViewById(R.id.comment);
        TextView date=(TextView) convertView.findViewById(R.id.date);


        Item item = listItem.get(position);
        // setting the image resource and title
        //imgIcon.setImageResource(item.getIconID());
        name.setText(item.getName());
        comment.setText(item.getComment());
        date.setText(item.getDate());

        return convertView;
    }
}
