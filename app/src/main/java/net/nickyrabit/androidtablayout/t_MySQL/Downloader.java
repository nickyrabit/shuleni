package net.nickyrabit.androidtablayout.t_MySQL;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.ListView;
import android.widget.Toast;

import com.github.florent37.fiftyshadesof.FiftyShadesOf;

import net.nickyrabit.androidtablayout.R;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;

/**
 * Created by Nicholas on 6/11/2016.
 */
public class Downloader extends AsyncTask<Void,Void,String> {

    Context c;
    String urlAddress;
    ListView lv;

    ProgressDialog pd;
    FiftyShadesOf fiftyShadesOf;
    public Downloader(Context c, String urlAddress, ListView lv) {
        this.c = c;
        this.urlAddress = urlAddress;
        this.lv = lv;


    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();


        //pd=new ProgressDialog(c);
        //pd.setTitle("Retrieve");
        //pd.setMessage("Retrieving...Please wait");
//       pd.show();

         fiftyShadesOf = FiftyShadesOf.with(c).on(R.id.container_toolbar).start();


    }

    @Override
    protected String doInBackground(Void... params) {
        return this.downloadData();
    }

    @Override
    protected void onPostExecute(String jsonData) {
        super.onPostExecute(jsonData);
        //pd.dismiss();
        fiftyShadesOf.stop();


        if(jsonData==null)

        {

            Toast.makeText(c,"Unsuccesful no data Received", Toast.LENGTH_SHORT).show();
        }else
        {
            //PARSER CLASS  GV ILIZINGUA
            DataParser parser = new DataParser(c,jsonData,lv);
            parser.execute();

        }
    }
    private String downloadData(){

        HttpURLConnection con = Connector.connect(urlAddress);
        if(con==null)
        {
            return null;
        }

        try
        {
            InputStream is = new BufferedInputStream(con.getInputStream());
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String line;
            StringBuffer jsonData = new StringBuffer();
            while((line=br.readLine())!=null)
            {
                jsonData.append(line+"\n");
            }
            br.close();
            is.close();

            return jsonData.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
