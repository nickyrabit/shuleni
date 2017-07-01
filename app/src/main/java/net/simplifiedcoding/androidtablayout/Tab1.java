package net.simplifiedcoding.androidtablayout;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import net.simplifiedcoding.androidtablayout.t_MySQL.Downloader;

/**
 * Created by Belal on 2/3/2016.
 */

//Our class extending fragment
public class Tab1 extends Fragment implements SwipeRefreshLayout.OnRefreshListener {

    //doing the initializing for boolen thingy
    public Boolean initialized = false;

    private SwipeRefreshLayout swipeView;
    //public static final String urlAddress = "http://192.168.188.1:8080/shule/news.php?";
    public static final String urlAddress = "https://tixa.000webhostapp.com/shuleni/news.php?";
    ListView lv;


    //Overriden method onCreateView
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        //Returning the layout file after inflating
        //Change R.layout.tab1 in you classes
       // ((MainActivity) getActivity()).setActionBarTitle("Home");
        LayoutInflater lf = getActivity().getLayoutInflater();
        final View view =  lf.inflate(R.layout.tab1, container, false);


        lv = (ListView) view.findViewById(R.id.news_lv);

        //declaring the swipe stufs to refresh
        swipeView = (SwipeRefreshLayout) view.findViewById(R.id.swipe_refresh_layout);

        swipeView.setOnRefreshListener(this);

        swipeView.setColorSchemeResources(R.color.colorIndicator,R.color.colorAccent, R.color.colorPrimary, R.color.colorPrimaryDark);
        swipeView.setDistanceToTriggerSync(20);// in dips
        swipeView.setSize(SwipeRefreshLayout.DEFAULT);// LARGE also can be used

        //placing the if condition
         if (initialized) {
            //Poppulating the entire layout
            new Downloader(getContext(), urlAddress, lv).execute();
             initialized=true;
        } else {
             //if it has already been initialised
             //do nothing
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
