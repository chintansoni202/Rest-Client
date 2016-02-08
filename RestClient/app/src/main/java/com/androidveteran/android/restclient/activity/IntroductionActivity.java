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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_introduction);

        findViewsById();

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
                        break;
                    case 1:
                        mRadioGroup.check(R.id.rbIntroduction1);
                        break;
                    case 2:
                        mRadioGroup.check(R.id.rbIntroduction2);
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
    }

    private void findViewsById() {
        mViewPager = (ViewPager) findViewById(R.id.vpIntroduction);
        mButtonSkip = (Button) findViewById(R.id.btnIntroductionSkip);
        mRadioGroup = (RadioGroup) findViewById(R.id.rgIntroduction);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnIntroductionSkip:
                launchActivity(LoginActivity.class);
                break;
            case R.id.btnIntroductionNext:

                break;
        }
    }
}