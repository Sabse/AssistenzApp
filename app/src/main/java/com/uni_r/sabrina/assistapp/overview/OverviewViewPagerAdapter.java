package com.uni_r.sabrina.assistapp.overview;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by Sabse on 24.05.2015.
 * This class is needed to setup fragments correctly.
 */
public class OverviewViewPagerAdapter extends FragmentStatePagerAdapter {
    CharSequence Titles[]; // This will Store the Titles of the Tabs which are Going to be passed when ViewPagerAdapter is created
    int NumbOfTabs; // Store the number of tabs, this will also be passed when the ViewPagerAdapter is created

    // Build a Constructor and assign the passed Values to appropriate values in the class
    public OverviewViewPagerAdapter(FragmentManager fm,CharSequence mTitles[], int mNumbOfTabsumb) {
        super(fm);

        this.Titles = mTitles;
        this.NumbOfTabs = mNumbOfTabsumb;
    }


    @Override
    public Fragment getItem(int position) {
        // Return the fragment for every position in the View Pager.
        if(position == 0)
        {
            InjuryFragment injuryFrag = new InjuryFragment();
            return injuryFrag;
        }
        else if(position == 1)
        {
            HeadFragment headFrag = new HeadFragment();
            return headFrag;
        }
        else if(position == 2)
        {
            ChestFragment chestFrag = new ChestFragment();
            return chestFrag;
        }
        else
        {
            StomachFragment stomachFrag = new StomachFragment();
            return stomachFrag;
        }
    }

    @Override
    public CharSequence getPageTitle(int position) {
        // Return the titles for the Tabs in the Tab Strip.
        return Titles[position];
    }

    @Override
    public int getCount() {
        // Return the Number of tabs for the tabs Strip.
        return NumbOfTabs;
    }
}
