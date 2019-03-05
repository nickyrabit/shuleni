package net.nickyrabit.androidtablayout.result_codes;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import net.nickyrabit.androidtablayout.R;
import net.nickyrabit.androidtablayout.results.Report;

import mehdi.sakout.fancybuttons.FancyButton;

public class SingleItemView extends Activity {
	// Declare Variables
	String rank;
	String name;
	String number;
	String face;
	String comment;
	ImageLoader imageLoader = new ImageLoader(this);
	FancyButton terminalbtn, annualbtn, midtermbtn;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// Get the view from singleitemview.xml
		setContentView(R.layout.singleitemview);

		Intent i = getIntent();
		// Get the result of rank
		rank = i.getStringExtra("id");
		// Get the result of country
		name = i.getStringExtra("name");
		// Get the result of population
		//population = i.getStringExtra("population");
		// Get the result of flag
		face = i.getStringExtra("profile_pic");
		comment = i.getStringExtra("comment");
		number = i.getStringExtra("phone");

		// Locate the TextViews in singleitemview.xml
		//TextView txtrank = (TextView) findViewById(R.id.rank);
		TextView txt_name = (TextView) findViewById(R.id.student_name);
		//TextView txtpopulation = (TextView) findViewById(R.id.population);
		TextView comments = (TextView) findViewById(R.id.comments);
		// Locate the ImageView in singleitemview.xml
		ImageView imgflag = (ImageView) findViewById(R.id.head_pic_detail);

		midtermbtn = (FancyButton) findViewById(R.id.midterm);
		annualbtn = (FancyButton) findViewById(R.id.annual);
		terminalbtn = (FancyButton) findViewById(R.id.terminal);
		Button call = (Button) findViewById(R.id.call_teacher);
		// Set results to the TextViews
		//txtrank.setText(rank);
		txt_name.setText(name);
		//txtpopulation.setText(population);
		comments.setText(comment);

		// Capture position and set results to the ImageView
		// Passes flag images URL into ImageLoader.class
		imageLoader.DisplayImage(face, imgflag);

		call.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:"+number));
                startActivity(callIntent);
			}});


		midtermbtn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
			   Intent intent = new Intent(SingleItemView.this, Report.class);
				// Pass all data id
				intent.putExtra("id", rank);
				intent.putExtra("test", "midterm");
				startActivity(intent);
			}
		});

		annualbtn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(SingleItemView.this, Report.class);
				// Pass all data id
				intent.putExtra("id", rank);
				intent.putExtra("test", "report");
				startActivity(intent);
			}
		});


		terminalbtn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(SingleItemView.this, Report.class);
				// Pass all data id
				intent.putExtra("id", rank);
				intent.putExtra("test", "terminal");
				startActivity(intent);
			}
		});
	}


}