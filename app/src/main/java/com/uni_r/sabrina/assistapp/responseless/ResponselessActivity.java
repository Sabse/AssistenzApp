package com.uni_r.sabrina.assistapp.responseless;


import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.SoundEffectConstants;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.uni_r.sabrina.assistapp.R;
import com.uni_r.sabrina.assistapp.SlidingTabLayout;
import com.uni_r.sabrina.assistapp.main.EmergencyCallActivity;
import com.uni_r.sabrina.assistapp.responseless.ViewPagerAdapter;

import java.io.IOException;

/**
 * Created by Sabse on 23.05.2015.
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

        // Assigning ViewPager View and setting the adapter
        pager = (ViewPager) findViewById(R.id.responseless_pager);
        pager.setAdapter(adapter);

        // Assiging the Sliding Tab Layout View
        tabs = (SlidingTabLayout) findViewById(R.id.tabs);
        tabs.setDistributeEvenly(true); // To make the Tabs Fixed set this true, This makes the tabs Space Evenly in Available width

        // Setting Custom Color for the Scroll bar indicator of the Tab View
        tabs.setCustomTabColorizer(new SlidingTabLayout.TabColorizer() {
            @Override
            public int getIndicatorColor(int position) {
                return getResources().getColor(R.color.red);
            }
        });

        // Setting the ViewPager For the SlidingTabsLayout
        tabs.setViewPager(pager);
        pager.setCurrentItem(1, false);

        mp = MediaPlayer.create(this, R.raw.snare2);

    }

    public void showActiveFrag(View v){
        pager.setCurrentItem(0,false);
    }

    public void showInactiveFrag(View v){
        pager.setCurrentItem(2,false);
    }

    public void playSound(View v){

        playButton = (ImageView) findViewById(R.id.play_button);

        if(mp.isPlaying()){
            playButton.setImageResource(R.drawable.ic_play_button);
            mp.pause();

        } else {
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


