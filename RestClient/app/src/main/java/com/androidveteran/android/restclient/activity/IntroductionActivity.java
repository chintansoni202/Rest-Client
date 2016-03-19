package com.androidveteran.android.restclient.activity;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;

import com.androidveteran.android.restclient.R;
import com.androidveteran.android.restclient.adapter.IntroductionFragmentPagerAdapter;
import com.androidveteran.android.restclient.baseclass.BaseAppCompatActivity;

import butterknife.Bind;
import butterknife.OnClick;

public class IntroductionActivity extends BaseAppCompatActivity {

    @Bind(R.id.vpIntroduction)
    ViewPager mViewPager;

    @Bind(R.id.rgIntroduction)
    RadioGroup mRadioGroup;

    @Bind(R.id.btnIntroductionSkip)
    Button mButtonSkip;

    @Bind(R.id.btnIntroductionNext)
    Button mButtonNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

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
                        mButtonNext.setText(getStringResource(R.string.string_next_arrow));
                        break;
                    case 1:
                        mRadioGroup.check(R.id.rbIntroduction1);
                        mButtonSkip.setVisibility(View.VISIBLE);
                        mButtonNext.setText(getStringResource(R.string.string_next_arrow));
                        break;
                    case 2:
                        mRadioGroup.check(R.id.rbIntroduction2);
                        mButtonSkip.setVisibility(View.INVISIBLE);
                        mButtonNext.setText(getStringResource(R.string.string_done));
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
    }

    @OnClick(R.id.btnIntroductionSkip)
    public void skip() {
        launchActivity(LoginActivity.class);
    }

    @OnClick(R.id.btnIntroductionNext)
    public void next() {
        if (mViewPager.getCurrentItem() == 2) {
            launchActivity(HomeActivity.class);
        } else {
            mViewPager.setCurrentItem(mViewPager.getCurrentItem() + 1, true);
        }
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_introduction;
    }
}