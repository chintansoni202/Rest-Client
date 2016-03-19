package com.androidveteran.android.restclient.activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.androidveteran.android.restclient.R;
import com.androidveteran.android.restclient.adapter.RequestResponsePagerAdapter;
import com.androidveteran.android.restclient.baseclass.BaseAppCompatActivity;
import com.androidveteran.android.restclient.baseclass.GoogleSignInActivity;
import com.androidveteran.android.restclient.database.model.User;
import com.androidveteran.android.restclient.utils.SharedPreferencesUtils;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;

import butterknife.Bind;

public class HomeActivity extends GoogleSignInActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Bind(R.id.fabHome)
    FloatingActionButton mFloatingActionButton;

    @Bind(R.id.dlHome)
    DrawerLayout mDrawerLayout;

    @Bind(R.id.nvHome)
    NavigationView mNavigationView;

    @Bind(R.id.vpHome)
    ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initToolBar();
        initTabLayout();
        showTabLayout();

        mFloatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        ActionBarDrawerToggle mActionBarDrawerToggle = new ActionBarDrawerToggle(
                this, mDrawerLayout, getToolBar(), R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        mDrawerLayout.setDrawerListener(mActionBarDrawerToggle);
        mActionBarDrawerToggle.syncState();

        View headerView = LayoutInflater.from(this).inflate(R.layout.nav_header_home, null);
        mNavigationView.setNavigationItemSelectedListener(this);

        RequestResponsePagerAdapter requestResponsePagerAdapter = new RequestResponsePagerAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(requestResponsePagerAdapter);
        getTabLayout().setupWithViewPager(mViewPager);
    }

    @Override
    public void signInResult(GoogleSignInResult googleSignInResult) {

    }

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_home;
    }

    @Override
    public void onBackPressed() {
        if (mDrawerLayout.isDrawerOpen(GravityCompat.START)) {
            mDrawerLayout.closeDrawer(GravityCompat.START);
        } else if (mDrawerLayout.isDrawerOpen(GravityCompat.END)) {
            mDrawerLayout.closeDrawer(GravityCompat.END);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_history) {
            mDrawerLayout.openDrawer(GravityCompat.END);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
//        int id = item.getItemId();

//        if (id == R.id.nav_camera) {
//            // Handle the camera action
//        } else if (id == R.id.nav_gallery) {
//
//        } else if (id == R.id.nav_slideshow) {
//
//        } else if (id == R.id.nav_manage) {
//
//        } else if (id == R.id.nav_share) {
//
//        } else if (id == R.id.nav_send) {
//
//        }

        mDrawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
}
