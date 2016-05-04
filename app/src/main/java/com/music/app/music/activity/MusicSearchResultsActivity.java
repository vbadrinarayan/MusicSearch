package com.music.app.music.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.music.app.R;
import com.music.app.adapter.SongsListAdapter;
import com.music.app.data.DataManager;
import com.music.app.inter.ListItemClickCallback;
import com.music.app.inter.ResponseListener;
import com.music.app.model.UISearchResult;
import com.music.app.model.UISearchResultList;
import com.music.app.servicemanager.model.SearchMusicResult;
import com.music.app.utility.Constants;

import java.util.List;

/**
 * MusicSearchResultsActivity displays the list of track results.
 */
public class MusicSearchResultsActivity extends AppCompatActivity implements ListItemClickCallback {

    private RecyclerView mrecycler_view;

    private ProgressBar mProgressBar;

    private TextView mNoData;

    private String mSearchText;

    private List<SearchMusicResult> mResponse;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_results_activity);

        InitViews();

        mSearchText = getIntent().getStringExtra(Constants.SEARCH_KEY);

        DataManager.getMusicSearchResults(getApplication(), mSearchText, new ResponseListener<UISearchResultList>() {
            @Override
            public void onSuccess(UISearchResultList response) {

                if(response.getResultCount() > 0) {
                    mResponse = response.getResults();
                    mrecycler_view.setAdapter(new SongsListAdapter(MusicSearchResultsActivity.this
                            , mResponse));

                }else{
                    Toast.makeText(MusicSearchResultsActivity.this
                            , getResources().getString(R.string.no_data), Toast.LENGTH_LONG).show();
                    finish();
                }
                mProgressBar.setVisibility(View.GONE);

            }

            @Override
            public void onFailure(Throwable throwable, String errorResponse) {

            }
        });
    }

    private void InitViews(){

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        ((TextView)toolbar.findViewById(R.id.title_toolbar_view)).setText(getResources()
                .getString(R.string.search_results));

        mrecycler_view = (RecyclerView) findViewById(R.id.recycler_view);
        mrecycler_view.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        mrecycler_view.setLayoutManager(llm);

        mProgressBar = (ProgressBar) findViewById(R.id.pBar);
        mNoData = (TextView) findViewById(R.id.no_data);

    }

    @Override
    public void OnHandleItemCLick(int position) {
        SearchMusicResult selectedTrack = mResponse.get(position);
        Intent intent = new Intent(this, MusicSearchDetailActivity.class);
        UISearchResult result = new UISearchResult();

        result.setArtistName(selectedTrack.getArtistName());
        result.setArtworkUrl30(selectedTrack.getArtworkUrl30());
        result.setArtworkUrl60(selectedTrack.getArtworkUrl60());
        result.setArtworkUrl100(selectedTrack.getArtworkUrl100());
        result.setCollectionPrice(selectedTrack.getCollectionPrice());
        result.setReleaseDate(selectedTrack.getReleaseDate());
        result.setCurrency(selectedTrack.getCurrency());
        result.setPreviewUrl(selectedTrack.getPreviewUrl());
        result.setTrackName(selectedTrack.getTrackName());
        result.setTrackPrice(selectedTrack.getTrackPrice());
        result.setTrackTimeMillis(selectedTrack.getTrackTimeMillis());

        intent.putExtra(Constants.SELECTED_TRACK, result);
        startActivity(intent);
    }
}
