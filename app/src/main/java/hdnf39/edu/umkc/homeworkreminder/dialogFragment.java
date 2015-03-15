package hdnf39.edu.umkc.homeworkreminder;

import android.app.Activity;
import android.app.DialogFragment;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by mr_glaf43 on 3/9/2015.
 */
public class dialogFragment extends DialogFragment implements View.OnClickListener {
    private EditText txtName;
    private EditText txtComment;
    private EditText txtDate;
    private Button btnDone;

    public static final String TAG = "DdalogFragment";

    private OnCallback callback;

    public interface OnCallback {
        void onClassSetted(String newName, String Comment, String date);
    }


    public dialogFragment() {
// Empty constructor required for DialogFragment
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        try {
            callback = (OnCallback) activity;
        }
        catch(ClassCastException e) {
            //Log.e(TAG, "The MainActivity should implement the OnNameSettedCallback interface");
            e.printStackTrace();
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dialogfragment, container);
        txtName = (EditText) view.findViewById(R.id.txt_name);
        txtComment = (EditText) view.findViewById(R.id.txt_comment);
        txtDate = (EditText) view.findViewById(R.id.txt_date);
        btnDone = (Button) view.findViewById(R.id.btn_done);

// Set the dialog's title
        getDialog().setTitle("New Assignment");

        btnDone.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        Editable name = txtName.getText();
        Editable comment= txtComment.getText();
        Editable date= txtDate.getText();
        if(!TextUtils.isEmpty(name)) {
// Return the new entered name to the calling activity
            callback.onClassSetted(name.toString(), comment.toString(), date.toString());
            //System.out.println(name.toString());
            //System.out.println(comment.toString());
            //System.out.println(date.toString());
            this.dismiss();
        }
        else
            Toast.makeText(getActivity(), "You should enter your name !", Toast.LENGTH_LONG).show();
    }
}


