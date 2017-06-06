package net.simplifiedcoding.androidtablayout.UI_t;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import net.simplifiedcoding.androidtablayout.R;
import net.simplifiedcoding.androidtablayout.t_DataObject.Events_t;
import net.simplifiedcoding.androidtablayout.t_DetailActivity.Detail2Activity_t;

import java.util.ArrayList;


public class CustomAdapter_t extends BaseAdapter {

   Context c;
    ArrayList<Events_t> events;


    //TRYING
    public class ViewHolder{
        //ImageView image;
        TextView title;
        TextView time,id,snippet;
        LinearLayout card_t;
    }

    public CustomAdapter_t(Context c, ArrayList<Events_t> events) {
        this.c = c;
        this.events = events;
    }

    @Override
    public int getCount() {
        return events.size();
    }

    @Override
    public Object getItem(int position) {
        return events.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if(convertView==null)
        {
            convertView= LayoutInflater.from(c).inflate(R.layout.news_model,parent,false);

            //TRYING
            holder = new ViewHolder();
            holder.card_t = (LinearLayout) convertView.findViewById(R.id.card_t);
       //    holder.image = (ImageView)convertView.findViewById(R.id.MovieImage);
            holder.title = (TextView)convertView.findViewById(R.id.news_title);
            holder.time = (TextView)convertView.findViewById(R.id.news_time);
            holder.snippet = (TextView)convertView.findViewById(R.id.news_snippet);
            convertView.setTag(holder);
        }

        //ON main activity
        TextView NewsTitle = (TextView) convertView.findViewById(R.id.news_title);
        ImageView img = (ImageView) convertView.findViewById(R.id.ticket_MovieImage);
      //  TextView id = (TextView) convertView.findViewById(R.id.id);
        //TextView seats = (TextView) convertView.findViewById(R.id.seats);
        TextView time = (TextView) convertView.findViewById(R.id.news_time);
        final Events_t s = (Events_t) this.getItem(position);
        TextView snippet = (TextView) convertView.findViewById(R.id.news_snippet);

        //nameTxt.setText(s.getName());
      //  id.setText(i.getId());
        //seats.setText(j.getSeats());
        NewsTitle.setText(s.getTitle());
        time.setText("Published On: "+s.getTime());
        PicassoClient_t.downloadImage(c,s.getUrl(),img);
        snippet.setText(s.getDetail().substring(0,72)+"...");



convertView.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {

        openDetailActivity(s.getTitle(),s.getUrl(),s.getDetail(),s.getTime());
    }
});






        return convertView;
    }

    private void openDetailActivity(String name, String id, String seats, String time){
            Intent i = new Intent(c, Detail2Activity_t.class);




        //Pck datail
        i.putExtra("TITLE_KEY", name);
        i.putExtra("URL_KEY",id);
        i.putExtra("DETAILS_KEY",seats);
        i.putExtra("TIME_KEY",time);

        ((Activity)c).finish();

        c.startActivity(i);


    }


}
