package com.androidveteran.android.restclient.baseclass;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.Toast;

import com.activeandroid.ActiveAndroid;
import com.androidveteran.android.restclient.R;

/**
 * Created by chint on 04-02-2016.
 */
public abstract class BaseAppCompatActivity extends AppCompatActivity {

    private ProgressDialog mProgressDialog;

    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);

        initToolBar();

        initDatabase();
    }

    private void initDatabase() {
        ActiveAndroid.initialize(this);
    }

    public void initToolBar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
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
}
