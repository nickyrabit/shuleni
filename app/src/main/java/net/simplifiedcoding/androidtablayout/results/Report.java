package net.simplifiedcoding.androidtablayout.results;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.ramotion.foldingcell.FoldingCell;

import net.simplifiedcoding.androidtablayout.R;
import net.simplifiedcoding.androidtablayout.result_codes.JSONfunctions;
import net.simplifiedcoding.androidtablayout.result_codes.ListViewAdapter_For_Report;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

import mehdi.sakout.fancybuttons.FancyButton;

/** * Created by NICHOLAUS L. NGAILO on 7/30/2017.
 */

public class Report extends AppCompatActivity {
    String student_id,test_id;
    // Declare Variables
    JSONObject jsonobject;
    JSONArray jsonarray;
    ListView listview;
    ListViewAdapter_For_Report adapter;
    ProgressDialog mProgressDialog2;
    ArrayList<HashMap<String, String>> arraylist;
    public static String RANK = "id";
    public static String PHONE = "phone";
    public static String NAME = "name";
    public static String COMMENT = "comment";
    public static String PROFILE_PIC = "profile_pic";
    public static String ENGLISH = "english";
    public static String POSITION ="position";
    public static String TOTAL = "total";
    public static String GEOGRAPHY ="geography";
    public static String BIOLOGY ="biology";
    public static String PHYSICS ="physics";
    public static String HISTORY = "history";
    public static String KISWAHILI ="kiswahili";
    public static String CHEMISTRY ="chemistry";
    public static String EXTRACURRICULAR ="extra";
    public static String AVERAGE ="avg";
    public static String MATH ="math";
    FancyButton button_fold_;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.report);

        Intent i = getIntent();
        // Get the result of rank
        student_id = i.getStringExtra("id");
        test_id = i.getStringExtra("test");
        try{new DownloadJSON().execute();
        }
        catch (Exception r)
        {
            Toast.makeText(getApplicationContext(),"No Internet Connection",Toast.LENGTH_LONG).show();

        }

        // get our folding cell
        final FoldingCell fc = (FoldingCell) findViewById(R.id.folding_cell);
         button_fold_ = (FancyButton) findViewById(R.id.button_fold);


        // attach click listener to folding cell
        fc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fc.toggle(false);
            }
        });


       button_fold_.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fc.toggle(true);
            }
        });




    }
    // DownloadJSON AsyncTask
    private class DownloadJSON extends AsyncTask<Void, Void, Void> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            // Create a progressdialog
            mProgressDialog2 = new ProgressDialog(Report.this);
            // Set progressdialog title
            mProgressDialog2.setTitle("Loading Accounts");
            // Set progressdialog message
            mProgressDialog2.setMessage("Loading...");
            mProgressDialog2.setIndeterminate(false);
            // Show progressdialog
            mProgressDialog2.show();
        }

        @Override
        protected Void doInBackground(Void... params) {
            // Create an array
            arraylist = new ArrayList<>();
            // Retrieve JSON Objects from the given URL address
            jsonobject = JSONfunctions.getJSONfromURL("https://tixa.000webhostapp.com/shuleni/midterm.json");

            try {
                // Locate the array name in JSON
                jsonarray = jsonobject.getJSONArray("midterm");

                for (int i = 0; i < jsonarray.length(); i++) {
                    HashMap<String, String> map = new HashMap<>();
                    jsonobject = jsonarray.getJSONObject(i);
                    // Retrive JSON Objects
                    map.put("id", jsonobject.getString("id"));
                    map.put("name", jsonobject.getString("name"));
                    // map.put("comment", jsonobject.getString("comment"));
                    //map.put("phone", jsonobject.getString("phone"));
                    //  map.put("profile_pic", jsonobject.getString("profile_pic"));
                    map.put("english", jsonobject.getString("english"));
                    map.put("position", jsonobject.getString("position"));
                    map.put("total", jsonobject.getString("total"));
                    map.put("geography", jsonobject.getString("geography"));
                    map.put("biology", jsonobject.getString("biology"));
                    map.put("physics", jsonobject.getString("physics"));
                    map.put("history", jsonobject.getString("history"));
                    map.put("kiswahili", jsonobject.getString("kiswahili"));
                    map.put("chemistry", jsonobject.getString("chemistry"));
                    map.put("math", jsonobject.getString("math"));
                    map.put("extra", jsonobject.getString("extra"));
                    //   map.put("avg", jsonobject.getString("avg"));

                    // Set the JSON Objects into the array
                    arraylist.add(map);
                }
            } catch (JSONException e) {
                Log.e("Error", e.getMessage());
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void args) {
            // Locate the listview in listview_main.xml
            listview = (ListView)  findViewById(R.id.report_listview);
            // Pass the results into ListViewAdapter.java
            adapter = new ListViewAdapter_For_Report(Report.this, arraylist);
            // Set the adapter to the ListView
            listview.setAdapter(adapter);

            try{
                // Close the progressdialog
                mProgressDialog2.dismiss();
            }
            catch(Exception e)
            {
                Log.wtf("WTF","What the hell is going on");
            }

        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mProgressDialog2 != null) {
            mProgressDialog2.dismiss();
            mProgressDialog2 = null;
        }

        finish();
    }

    @Override
    public void onBackPressed() {
        // TODO Auto-generated method stub
        super.onBackPressed();
        if (mProgressDialog2 != null) {
            mProgressDialog2.dismiss();
            mProgressDialog2 = null;
        }
        finish();
    }



}
