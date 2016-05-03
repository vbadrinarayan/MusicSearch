package com.music.app.music.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.music.app.R;
import com.music.app.adapter.SongsListAdapter;
import com.music.app.data.DataManager;
import com.music.app.inter.ListItemClickCallback;
import com.music.app.inter.ResponseListener;
import com.music.app.model.UISearchResultList;
import com.music.app.utility.Constants;

/**
 * MusicSearchResultsActivity displays the list of track results.
 */
public class MusicSearchResultsActivity extends AppCompatActivity implements ListItemClickCallback {

    private RecyclerView mrecycler_view;

    private ProgressBar mProgressBar;

    private TextView mNoData;

    private String mSearchText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_results_activity);

        InitViews();

        mSearchText = getIntent().getStringExtra(Constants.SEARCH_KEY);

        DataManager.getMusicSearchResults(getApplication(), mSearchText, new ResponseListener<UISearchResultList>() {
            @Override
            public void onSuccess(UISearchResultList response) {
                mrecycler_view.setAdapter(new SongsListAdapter(MusicSearchResultsActivity.this
                        , response.getResults()));
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

    }
}
