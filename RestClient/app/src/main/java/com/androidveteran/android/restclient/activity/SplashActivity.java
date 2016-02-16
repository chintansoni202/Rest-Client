package com.androidveteran.android.restclient.activity;

import android.content.Context;
import android.os.Bundle;

import com.androidveteran.android.restclient.R;
import com.androidveteran.android.restclient.baseclass.BaseAppCompatActivity;

public class SplashActivity extends BaseAppCompatActivity {

    private Context mContext = this;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_splash);

//        new Handler().postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                startActivity(new Intent(mContext, IntroductionActivity.class));
//            }
//        }, 4000);
    }

    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_splash;
    }

    @Override
    protected void initiateViews() {
        setHasToolBar(false);
    }
}