package com.androidveteran.android.restclient.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.androidveteran.android.restclient.R;
import com.androidveteran.android.restclient.baseclass.BaseFragment;
import com.androidveteran.android.restclient.customview.RobotoEditText;

import butterknife.Bind;

/**
 * A simple {@link Fragment} subclass.
 */
public class RequestBodyRawFragment extends BaseFragment {

    @Bind(R.id.etRequestBodyRaw)
    RobotoEditText mEditText;

    public RequestBodyRawFragment() {
        // Required empty public constructor
    }

    @Override
    protected int getResourceLayout() {
        return R.layout.fragment_request_body_raw;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }
}
