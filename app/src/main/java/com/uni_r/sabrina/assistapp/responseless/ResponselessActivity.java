package com.uni_r.sabrina.assistapp.responseless;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import com.uni_r.sabrina.assistapp.R;
import com.uni_r.sabrina.assistapp.SlidingTabLayout;
import com.uni_r.sabrina.assistapp.main.EmergencyCallActivity;

/**
 * Created by Sabse on 23.05.2015.
 * This class manages the fragments about breath check, no breath and breath active.
 * It is therefore needed to help the user to run through the right actions.
 * Emergency Call is embedded.
 */
public class ResponselessActivity extends EmergencyCallActivity {

    ViewPager pager;
    ViewPagerAdapter adapter;
    ImageView playButton;
    SlidingTabLayout tabs;
    String Titles[]={"Atmung \naktiv", "Atmung \nprüfen", "Atmung \ninaktiv"};
    int Numboftabs =3;
    MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_responseless);

        // Creating The ViewPagerAdapter and Passing Fragment Manager, Titles fot the Tabs and Number Of Tabs.
        adapter =  new ViewPagerAdapter(getSupportFragmentManager(),Titles,Numboftabs);

        // Assigning ViewPager View and setting the adapter.
        pager = (ViewPager) findViewById(R.id.responseless_pager);
        pager.setAdapter(adapter);

        // Assiging the Sliding Tab Layout View
        tabs = (SlidingTabLayout) findViewById(R.id.tabs);
        tabs.setDistributeEvenly(true); // To make the Tabs Fixed set this true, This makes the tabs Space Evenly in Available width.

        // Setting Custom Color for the Scroll bar indicator of the Tab View.
        tabs.setCustomTabColorizer(new SlidingTabLayout.TabColorizer() {
            @Override
            public int getIndicatorColor(int position) {
                return getResources().getColor(R.color.red);
            }
        });

        // Setting the ViewPager For the SlidingTabsLayout.
        tabs.setViewPager(pager);
        pager.setCurrentItem(1, false);

        //Start media player.
        mp = MediaPlayer.create(this, R.raw.snare2);
    }

    public void showActiveFrag(View v){
        // Switch to BreathActiveFragment.
        pager.setCurrentItem(0,false);
    }

    public void showInactiveFrag(View v){
        // Switch to BreathInactiveFragment.
        pager.setCurrentItem(2,false);
    }


    public void playSound(View v){
        // Called when button vor playing audio touched.
        playButton = (ImageView) findViewById(R.id.play_button);

        // If media player is playing while pushed, change button image back to play image and pause audio.
        if(mp.isPlaying()){
            playButton.setImageResource(R.drawable.ic_play_button);
            mp.pause();

        } else {
            // Loop audio, change button image to pause image and play audio.
            mp.setLooping(true);
            try {
                playButton.setImageResource(R.drawable.ic_pause_button);
                mp.start();
            } catch (IllegalStateException e) {
                e.printStackTrace();
            }
        }
    }
}


