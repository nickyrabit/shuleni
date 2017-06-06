package net.simplifiedcoding.androidtablayout;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

/**
 * Created by Nicholas on 5/18/2017.
 */

public class SplashActivity extends AppCompatActivity {
    // MY_PREFS_NAME - a static String variable like:
    public static final String MY_PREFS_NAME = "username_pref";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        //Seeing if the use is logged In
        SharedPreferences prefs = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE);
       String isIt = prefs.getString("isLogged", null);

        Toast.makeText(getApplicationContext(),isIt,Toast.LENGTH_SHORT).show();


    if(isIt == null){
        //Login -->
        Intent intent = new Intent(this, Login.class);
        finish();
        startActivity(intent);

    }
     else{

        //Main Activity -->
        Intent intent = new Intent(this, MainActivity.class);
        finish();
        startActivity(intent);




    }
}

}
