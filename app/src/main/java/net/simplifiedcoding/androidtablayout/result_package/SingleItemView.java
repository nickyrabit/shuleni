package net.simplifiedcoding.androidtablayout.result_package;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import net.simplifiedcoding.androidtablayout.R;

public class SingleItemView extends Activity {
	// Declare Variables
	String rank;
	String country;
	String population;
	String flag;
	String position;
	ImageLoader imageLoader = new ImageLoader(this);

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// Get the view from singleitemview.xml
		setContentView(R.layout.singleitemview);

		Intent i = getIntent();
		// Get the result of rank
		rank = i.getStringExtra("id");
		// Get the result of country
		country = i.getStringExtra("name");
		// Get the result of population
		//population = i.getStringExtra("population");
		// Get the result of flag
		flag = i.getStringExtra("profile_pic");

		// Locate the TextViews in singleitemview.xml
		TextView txtrank = (TextView) findViewById(R.id.rank);
		TextView txt_name = (TextView) findViewById(R.id.student_name);
		TextView txt_comments = (TextView) findViewById(R.id.comments);

		// Locate the ImageView in singleitemview.xml
		ImageView imgflag = (ImageView) findViewById(R.id.head_pic_detail);

		// Set results to the TextViews
		txtrank.setText(rank);
		txtcountry.setText(country);
		txtpopulation.setText(population);

		// Capture position and set results to the ImageView
		// Passes flag images URL into ImageLoader.class
		imageLoader.DisplayImage(flag, imgflag);
	}
}