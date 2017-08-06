package net.simplifiedcoding.androidtablayout;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import mehdi.sakout.fancybuttons.FancyButton;

/** * Created by NICKY on 2/3/2016.
 */

public class Tab3 extends Fragment {
    View view;
    private FragmentActivity myContext;
        FancyButton theKids,theFaq;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.d("IS_THIS", "Tab 3  Results Opened");


        LayoutInflater lf = getActivity().getLayoutInflater();
        view =  lf.inflate(R.layout.tab3, container, false);

        theKids = (FancyButton) view.findViewById(R.id.select_a_child);
        theFaq = (FancyButton) view.findViewById(R.id.faq);
        theKids.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent account = new Intent(getContext(),Accounts.class);
                startActivity(account);
            }
        });
        theFaq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent account = new Intent(getContext(),Faq.class);
                startActivity(account);
            }
        });

        return  view;
    }

    public void onResume(){
        super.onResume();

        // Set title bar
        //((MainActivity) getActivity()).setActionBarTitle("Results");
     //   Intent account = new Intent(getContext(),Accounts.class);
    //    startActivity(account);

    }

    @Override
    public void onAttach(Activity activity) {
        myContext=(FragmentActivity) activity;
        super.onAttach(activity);
    }

}
