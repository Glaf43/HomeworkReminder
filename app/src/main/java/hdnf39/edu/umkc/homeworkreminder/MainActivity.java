package hdnf39.edu.umkc.homeworkreminder;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;

import java.util.Calendar;

import hdnf39.edu.umkc.homeworkreminder.service.ScheduleClient;


public class MainActivity extends ActionBarActivity implements dialogFragment.OnCallback {
    private Toolbar topbar;
    FragmentManager fm ;
    Fragment fr;
    public Model model;

    public static final String TAG = "MainActivity";

    private ScheduleClient scheduleClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        topbar = (Toolbar) findViewById(R.id.topbar);
        setSupportActionBar(topbar);
        //set title action bar
        getSupportActionBar().setTitle("Home");
        fm = getFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();

        fr = new ListFragment();
        fragmentTransaction.replace(R.id.fragment_place, fr);
        fragmentTransaction.commit();
        model=Model.instance(getApplicationContext());


        //

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_top, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.plus) {
            dialogFragment dialog = new dialogFragment();
            dialog.show(fm, dialogFragment.TAG);
        }
        return super.onOptionsItemSelected(item);
    }
    //This is where ClassCastException might be thrown
    @Override
    public void onClassSetted(String newName, String Comment, String date, Calendar calendar) throws ClassCastException{
        if(!TextUtils.isEmpty(newName)) {
            scheduleClient = new ScheduleClient(this.getApplicationContext());
            scheduleClient.doBindService();

            model.insert(new Item(newName, Comment, date, calendar));

            scheduleClient.setAlarmForNotification(calendar);
            //scheduleClient.setAlarmForNotification(calendar);
            //System.out.println(newName);
            //System.out.println(Comment);
            //System.out.println(date);
            fr = new ListFragment();
            fm = getFragmentManager();
            FragmentTransaction fragmentTransaction = fm.beginTransaction();
            fragmentTransaction.replace(R.id.fragment_place, fr);
            fragmentTransaction.commit();
        }
    }
    @Override
    protected void onStop() {
        // When our activity is stopped ensure we also stop the connection to the service
        // this stops us leaking our activity into the system *bad*
        if(scheduleClient != null) {
            scheduleClient.doUnbindService();
            System.out.println("doBindSevice disconnected");
        }
        super.onStop();
    }
}
