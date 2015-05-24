package com.uni_r.sabrina.assistapp.responseless;

/**
 * Created by Sabse on 24.05.2015.
 */
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class ViewPagerAdapter extends FragmentStatePagerAdapter {

    String Titles[]; // This will Store the Titles of the Tabs which are Going to be passed when ViewPagerAdapter is created
    int NumbOfTabs; // Store the number of tabs, this will also be passed when the ViewPagerAdapter is created


    // Build a Constructor and assign the passed Values to appropriate values in the class
    public ViewPagerAdapter(FragmentManager fm,String mTitles[], int mNumbOfTabsumb) {
        super(fm);

        this.Titles = mTitles;
        this.NumbOfTabs = mNumbOfTabsumb;

    }

    //This method return the fragment for the every position in the View Pager
    @Override
    public Fragment getItem(int position) {

        if(position == 0) // if the position is 0 we are returning the First tab
        {
            BreathActiveFragment baf = new BreathActiveFragment();
            return baf;
        }
        else if(position == 1)            // As we are having 2 tabs if the position is now 0 it must be 1 so we are returning second tab
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

    // This method return the titles for the Tabs in the Tab Strip

    @Override
    public String getPageTitle(int position) {
        return Titles[position];
    }

    // This method return the Number of tabs for the tabs Strip

    @Override
    public int getCount() {
        return NumbOfTabs;
    }
}
