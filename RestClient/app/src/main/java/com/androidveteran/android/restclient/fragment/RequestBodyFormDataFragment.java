package com.androidveteran.android.restclient.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.androidveteran.android.restclient.R;
import com.androidveteran.android.restclient.adapter.RequestBodyFormDataRecyclerAdapter;
import com.androidveteran.android.restclient.baseclass.BaseFragment;

import java.util.ArrayList;

import butterknife.Bind;

/**
 * A simple {@link Fragment} subclass.
 */
public class RequestBodyFormDataFragment extends BaseFragment {

    @Bind(R.id.rvRequestBodyFormData)
    RecyclerView mRecyclerView;

    public RequestBodyFormDataFragment() {
        // Required empty public constructor
    }

    @Override
    protected int getResourceLayout() {
        return R.layout.fragment_request_body_form_data;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ArrayList<FormData> formDataArrayList = new ArrayList<>();
        formDataArrayList.add(new FormData("username", "chintansoni"));
        formDataArrayList.add(new FormData("password", "chintan123"));
        formDataArrayList.add(new FormData("email", "chintansoni@gmail.com"));
        formDataArrayList.add(new FormData("mobile", "9876543210"));

        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView.setAdapter(new RequestBodyFormDataRecyclerAdapter(getActivity(), formDataArrayList));
    }

    public class FormData{
        private String key;
        private String value;

        public FormData(String key, String value) {
            this.key = key;
            this.value = value;
        }

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }
}