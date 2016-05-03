package com.music.app.music.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.music.app.R;
import com.music.app.data.DataManager;
import com.music.app.inter.ResponseListener;
import com.music.app.model.UISearchResultList;
import com.music.app.utility.Constants;

/**
 * Created by Badri on 03/05/16.
 */
public class MusicSearchResultsActivity extends AppCompatActivity {

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
                Toast.makeText(MusicSearchResultsActivity.this, "Response::"+response.getResultCount(), Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Throwable throwable, String errorResponse) {

            }
        });
    }

    private void InitViews(){
        mrecycler_view = (RecyclerView) findViewById(R.id.list_songs);
        mrecycler_view.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        mrecycler_view.setLayoutManager(llm);

        mProgressBar = (ProgressBar) findViewById(R.id.pBar);
        mNoData = (TextView) findViewById(R.id.no_data);

    }
}
