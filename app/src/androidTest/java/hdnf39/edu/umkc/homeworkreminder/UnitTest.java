package hdnf39.edu.umkc.homeworkreminder;

import android.content.Context;
import android.test.AndroidTestCase;

import junit.framework.TestCase;

/**
 * Created by mr_glaf43 on 4/26/2015.
 */
public class UnitTest extends AndroidTestCase {
    Context context=getContext();
    public void testListFragment() throws Exception{
        Model model=Model.instance(context);

        ListFragment listFragment=new ListFragment();
        listFragment.populateList(model);
        assertEquals(1, model.countItem());
    }
}
