package com.music.app.music.activity;

import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.GsonBuilder;
import com.music.app.R;
import com.music.app.inter.SearchInterface;
import com.music.app.model.UISearchResult;
import com.music.app.servicemanager.model.LyricsResult;
import com.music.app.utility.Constants;
import com.music.app.utility.CustomizedGsonConverter;
import com.music.app.utility.Util;
import com.squareup.picasso.Picasso;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * MusicSearchDetailActivity displays the details of the sleected music.
 */
public class MusicSearchDetailActivity extends AppCompatActivity {

    private UISearchResult mResult;

    private TextView mTrackLyrics;

    /**
     *
     * @param savedInstanceState bundle object to repopulate contents when activity re-created.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.music_search_detail_activity);

        mResult = (UISearchResult) getIntent().getParcelableExtra(Constants.SELECTED_TRACK);

        /**
         * Due to time constraints, this service is called form UI layer. If i had some more time,
         * I would have moved this layer to teh service layer as done for the search results
         */

        GsonBuilder gsonBuilder=new GsonBuilder();
        RestAdapter adapter = new RestAdapter.Builder()
                .setEndpoint(Constants.URL_LYRICS)
                .setConverter(new CustomizedGsonConverter(gsonBuilder.create()))
                .build();
        SearchInterface restInterface = adapter.create(SearchInterface.class);
        restInterface.searchTracks(mResult.getArtistName(), mResult.getTrackName(), new Callback<LyricsResult>() {

            @Override
            public void success(LyricsResult lyricsResponse, Response response) {
                if (lyricsResponse != null){
                    mTrackLyrics.setText(lyricsResponse.getLyrics());
                }
            }

            @Override
            public void failure(RetrofitError error) {
                String strError=error.getMessage();
                mTrackLyrics.setText("error:"+strError);
            }
        });


        InitViews();


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == android.R.id.home)
            finish();

        return super.onOptionsItemSelected(item);
    }

    private void InitViews(){

        Toolbar mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ImageView mImageView = (ImageView) findViewById(R.id.track_photo);
        Picasso.with(this).load(mResult.getArtworkUrl100()).into(mImageView);

        TextView trackArtist = (TextView) findViewById(R.id.track_artist);
        TextView trackLength = (TextView) findViewById(R.id.track_length);
        TextView trackPrice = (TextView) findViewById(R.id.track_price);
        mTrackLyrics = (TextView) findViewById(R.id.track_lyrics);

        trackArtist.setText(mResult.getArtistName());
        trackLength.setText(Util.getDuration(mResult.getTrackTimeMillis()));
        trackPrice.setText(mResult.getCurrency() + String.valueOf(mResult.getTrackPrice()));

        CollapsingToolbarLayout collapsingToolbarLayout
                = (CollapsingToolbarLayout) findViewById(R.id.collapsingToolbarLayout);
        collapsingToolbarLayout.setTitle(mResult.getTrackName());
    }
}
