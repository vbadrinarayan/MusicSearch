package com.music.app.music.activity;

import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.music.app.R;

/**
 * MusicSearchDetailActivity displays the details of the sleected music.
 */
public class MusicSearchDetailActivity extends AppCompatActivity {

    private Toolbar mToolbar;

    /**
     *
     * @param savedInstanceState bundle object to repopulate contents when activity re-created.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.music_search_detail_activity);

        InitViews();


    }

    private void InitViews(){
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);

        CollapsingToolbarLayout collapsingToolbarLayout
                = (CollapsingToolbarLayout) findViewById(R.id.collapsingToolbarLayout);
        collapsingToolbarLayout.setTitle("Collapsible Toolbar");
    }
}
