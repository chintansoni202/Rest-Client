package com.androidveteran.android.restclient.baseclass;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.Toast;

import com.androidveteran.android.restclient.R;

/**
 * Created by chint on 04-02-2016.
 */
public abstract class BaseAppCompatActivity extends AppCompatActivity {

    private ProgressDialog mProgressDialog;
    private Toolbar mToolbar;
    private TabLayout mTabLayout;

    private boolean hasToolBar;
    private boolean hasTabLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutResourceId());
        initiateViews();
    }

    protected abstract int getLayoutResourceId();

    protected abstract void initiateViews();

    public void setHasToolBar(boolean hasToolBar) {
        this.hasToolBar = hasToolBar;
    }

    public void initToolBar() {
        if (hasToolBar) {
            mToolbar = (Toolbar) findViewById(R.id.toolbar);
            setSupportActionBar(mToolbar);
        }
    }

    public Toolbar getToolBar() {
        return mToolbar;
    }

    public void setHasTabLayout(boolean hasTabLayout) {
        this.hasTabLayout = hasTabLayout;
    }

    public void initTabLayout() {
        if (hasTabLayout) {
            mTabLayout = (TabLayout) findViewById(R.id.tabLayout);
        }
    }

    public void showProgressDialog() {
        mProgressDialog = ProgressDialog.show(this, "Loading", "Please wait...", true, false);
    }

    public void hideProgressDialog() {
        if (mProgressDialog != null && mProgressDialog.isShowing()) {
            mProgressDialog.dismiss();
        }
    }

    public void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    public void logInformation(Class tag, String description) {
        Log.i(tag.getName(), description);
    }

    public void logError(Class tag, String description) {
        Log.e(tag.getName(), description);
    }

    public void logDebug(Class tag, String description) {
        Log.d(tag.getName(), description);
    }

    public void launchActivity(Class activity, Bundle bundle) {
        Intent intent = new Intent(this, activity);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        startActivity(intent);
    }

    public void launchActivity(Class activity) {
        launchActivity(activity, null);
    }

    public void loadFragment() {
    }

    public String getStringResource(int key) {
        return getResources().getString(key);
    }
}
