package net.simplifiedcoding.androidtablayout;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

import static net.simplifiedcoding.androidtablayout.Login.MY_PREFS_NAME;

//Implementing the interface OnTabSelectedListener to our MainActivity
//This interface would help in swiping views
public class MainActivity extends AppCompatActivity implements TabLayout.OnTabSelectedListener {

    //This is our tablayout
    private TabLayout tabLayout;

    //This is our viewPager
    private ViewPager viewPager;
    TextView mTitle;


    final int[] ICONS = new int[]{
            R.drawable.home_selector,
            R.drawable.gallery_selector,
            R.drawable.result_selector};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Adding toolbar to the activity
        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Initializing the tablayout
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);

        //Adding the tabs using addTab() method
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.home_selector));
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.gallery_selector));
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.result_selector));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);


       //Initializing viewPager
        viewPager = (ViewPager) findViewById(R.id.pager);

        //Creating our pager adapter
        Pager adapter = new Pager(getSupportFragmentManager(), tabLayout.getTabCount());

        //Adding adapter to pager
        viewPager.setAdapter(adapter);

        //Adding onTabSelectedListener to swipe views
        tabLayout.setOnTabSelectedListener(this);
/**
       viewPager.setOnTouchListener(new View.OnTouchListener()
        {
            @Override
            public boolean onTouch(View v, MotionEvent event)
            {
                return true;
            }

        });

 **/

        mTitle = (TextView) toolbar.findViewById(R.id.toolbar_title);

       String fontPath = "fonts/Comfortaa.ttf";
        Typeface tf = Typeface.createFromAsset(getAssets(), fontPath);
        mTitle.setTypeface(tf);




        setSupportActionBar(toolbar);
        mTitle.setText(toolbar.getTitle());
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        //Setting the default title
        ((MainActivity.this)).setActionBarTitle("Home");

        //try ting to change the actionbar
        //tabLayout.setupWithViewPager(viewPager);

        //setting the wordsin  the title
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(
                tabLayout));

//setitng the icons
     /**   tabLayout.setupWithViewPager(viewPager);
        for (int i = 0; i < tabLayout.getTabCount(); i++) {
            tabLayout.getTabAt(i).setIcon(ICONS[i]);
        }

**/
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
                //Set title here using setTitle()
                switch(tab.getPosition())
                {
                    case 0:
                        ((MainActivity.this)).setActionBarTitle("Home");
                        break;
                    case 1:
                        ((MainActivity.this)).setActionBarTitle("Gallery");
                        break;
                    case 2:
                        ((MainActivity.this)).setActionBarTitle("Result");
                        break;
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });





    }

    public void setActionBarTitle(String title){
        mTitle.setText(title);
    }


    @Override
    public void onTabSelected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main, menu);
        // return true so that the menu pop up is opened
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {

            case R.id.action_about:

                Intent abtIntent = new Intent(this,About.class);
                startActivity(abtIntent);
              //  Toast.makeText(getApplicationContext(),"about",Toast.LENGTH_SHORT).show();
                break;

            case R.id.action_settings:

                Intent settingIntent = new Intent(this,Settings.class);
                startActivity(settingIntent);
//              Toast.makeText(getApplicationContext(),"settings",Toast.LENGTH_SHORT).show();
                break;

        case R.id.action_log_out:


            //Logging out

            //SHared preference to take the Username when the usr has successfully login in to the system
            SharedPreferences.Editor editor = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE).edit();
            editor.clear();
            editor.commit();

            Intent logOutIntent = new Intent(this,Login.class);
            finish();
            startActivity(logOutIntent);
//              Toast.makeText(getApplicationContext(),"settings",Toast.LENGTH_SHORT).show();
        break;
    }
        return super.onOptionsItemSelected(item);
    }
/**
    @Override
    public void onBackPressed() {
        //do nothing


    }
    **/
}
