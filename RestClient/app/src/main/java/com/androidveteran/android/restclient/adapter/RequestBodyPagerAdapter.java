package com.androidveteran.android.restclient.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.androidveteran.android.restclient.fragment.RequestBodyFormDataFragment;
import com.androidveteran.android.restclient.fragment.RequestBodyRawFragment;

/**
 * Created by chint on 3/21/2016.
 */
public class RequestBodyPagerAdapter extends FragmentPagerAdapter {

    public RequestBodyPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                return new RequestBodyRawFragment();
            case 1:
                return new RequestBodyFormDataFragment();
        }

        return null;
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0:
                return "Raw";
            case 1:
                return "Form Data";
        }
        return "";
    }
}
