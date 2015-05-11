package hdnf39.edu.umkc.homeworkreminder;

import android.app.DialogFragment;
import android.os.Bundle;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by mr_glaf43 on 5/10/2015.
 */
public class ClassDialog extends DialogFragment implements View.OnClickListener{
    private EditText txtClassName;
    private EditText txtProfessorName;
    private Button btnDone;
    private Button btnCancel;

    private Class aClass;

    public static final String TAG = "ClassDialogFragment";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.class_dialog, container);

        txtClassName = (EditText) view.findViewById(R.id.txt_professor_name);
        txtProfessorName = (EditText) view.findViewById(R.id.txt_class_name);
        //txtDate = (EditText) view.findViewById(R.id.txt_date);
        btnDone = (Button) view.findViewById(R.id.btn_class_done);
        btnCancel = (Button) view.findViewById(R.id.btn_class_cancel);

        btnDone.setOnClickListener(this);
        btnCancel.setOnClickListener(this);

        getDialog().setTitle("New Class");
        return view;
    }

    @Override
    public void onClick(View v) {
        String name = txtClassName.getText().toString();
        String professor = txtProfessorName.getText().toString();

        if (v.getId() == R.id.btn_class_done) {
            aClass = new Class(name,professor) ;
            this.dismiss();
        }
        else if(v.getId()==R.id.btn_class_cancel){
            this.dismiss();
        }
    }
}
