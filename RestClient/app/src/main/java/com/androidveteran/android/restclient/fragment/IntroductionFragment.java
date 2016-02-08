package com.androidveteran.android.restclient.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.androidveteran.android.restclient.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class IntroductionFragment extends Fragment {

    public static final String KEY_POSITION = "position";

    private int position;

    private ImageView mImageView;
    private TextView mTextView;

    public IntroductionFragment() {
        // Required empty public constructor
    }

    public static IntroductionFragment newInstance(int position) {
        Bundle bundle = new Bundle();
        bundle.putInt(KEY_POSITION, position);
        IntroductionFragment introductionFragment = new IntroductionFragment();
        introductionFragment.setArguments(bundle);
        return introductionFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null)
            position = getArguments().getInt(KEY_POSITION);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_introduction, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        findViewsByIds(view);

        switch (position) {
            case 0:
                setImageAndText(R.drawable.ic_looks_one_black_48dp, "One");
                break;
            case 1:
                setImageAndText(R.drawable.ic_looks_two_black_48dp, "Two");
                break;
            case 2:
                setImageAndText(R.drawable.ic_looks_three_black_48dp, "Three");
                break;
        }
    }

    private void findViewsByIds(View view) {
        mImageView = (ImageView) view.findViewById(R.id.ivIntroduction);
        mTextView = (TextView) view.findViewById(R.id.tvIntroduction);
    }

    private void setImageAndText(int imageResource, String description) {
        mImageView.setImageResource(imageResource);
        mTextView.setText(description);
    }
}
