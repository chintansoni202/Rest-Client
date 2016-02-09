package com.androidveteran.android.restclient.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.androidveteran.android.restclient.R;
import com.androidveteran.android.restclient.baseclass.BaseAppCompatActivity;

public class SplashActivity extends BaseAppCompatActivity {

    // For logging purpose
    public final String TAG = getClass().getName();
    // Context - current class
    private Context mContext = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(mContext, IntroductionActivity.class));
            }
        }, 4000);
    }
}