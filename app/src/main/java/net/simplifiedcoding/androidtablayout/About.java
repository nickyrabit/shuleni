package net.simplifiedcoding.androidtablayout;

import android.app.ActionBar;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

/**
 * Created by Nicholas on 5/17/2017.
 */

public class About extends AppCompatActivity {

    TextView shule;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about);


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        //declaring hte tex ews
        shule = (TextView) findViewById(R.id.title_logo);
        //Declaring the fonts
        String fontPath = "fonts/Stainy.ttf";
        Typeface tf = Typeface.createFromAsset(getAssets(), fontPath);
        shule.setTypeface(tf);
        shule.setText("Shule");
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                // app icon in action bar clicked; goto parent activity.
                Intent homeIntent = new Intent(this,MainActivity.class);
                startActivity(homeIntent);


                this.finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}

