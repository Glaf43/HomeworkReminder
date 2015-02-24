package hdnf39.edu.umkc.homeworkreminder;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;


public class MainActivity extends ActionBarActivity {
    private Toolbar topbar;
    FragmentManager fm ;
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

        Fragment fr = new ListFragment();
        fragmentTransaction.replace(R.id.fragment_place, fr);
        fragmentTransaction.commit();
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
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
