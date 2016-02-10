package com.androidveteran.android.restclient.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.androidveteran.android.restclient.R;
import com.androidveteran.android.restclient.baseclass.BaseFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeHostFragment extends BaseFragment {

    public HomeHostFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home_host, container, false);
    }

}
