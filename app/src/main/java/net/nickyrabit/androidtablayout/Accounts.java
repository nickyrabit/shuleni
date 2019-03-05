package net.nickyrabit.androidtablayout;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;

import net.nickyrabit.androidtablayout.result_codes.JSONfunctions;
import net.nickyrabit.androidtablayout.result_codes.ListViewAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

/** * Created by NICHOLAUS L. NGAILO on 8/3/2017.
 */

public class Accounts extends AppCompatActivity {

    // Declare Variables
    JSONObject jsonobject;
    JSONArray jsonarray;
    ListView listview;
    ListViewAdapter adapter;
    ProgressDialog mProgressDialog;
    ArrayList<HashMap<String, String>> arraylist;
    public static String RANK = "id";
    public  static String PHONE = "phone";
    public  static String NAME = "name";
    public  static String COMMENT = "comment";
    public  static String PROFILE_PIC = "profile_pic";


    TextView title_dialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.account);

        title_dialog = (TextView) findViewById(R.id.title);

         new DownloadJSON().execute();



    }

    // DownloadJSON AsyncTask
    private class DownloadJSON extends AsyncTask<Void, Void, Void> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            // Create a progressdialog
            mProgressDialog = new ProgressDialog(Accounts.this);
            // Set progressdialog title
            mProgressDialog.setTitle("Loading Accounts");
            // Set progressdialog message
            mProgressDialog.setMessage("Loading...");
            mProgressDialog.setIndeterminate(false);
            // Show progressdialog
            mProgressDialog.show();
        }

        @Override
        protected Void doInBackground(Void... params) {
            // Create an array
            arraylist = new ArrayList<>();
            // Retrieve JSON Objects from the given URL address
            jsonobject = JSONfunctions.getJSONfromURL("https://tixa.000webhostapp.com/shuleni/profile_pic/result.json");

            try {
                // Locate the array name in JSON
                jsonarray = jsonobject.getJSONArray("result");

                for (int i = 0; i < jsonarray.length(); i++) {
                    HashMap<String, String> map = new HashMap<>();
                    jsonobject = jsonarray.getJSONObject(i);
                    // Retrive JSON Objects
                    map.put("id", jsonobject.getString("id"));
                    map.put("name", jsonobject.getString("name"));
                    map.put("comment", jsonobject.getString("comment"));
                    map.put("phone", jsonobject.getString("phone"));
                    map.put("profile_pic", jsonobject.getString("profile_pic"));
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
            listview = (ListView)  findViewById(R.id.listview);
            // Pass the results into ListViewAdapter.java
            adapter = new ListViewAdapter(Accounts.this, arraylist);
            // Set the adapter to the ListView
            listview.setAdapter(adapter);


          try{
            // Close the progressdialog
            mProgressDialog.dismiss();
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
        if (mProgressDialog != null) {
            mProgressDialog.dismiss();
            mProgressDialog = null;
        }
            finish();
    }

    @Override
    public void onBackPressed() {
        // TODO Auto-generated method stub
        super.onBackPressed();
        finish();
    }

}
