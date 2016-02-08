package com.androidveteran.android.restclient.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.androidveteran.android.restclient.fragment.IntroductionFragment;

/**
 * Created by chintan on 08-02-2016.
 */
public class IntroductionFragmentPagerAdapter extends FragmentPagerAdapter {

    public IntroductionFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return IntroductionFragment.newInstance(position);
    }

    @Override
    public int getCount() {
        return 3;
    }
}