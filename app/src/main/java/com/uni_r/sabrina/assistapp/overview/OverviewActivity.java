package com.uni_r.sabrina.assistapp.overview;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.uni_r.sabrina.assistapp.R;
import com.uni_r.sabrina.assistapp.SlidingTabLayout;

/**
 * Created by Sabse on 24.05.2015.
 */
public class OverviewActivity extends AppCompatActivity{

    ViewPager pager;
    OverviewViewPagerAdapter adapter;
    SlidingTabLayout tabs;
    CharSequence Titles[]={"Verlet-\nzungen","Kopf", "Brust", "Bauch"};
    int Numboftabs =4;
    int fragmentValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_overview);

        Intent i= getIntent();
        Bundle b = i.getExtras();
        fragmentValue = (int)b.get("ButtonValue");


        // Creating The ViewPagerAdapter and Passing Fragment Manager, Titles fot the Tabs and Number Of Tabs.
        adapter =  new OverviewViewPagerAdapter(getSupportFragmentManager(),Titles,Numboftabs);

        // Assigning ViewPager View and setting the adapter
        pager = (ViewPager) findViewById(R.id.overview_pager);
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
        pager.setCurrentItem(fragmentValue);
    }

}
