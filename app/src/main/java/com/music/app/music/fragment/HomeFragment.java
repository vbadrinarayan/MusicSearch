package com.music.app.music.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.music.app.R;
import com.music.app.music.activity.MusicSearchResultsActivity;
import com.music.app.utility.Constants;

/**
 * HomeFragment contains UI for home screen content.
 */
public class HomeFragment extends Fragment implements View.OnClickListener{

    private View mRootView;

    private EditText mSearchEditText;

    private Button mSearchButton;

    private Context mContext;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    /**
     *
     * @param inflater used for inflationg the layout for the fragment
     * @param container view group for attaching the fragment
     * @param savedInstanceState bundle object to repopulate contents when re-created
     * @return mRootView
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        mRootView = inflater.inflate(R.layout.home_fragment, container, false);

        initViews();

        return mRootView;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mContext = getActivity();

    }

    private void initViews(){
        mSearchEditText = (EditText) mRootView.findViewById(R.id.edittext_search);
        mSearchButton = (Button) mRootView.findViewById(R.id.button_search);
        mSearchButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        String searchText = mSearchEditText.getText().toString().trim();

        if(searchText == null
                || searchText.trim().length() == 0){
            mSearchEditText.setError(mContext.getResources().getString(R.string.error_search_text));
        }else{
            Intent intent = new Intent(mContext, MusicSearchResultsActivity.class);
            intent.putExtra(Constants.SEARCH_KEY, searchText);
            startActivity(intent);
        }
    }
}
