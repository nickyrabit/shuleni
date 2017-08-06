package net.simplifiedcoding.androidtablayout.results;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import net.simplifiedcoding.androidtablayout.R;

/** * Created by NICHOLAUS L. NGAILO on 7/30/2017.
 */

public class Report extends AppCompatActivity {
    String student_id,test_id;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.report);

        Intent i = getIntent();
        // Get the result of rank
        student_id = i.getStringExtra("id");
        test_id = i.getStringExtra("test");



    }
}