package com.androidveteran.android.restclient.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;

import com.androidveteran.android.restclient.R;
import com.androidveteran.android.restclient.adapter.RequestBodyPagerAdapter;
import com.androidveteran.android.restclient.baseclass.BaseFragment;
import com.androidveteran.android.restclient.utils.SharedPreferencesUtils;

import butterknife.Bind;

public class RequestFragment extends BaseFragment {
//    private OnFragmentInteractionListener mListener;

    @Bind(R.id.spRequestMethod)
    Spinner mSpinnerMethod;

    @Bind(R.id.etRequestUrl)
    EditText mEditTextUrl;

    @Bind(R.id.llRequestHeaders)
    LinearLayout mLinearLayoutHeaders;

    @Bind(R.id.llRequestParameters)
    LinearLayout mLinearLayoutParameters;

    @Bind(R.id.vpRequestBody)
    ViewPager mViewPagerBody;

    public RequestFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int getResourceLayout() {
        return R.layout.fragment_request;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mViewPagerBody.setAdapter(new RequestBodyPagerAdapter(getFragmentManager()));
    }

    // TODO: Rename method, update argument and hook method into UI event
//    public void onButtonPressed(Uri uri) {
//        if (mListener != null) {
//            mListener.onFragmentInteraction(uri);
//        }
//    }

//    @Override
//    public void onAttach(Context context) {
//        super.onAttach(context);
//        if (context instanceof OnFragmentInteractionListener) {
//            mListener = (OnFragmentInteractionListener) context;
//        } else {
//            throw new RuntimeException(context.toString()
//                    + " must implement OnFragmentInteractionListener");
//        }
//    }

//    @Override
//    public void onDetach() {
//        super.onDetach();
//        mListener = null;
//    }

//    public interface OnFragmentInteractionListener {
//        void onFragmentInteraction(Uri uri);
//    }
}
