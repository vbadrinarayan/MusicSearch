package com.music.app.authentication.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.music.app.R;
import com.music.app.music.activity.MusicSearchActivity;

/**
 * LoginActivity display the login screen for logging in to the application.
 *
 *-------------------------------------------------------------
 * Was planning to do an Social Networking site integration.
 * Here i would authenticate users throush Facebook etc.
 * But if get some more time i would have done this.
 *
 */
public class LoginActivity extends AppCompatActivity implements View.OnClickListener{

    private Button mLoginButton;

    /**
     *
     * @param savedInstanceState bundle object to repopulate contents when activity re-created.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);

        InitViews();
    }

    /**
     *
     */
    private void InitViews(){
        mLoginButton = (Button) findViewById(R.id.button_login);
        if (mLoginButton != null)
            mLoginButton.setOnClickListener(this);

    }

    /**
     *
     * @param view view that has triggered the onclick event
     */
    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.button_login){
            Intent intent = new Intent(this, MusicSearchActivity.class);
            startActivity(intent);
        }
    }
}
