package hdnf39.edu.umkc.homeworkreminder;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.DialogFragment;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

import junit.framework.Assert;

import java.util.Calendar;

/**
 * Created by mr_glaf43 on 3/9/2015.
 */
public class HomeworkDialog extends DialogFragment implements View.OnClickListener,DatePicker.OnDateChangedListener, TimePicker.OnTimeChangedListener {
    private EditText txtName;
    private EditText txtComment;
    private Button btnDone;
    private Button btnCancel;
    private TextView date;
    private TextView time;

    private Calendar c;

    private int mYear, mMonth, mDay, mHour, mMinute;

    public static final String TAG = "DdalogFragment";

    private OnCallback callback;

    @Override
    public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
        date.setText(dayOfMonth + "-"
                + (monthOfYear + 1) + "-" + year);
    }

    @Override
    public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {

    }

    public interface OnCallback {
        void onClassSetted(String newName, String Comment, String date, Calendar calendar);
    }


    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        try {
            callback = (OnCallback) activity;
        }
        catch(ClassCastException e) {
            //print message. OnCallBack could have failed
            //and this it where handle ClassCastException
            e.printStackTrace();
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.homework_dialog, container);

        txtName = (EditText) view.findViewById(R.id.txt_name);
        txtComment = (EditText) view.findViewById(R.id.txt_comment);
        //txtDate = (EditText) view.findViewById(R.id.txt_date);
        btnDone = (Button) view.findViewById(R.id.btn_done);
        btnCancel = (Button) view.findViewById(R.id.btn_cancel);

        date=(TextView) view.findViewById(R.id.current_date);
        time=(TextView) view.findViewById(R.id.current_time);

        btnDone.setOnClickListener(this);
        btnCancel.setOnClickListener(this);
        date.setOnClickListener(this);
        time.setOnClickListener(this);

        getDialog().setTitle("New Assignment");
        return view;
    }

    @Override
    public void onClick(View v) {
        Editable name = txtName.getText();
        Editable comment = txtComment.getText();
        String date_input=date.getText().toString();

        c = Calendar.getInstance();
        if (v.getId() == R.id.btn_done) {
            doneButton(name, comment, date_input);
        }
        else if(v.getId()==R.id.btn_cancel){
            this.dismiss();
        }
        else if(v.getId()==R.id.current_date){

            getCurrentDate();
        }

        else if(v.getId()==R.id.current_time){
            getCurrentTime();
        }
   }

    public void doneButton(Editable name, Editable comment, String date_input){
        c.set(mYear,mMonth,mDay,mHour,mMinute,0);
        callback.onClassSetted(name.toString(), comment.toString(), date_input, c);
        this.dismiss();
        Assert.assertTrue("class name found", !TextUtils.isEmpty(name));
    }

    public void getCurrentDate(){
        //c = Calendar.getInstance();
        mYear = c.get(Calendar.YEAR);
        mMonth = c.get(Calendar.MONTH);
        mDay = c.get(Calendar.DAY_OF_MONTH);

        // Launch Date Picker Dialog
        DatePickerDialog dpd = new DatePickerDialog(getActivity(),
                new MyOnDateSetListener(date), mYear, mMonth, mDay);

        dpd.show();
    }

    public void getCurrentTime(){
        //c = Calendar.getInstance();
        mHour = c.get(Calendar.HOUR_OF_DAY);
        mMinute = c.get(Calendar.MINUTE);

        // Launch Time Picker Dialog
        TimePickerDialog tpd = new TimePickerDialog(getActivity(),
                new TimePickerDialog.OnTimeSetListener() {

                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay,
                                          int minute) {
                        // Display Selected time in textbox
                        time.setText(hourOfDay + ":" + minute);
                    }
                }, mHour, mMinute, false);
        tpd.show();
    }

    private static class MyOnDateSetListener implements DatePickerDialog.OnDateSetListener {

        private final TextView date;

        public MyOnDateSetListener(TextView date) {
            this.date = date;
        }

        @Override
        public void onDateSet(DatePicker view, int year,
                              int monthOfYear, int dayOfMonth) {
            // Display Selected date in textbox
            date.setText(year + "/"
                    + (monthOfYear + 1) + "/" + dayOfMonth);

        }
    }
}


