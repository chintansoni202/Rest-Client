package com.androidveteran.android.restclient.activity;

import android.os.Bundle;

import com.androidveteran.android.restclient.R;
import com.androidveteran.android.restclient.baseclass.GoogleSignInActivity;
import com.androidveteran.android.restclient.database.model.User;
import com.androidveteran.android.restclient.utils.SharedPreferencesUtils;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.SignInButton;

import butterknife.Bind;
import butterknife.OnClick;

public class LoginActivity extends GoogleSignInActivity {

    @Bind(R.id.sibLogin)
    SignInButton mSignInButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mSignInButton.setSize(SignInButton.SIZE_WIDE);
        mSignInButton.setScopes(getGoogleSignInOptions().getScopeArray());
    }

    @OnClick(R.id.sibLogin)
    public void googleSignIn() {
        signIn();
    }

    @Override
    public void signInResult(GoogleSignInResult googleSignInResult) {
        logDebug(getClass(), "handleSignInResult:" + googleSignInResult.isSuccess());
        if (googleSignInResult.isSuccess()) {
            // Signed in successfully, show authenticated UI.
            GoogleSignInAccount googleSignInAccount = googleSignInResult.getSignInAccount();
            User user = new User(googleSignInAccount.getDisplayName(), googleSignInAccount.getEmail());
            user.save();

            // save the logged in preference
            SharedPreferencesUtils.getInstance(this).setBoolean("isUserLoggedIn", true);
            launchActivity(HomeActivity.class);
        } else {
            // Signed out, show unauthenticated UI.
        }
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_login;
    }

    @OnClick(R.id.btnLoginSkip)
    public void skip() {
        launchActivity(IntroductionActivity.class);
    }
}
