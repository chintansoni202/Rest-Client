package com.androidveteran.android.restclient.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.androidveteran.android.restclient.fragment.RequestFragment;
import com.androidveteran.android.restclient.fragment.ResponseFragment;

/**
 * Created by chint on 3/20/2016.
 */
public class HomePagerAdapter extends FragmentPagerAdapter {

    public HomePagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                return new RequestFragment();
            case 1:
                return new ResponseFragment();
        }
        return null;
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "Request";
            case 1:
                return "Response";
        }
        return null;
    }
}
