package net.simplifiedcoding.androidtablayout;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.github.florent37.fiftyshadesof.FiftyShadesOf;

import net.simplifiedcoding.androidtablayout.t_MySQL.Downloader;

/**
 * Created by Nicky on 2/3/2016.
 */

//Our class extending fragment
public class Tab1 extends Fragment implements SwipeRefreshLayout.OnRefreshListener {

    private SwipeRefreshLayout swipeView;
    //public static final String urlAddress = "http://192.168.188.1:8080/shule/news.php?";
    public static final String urlAddress = "https://tixa.000webhostapp.com/shuleni/news.php?";
    ListView lv;

    //doing the initializing for boolen thingy
    boolean loaded=false;



    //Overriden method onCreateView
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //Returning the layout file after inflating
        //Change R.layout.tab1 in you classes
       // ((MainActivity) getActivity()).setActionBarTitle("Home");
        setRetainInstance(true);
        LayoutInflater lf = getActivity().getLayoutInflater();
        final View view =  lf.inflate(R.layout.tab1, container, false);


        lv = (ListView) view.findViewById(R.id.news_lv);

        //declaring the swipe stufs to refresh
        swipeView = (SwipeRefreshLayout) view.findViewById(R.id.swipe_refresh_layout);
        swipeView.setOnRefreshListener(this);
        swipeView.setColorSchemeResources(R.color.colorIndicator,R.color.colorAccent, R.color.colorPrimary, R.color.colorPrimaryDark);
        swipeView.setDistanceToTriggerSync(20);// in dips
        swipeView.setSize(SwipeRefreshLayout.DEFAULT);// LARGE also can be used

        //avoidiing hte reload
        if(savedInstanceState == null) {
        final FiftyShadesOf fiftyShadesOf = FiftyShadesOf.with(getContext()).on(R.id.container_toolbar).start();
        }

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getContext());
        if(!prefs.getBoolean("irstTime", false)) {
            // run your one time code
            new Downloader(getContext(), urlAddress, lv).execute();
            SharedPreferences.Editor editor = prefs.edit();
            editor.putBoolean("irstTime", true);
            editor.apply();
        }

        swipeView.postDelayed(new Runnable() {

            @Override
            public void run() {
                //Toast.makeText(getApplicationContext(), "tickets refreshed", Toast.LENGTH_SHORT).show();
                swipeView.setRefreshing(false);
            }
        }, 1000);


       return  view;


    }

    public void onResume(){
        super.onResume();

        // Set title bar
       // ((MainActivity) getActivity()).setActionBarTitle("Home");

    }


    @Override
    public void onRefresh() {
        //   swipeView.setRefreshing(true);
        new Downloader(getContext(), urlAddress, lv).execute();
        swipeView.setRefreshing(false);
    }



}
