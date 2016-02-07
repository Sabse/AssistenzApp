package com.uni_r.sabrina.assistapp.overview;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.RelativeLayout;

import com.uni_r.sabrina.assistapp.R;
import com.uni_r.sabrina.assistapp.SlidingTabLayout;
import com.uni_r.sabrina.assistapp.main.EmergencyCallActivity;
import com.uni_r.sabrina.assistapp.responseless.ResponselessActivity;

/**
 * Created by Sabse on 24.05.2015.
 * This class contains all buttons related to the overview topics (chest, head, injuries, stomach).
 * It sets up all the fragments per topic and embeds the emergency call.
 */
public class OverviewActivity extends EmergencyCallActivity{

    ViewPager pager;
    OverviewViewPagerAdapter adapter;
    SlidingTabLayout tabs;
    CharSequence Titles[]={"Verlet-\nzungen","Kopf", "Brust", "Bauch"};
    int Numboftabs =4;
    int fragmentValue;

    RelativeLayout contentLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_overview);

        Intent i= getIntent();
        Bundle b = i.getExtras();
        fragmentValue = (int)b.get("ButtonValue");

        // Creating The ViewPagerAdapter and Passing Fragment Manager, Titles fot the Tabs and Number Of Tabs.
        adapter =  new OverviewViewPagerAdapter(getSupportFragmentManager(),Titles,Numboftabs);

        // Assigning ViewPager View and setting the adapter.
        pager = (ViewPager) findViewById(R.id.overview_pager);
        pager.setAdapter(adapter);

        // Assigning the Sliding Tab Layout View.
        tabs = (SlidingTabLayout) findViewById(R.id.tabs);
        tabs.setDistributeEvenly(true); // To make the Tabs Fixed set this true, This makes the tabs Space Evenly in Available width.

        // Setting Custom Color for the Scroll bar indicator of the Tab View.
        tabs.setCustomTabColorizer(new SlidingTabLayout.TabColorizer() {
            @Override
            public int getIndicatorColor(int position) {
                return getResources().getColor(R.color.red);
            }
        });

        // Setting the ViewPager for the SlidingTabsLayout.
        tabs.setViewPager(pager);
        pager.setCurrentItem(fragmentValue);
    }

    public void startResponselessActivity(View v){
        // If responsless button in the footer is touched, open ResponslessActivity.
        Intent intent = new Intent(OverviewActivity.this, ResponselessActivity.class);
        startActivity(intent);
    }

    private final void focusOnView(final View v, final View v2){
        // Center actual content of open list entry in the screen.
        new Handler().post(new Runnable() {
            @Override
            public void run() {
                v.scrollTo(0, v2.getTop());
            }
        });
    }

    public void expandTitle(View v){
        // Depending on the list entry that is touched, show content and switch color.
        switch (v.getTag().toString()){
            case "injury2": contentLayout = (RelativeLayout) findViewById(R.id.injury_title_2_content);
                contentLayout.setVisibility(contentLayout.isShown() ? View.GONE : View.VISIBLE);
                if(contentLayout.isShown()){
                    v.setBackgroundColor(getResources().getColor(R.color.alert_red));
                    focusOnView(findViewById(R.id.injury_scroll), findViewById(R.id.injury_title_2));
                }else{
                    v.setBackgroundColor(getResources().getColor(R.color.light_red));
                }
                break;
            case "injury3": contentLayout = (RelativeLayout) findViewById(R.id.injury_title_3_content);
                contentLayout.setVisibility(contentLayout.isShown() ? View.GONE : View.VISIBLE);
                if(contentLayout.isShown()){
                    v.setBackgroundColor(getResources().getColor(R.color.alert_red));
                    focusOnView(findViewById(R.id.injury_scroll), findViewById(R.id.injury_title_3));
                }else{
                    v.setBackgroundColor(getResources().getColor(R.color.light_red));
                }
                break;
            case "injury4": contentLayout = (RelativeLayout) findViewById(R.id.injury_title_4_content);
                contentLayout.setVisibility(contentLayout.isShown() ? View.GONE : View.VISIBLE);
                if(contentLayout.isShown()){
                    v.setBackgroundColor(getResources().getColor(R.color.alert_red));
                    focusOnView(findViewById(R.id.injury_scroll), findViewById(R.id.injury_title_4));
                }else{
                    v.setBackgroundColor(getResources().getColor(R.color.light_red));
                }
                break;
            case "injury5": contentLayout = (RelativeLayout) findViewById(R.id.injury_title_5_content);
                contentLayout.setVisibility(contentLayout.isShown() ? View.GONE : View.VISIBLE);
                if(contentLayout.isShown()){
                    v.setBackgroundColor(getResources().getColor(R.color.alert_red));
                    focusOnView(findViewById(R.id.injury_scroll), findViewById(R.id.injury_title_5));
                }else{
                    v.setBackgroundColor(getResources().getColor(R.color.light_red));
                }
                break;
            case "injury6": contentLayout = (RelativeLayout) findViewById(R.id.injury_title_6_content);
                contentLayout.setVisibility(contentLayout.isShown() ? View.GONE : View.VISIBLE);
                if(contentLayout.isShown()){
                    v.setBackgroundColor(getResources().getColor(R.color.alert_red));
                    focusOnView(findViewById(R.id.injury_scroll), findViewById(R.id.injury_title_6));
                }else{
                    v.setBackgroundColor(getResources().getColor(R.color.light_red));
                }
                break;
            case "injury7": contentLayout = (RelativeLayout) findViewById(R.id.injury_title_7_content);
                contentLayout.setVisibility(contentLayout.isShown() ? View.GONE : View.VISIBLE);
                if(contentLayout.isShown()){
                    v.setBackgroundColor(getResources().getColor(R.color.alert_red));
                    focusOnView(findViewById(R.id.injury_scroll), findViewById(R.id.injury_title_7));
                }else{
                    v.setBackgroundColor(getResources().getColor(R.color.light_red));
                }
                break;

            case "head1": contentLayout = (RelativeLayout) findViewById(R.id.head_title_1_content);
                contentLayout.setVisibility(contentLayout.isShown() ? View.GONE : View.VISIBLE);
                if(contentLayout.isShown()){
                    v.setBackgroundColor(getResources().getColor(R.color.alert_red));
                    focusOnView(findViewById(R.id.head_scroll), findViewById(R.id.head_title_1));
                }else{
                    v.setBackgroundColor(getResources().getColor(R.color.light_red));
                }
                break;
            case "head2": contentLayout = (RelativeLayout) findViewById(R.id.head_title_2_content);
                contentLayout.setVisibility(contentLayout.isShown() ? View.GONE : View.VISIBLE);
                if(contentLayout.isShown()){
                    v.setBackgroundColor(getResources().getColor(R.color.alert_red));
                    focusOnView(findViewById(R.id.head_scroll), findViewById(R.id.head_title_2));
                }else{
                    v.setBackgroundColor(getResources().getColor(R.color.light_red));
                }
                break;
            case "head3": contentLayout = (RelativeLayout) findViewById(R.id.head_title_3_content);
                contentLayout.setVisibility(contentLayout.isShown() ? View.GONE : View.VISIBLE);
                if(contentLayout.isShown()){
                    v.setBackgroundColor(getResources().getColor(R.color.alert_red));
                    focusOnView(findViewById(R.id.head_scroll), findViewById(R.id.head_title_3));
                }else{
                    v.setBackgroundColor(getResources().getColor(R.color.light_red));
                }
                break;

            case "chest1": contentLayout = (RelativeLayout) findViewById(R.id.chest_title_1_content);
                contentLayout.setVisibility(contentLayout.isShown() ? View.GONE : View.VISIBLE);
                if(contentLayout.isShown()){
                    v.setBackgroundColor(getResources().getColor(R.color.alert_red));
                    focusOnView(findViewById(R.id.chest_scroll), findViewById(R.id.chest_title_1));
                }else{
                    v.setBackgroundColor(getResources().getColor(R.color.light_red));
                }
                break;
            case "chest2": contentLayout = (RelativeLayout) findViewById(R.id.chest_title_2_content);
                contentLayout.setVisibility(contentLayout.isShown() ? View.GONE : View.VISIBLE);
                if(contentLayout.isShown()){
                    v.setBackgroundColor(getResources().getColor(R.color.alert_red));
                    focusOnView(findViewById(R.id.chest_scroll), findViewById(R.id.chest_title_2));
                }else{
                    v.setBackgroundColor(getResources().getColor(R.color.light_red));
                }
                break;
            case "chest3": contentLayout = (RelativeLayout) findViewById(R.id.chest_title_3_content);
                contentLayout.setVisibility(contentLayout.isShown() ? View.GONE : View.VISIBLE);
                if(contentLayout.isShown()){
                    v.setBackgroundColor(getResources().getColor(R.color.alert_red));
                    focusOnView(findViewById(R.id.chest_scroll), findViewById(R.id.chest_title_3));
                }else{
                    v.setBackgroundColor(getResources().getColor(R.color.light_red));
                }
                break;
            case "chest4": contentLayout = (RelativeLayout) findViewById(R.id.chest_title_4_content);
                contentLayout.setVisibility(contentLayout.isShown() ? View.GONE : View.VISIBLE);
                if(contentLayout.isShown()){
                    v.setBackgroundColor(getResources().getColor(R.color.alert_red));
                    focusOnView(findViewById(R.id.chest_scroll), findViewById(R.id.chest_title_4));
                }else{
                    v.setBackgroundColor(getResources().getColor(R.color.light_red));
                }
                break;

            case "stomach1": contentLayout = (RelativeLayout) findViewById(R.id.stomach_title_1_content);
                contentLayout.setVisibility(contentLayout.isShown() ? View.GONE : View.VISIBLE);
                if(contentLayout.isShown()){
                    v.setBackgroundColor(getResources().getColor(R.color.alert_red));
                    focusOnView(findViewById(R.id.stomach_scroll), findViewById(R.id.stomach_title_1));
                }else{
                    v.setBackgroundColor(getResources().getColor(R.color.light_red));
                }
                break;
            case "stomach2": contentLayout = (RelativeLayout) findViewById(R.id.stomach_title_2_content);
                contentLayout.setVisibility(contentLayout.isShown() ? View.GONE : View.VISIBLE);
                if(contentLayout.isShown()){
                    v.setBackgroundColor(getResources().getColor(R.color.alert_red));
                    focusOnView(findViewById(R.id.stomach_scroll), findViewById(R.id.stomach_title_2));
                }else{
                    v.setBackgroundColor(getResources().getColor(R.color.light_red));
                }
                break;

            default: break;
        }
    }
}
