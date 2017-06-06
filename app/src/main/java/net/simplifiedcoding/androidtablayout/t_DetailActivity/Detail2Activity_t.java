package net.simplifiedcoding.androidtablayout.t_DetailActivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import net.simplifiedcoding.androidtablayout.MainActivity;
import net.simplifiedcoding.androidtablayout.R;
import net.simplifiedcoding.androidtablayout.UI_t.PicassoClient_t;


public class Detail2Activity_t extends AppCompatActivity {

    TextView TitleTxt;
    TextView DetailsTxt;
    //TextView description_detail;// nimeitoa nkaiekandani
    Button back;
    ImageView ImageDetail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.news_activity_detail);

        //DECLARATION
        back = (Button) findViewById(R.id.ticket_Buybutton);
        TitleTxt= (TextView) findViewById(R.id.title_detail);
        //seatsTxt = (TextView) findViewById(R.id.ticket_seatsDetailTxt);
        DetailsTxt = (TextView) findViewById(R.id.description_detail);
        ImageDetail = (ImageView) findViewById(R.id.detail_image);

        //RECIVE THE DATA
        Intent i = this.getIntent();
        final String title = i.getExtras().getString("TITLE_KEY");
        final String imageUrl = i.getExtras().getString("URL_KEY");
        String details = i.getExtras().getString("DETAILS_KEY");
        final String time = i.getExtras().getString("TIME_KEY");


        //BIND
        TitleTxt.setText("\t" + title);
        DetailsTxt.setText("\t" + details);

        //setting theimae here
        PicassoClient_t.downloadImage(getApplicationContext(),imageUrl,ImageDetail);

        back.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(Detail2Activity_t.this, MainActivity.class);
                finish();
                startActivity(myIntent);

            }
        });


    }

    @Override
    public void onBackPressed() {
        Intent myIntent = new Intent(Detail2Activity_t.this, MainActivity.class);
        finish();
        startActivity(myIntent);
    }


}




