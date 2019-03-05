package net.nickyrabit.androidtablayout;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.Toast;

/**
 * Created by Nicholas on 5/17/2017.
 */

public class Settings extends  AppCompatActivity {

CheckBox notif;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings);

                    //setting the backbutton
       getSupportActionBar().setDisplayHomeAsUpEnabled(true);


       notif = (CheckBox) findViewById(R.id.checkBoxNotification);

notif.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                //is chkIos checked?
                if (((CheckBox) v).isChecked()) {
                    Toast.makeText(getApplicationContext(),"Checked", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(getApplicationContext(),"Un-Checked", Toast.LENGTH_SHORT).show();

                }
            }
        });




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
