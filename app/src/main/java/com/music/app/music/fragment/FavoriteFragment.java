package com.music.app.music.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.music.app.R;

/**
 * FavoriteFragment contains UI for listing favorites.
 */
public class FavoriteFragment extends Fragment{

    private View mRootView;

    /**
     *
     * @param inflater used for inflationg the layout for the fragment
     * @param container view group for attaching the fragment
     * @param savedInstanceState bundle object to repopulate contents when re-created
     * @return mRootView
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        mRootView = inflater.inflate(R.layout.favorite_fragment, container, false);

        initViews();

        return mRootView;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    private void initViews(){

    }
}
