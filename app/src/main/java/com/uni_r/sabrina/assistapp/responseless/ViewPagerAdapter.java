package com.uni_r.sabrina.assistapp.responseless;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by Sabse on 24.05.2015.
 * Adapter to setup logic behind fragments.
 */
public class ViewPagerAdapter extends FragmentStatePagerAdapter {

    String Titles[];
    int NumbOfTabs;

    public ViewPagerAdapter(FragmentManager fm,String mTitles[], int mNumbOfTabsumb) {
        super(fm);
        // Store passed values.
        this.Titles = mTitles;
        this.NumbOfTabs = mNumbOfTabsumb;
    }

    @Override
    public Fragment getItem(int position) {
        //Return the fragment for every position in the View Pager
        if(position == 0)
        {
            BreathActiveFragment baf = new BreathActiveFragment();
            return baf;
        }
        else if(position == 1)
        {
            BreathCheckFragment bcf = new BreathCheckFragment();
            return bcf;
        }
        else
        {
            BreathInactiveFragment bif = new BreathInactiveFragment();
            return bif;
        }
    }

    @Override
    public String getPageTitle(int position) {
        // Return Titles for tab on this position.
        return Titles[position];
    }

    @Override
    public int getCount() {
        // Return number of tabs.
        return NumbOfTabs;
    }
}
