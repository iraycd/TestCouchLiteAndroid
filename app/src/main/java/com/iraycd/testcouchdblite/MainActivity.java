package com.iraycd.testcouchdblite;

import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;
import android.widget.Toast;

import com.iraycd.testcouchdblite.models.DatabaseWrapper;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.iraycd.testcouchdblite.utils.Keys.*;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            getFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    private static String txt = "";
    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);

            Date now = new Date();
            String nowString = DateFormat.getDateTimeInstance(
                    DateFormat.LONG, DateFormat.LONG).format(now);

            List<Double> scores = new ArrayList<Double>();
            scores.add(190.00);
            scores.add(210.00);
            scores.add(250.00);
            scores.add(275.00);

            DatabaseWrapper db = new DatabaseWrapper(DB_NAME,getActivity().getBaseContext());

            // create an object that contains data for a document
            Map<String, Object> docContent = new HashMap<String, Object>();
            docContent.put(KEY_MAIL, "i@iraycd.com");
            docContent.put(KEY_REG, nowString);
            docContent.put(KEY_SCORES, scores);
            String docId = null;
            try {
                // 1. Create
                docId = db.create(docContent);
                assert(docId != null);
                txt += ("Created doc with id " + docId + "\n");

                txt += ("\n\nRETRIEVE --> ");
                // 2. Retrieve
                docContent= db.retrieve(docId);
                assert(docContent != null);
                txt += ("Retrieved Doc " + String.valueOf(docContent) + "\n");

                txt += ("\n\nUPDATE --> ");
                // 3. Update
                scores.add(350.00);
                db.update(KEY_SCORES, scores, docId);
                Map<String, Object> updatedContent = db.retrieve(docId); // verify update
                txt += ("Updated content: " + String.valueOf(updatedContent) + "\n");

                txt += ("\n\nDELETE --> ");
                // 4. Delete
                boolean deleted = db.delete(docId);
                assert(deleted == true);
                txt += ("Deleted document with id: " + docId + "\n");

                txt += ("\n\nSUCCESS.");
            }
            catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            Log.d("LOG_DONE",txt);
            return rootView;
        }
    }
}
