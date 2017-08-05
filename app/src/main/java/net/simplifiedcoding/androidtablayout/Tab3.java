package net.simplifiedcoding.androidtablayout;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.view.ContextThemeWrapper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import net.simplifiedcoding.androidtablayout.result_codes.JSONfunctions;
import net.simplifiedcoding.androidtablayout.result_codes.ListViewAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;


/**
 * Created by NICKKK on 2/3/2016.
 */

public class Tab3 extends Fragment {

      View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        Intent account = new Intent(getContext(),Accounts.class);
        startActivity(account);



        return  view;
    }

    public void onResume(){
        super.onResume();

        // Set title bar
     //   ((MainActivity) getActivity()).setActionBarTitle("Results");
        Intent account = new Intent(getContext(),Accounts.class);
        startActivity(account);

    }

}
