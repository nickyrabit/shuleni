package net.simplifiedcoding.androidtablayout.t_DetailActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import net.simplifiedcoding.androidtablayout.MainActivity;
import net.simplifiedcoding.androidtablayout.R;
import net.simplifiedcoding.androidtablayout.UI_t.PicassoClient_t;

import mehdi.sakout.fancybuttons.FancyButton;


public class Detail2Activity_t extends AppCompatActivity {

    TextView TitleTxt;
    WebView DetailsTxt;
    //TextView description_detail;// nimeitoa nkaiekandani
    FancyButton back;
    ImageView ImageDetail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.news_activity_detail);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //DECLARATION
        back = (FancyButton) findViewById(R.id.ticket_Buybutton);
        TitleTxt= (TextView) findViewById(R.id.title_detail);
        //seatsTxt = (TextView) findViewById(R.id.ticket_seatsDetailTxt);
        DetailsTxt = (WebView) findViewById(R.id.description_detail);
        ImageDetail = (ImageView) findViewById(R.id.detail_image);

        DetailsTxt.getSettings();
        DetailsTxt.setBackgroundColor(Color.parseColor("#e5e5e5"));

        //RECIVE THE DATA
        Intent i = this.getIntent();
        final String title = i.getExtras().getString("TITLE_KEY");
        final String imageUrl = i.getExtras().getString("URL_KEY");
        String details = i.getExtras().getString("DETAILS_KEY");
        final String time = i.getExtras().getString("TIME_KEY");


        //BIND
        TitleTxt.setText("\t" + title);
        // DetailsTxt.setText("\t" + details);

        //placing the HTML Wb view
        StringBuilder sb = new StringBuilder("<html><body>");
        sb.append(details);
        sb.append("</body></html>");
        DetailsTxt.loadData(sb.toString(), "text/html", "UTF-8");

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




