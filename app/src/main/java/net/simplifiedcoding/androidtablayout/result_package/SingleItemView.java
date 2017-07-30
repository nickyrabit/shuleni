package net.simplifiedcoding.androidtablayout.result_package;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import net.simplifiedcoding.androidtablayout.R;
import net.simplifiedcoding.androidtablayout.results.Annual;
import net.simplifiedcoding.androidtablayout.results.Midterm;
import net.simplifiedcoding.androidtablayout.results.Terminal;

import org.w3c.dom.Text;

import mehdi.sakout.fancybuttons.FancyButton;


public class SingleItemView extends Activity {
	// Declare Variables
	String rank;
	String name;
	String pic,comment,phone_number;
	String position;
	ImageLoader imageLoader = new ImageLoader(this);
	FancyButton midterm,terminal,annual;
	TextView title,comments;

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
		comment = i.getStringExtra("comments");

		phone_number = i.getStringExtra("phone");

		// Get the result of flag
		pic = i.getStringExtra("profile_pic");



		// Locate the TextViews in singleitemview.xml
		//TextView txtrank = (TextView) findViewById(R.id.rank);
		TextView txt_name = (TextView) findViewById(R.id.student_name);
		comments = (TextView) findViewById(R.id.comments);
		title = (TextView) findViewById(R.id.class_teacher_title);
		// Locate the ImageView in singleitemview.xml
		ImageView imgflag = (ImageView) findViewById(R.id.head_pic_detail);

		// Set results to the TextViews
		//txtrank.setText(rank);
		txt_name.setText(name);
		comments.setText(comment);

		// Capture position and set results to the ImageView
		// Passes flag images URL into ImageLoader.class
		imageLoader.DisplayImage(pic, imgflag);

		midterm = (FancyButton) findViewById(R.id.midterm);
		terminal  = (FancyButton) findViewById(R.id.terminal);
		annual = (FancyButton) findViewById(R.id.annual);

		midterm.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {

				Intent midterm = new Intent(SingleItemView.this, Midterm.class);
				startActivity(midterm);

			}
		});

		terminal.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent midterm = new Intent(SingleItemView.this, Terminal.class);
				startActivity(midterm);

			}
		});

		annual.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent midterm = new Intent(SingleItemView.this, Annual.class);
				startActivity(midterm);


			}
		});
	}





	public void midterm(View view) {
	}

	public void terminal(View view) {
	}

	public void annual(View view) {
	}
}