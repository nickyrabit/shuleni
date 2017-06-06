package net.simplifiedcoding.androidtablayout;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by NICKKK on 2/3/2016.
 */

public class Tab3 extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        //((MainActivity) getActivity()).setActionBarTitle("Results");
        LayoutInflater lf = getActivity().getLayoutInflater();
        final View view =  lf.inflate(R.layout.tab3, container, false);








        return  view;
    }

    public void onResume(){
        super.onResume();

        // Set title bar
     //   ((MainActivity) getActivity()).setActionBarTitle("Results");

    }

}
