package com.androidveteran.android.restclient.baseclass;

import android.app.Application;

import com.activeandroid.ActiveAndroid;

/**
 * Created by chint on 14-02-2016.
 */
public class BaseApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        initDatabase();
    }

    /**
     * Initialize the Active Android
     **/
    private void initDatabase() {
        ActiveAndroid.initialize(this, true);
    }
}
