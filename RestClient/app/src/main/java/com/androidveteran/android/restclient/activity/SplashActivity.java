package com.androidveteran.android.restclient.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.ActivityOptionsCompat;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.androidveteran.android.restclient.R;
import com.androidveteran.android.restclient.baseclass.BaseAppCompatActivity;

import butterknife.Bind;

public class SplashActivity extends BaseAppCompatActivity {

    @Bind(R.id.btnSplash)
    Button mButton;

    @Bind(R.id.ivSplash)
    ImageView mImageView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SplashActivity.this, LoginActivity.class);
                ActivityOptionsCompat options = ActivityOptionsCompat.
                        makeSceneTransitionAnimation(SplashActivity.this, mImageView, "appLogo");
                startActivity(intent, options.toBundle());
            }
        });

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                mButton.setVisibility(View.VISIBLE);
            }
        }, 4000);
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_splash;
    }
}