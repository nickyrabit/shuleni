package net.simplifiedcoding.androidtablayout.t_MySQL;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.ListView;
import android.widget.Toast;

import net.simplifiedcoding.androidtablayout.UI_t.CustomAdapter_t;
import net.simplifiedcoding.androidtablayout.t_DataObject.Events_t;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


/**
 * Created by Nicholas on 6/11/2016.
 */

public class DataParser extends AsyncTask<Void,Void,Boolean> {

    Context c;
    String jsonData;
    ListView news_lv;

    ProgressDialog pd;

    ArrayList<Events_t> events = new ArrayList<>();

    public DataParser(Context c, String jsonData, ListView news_lv) {
        this.c = c;
        this.jsonData = jsonData;
        this.news_lv = news_lv;

    }




    @Override
    protected void onPreExecute() {
        super.onPreExecute();

        pd = new ProgressDialog(c);
        pd.setTitle("PARSING");
        pd.setMessage("Parsing PLease wait");
//        pd.show();
    }

    @Override
    protected Boolean doInBackground(Void... voids) {
        return this.parseData();
    }

    @Override
    protected void onPostExecute(Boolean parsed) {
        super.onPostExecute(parsed);

        pd.dismiss();

        if (parsed) {
            //BIND

            CustomAdapter_t adapter = new CustomAdapter_t(c,events);
            news_lv.setAdapter(adapter);
        } else {
            Toast.makeText(c, "Unable to parse", Toast.LENGTH_SHORT).show();

        }
    }

    private Boolean parseData()
    {
        try{

            JSONArray ja = new JSONArray(jsonData);
            JSONObject jo;
            events.clear();

            Events_t event;

            for (int i=0;i<ja.length();i++)
            {
                jo = ja.getJSONObject(i);

                String title = jo.getString("title");
                String url = jo.getString("url");
                String detail = jo.getString("detail");
                String time = jo.getString("time");

                event = new Events_t();
                event.setTitle(title);
                event.setUrl(url);
                event.setDetail(detail);
                event.setTime(time);
                events.add(event);
            }

 return true;

        } catch(JSONException e)
        {
            e.printStackTrace();
        }
            return false;
    }
    }




