package com.androidveteran.android.restclient.activity;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;

import com.androidveteran.android.restclient.R;
import com.androidveteran.android.restclient.adapter.IntroductionFragmentPagerAdapter;
import com.androidveteran.android.restclient.baseclass.BaseAppCompatActivity;

public class IntroductionActivity extends BaseAppCompatActivity implements View.OnClickListener {

    private ViewPager mViewPager;
    private RadioGroup mRadioGroup;
    private Button mButtonSkip;
    private Button mButtonDone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasToolBar(false);
        setContentView(R.layout.activity_introduction);

        IntroductionFragmentPagerAdapter introductionFragmentPagerAdapter = new IntroductionFragmentPagerAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(introductionFragmentPagerAdapter);
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        mRadioGroup.check(R.id.rbIntroduction0);
                        mButtonSkip.setVisibility(View.VISIBLE);
                        mButtonDone.setText(getStringResource(R.string.string_next_arrow));
                        break;
                    case 1:
                        mRadioGroup.check(R.id.rbIntroduction1);
                        mButtonSkip.setVisibility(View.VISIBLE);
                        mButtonDone.setText(getStringResource(R.string.string_next_arrow));
                        break;
                    case 2:
                        mRadioGroup.check(R.id.rbIntroduction2);
                        mButtonSkip.setVisibility(View.INVISIBLE);
                        mButtonDone.setText(getStringResource(R.string.string_done));
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        mRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rbIntroduction0:
                        mViewPager.setCurrentItem(0, true);
                        break;
                    case R.id.rbIntroduction1:
                        mViewPager.setCurrentItem(1, true);
                        break;
                    case R.id.rbIntroduction2:
                        mViewPager.setCurrentItem(2, true);
                        break;
                }
            }
        });

        mButtonSkip.setOnClickListener(this);
        mButtonDone.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnIntroductionSkip:
                launchActivity(LoginActivity.class);
                break;
            case R.id.btnIntroductionNext:
                mViewPager.setCurrentItem(
                        mViewPager.getCurrentItem() == 2
                                ? 0
                                : mViewPager.getCurrentItem() + 1
                        , true);
                break;
        }
    }

    @Override
    public int getLayoutResourceId() {
        return 0;
    }

    @Override
    protected void initiateViews() {
        mViewPager = (ViewPager) findViewById(R.id.vpIntroduction);
        mButtonSkip = (Button) findViewById(R.id.btnIntroductionSkip);
        mRadioGroup = (RadioGroup) findViewById(R.id.rgIntroduction);
        mButtonDone = (Button) findViewById(R.id.btnIntroductionNext);
    }
}