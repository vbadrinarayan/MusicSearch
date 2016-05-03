package com.music.app.main.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.music.app.R;
import com.music.app.authentication.activity.LoginActivity;
import com.music.app.utility.Constants;

/**
 * SplashActivity displays the splash screen for 3 seconds.
 */
public class SplashActivity extends Activity {

    /*TAG*/
    private static final String TAG = SplashActivity.class.getName();

    /**
     * onCreate
     * Called when the activity is starting.
     *
     * @param savedInstanceState bundle object to repopulate contents when activity re-created.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_activity);

        // Calling the next activity after some delay
        new Handler().postDelayed(
                new Runnable() {
                    /**
                     * Showing splash screen with a
                     * timer.
                     */
                    @Override
                    public void run() {
                        Intent intent = new Intent(SplashActivity.this, LoginActivity.class);
                        startActivity(intent);
                    }
                },
                /*Constant time that the Splash screen has to be shown to user.*/
                Constants.SPLASH_TIME_OUT);
    }
}
