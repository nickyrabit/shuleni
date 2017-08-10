package net.simplifiedcoding.androidtablayout.result_codes;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import net.simplifiedcoding.androidtablayout.R;
import net.simplifiedcoding.androidtablayout.results.Report;

import java.util.ArrayList;
import java.util.HashMap;

public class ListViewAdapter_For_Report extends BaseAdapter {

	// Declare Variables
	Context context;
	LayoutInflater inflater;
	ArrayList<HashMap<String, String>> data;
	ImageLoader imageLoader;
	HashMap<String, String> resultp = new HashMap<String, String>();

	public ListViewAdapter_For_Report(Context context,
									  ArrayList<HashMap<String, String>> arraylist) {
		this.context = context;
		data = arraylist;
		imageLoader = new ImageLoader(context);
	}

	@Override
	public int getCount() {
		return data.size();
	}

	@Override
	public Object getItem(int position) {
		return null;
	}

	@Override
	public long getItemId(int position) {
		return 0;
	}

	public View getView(final int position, View convertView, ViewGroup parent) {
		// Declare Variables
		TextView name;
		ImageView flag;
		TextView total,average,geography,history,chemistry,english,_id,student_position,biology,kiswahili,physics,math,extra_activities;


		inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View itemView = inflater.inflate(R.layout.report_listview_item, parent, false);

		// Get the position
		resultp = data.get(position);
		// Locate the TextViews in listview_item.xml
		name = (TextView) itemView.findViewById(R.id.name_detail);
		total = (TextView) itemView.findViewById(R.id.total);
		geography= (TextView) itemView.findViewById(R.id.geography);
		history= (TextView) itemView.findViewById(R.id.history);
		chemistry= (TextView) itemView.findViewById(R.id.chemistry);
		english= (TextView) itemView.findViewById(R.id.english);
		//_id= (TextView) itemView.findViewById(R.id.id);
		student_position= (TextView) itemView.findViewById(R.id.position);
		biology= (TextView) itemView.findViewById(R.id.biology);
		kiswahili= (TextView) itemView.findViewById(R.id.kiswahili);
		physics= (TextView) itemView.findViewById(R.id.physics);
		math= (TextView) itemView.findViewById(R.id.math);
		average= (TextView) itemView.findViewById(R.id.avg);
		extra_activities= (TextView) itemView.findViewById(R.id.extracurr);

		// Locate the ImageView in listview_item.xml
		flag = (ImageView) itemView.findViewById(R.id.face);
		// Capture position and set results to the TextViews
//		name.setText(resultp.get(Report.NAME));
		total.setText(resultp.get(Report.TOTAL));
		geography.setText(resultp.get(Report.GEOGRAPHY));
		history.setText(resultp.get(Report.HISTORY));
		chemistry.setText(resultp.get(Report.CHEMISTRY));
		history.setText(resultp.get(Report.HISTORY));
		english.setText(resultp.get(Report.ENGLISH));
		student_position.setText(resultp.get(Report.POSITION));
		kiswahili.setText(resultp.get(Report.KISWAHILI));
		physics.setText(resultp.get(Report.PHYSICS));
		math.setText(resultp.get(Report.MATH));
		biology.setText(resultp.get(Report.BIOLOGY));
		//average.setText(resultp.get(Report.AVERAGE));
		extra_activities.setText(resultp.get(Report.EXTRACURRICULAR));

     	// Passes flag images URL into ImageLoader.class
		imageLoader.DisplayImage(resultp.get(Report.PROFILE_PIC), flag);

	/**	// Capture ListView item click
		itemView.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// Get the position
				resultp = data.get(position);
				Intent intent = new Intent(context, SingleItemView.class);
				// Pass all data id
				intent.putExtra("id", resultp.get(Report.RANK));
				// Pass all data name
				intent.putExtra("name", resultp.get(Report.NAME));
				// Pass all data math
				intent.putExtra("math",resultp.get(Report.MATH));
				// Pass all data english
				intent.putExtra("english",resultp.get(Report.ENGLISH));
				// Pass all data chemistry
				intent.putExtra("chemistry", resultp.get(Report.CHEMISTRY));
				// Pass all data physics
				intent.putExtra("physics", resultp.get(Report.PHYSICS));
				// Pass all data kiswahili
				intent.putExtra("kiswahili", resultp.get(Report.KISWAHILI));
				// Pass all data history
				intent.putExtra("history", resultp.get(Report.HISTORY));
				// Pass all data biology
				intent.putExtra("biology", resultp.get(Report.BIOLOGY));
				// Pass all data geography
				intent.putExtra("geography", resultp.get(Report.GEOGRAPHY));
				// Pass all data position
				intent.putExtra("position", resultp.get(Report.POSITION));
				// Pass all data total
				intent.putExtra("total", resultp.get(Report.TOTAL));
				// Start SingleItemView Class
				context.startActivity(intent);

			}
		});
		 **/
		return itemView;
	}
}
